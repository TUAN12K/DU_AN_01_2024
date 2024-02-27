package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.DongSanPham;
import com.example.bai_hoc_1.repository.DongSanPhamRepository;
import com.example.bai_hoc_1.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAllDongSanPhams() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public DongSanPham getOneDongSanPham(String id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveDongSanPham(DongSanPham dongSanPham) {
        if (!dongSanPhamRepository.existsById(dongSanPham.getId())) {
            dongSanPhamRepository.saveAndFlush(dongSanPham);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateDongSanPham(DongSanPham dongSanPham) {
        if (dongSanPhamRepository.existsById(dongSanPham.getId())) {
            dongSanPhamRepository.saveAndFlush(dongSanPham);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (dongSanPhamRepository.existsById(id)) {
            dongSanPhamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
