package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.ThuongHieu;
import com.example.bai_hoc_1.repository.ThuongHieuRepository;
import com.example.bai_hoc_1.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Override
    public List<ThuongHieu> getAllThuongHieus() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public ThuongHieu getOneThuongHieu(String id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveThuongHieu(ThuongHieu thuongHieu) {
        if (!thuongHieuRepository.existsById(thuongHieu.getId())) {
            thuongHieuRepository.saveAndFlush(thuongHieu);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateThuongHieu(ThuongHieu thuongHieu) {
        if (thuongHieuRepository.existsById(thuongHieu.getId())) {
            thuongHieuRepository.saveAndFlush(thuongHieu);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (thuongHieuRepository.existsById(id)) {
            thuongHieuRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
