package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Dtos.TransaksiDto;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.TransaksiEntity;
import com.loyalty3.loyalty3.Services.MerchantService;
import com.loyalty3.loyalty3.Services.TransaksiService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/transaksi")
    public ResponseEntity<ResponsDataDto<TransaksiEntity>> create(@Valid @RequestBody TransaksiDto transaksiDto, Errors errors) {
        System.out.println(transaksiDto.toString());
        ResponsDataDto<TransaksiEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

//        TransaksiEntity transaksiEntity = modelMapper.map(transaksiDto, TransaksiEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(transaksiService.save(transaksiDto));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<TransaksiEntity> findAll() {
        return transaksiService.findAll();
    }

    @GetMapping("/{id}")
    public TransaksiEntity findOne(@PathVariable("id") Long idTransaksi) {
        return transaksiService.findOne(idTransaksi);
    }
}


