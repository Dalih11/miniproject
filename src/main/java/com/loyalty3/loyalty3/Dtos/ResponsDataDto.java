package com.loyalty3.loyalty3.Dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponsDataDto<T> {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
