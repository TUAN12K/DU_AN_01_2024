package com.example.bai_hoc_1.service;


import com.example.bai_hoc_1.entity.KichThuoc;

import java.util.List;

public interface KichThuocService {
    List<KichThuoc> getAllKichThuocs();

    KichThuoc getOneKichThuoc(String id);

    Boolean saveKichThuoc(KichThuoc kichThuoc);

    Boolean updateKichThuoc(KichThuoc kichThuoc);

    Boolean deleteById(String id);
}
