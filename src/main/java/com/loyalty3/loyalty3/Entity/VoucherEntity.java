package com.loyalty3.loyalty3.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "voucher")
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoucher;
    @NotEmpty(message = "Data Harus Diisi")
    private String nameVoucher;
    @NotEmpty(message = "Data Harus Diisi")
    private String ket;
}
