package com.example.bai_hoc_1.service.impl;

import com.example.bai_hoc_1.entity.BoNho;
import com.example.bai_hoc_1.repository.BoNhoRepository;
import com.example.bai_hoc_1.service.BoNhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoNhoServiceImpl implements BoNhoService {

    @Autowired
    private BoNhoRepository boNhoRepository;

    @Override
    public List<BoNho> getAllBoNhos() {
        return boNhoRepository.findAll();
    }

    @Override
    public BoNho getOneBoNho(String id) {
        return boNhoRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean saveBoNho(BoNho boNho) {
        if (!boNhoRepository.existsById(boNho.getId())) {
            boNhoRepository.saveAndFlush(boNho);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateBoNho(BoNho boNho) {
        if (boNhoRepository.existsById(boNho.getId())) {
            boNhoRepository.saveAndFlush(boNho);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        if (boNhoRepository.existsById(id)) {
            boNhoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
