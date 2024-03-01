package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.KichThuoc;
import com.example.bai_hoc_1.service.KichThuocService;
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
@RequestMapping("/kich-thuoc")
public class KichThuocRestController {

    @Autowired
    private KichThuocService kichThuocService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<KichThuoc>> getAllKichThuocs() {
        List<KichThuoc> listKichThuocs = kichThuocService.getAllKichThuocs();
        return ResponseEntity.ok(listKichThuocs);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<KichThuoc> getOneKichThuoc(@PathVariable(name = "id") String id) {
        KichThuoc kichThuoc = kichThuocService.getOneKichThuoc(id);
        if (kichThuoc != null) {
            return ResponseEntity.ok(kichThuoc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-kich-thuoc")
    public ResponseEntity<Boolean> saveKichThuoc(@RequestBody KichThuoc kichThuoc) {
        boolean saved = kichThuocService.saveKichThuoc(kichThuoc);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-kich-thuoc/{id}")
    public ResponseEntity<Boolean> updateKichThuoc(@PathVariable(name = "id") String id, @RequestBody KichThuoc kichThuoc) {
        boolean updated = kichThuocService.updateKichThuoc(kichThuoc);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-kich-thuoc/{id}")
    public ResponseEntity<Boolean> deleteKichThuoc(@PathVariable(name = "id") String id) {
        boolean deleted = kichThuocService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
