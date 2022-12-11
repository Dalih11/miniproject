package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.PointDto;
import com.loyalty3.loyalty3.Dtos.PromoDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.PointEntity;
import com.loyalty3.loyalty3.Entity.PromoEntity;
import com.loyalty3.loyalty3.Services.PointService;
import com.loyalty3.loyalty3.Services.PromoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/promo")
public class PromoController {
    @Autowired
    private PromoService promoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/promo")
    public ResponseEntity<ResponsDataDto<PromoEntity>> create(@Valid @RequestBody PromoDto promoDto, Errors errors){
        ResponsDataDto<PromoEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        PromoEntity promoEntity = modelMapper.map(promoDto, PromoEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(promoService.save(promoEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<PromoEntity> findAll(){
        return promoService.findAll();
    }

    @GetMapping("/{id}")
    public PromoEntity findOne(@PathVariable("id") Long idPromo){
        return promoService.findOne(idPromo);
    }

    @PutMapping("/promo")
    public ResponseEntity<ResponsDataDto<PromoEntity>> update(@Valid @RequestBody PromoDto promoDto, Errors errors){
        ResponsDataDto<PromoEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        PromoEntity promoEntity = modelMapper.map(promoDto, PromoEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(promoService.save(promoEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idPromo){
        promoService.removeOne(idPromo);
    }


}
