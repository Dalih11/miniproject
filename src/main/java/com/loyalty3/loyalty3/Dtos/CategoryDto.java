package com.loyalty3.loyalty3.Dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryDto {
    @NotEmpty(message = "Data Harus Diisi")
    private String nameCategory;
}
