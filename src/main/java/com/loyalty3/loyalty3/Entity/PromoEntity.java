package com.loyalty3.loyalty3.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "promo")
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromo;
    private String namePromo;
    private String kepo;
    private Integer amount;

}
