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
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "ma_tai_khoan", length = 30)
    private String maTaiKhoan;

    @Column(name = "id_khach_hang", length = 36)
    private String idKhachHang;

    @Column(name = "id_chuc_vu", length = 36)
    private String idChucVu;

    @Column(name = "tai_khoan", length = 30)
    private String taiKhoan;

    @Column(name = "mat_khau", length = 30)
    private String matKhau;

    @Column(name = "mat_khau_cu", length = 30)
    private String matKhauCu;

    @Column(name = "ngay_tao_tai_khoan")
    private Timestamp ngayTaoTaiKhoan;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
