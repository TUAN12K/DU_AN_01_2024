package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.KhachHang;
import com.example.bai_hoc_1.service.KhachHangService;
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
@RequestMapping("/khach-hang")
public class KhachHangRestController {

    @Autowired
    private KhachHangService khachHangService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<KhachHang>> getAllKhachHangs() {
        List<KhachHang> listKhachHangs = khachHangService.getAllKhachHangs();
        return ResponseEntity.ok(listKhachHangs);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<KhachHang> getOneKhachHang(@PathVariable(name = "id") String id) {
        KhachHang khachHang = khachHangService.getOneKhachHang(id);
        if (khachHang != null) {
            return ResponseEntity.ok(khachHang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-khach-hang")
    public ResponseEntity<Boolean> saveKhachHang(@RequestBody KhachHang khachHang) {
        boolean saved = khachHangService.saveKhachHang(khachHang);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-khach-hang/{id}")
    public ResponseEntity<Boolean> updateKhachHang(@PathVariable(name = "id") String id, @RequestBody KhachHang khachHang) {
        boolean updated = khachHangService.updateKhachHang(khachHang);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-khach-hang/{id}")
    public ResponseEntity<Boolean> deleteKhachHang(@PathVariable(name = "id") String id) {
        boolean deleted = khachHangService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
