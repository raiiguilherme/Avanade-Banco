package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.model.EmailModel;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {


    private final EmailRepository repository;

    private final JavaMailSender mailSender;

    public EmailService(EmailRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    @Transactional //garante o ROLLBACK caso alguma operação falhe
    public void EmailSend(EmailModel email){

      try {

          email.setSendDateEmail(LocalDateTime.now()); //data de envio do email
          email.setEmailFrom("teste@gmail.com");

          var message = new SimpleMailMessage(); //criando o email
          message.setFrom("teste@gmail.com"); //quem esta enviando
          message.setTo(email.getEmailTo()); //para quem é o email
          message.setSubject(email.getSubject()); //assunto do email
          message.setText(email.getText()); //corpo do email

          mailSender.send(message); //enviando a mensagem

          email.setStatusEmail(StatusEmail.SEND); //defininado o status do email
      }
      catch (MailException e){ //se capturar uma exceção, ira setar o status do email como error
          email.setStatusEmail(StatusEmail.ERROR);
      }
      finally { //ira salvar o email no banco de dados, independente de falhas
          repository.save(email);
      }

    }
}
