package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.ChucVu;
import com.example.bai_hoc_1.repository.ChucVuRepository;
import com.example.bai_hoc_1.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAllChucVus() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getOneChucVu(String id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveChucVu(ChucVu chucVu) {
        if (!chucVuRepository.existsById(chucVu.getId())) {
            chucVuRepository.saveAndFlush(chucVu);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateChucVu(ChucVu chucVu) {
        if (chucVuRepository.existsById(chucVu.getId())) {
            chucVuRepository.saveAndFlush(chucVu);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (chucVuRepository.existsById(id)) {
            chucVuRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
