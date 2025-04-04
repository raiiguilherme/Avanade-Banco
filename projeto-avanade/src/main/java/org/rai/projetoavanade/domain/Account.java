package org.rai.projetoavanade.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@Entity(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    @PrePersist
    public void prePersist() {
        if (this.number == null) {
            this.number = generateAccountNumber();
        }
        if (this.agency == null) {
            this.agency = "0001";
        }
        if (this.balance == null) {
            this.balance = BigDecimal.ZERO;
        }
        if (this.limit == null) {
            this.limit = new BigDecimal("1000.00");
        }
    }
    private String generateAccountNumber() {
        return String.valueOf(100000 + new Random().nextInt(900000)); // 6 dígitos
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
