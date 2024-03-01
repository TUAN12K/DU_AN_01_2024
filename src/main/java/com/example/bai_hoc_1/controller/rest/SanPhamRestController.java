package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.SanPham;
import com.example.bai_hoc_1.service.SanPhamService;
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
@RequestMapping("/san-pham")
public class SanPhamRestController {

    @Autowired
    private SanPhamService sanPhamService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<SanPham>> getAllSanPhams() {
        List<SanPham> listSanPhams = sanPhamService.getAllSanPhams();
        return ResponseEntity.ok(listSanPhams);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<SanPham> getOneSanPham(@PathVariable(name = "id") String id) {
        SanPham sanPham = sanPhamService.getOneSanPham(id);
        if (sanPham != null) {
            return ResponseEntity.ok(sanPham);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-san-pham")
    public ResponseEntity<Boolean> saveSanPham(@RequestBody SanPham sanPham) {
        boolean saved = sanPhamService.saveSanPham(sanPham);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-san-pham/{id}")
    public ResponseEntity<Boolean> updateSanPham(@PathVariable(name = "id") String id, @RequestBody SanPham sanPham) {
        boolean updated = sanPhamService.updateSanPham(sanPham);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-san-pham/{id}")
    public ResponseEntity<Boolean> deleteSanPham(@PathVariable(name = "id") String id) {
        boolean deleted = sanPhamService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
