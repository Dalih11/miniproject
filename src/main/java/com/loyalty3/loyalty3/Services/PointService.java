package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Entity.MerchantEntity;
import com.loyalty3.loyalty3.Entity.PointEntity;
import com.loyalty3.loyalty3.Repository.MerchantRepository;
import com.loyalty3.loyalty3.Repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PointService {
    @Autowired
    private PointRepository pointRepository;

    public PointEntity save(PointEntity pointEntity){
        return pointRepository.save(pointEntity);
    }

    public PointEntity findOne(Long idPoint){
        Optional<PointEntity> pointEntity = pointRepository.findById(idPoint);
        if (!pointEntity.isPresent()){
            return null;
        }
        return pointEntity.get();
    }
    public Iterable<PointEntity> findAll(){
        return pointRepository.findAll();
    }

    public void removeOne(Long idPoint){
        pointRepository.deleteById(idPoint);
    }
}
