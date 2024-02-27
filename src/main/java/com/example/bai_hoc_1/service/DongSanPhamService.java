package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.DongSanPham;

import java.util.List;

public interface DongSanPhamService {
    List<DongSanPham> getAllDongSanPhams();

    DongSanPham getOneDongSanPham(String id);

    Boolean saveDongSanPham(DongSanPham dongSanPham);

    Boolean updateDongSanPham(DongSanPham dongSanPham);

    Boolean deleteById(String id);
}
