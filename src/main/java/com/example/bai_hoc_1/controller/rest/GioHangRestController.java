package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.GioHang;
import com.example.bai_hoc_1.service.GioHangService;
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
@RequestMapping("/gio-hang")
public class GioHangRestController {

    @Autowired
    private GioHangService gioHangService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<GioHang>> getAllGioHangs() {
        List<GioHang> listGioHangs = gioHangService.getAllGioHangs();
        return ResponseEntity.ok(listGioHangs);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<GioHang> getOneGioHang(@PathVariable(name = "id") String id) {
        GioHang gioHang = gioHangService.getOneGioHang(id);
        if (gioHang != null) {
            return ResponseEntity.ok(gioHang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-gio-hang")
    public ResponseEntity<Boolean> saveGioHang(@RequestBody GioHang gioHang) {
        boolean saved = gioHangService.saveGioHang(gioHang);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-gio-hang/{id}")
    public ResponseEntity<Boolean> updateGioHang(@PathVariable(name = "id") String id, @RequestBody GioHang gioHang) {
        boolean updated = gioHangService.updateGioHang(gioHang);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-gio-hang/{id}")
    public ResponseEntity<Boolean> deleteGioHang(@PathVariable(name = "id") String id) {
        boolean deleted = gioHangService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
