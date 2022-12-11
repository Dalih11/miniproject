package com.loyalty3.loyalty3.Entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "benefit")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BenefitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBenefit;
    private String nameBenefit;
    private String keterangan;

}
