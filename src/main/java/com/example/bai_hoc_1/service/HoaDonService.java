package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> getAllHoaDons();

    HoaDon getOneHoaDon(String id);

    Boolean saveHoaDon(HoaDon hoaDon);

    Boolean updateHoaDon(HoaDon hoaDon);

    Boolean deleteById(String id);
}
