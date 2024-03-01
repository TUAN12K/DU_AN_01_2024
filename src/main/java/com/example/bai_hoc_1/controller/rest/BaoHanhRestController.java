package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.BaoHanh;
import com.example.bai_hoc_1.service.BaoHanhService;
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
@RequestMapping("/bao-hanh")
public class BaoHanhRestController {

    @Autowired
    private BaoHanhService baoHanhService;

    @GetMapping("/get-all")
    public ResponseEntity<List<BaoHanh>> getAllBaoHanhs() {
        List<BaoHanh> listBaoHanhs = baoHanhService.getAllBaoHanhs();
        return ResponseEntity.ok(listBaoHanhs);
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<BaoHanh> getOneBaoHanh(@PathVariable("id") String id) {
        BaoHanh baoHanh = baoHanhService.getOneBaoHanh(id);
        if (baoHanh != null) {
            return ResponseEntity.ok(baoHanh);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-bao-hanh")
    public ResponseEntity<Boolean> saveBaoHanh(@RequestBody BaoHanh baoHanh) {
        boolean saved = baoHanhService.saveBaoHanh(baoHanh);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-bao-hanh/{id}")
    public ResponseEntity<Boolean> updateBaoHanh(@PathVariable("id") String id, @RequestBody BaoHanh baoHanh) {
        boolean updated = baoHanhService.updateBaoHanh(baoHanh);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-bao-hanh/{id}")
    public ResponseEntity<Boolean> deleteBaoHanh(@PathVariable("id") String id) {
        boolean deleted = baoHanhService.deleteBaoHanh(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
