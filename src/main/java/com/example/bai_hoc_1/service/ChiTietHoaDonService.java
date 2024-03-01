package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.ChiTietHoaDon;

import java.util.List;

public interface ChiTietHoaDonService {
    List<ChiTietHoaDon> getAllChiTietHoaDons();

    ChiTietHoaDon getOneChiTietHoaDon(String id);

    Boolean saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);

    Boolean updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);

    Boolean deleteById(String id);
}
