/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package com.fajrin.pembayaran.controller;

import com.fajrin.pembayaran.entity.Pembayaran;
import com.fajrin.pembayaran.service.PembayaranService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author HP14s FQ2002AU
 */
@RestController
@RequestMapping("/api/v1/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranService pembayaranService;
    
    @GetMapping
    public List<Pembayaran> getAll(){
        return pembayaranService.getAll();
    }
    
    @PostMapping 
    public void insertPembayaran(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insert(pembayaran);
    }

    @DeleteMapping("/{id}") 
    public void deletePembayaran(@PathVariable Long id) {
        pembayaranService.delete(id);
    }
    
    @PutMapping("/{pembayaranId}")
    public void updatePembayaran(@PathVariable Long pembayaranId, @RequestBody Pembayaran pembayaran) {
        pembayaranService.update(pembayaranId, pembayaran.getRef_number(), pembayaran.getTgl_pembayaran(), pembayaran.getStatus(), pembayaran.getTotal());
    }
}
