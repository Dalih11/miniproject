package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.ProductEntity;
import com.loyalty3.loyalty3.Services.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/merchant")
    public ResponseEntity<ResponsDataDto<MerchantEntity>> create(@Valid @RequestBody MerchantDto merchantDto, Errors errors){
        ResponsDataDto<MerchantEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        MerchantEntity merchantEntity = modelMapper.map(merchantDto, MerchantEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(merchantService.save(merchantEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping("/mer")
    public Iterable<MerchantEntity> findAll(){
        System.out.println("name");
        return merchantService.findAll();
    }

    @GetMapping("/{id}")
    public MerchantEntity findOne(@PathVariable("id") Long idMerchant){
        return merchantService.findOne(idMerchant);
    }

    @PutMapping("/merchant")
    public ResponseEntity<ResponsDataDto<MerchantEntity>> update(@Valid @RequestBody MerchantDto merchantDto, Errors errors){
        ResponsDataDto<MerchantEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        MerchantEntity merchantEntity = modelMapper.map(merchantDto, MerchantEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(merchantService.save(merchantEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idMerchant){
        merchantService.removeOne(idMerchant);
    }
}
