package org.rai.projetoavanade.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.rai.projetoavanade.domain.dto.UserCreateDto;
import org.rai.projetoavanade.domain.dto.UserUpdateDto;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 10, nullable = false)
    private String gender;
    @Column(length = 10, nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User(UserCreateDto userDto){

        this.name = userDto.getName();
        this.cpf = userDto.getCpf();
        this.email = userDto.getEmail();
        this.gender = userDto.getGender();
        this.birthday = userDto.getBirthday();
    }
    public User(UserUpdateDto userDto){

        this.name = userDto.getName();
        this.cpf = userDto.getCpf();
        this.email = userDto.getEmail();
        this.gender = userDto.getGender();
        this.birthday = userDto.getBirthday();
    }

    public User() {
    }

    public User(Long id, String name, String cpf, String email, String gender, LocalDate birthday, Account account, Card card) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.account = account;
        this.card = card;
    }
}

