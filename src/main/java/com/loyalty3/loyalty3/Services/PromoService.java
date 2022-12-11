package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.ProductEntity;
import com.loyalty3.loyalty3.Entity.PromoEntity;
import com.loyalty3.loyalty3.Entity.VoucherEntity;
import com.loyalty3.loyalty3.Repository.PromoRepository;
import com.loyalty3.loyalty3.Repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PromoService {
    @Autowired
    private PromoRepository promoRepository;

    public PromoEntity save(PromoEntity promoEntity){
        return promoRepository.save(promoEntity);
    }

    public PromoEntity findOne(Long idPromo){
        Optional<PromoEntity> promoEntity = promoRepository.findById(idPromo);
        if (!promoEntity.isPresent()){
            return null;
        }
        return promoEntity.get();
    }
    public Iterable<PromoEntity> findAll(){
        return promoRepository.findAll();
    }

    public void removeOne(Long idPromo){
        promoRepository.deleteById(idPromo);
    }
}
