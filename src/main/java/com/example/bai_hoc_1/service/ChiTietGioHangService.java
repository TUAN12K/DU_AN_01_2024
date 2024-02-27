package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.ChiTietGioHang;

import java.util.List;

public interface ChiTietGioHangService {
    List<ChiTietGioHang> getAllChiTietGioHangs();

    ChiTietGioHang getOneChiTietGioHang(String id);

    Boolean saveChiTietGioHang(ChiTietGioHang chiTietGioHang);

    Boolean updateChiTietGioHang(ChiTietGioHang chiTietGioHang);

    Boolean deleteById(String id);
}
