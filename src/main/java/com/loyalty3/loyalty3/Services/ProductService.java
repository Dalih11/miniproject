package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.ProductEntity;
import com.loyalty3.loyalty3.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity save(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public ProductEntity findOne(Long idProduct){
        Optional<ProductEntity> productEntity = productRepository.findById(idProduct);
        if(!productEntity.isPresent()){
            return null;
        }
        return productEntity.get();
//        return productRepository.findById(idProduct).get();
    }

    public Iterable<ProductEntity>findAll(){
        return productRepository.findAll();
    }

    public void removeOne(Long idProduct){
        productRepository.deleteById(idProduct);
    }

    public List<ProductEntity> findByNameProduct(String nameProduct){
        return productRepository.findByNameProductContains(nameProduct);
    }

//    public void addMerchant(MerchantEntity merchantEntity, Long idProduct){
//        ProductEntity productEntity = findOne(idProduct);
//        if(productEntity == null){
//            throw new RuntimeException("Product with id:"+idProduct+"not found");
//        }
//        productEntity.getMerchantEntities().add(merchantEntity);
//        save(productEntity);
//    }
}
