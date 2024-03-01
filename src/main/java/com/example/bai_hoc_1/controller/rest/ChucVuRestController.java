package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.ChucVu;
import com.example.bai_hoc_1.service.ChucVuService;
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
@RequestMapping("/chuc-vu")
public class ChucVuRestController {

    @Autowired
    private ChucVuService chucVuService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<ChucVu>> getAllChucVus() {
        List<ChucVu> listChucVus = chucVuService.getAllChucVus();
        return ResponseEntity.ok(listChucVus);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<ChucVu> getOneChucVu(@PathVariable("id") String id) {
        ChucVu chucVu = chucVuService.getOneChucVu(id);
        if (chucVu != null) {
            return ResponseEntity.ok(chucVu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-chuc-vu")
    public ResponseEntity<Boolean> saveChucVu(@RequestBody ChucVu chucVu) {
        boolean saved = chucVuService.saveChucVu(chucVu);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-chuc-vu/{id}")
    public ResponseEntity<Boolean> updateChucVu(@PathVariable("id") String id, @RequestBody ChucVu chucVu) {
        boolean updated = chucVuService.updateChucVu(chucVu);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-chuc-vu/{id}")
    public ResponseEntity<Boolean> deleteChucVu(@PathVariable("id") String id) {
        boolean deleted = chucVuService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
