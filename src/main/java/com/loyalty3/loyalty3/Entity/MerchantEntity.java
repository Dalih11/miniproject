package com.loyalty3.loyalty3.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "merchant")
@Data
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "idMerchant"
//)
public class MerchantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMerchant;
    @Column(nullable = false)
    private String nameMerchant;
    @Column(nullable = false)
    private String alamatMerchant;
    private String tlpn;
    private Long idProduct;

//    @ManyToMany(mappedBy = "merchantEntities")
//    private Set<ProductEntity> productEntities;
}
