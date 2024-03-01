package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.TaiKhoan;
import com.example.bai_hoc_1.repository.TaiKhoanRepository;
import com.example.bai_hoc_1.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> getAllTaiKhoans() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoan getOneTaiKhoan(String id)  {
        return taiKhoanRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveTaiKhoan(TaiKhoan taiKhoan) {
        if (!taiKhoanRepository.existsById(taiKhoan.getId())) {
            taiKhoanRepository.saveAndFlush(taiKhoan);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        if (taiKhoanRepository.existsById(taiKhoan.getId())) {
            taiKhoanRepository.saveAndFlush(taiKhoan);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (taiKhoanRepository.existsById(id)) {
            taiKhoanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
