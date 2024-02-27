package com.example.bai_hoc_1.repository;

import com.example.bai_hoc_1.entity.GioHang;
import com.example.bai_hoc_1.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
}
