package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {
    List<ThuongHieu> getAllThuongHieus();

    ThuongHieu getOneThuongHieu(String id);

    Boolean saveThuongHieu(ThuongHieu thuongHieu);

    Boolean updateThuongHieu(ThuongHieu thuongHieu);

    Boolean deleteById(String id);
}
