package com.example.bai_hoc_1.controller.rest;

import com.example.bai_hoc_1.entity.HoaDon;
import com.example.bai_hoc_1.service.HoaDonService;
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
@RequestMapping("/hoa-don")
public class HoaDonRestController {

    @Autowired
    private HoaDonService hoaDonService;

    // GET ALL:
    @GetMapping("/get-all")
    public ResponseEntity<List<HoaDon>> getAllHoaDon() {
        List<HoaDon> listHoaDon = hoaDonService.getAllHoaDons();
        return ResponseEntity.ok(listHoaDon);
    }

    // GET ONE:
    @GetMapping("/get-one/{id}")
    public ResponseEntity<HoaDon> getOneHoaDon(@PathVariable(name = "id") String id) {
        HoaDon hoaDon = hoaDonService.getOneHoaDon(id);
        if (hoaDon != null) {
            return ResponseEntity.ok(hoaDon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST:
    @PostMapping("/save-hoa-don")
    public ResponseEntity<Boolean> saveHoaDon(@RequestBody HoaDon hoaDon) {
        boolean saved = hoaDonService.saveHoaDon(hoaDon);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // PUT:
    @PutMapping("/update-hoa-don/{id}")
    public ResponseEntity<Boolean> updateHoaDon(@PathVariable(name = "id") String id, @RequestBody HoaDon hoaDon) {
        boolean updated = hoaDonService.updateHoaDon(hoaDon);
        if (updated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE:
    @DeleteMapping("/delete-hoa-don/{id}")
    public ResponseEntity<Boolean> deleteHoaDon(@PathVariable(name = "id") String id) {
        boolean deleted = hoaDonService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
