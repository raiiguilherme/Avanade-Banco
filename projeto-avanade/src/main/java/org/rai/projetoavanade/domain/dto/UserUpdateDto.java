package org.rai.projetoavanade.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserUpdateDto {

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "the CPF must follow this pattern xxx.xxx.xxx-xx")
    private String cpf;

    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "Masculino|Feminino", message = "The gender must be 'Masculino' or 'Feminino'")
    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy") //formatando a data
    private LocalDate birthday; //maior de 18
    @NotBlank
    @Email(message = "Email in invalid format", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;

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
}
