package com.ms.email.model;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailModel implements Serializable { //Entidade do nosso banco de dados seguindo as regras de negocio

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
  private Long userId;

  private String emailFrom;
   private String emailTo;
  private String subject;
  @Column(columnDefinition = "TEXT")
    private String text;
  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;

}
