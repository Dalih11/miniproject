package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Dtos.VoucherDto;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.VoucherEntity;
import com.loyalty3.loyalty3.Services.MerchantService;
import com.loyalty3.loyalty3.Services.VoucherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/voucher")
    public ResponseEntity<ResponsDataDto<VoucherEntity>> create(@Valid @RequestBody VoucherDto voucherDto, Errors errors){
        ResponsDataDto<VoucherEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        VoucherEntity voucherEntity = modelMapper.map(voucherDto, VoucherEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(voucherService.save(voucherEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<VoucherEntity> findAll(){
        return voucherService.findAll();
    }

    @GetMapping("/{id}")
    public VoucherEntity findOne(@PathVariable("id") Long idVoucher){
        return voucherService.findOne(idVoucher);
    }

    @PutMapping("/voucher")
    public ResponseEntity<ResponsDataDto<VoucherEntity>> update(@Valid @RequestBody VoucherDto voucherDto, Errors errors){
        ResponsDataDto<VoucherEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        VoucherEntity voucherEntity = modelMapper.map(voucherDto, VoucherEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(voucherService.save(voucherEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idVoucher){
        voucherService.removeOne(idVoucher);
    }
}
