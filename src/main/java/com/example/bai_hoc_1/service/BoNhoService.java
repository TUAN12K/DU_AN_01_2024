package com.example.bai_hoc_1.service;

import com.example.bai_hoc_1.entity.BoNho;

import java.util.List;

public interface BoNhoService {

    List<BoNho> getAllBoNhos();

    BoNho getOneBoNho(String id);

    Boolean saveBoNho(BoNho boNho);

    Boolean updateBoNho(BoNho boNho);

    Boolean deleteById(String id);
}
