package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAllChiTietSanPhams();

    ChiTietSanPham getOneChiTietSanPham(String id);

    Boolean saveChiTietSanPham(ChiTietSanPham chiTietSanPham);

    Boolean updateChiTietSanPham(ChiTietSanPham ChiTietSanPham);

    Boolean deleteById(String id);
}
