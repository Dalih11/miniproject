package com.loyalty3.loyalty3.Controller;

import com.loyalty3.loyalty3.Dtos.CategoryDto;
import com.loyalty3.loyalty3.Dtos.MerchantDto;
import com.loyalty3.loyalty3.Dtos.ResponsDataDto;
import com.loyalty3.loyalty3.Entity.CategoryEntity;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/category")
    public ResponseEntity<ResponsDataDto<CategoryEntity>> create(@Valid @RequestBody CategoryDto categoryDto, Errors errors){
        ResponsDataDto<CategoryEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(categoryService.save(categoryEntity));
        return ResponseEntity.ok(responsDataDto);
    }

    @GetMapping
    public Iterable<CategoryEntity> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryEntity findOne(@PathVariable("id") Long idCategory){
        return categoryService.findOne(idCategory);
    }

    @PutMapping("/category")
    public ResponseEntity<ResponsDataDto<CategoryEntity>> update(@Valid @RequestBody CategoryDto categoryDto, Errors errors){
        ResponsDataDto<CategoryEntity> responsDataDto = new ResponsDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responsDataDto.getMessages().add(error.getDefaultMessage());
            }
            responsDataDto.setStatus(false);
            responsDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsDataDto);
        }

        CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);

        responsDataDto.setStatus(true);
        responsDataDto.setPayload(categoryService.save(categoryEntity));
        return ResponseEntity.ok(responsDataDto);
    }
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idCategory){
        categoryService.delete(idCategory);
    }

}
