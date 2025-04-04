package org.rai.projetoavanade.producers;

import org.rai.projetoavanade.domain.User;
import org.rai.projetoavanade.domain.dto.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingkey;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void pushMessageEmail(User user){
        var emailDTO = new EmailDto(); //CONSTRUINDO O EMAIL
        emailDTO.setUserId(user.getId());
        emailDTO.setEmailTo(user.getEmail());
        emailDTO.setSubject("cadastro realizado com sucesso!");
        emailDTO.setText("Ola," +user.getName() +"! Acabamos de receber o seu cadastro em nossa plataforma bancaria. Aproveite!");


        //COMO SERA UTILIZADO EXCHANGE DEFAULT, BASTA ADICIONAR UMA STRING VAZIA
        //ADICIONANDO TAMBEM A ROUTINGKEY
        //ADICIONANDO TAMBEM A MENSAGEM
        rabbitTemplate.convertAndSend("",routingkey,emailDTO);

    }
}
