package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.BaoHanh;

import java.util.List;

public interface BaoHanhService {

    List<BaoHanh> getAllBaoHanhs();

    BaoHanh getOneBaoHanh(String id);

    Boolean saveBaoHanh(BaoHanh baoHanh);

    Boolean updateBaoHanh(BaoHanh baoHanh);

    Boolean deleteBaoHanh(String id);

}
