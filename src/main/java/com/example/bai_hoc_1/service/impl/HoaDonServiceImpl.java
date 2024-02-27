package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.HoaDon;
import com.example.bai_hoc_1.repository.HoaDonRepository;
import com.example.bai_hoc_1.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAllHoaDons() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon getOneHoaDon(String id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveHoaDon(HoaDon hoaDon) {
        if (!hoaDonRepository.existsById(hoaDon.getId())) {
            hoaDonRepository.saveAndFlush(hoaDon);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateHoaDon(HoaDon hoaDon) {
        if (hoaDonRepository.existsById(hoaDon.getId())) {
            hoaDonRepository.saveAndFlush(hoaDon);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (hoaDonRepository.existsById(id)) {
            hoaDonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
