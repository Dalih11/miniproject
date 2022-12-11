package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.ProductEntity;
import com.loyalty3.loyalty3.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ResponsDataDto<ProductEntity>> create(@Valid @RequestBody ProductEntity productEntity, Errors errors){
        ResponsDataDto<ProductEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }
            responsDataDto.setStatus(true);
            responsDataDto.setPayload(productService.save(productEntity));
            return ResponseEntity.ok(responsDataDto);

//        return productService.save(productEntity);
    }

    @GetMapping
    public Iterable<ProductEntity> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity findOne(@PathVariable("id") Long idProduct){
        return productService.findOne(idProduct);
    }

    @PutMapping("/product")
    public ResponseEntity<ResponsDataDto<ProductEntity>> update(@Valid @RequestBody ProductEntity productEntity, Errors errors){
        ResponsDataDto<ProductEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }
        responsDataDto.setStatus(true);
        responsDataDto.setPayload(productService.save(productEntity));
        return ResponseEntity.ok(responsDataDto);

//        return productService.save(productEntity);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idProduct){
        productService.removeOne(idProduct);
    }

//    @PostMapping("/{id}")
//    public void addMerchant(@RequestBody MerchantEntity merchantEntity, @PathVariable("id") Long idProduct){
//        productService.addMerchant(merchantEntity, idProduct);
//    }

}
