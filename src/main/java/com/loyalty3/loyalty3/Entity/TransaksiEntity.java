package com.loyalty3.loyalty3.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "transaksi")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class TransaksiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaksi;

    private String nameProduct;
    private String description;
    private int qty;
    private double price;
    private String nameMerchant;
    private String alamatMerchant;
    private String tlpn;

    private String namePromo;
    private String kepo;
    private Integer amount;

    private Double total;

//    private String nameVoucher;
//    private String ket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TransaksiEntity that = (TransaksiEntity) o;
        return idTransaksi != null && Objects.equals(idTransaksi, that.idTransaksi);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
