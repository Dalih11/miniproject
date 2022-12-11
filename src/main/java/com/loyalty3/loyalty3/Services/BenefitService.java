package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.BenefitEntity;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Repository.BenefitRepository;
import com.loyalty3.loyalty3.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BenefitService {
    @Autowired
    private BenefitRepository benefitRepository;

    public BenefitEntity save(BenefitEntity benefitEntity){
        return benefitRepository.save(benefitEntity);
    }

    public BenefitEntity findOne(Long idBenefit){
        Optional<BenefitEntity> benefitEntity = benefitRepository.findById(idBenefit);
        if (!benefitEntity.isPresent()){
            return null;
        }
        return benefitEntity.get();
    }
    public Iterable<BenefitEntity> findAll(){
        return benefitRepository.findAll();
    }

    public void removeOne(Long idMerchant){
        benefitRepository.deleteById(idMerchant);
    }
}
