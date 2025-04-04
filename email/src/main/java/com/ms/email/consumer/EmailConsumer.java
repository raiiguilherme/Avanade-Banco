package com.ms.email.consumer;

import com.ms.email.dtos.EmailRecordDTO;
import com.ms.email.model.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {


    private final EmailService service;

    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.email.name}") //PEGANDO O NOME DA FILA QUE IRA CONSUMIR
    public void listerEmailQueue(@Payload EmailRecordDTO emailRecordDTO){//ANOTAÇÃO PAYLOAD PARA RECEBER A MENSAGEM

        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO, emailModel); //copiando as propriedades e transformando em emailModel
        service.EmailSend(emailModel); //usando o metodo da classe EmailService que criamos

    }



}
