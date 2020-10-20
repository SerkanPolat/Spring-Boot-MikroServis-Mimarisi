package com.sp.accountservice.service;

import com.sp.accountservice.entity.Hesap;
import com.sp.accountservice.repo.HesapRepository;
import com.sp.client.contract.HesapDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HesapService {

    private final HesapRepository hesapRepository;
    //Hesap nesnelerinin HesapDTO Class turune donusturulmesini icin kullanildi.
    private final ModelMapper modelMapper;

    public HesapDTO get(String id) {

        Hesap hesap = hesapRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(hesap,HesapDTO.class);
    }
    @Transactional
    public HesapDTO save(HesapDTO hesapDTO) {
        Hesap hesap = modelMapper.map(hesapDTO,Hesap.class);
        hesap.setId(UUID.randomUUID().toString());
        return modelMapper.map(hesapRepository.save(hesap),HesapDTO.class);
    }
    @Transactional
    public HesapDTO update(String id,HesapDTO hesapDTO) {
        Assert.isNull(id,"ID YOK");
        hesapRepository.findById(id);
        Optional<Hesap> hesap = hesapRepository.findById(id);
        Hesap hesapUpdate = hesap.map(iter->{
            iter.setAd(hesapDTO.getAd());
            iter.setYas(hesapDTO.getYas());
            return iter;
        }).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(hesapRepository.save(hesapUpdate),HesapDTO.class);
    }

    @Transactional
    public void delete(String id) {
        hesapRepository.deleteById(id);
    }

    public Slice<HesapDTO> getAll(Pageable pageable){
        Slice<Hesap> hesapPage = hesapRepository.findAll(pageable);
        return null;
    }

}
