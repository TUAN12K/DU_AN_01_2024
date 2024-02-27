package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.GioHang;

import java.util.List;

public interface GioHangService {
    List<GioHang> getAllGioHangs();

    GioHang getOneGioHang(String id);

    Boolean saveGioHang(GioHang gioHang);

    Boolean updateGioHang(GioHang gioHang);

    Boolean deleteById(String id);
}
