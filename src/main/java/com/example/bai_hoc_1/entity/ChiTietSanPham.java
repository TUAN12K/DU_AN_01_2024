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

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "id_san_pham", length = 36)
    private String idSanPham;

    @Column(name = "id_dong_san_pham", length = 36)
    private String idDongSanPham;

    @Column(name = "id_kich_thuoc", length = 36)
    private String idKichThuoc;

    @Column(name = "id_thuong_hieu", length = 36)
    private String idThuongHieu;

    @Column(name = "id_bo_nho", length = 36)
    private String idBoNho;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "ngay_nhap_hang")
    private Timestamp ngayNhapHang;

    @Column(name = "nam_bao_hanh")
    private Integer namBaoHanh;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
