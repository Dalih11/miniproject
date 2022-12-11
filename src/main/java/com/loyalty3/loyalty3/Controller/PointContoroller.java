package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.PointDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.PointEntity;
import com.loyalty3.loyalty3.Services.MerchantService;
import com.loyalty3.loyalty3.Services.PointService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/point")
public class PointContoroller {
    @Autowired
    private PointService pointService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/point")
    public ResponseEntity<ResponsDataDto<PointEntity>> create(@Valid @RequestBody PointDto pointDto, Errors errors){
        ResponsDataDto<PointEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        PointEntity pointEntity = modelMapper.map(pointDto, PointEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(pointService.save(pointEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<PointEntity> findAll(){
        return pointService.findAll();
    }

    @GetMapping("/{id}")
    public PointEntity findOne(@PathVariable("id") Long idPoint){
        return pointService.findOne(idPoint);
    }

    @PutMapping("/point")
    public ResponseEntity<ResponsDataDto<PointEntity>> update(@Valid @RequestBody PointDto pointDto, Errors errors){
        ResponsDataDto<PointEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        PointEntity pointEntity = modelMapper.map(pointDto, PointEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(pointService.save(pointEntity));
        return ResponseEntity.ok(responsDataDto);
    }
}
