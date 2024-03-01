package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.TaiKhoan;
import com.example.bai_hoc_1.service.TaiKhoanService;
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
@RequestMapping("/tai-khoan")
public class TaiKhoanRestController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<TaiKhoan>> getAllTaiKhoans() {
        List<TaiKhoan> listTaiKhoans = taiKhoanService.getAllTaiKhoans();
        return ResponseEntity.ok(listTaiKhoans);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<TaiKhoan> getOneTaiKhoan(@PathVariable(name = "id") String id) {
        TaiKhoan taiKhoan = taiKhoanService.getOneTaiKhoan(id);
        if (taiKhoan!= null) {
            return ResponseEntity.ok(taiKhoan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-tai-khoan")
    public ResponseEntity<Boolean> saveTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        boolean saved = taiKhoanService.saveTaiKhoan(taiKhoan);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-tai-khoan/{id}")
    public ResponseEntity<Boolean> updateTaiKhoan(@PathVariable(name = "id") String id, @RequestBody TaiKhoan taiKhoan) {
        boolean updated = taiKhoanService.updateTaiKhoan(taiKhoan);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-tai-khoan/{id}")
    public ResponseEntity<Boolean> deleteTaiKhoan(@PathVariable(name = "id") String id) {
        boolean deleted = taiKhoanService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
