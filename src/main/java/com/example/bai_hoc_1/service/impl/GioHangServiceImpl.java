package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.GioHang;
import com.example.bai_hoc_1.repository.GioHangRepository;
import com.example.bai_hoc_1.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getAllGioHangs() {
        return gioHangRepository.findAll();
    }

    @Override
    public GioHang getOneGioHang(String id) {
        return gioHangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveGioHang(GioHang gioHang) {
        if (!gioHangRepository.existsById(gioHang.getId())) {
            gioHangRepository.saveAndFlush(gioHang);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateGioHang(GioHang gioHang) {
        if (gioHangRepository.existsById(gioHang.getId())) {
            gioHangRepository.saveAndFlush(gioHang);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (gioHangRepository.existsById(id)) {
            gioHangRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
