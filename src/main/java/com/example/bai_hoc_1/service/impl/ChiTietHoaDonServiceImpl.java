package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.ChiTietHoaDon;
import com.example.bai_hoc_1.repository.ChiTietHoaDonRepository;
import com.example.bai_hoc_1.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Override
    public List<ChiTietHoaDon> getAllChiTietHoaDons() {
        return chiTietHoaDonRepository.findAll();
    }

    @Override
    public ChiTietHoaDon getOneChiTietHoaDon(String id) {
        return chiTietHoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (!chiTietHoaDonRepository.existsById(chiTietHoaDon.getId())) {
            chiTietHoaDonRepository.saveAndFlush(chiTietHoaDon);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        if (chiTietHoaDonRepository.existsById(chiTietHoaDon.getId())) {
            chiTietHoaDonRepository.saveAndFlush(chiTietHoaDon);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteById(String id) {
        if (chiTietHoaDonRepository.existsById(id)) {
            chiTietHoaDonRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
