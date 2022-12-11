package com.loyalty3.loyalty3.Services;

import com.loyalty3.loyalty3.Dtos.TransaksiDto;
import com.loyalty3.loyalty3.Entity.*;
import com.loyalty3.loyalty3.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private PromoRepository promoRepository;
    private TransaksiRepository transaksiRepository;

    @Transactional
    public TransaksiEntity save(TransaksiDto transaksiDto){
        ProductEntity product = productRepository.getReferenceById(transaksiDto.getIdProduk());
        MerchantEntity merchant = merchantRepository.getReferenceById(product.getIdMerchant());
        PromoEntity promo = promoRepository.getReferenceById(product.getIdPromo());
        TransaksiEntity transaksi = new TransaksiEntity();
        transaksi.setIdTransaksi(1L);
        transaksi.setNameProduct(product.getNameProduct());
        transaksi.setDescription(product.getDescription());
        transaksi.setQty(transaksiDto.getQty());
        transaksi.setPrice(product.getPrice());
        transaksi.setNameMerchant(merchant.getNameMerchant());
        transaksi.setAlamatMerchant(merchant.getAlamatMerchant());
        transaksi.setTlpn(merchant.getTlpn());
        transaksi.setNamePromo(promo.getNamePromo());
        transaksi.setKepo(promo.getKepo());
        transaksi.setAmount(promo.getAmount());
        Double totalHarga = product.getPrice() * transaksiDto.getQty();
        Double diskon = totalHarga * promo.getAmount() / 100;
        transaksi.setTotal(totalHarga - diskon);
        System.out.println(transaksi.toString());
        return transaksiRepository.save(transaksi);
    }

    public TransaksiEntity findOne(Long idTransaksi){
        Optional<TransaksiEntity> transaksiEntity = transaksiRepository.findById(idTransaksi);
        if (!transaksiEntity.isPresent()){
            return null;
        }
        return transaksiEntity.get();
    }
    public Iterable<TransaksiEntity> findAll(){
        return transaksiRepository.findAll();
    }

    public void removeOne(Long idTransaksi){
        transaksiRepository.deleteById(idTransaksi);
    }
}
