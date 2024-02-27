package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAllSanPhams();

    SanPham getOneSanPham(String id);

    Boolean saveSanPham(SanPham sanPham);

    Boolean updateSanPham(SanPham sanPham);

    Boolean deleteById(String id);
}
