package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.KhachHang;
import com.example.bai_hoc_1.repository.KhachHangRepository;
import com.example.bai_hoc_1.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHangs() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getOneKhachHang(String id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveKhachHang(KhachHang khachHang) {
        if (!khachHangRepository.existsById(khachHang.getId())) {
            khachHangRepository.saveAndFlush(khachHang);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateKhachHang(KhachHang khachHang) {
        if (khachHangRepository.existsById(khachHang.getId())) {
            khachHangRepository.saveAndFlush(khachHang);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (khachHangRepository.existsById(id)) {
            khachHangRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
