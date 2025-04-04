package org.rai.projetoavanade.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.rai.projetoavanade.domain.Account;
import org.rai.projetoavanade.domain.Card;

import java.time.LocalDate;
public class UserResponseDto {
    private Long id;
    private String cpf;

    private String name;

    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private String email;
    private Account account;
    private Card card;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String cpf, String name, String gender, LocalDate birthday, String email, Account account, Card card) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.account = account;
        this.card = card;
    }
}
