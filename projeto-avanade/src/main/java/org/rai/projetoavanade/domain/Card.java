package org.rai.projetoavanade.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Random;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;


    @PrePersist
    public void prePersist() {
        if (this.number == null) {
            this.number = generateCardNumber();
        }

        if (this.limit == null) {
            this.limit = new BigDecimal("3000.00");
        }
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Card(Long id, String number, BigDecimal limit) {
        this.id = id;
        this.number = number;
        this.limit = limit;
    }

    public Card() {
    }
}
