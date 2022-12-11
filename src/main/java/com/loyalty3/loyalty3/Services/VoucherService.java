package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.BenefitEntity;
import com.loyalty3.loyalty3.Entity.VoucherEntity;
import com.loyalty3.loyalty3.Repository.BenefitRepository;
import com.loyalty3.loyalty3.Repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public VoucherEntity save(VoucherEntity voucherEntity){
        return voucherRepository.save(voucherEntity);
    }

    public VoucherEntity findOne(Long idVoucher){
        Optional<VoucherEntity> voucherEntity = voucherRepository.findById(idVoucher);
        if (!voucherEntity.isPresent()){
            return null;
        }
        return voucherEntity.get();
    }
    public Iterable<VoucherEntity> findAll(){
        return voucherRepository.findAll();
    }

    public void removeOne(Long idVoucher){
        voucherRepository.deleteById(idVoucher);
    }
}
