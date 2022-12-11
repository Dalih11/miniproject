package com.loyalty3.loyalty3.Repository;

import com.loyalty3.loyalty3.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByNameProductContains(String nameProduct);
}
