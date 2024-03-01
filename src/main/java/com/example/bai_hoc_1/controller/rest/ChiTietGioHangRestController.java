package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.ChiTietGioHang;
import com.example.bai_hoc_1.service.ChiTietGioHangService;
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
@RequestMapping("/chi-tiet-gio-hang")
public class ChiTietGioHangRestController {

    @Autowired
    private ChiTietGioHangService chiTietGioHangService;

    // GET ALL
    @GetMapping("/get-all")
    public ResponseEntity<List<ChiTietGioHang>> getAllChiTietGioHangs() {
        List<ChiTietGioHang> listChiTietGioHangs = chiTietGioHangService.getAllChiTietGioHangs();
        return ResponseEntity.ok(listChiTietGioHangs);
    }

    // GET ONE
    @GetMapping("/get-one/{id}")
    public ResponseEntity<ChiTietGioHang> getOneChiTietGioHang(@PathVariable(name = "id") String id) {
        ChiTietGioHang chiTietGioHang = chiTietGioHangService.getOneChiTietGioHang(id);
        if (chiTietGioHang != null) {
            return ResponseEntity.ok(chiTietGioHang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save-gio-hang")
    public ResponseEntity<Boolean> saveChiTietGioHang(@RequestBody ChiTietGioHang chiTietGioHang) {
        boolean saved = chiTietGioHangService.saveChiTietGioHang(chiTietGioHang);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping("/update-gio-hang/{id}")
    public ResponseEntity<Boolean> updateChiTietGioHang(@PathVariable(name = "id") String id, @RequestBody ChiTietGioHang chiTietGioHang) {
        boolean updated = chiTietGioHangService.updateChiTietGioHang(chiTietGioHang);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-gio-hang/{id}")
    public ResponseEntity<Boolean> deleteChiTietGioHang(@PathVariable(name = "id") String id) {
        boolean deleted = chiTietGioHangService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
