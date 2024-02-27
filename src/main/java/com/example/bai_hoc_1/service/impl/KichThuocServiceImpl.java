package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.KichThuoc;
import com.example.bai_hoc_1.repository.KichThuocRepository;
import com.example.bai_hoc_1.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocServiceImpl implements KichThuocService {

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @Override
    public List<KichThuoc> getAllKichThuocs() {
        return kichThuocRepository.findAll();
    }

    @Override
    public KichThuoc getOneKichThuoc(String id) {
        return kichThuocRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveKichThuoc(KichThuoc kichThuoc) {
        if (!kichThuocRepository.existsById(kichThuoc.getId())) {
            kichThuocRepository.saveAndFlush(kichThuoc);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateKichThuoc(KichThuoc kichThuoc) {
        if (kichThuocRepository.existsById(kichThuoc.getId())) {
            kichThuocRepository.saveAndFlush(kichThuoc);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (kichThuocRepository.existsById(id)) {
            kichThuocRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
