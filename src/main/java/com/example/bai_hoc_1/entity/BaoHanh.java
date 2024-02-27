package com.example.bai_hoc_1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "bao_hanh")
public class BaoHanh {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "id_san_pham", length = 36)
    private String idSanPham;

    @Column(name = "thoi_gian_bao_hanh")
    private Timestamp thoiGianBaoHanh;

    @Column(name = "ngay_mua_hang")
    private Timestamp ngayMuaHang;

    @Column(name = "ngay_het_han")
    private Timestamp ngayHetHan;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
