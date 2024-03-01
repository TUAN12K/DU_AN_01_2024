package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.ThuongHieu;
import com.example.bai_hoc_1.service.ThuongHieuService;
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
@RequestMapping("/thuong-hieu")
public class ThuongHieuRestController {
    @Autowired
    private ThuongHieuService thuongHieuService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<ThuongHieu>> getAllThuongHieus() {
        List<ThuongHieu> listThuongHieus = thuongHieuService.getAllThuongHieus();
        return ResponseEntity.ok(listThuongHieus);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<ThuongHieu> getOneThuongHieu(@PathVariable(name = "id") String id) {
        ThuongHieu thuongHieu = thuongHieuService.getOneThuongHieu(id);
        if (thuongHieu != null) {
            return ResponseEntity.ok(thuongHieu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-thuong-hieu")
    public ResponseEntity<Boolean> saveThuongHieu(@RequestBody ThuongHieu thuongHieu) {
        boolean saved = thuongHieuService.saveThuongHieu(thuongHieu);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-thuong-hieu/{id}")
    public ResponseEntity<Boolean> updateThuongHieu(@PathVariable(name = "id") String id, @RequestBody ThuongHieu thuongHieu) {
        boolean updated = thuongHieuService.updateThuongHieu(thuongHieu);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-thuong-hieu/{id}")
    public ResponseEntity<Boolean> deleteThuongHieu(@PathVariable(name = "id") String id) {
        boolean deleted = thuongHieuService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
