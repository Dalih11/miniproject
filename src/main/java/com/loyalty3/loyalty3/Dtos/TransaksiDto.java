package com.loyalty3.loyalty3.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TransaksiDto implements Serializable {
    private Long idProduk;
    private Integer qty;

//    private String nameVoucher;
//    private String ket;
}
