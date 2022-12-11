package com.loyalty3.loyalty3.Repository;

import com.loyalty3.loyalty3.Entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
}
