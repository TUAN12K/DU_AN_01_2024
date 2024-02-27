package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.SanPham;
import com.example.bai_hoc_1.repository.SanPhamRepository;
import com.example.bai_hoc_1.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAllSanPhams() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getOneSanPham(String id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveSanPham(SanPham sanPham) {
        if (!sanPhamRepository.existsById(sanPham.getId())) {
            sanPhamRepository.saveAndFlush(sanPham);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSanPham(SanPham sanPham) {
        if (sanPhamRepository.existsById(sanPham.getId())) {
            sanPhamRepository.saveAndFlush(sanPham);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
