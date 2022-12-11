package com.loyalty3.loyalty3.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name = "product")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "idProduct"
//)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @NotEmpty(message = "Data Harus Diisi")
    private String nameProduct;
    @NotEmpty(message = "Data Harus Diisi")
    private String description;
    private Integer qty; //alias stok
    private Double price;
    private Long idPromo;
    private Long idMerchant;

//    @ManyToOne
//    private CategoryEntity categoryEntity;
//
//    @ManyToMany
//    @JoinTable(name = "tbl_product_merchant",
//                joinColumns = @JoinColumn(name = "idProduct"),
//                inverseJoinColumns = @JoinColumn(name = "idMerchant"))
//    private Set<MerchantEntity> merchantEntities;

}
