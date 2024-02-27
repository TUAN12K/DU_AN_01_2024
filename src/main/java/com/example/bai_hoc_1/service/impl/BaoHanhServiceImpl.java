package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.BaoHanh;
import com.example.bai_hoc_1.repository.BaoHanhRepository;
import com.example.bai_hoc_1.service.BaoHanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoHanhServiceImpl implements BaoHanhService {

    @Autowired
    private BaoHanhRepository baoHanhRepository;

    @Override
    public List<BaoHanh> getAllBaoHanhs() {
        return baoHanhRepository.findAll();
    }

    @Override
    public BaoHanh getOneBaoHanh(String id) {
        return baoHanhRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveBaoHanh(BaoHanh baoHanh) {
        if (!baoHanhRepository.existsById(baoHanh.getId())) {
            baoHanhRepository.saveAndFlush(baoHanh);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateBaoHanh(BaoHanh baoHanh) {
        if (baoHanhRepository.existsById(baoHanh.getId())) {
            baoHanhRepository.saveAndFlush(baoHanh);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBaoHanh(String id) {
        if (baoHanhRepository.existsById(id)) {
            baoHanhRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
