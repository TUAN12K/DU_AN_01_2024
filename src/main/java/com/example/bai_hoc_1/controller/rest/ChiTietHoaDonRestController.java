package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.ChiTietHoaDon;
import com.example.bai_hoc_1.service.ChiTietHoaDonService;
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
@RequestMapping("/chi-tiet-hoa-don")
public class ChiTietHoaDonRestController {
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<ChiTietHoaDon>> getAllChiTietHoaDons() {
        List<ChiTietHoaDon> listChiTietHoaDons = chiTietHoaDonService.getAllChiTietHoaDons();
        return ResponseEntity.ok(listChiTietHoaDons);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<ChiTietHoaDon> getOneChiTietHoaDon(@PathVariable(name = "id") String id) {
        ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.getOneChiTietHoaDon(id);
        if (chiTietHoaDon != null) {
            return ResponseEntity.ok(chiTietHoaDon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-chi-tiet-hoa-don")
    public ResponseEntity<Boolean> saveChiTietHoaDon(@RequestBody ChiTietHoaDon chiTietHoaDon) {
        boolean saved = chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping("/update-chi-tiet-hoa-don/{id}")
    public ResponseEntity<Boolean> saveChiTietHoaDon(@PathVariable(name = "id") String id, @RequestBody ChiTietHoaDon chiTietHoaDon) {
        boolean updated = chiTietHoaDonService.updateChiTietHoaDon(chiTietHoaDon);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-chi-tiet-hoa-don/{id}")
    public ResponseEntity<Boolean> deleteChiTietHoaDon(@PathVariable(name = "id") String id) {
        boolean deleted = chiTietHoaDonService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
