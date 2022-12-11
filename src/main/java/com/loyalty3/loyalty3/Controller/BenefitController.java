package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.BenefitDto;
import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.BenefitEntity;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Services.BenefitService;
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
@RequestMapping("/api/benefit")
public class BenefitController {
    @Autowired
    private BenefitService benefitService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/benefit")
    public ResponseEntity<ResponsDataDto<BenefitEntity>> create(@Valid @RequestBody BenefitDto benefitDto, Errors errors){
        ResponsDataDto<BenefitEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        BenefitEntity benefitEntity = modelMapper.map(benefitDto, BenefitEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(benefitService.save(benefitEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<BenefitEntity> findAll(){
        return benefitService.findAll();
    }

    @GetMapping("/{id}")
    public BenefitEntity findOne(@PathVariable("id") Long idBenefit){
        return benefitService.findOne(idBenefit);
    }

    @PutMapping("/benefit")
    public ResponseEntity<ResponsDataDto<BenefitEntity>> update(@Valid @RequestBody BenefitDto benefitDto, Errors errors){
        ResponsDataDto<BenefitEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        BenefitEntity benefitEntity = modelMapper.map(benefitDto, BenefitEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(benefitService.save(benefitEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idBenefit){
        benefitService.removeOne(idBenefit);
    }
}
