package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> getAllKhachHangs();

    KhachHang getOneKhachHang(String id);

    Boolean saveKhachHang(KhachHang khachHang);

    Boolean updateKhachHang(KhachHang khachHang);

    Boolean deleteById(String id);
}
