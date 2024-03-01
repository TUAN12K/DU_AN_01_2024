package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.BoNho;
import com.example.bai_hoc_1.service.BoNhoService;
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
@RequestMapping("/bo-nho")
public class BoNhoRestController {

    @Autowired
    private BoNhoService boNhoService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<BoNho>> getAllBoNhos() {
        List<BoNho> listBoNhos = boNhoService.getAllBoNhos();
        return ResponseEntity.ok(listBoNhos);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<BoNho> getOneBoNho(@PathVariable("id") String id) {
        BoNho boNho = boNhoService.getOneBoNho(id);
        if (boNho != null) {
            return ResponseEntity.ok(boNho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-bo-nho")
    public ResponseEntity<Boolean> saveBaoHanh(@RequestBody BoNho boNho) {
        boolean saved = boNhoService.saveBoNho(boNho);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-bo-nho/{id}")
    public ResponseEntity<Boolean> updateBoNho(@PathVariable("id") String id, @RequestBody BoNho boNho) {
        boolean updated = boNhoService.updateBoNho(boNho);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-bo-nho/{id}")
    public ResponseEntity<Boolean> deleteBoNho(@PathVariable("id") String id) {
        boolean deleted = boNhoService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
