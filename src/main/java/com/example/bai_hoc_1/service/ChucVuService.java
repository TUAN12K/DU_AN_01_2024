package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.ChucVu;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAllChucVus();

    ChucVu getOneChucVu(String id);

    Boolean saveChucVu(ChucVu chucVu);

    Boolean updateChucVu(ChucVu chucVu);

    Boolean deleteById(String id);
}
