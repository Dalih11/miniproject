package com.loyalty3.loyalty3.Dtos;

import com.loyalty3.loyalty3.Entity.ProductEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MerchantDto {
    @NotEmpty(message = "Data Harus Diisi")
    private String nameMerchant;
    @NotEmpty(message = "Data Harus Diisi")
    private String alamatMerchant;
    private String tlpn;

//    private ProductEntity productEntity;
}
