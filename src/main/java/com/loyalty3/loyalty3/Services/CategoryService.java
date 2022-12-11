package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.CategoryEntity;
import com.loyalty3.loyalty3.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@TransactionScoped
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity save(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    public CategoryEntity findOne(Long idCategory){
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(idCategory);
        if (!categoryEntity.isPresent()){
            return null;
        }
        return categoryEntity.get();
    }

    public Iterable<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public void delete(Long idCategory){
        categoryRepository.deleteById(idCategory);
    }
}
