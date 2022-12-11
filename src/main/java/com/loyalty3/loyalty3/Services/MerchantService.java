package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.CategoryEntity;
import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public MerchantEntity save(MerchantEntity merchantEntity){
        return merchantRepository.save(merchantEntity);
    }

    public MerchantEntity findOne(Long idMerchant){
        Optional<MerchantEntity> merchantEntity = merchantRepository.findById(idMerchant);
        if (!merchantEntity.isPresent()){
            return null;
        }
        return merchantEntity.get();
    }
    public Iterable<MerchantEntity> findAll(){
        return merchantRepository.findAll();
    }

    public void removeOne(Long idMerchant){
        merchantRepository.deleteById(idMerchant);
    }
}
