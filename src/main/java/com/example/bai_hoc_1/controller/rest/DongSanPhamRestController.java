package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.DongSanPham;
import com.example.bai_hoc_1.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham")
public class DongSanPhamRestController {
    @Autowired
    private DongSanPhamService dongSanPhamService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<DongSanPham>> getAllDongSanPhams() {
        List<DongSanPham> listDongSanPhams = dongSanPhamService.getAllDongSanPhams();
        return ResponseEntity.ok(listDongSanPhams);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<DongSanPham> getOneDongSanPham(@PathVariable(name = "id") String id) {
        DongSanPham dongSanPham = dongSanPhamService.getOneDongSanPham(id);
        if (dongSanPham != null) {
            return ResponseEntity.ok(dongSanPham);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-dong-san-pham")
    public ResponseEntity<Boolean> saveDongSanPham(@RequestBody DongSanPham dongSanPham) {
        boolean saved = dongSanPhamService.saveDongSanPham(dongSanPham);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    // PUT:
    @PutMapping("/update-dong-san-pham/{id}")
    public ResponseEntity<Boolean> updateDongSanPham(@PathVariable(name = "id") String id, @RequestBody DongSanPham dongSanPham) {
        boolean updated = dongSanPhamService.updateDongSanPham(dongSanPham);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-dong-san-pham/{id}")
    public ResponseEntity<Boolean> deleteDongSanPham(@PathVariable(name = "id") String id) {
        boolean deleted = dongSanPhamService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
