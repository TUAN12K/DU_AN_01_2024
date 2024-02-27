package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getAllTaiKhoans();

    TaiKhoan getOneTaiKhoan(String id);

    Boolean saveTaiKhoan(TaiKhoan taiKhoan);

    Boolean updateTaiKhoan(TaiKhoan taiKhoan);

    Boolean deleteById(String id);
}
