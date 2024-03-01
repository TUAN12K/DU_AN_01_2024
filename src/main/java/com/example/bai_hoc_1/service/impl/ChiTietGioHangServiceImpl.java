package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.ChiTietGioHang;
import com.example.bai_hoc_1.repository.ChiTietGioHangRepository;
import com.example.bai_hoc_1.service.ChiTietGioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietGioHangServiceImpl implements ChiTietGioHangService {
    @Autowired
    private ChiTietGioHangRepository chiTietGioHangRepository;

    @Override
    public List<ChiTietGioHang> getAllChiTietGioHangs() {
        return chiTietGioHangRepository.findAll();
    }

    @Override
    public ChiTietGioHang getOneChiTietGioHang(String id) {
        return chiTietGioHangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        if (!chiTietGioHangRepository.existsById(chiTietGioHang.getId())) {
            chiTietGioHangRepository.saveAndFlush(chiTietGioHang);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        if (chiTietGioHangRepository.existsById(chiTietGioHang.getId())) {
            chiTietGioHangRepository.saveAndFlush(chiTietGioHang);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteById(String id) {
        if (chiTietGioHangRepository.existsById(id)) {
            chiTietGioHangRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
