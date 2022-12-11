package com.loyalty3.loyalty3.Repository;

import com.loyalty3.loyalty3.Entity.ProductEntity;
import com.loyalty3.loyalty3.Entity.PromoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoRepository extends JpaRepository <PromoEntity, Long>{
    List<PromoEntity> findByNamePromoContains(String namePromo);
}
