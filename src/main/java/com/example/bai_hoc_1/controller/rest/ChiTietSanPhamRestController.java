package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.ChiTietSanPham;
import com.example.bai_hoc_1.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamRestController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<ChiTietSanPham>> getAllChiTietSanPhams() {
        List<ChiTietSanPham> listChiTietSanPhams = chiTietSanPhamService.getAllChiTietSanPhams();
        return ResponseEntity.ok(listChiTietSanPhams);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<ChiTietSanPham> getOneChiTietSanPham(@PathVariable("id") String id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOneChiTietSanPham(id);
        if (chiTietSanPham != null) {
            return ResponseEntity.ok(chiTietSanPham);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-chi-tiet-san-pham")
    public ResponseEntity<Boolean> saveChiTietSanPham(@RequestBody ChiTietSanPham chiTietSanPham) {
        boolean saved = chiTietSanPhamService.saveChiTietSanPham(chiTietSanPham);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-chi-tiet-san-pham/{id}")
    public ResponseEntity<Boolean> updateChiTietSanPham(@PathVariable("id") String id, @RequestBody ChiTietSanPham chiTietSanPham) {
        boolean updated = chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-chi-tiet-san-pham/{id}")
    public ResponseEntity<Boolean> deleteChiTietSanPham(@PathVariable("id") String id) {
        boolean deleted = chiTietSanPhamService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
