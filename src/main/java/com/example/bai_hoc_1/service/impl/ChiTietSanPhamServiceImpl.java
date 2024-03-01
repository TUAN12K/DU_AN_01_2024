package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.ChiTietSanPham;
import com.example.bai_hoc_1.repository.ChiTietSanPhamRepository;
import com.example.bai_hoc_1.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAllChiTietSanPhams() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSanPham getOneChiTietSanPham(String id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        if (!chiTietSanPhamRepository.existsById(chiTietSanPham.getId())) {
            chiTietSanPhamRepository.saveAndFlush(chiTietSanPham);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        if (chiTietSanPhamRepository.existsById(chiTietSanPham.getId())) {
            chiTietSanPhamRepository.saveAndFlush(chiTietSanPham);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteById(String id) {
        if (chiTietSanPhamRepository.existsById(id)) {
            chiTietSanPhamRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
