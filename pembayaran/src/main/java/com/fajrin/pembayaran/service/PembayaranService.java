/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.pembayaran.service;

import com.fajrin.pembayaran.entity.Pembayaran;
import com.fajrin.pembayaran.repository.PembayaranRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP14s FQ2002AU
 */
@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    public List<Pembayaran> getAll() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaranById(Long id) {
        return pembayaranRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Pembayaran dengan ID " + id + " tidak ditemukan"));
    }

    public void insert(Pembayaran pembayaran) {
        pembayaranRepository.save(pembayaran);
    }

    public void delete(Long id) {
        pembayaranRepository.deleteById(id);
    }

    @Transactional
    public void update(Long pembayaranId, int ref_number, String tgl_pembayaran, String status, double total) {
        Pembayaran pembayaran = pembayaranRepository.findById(pembayaranId)
                .orElseThrow(() -> new IllegalStateException("Pembayaran dengan ID " + pembayaranId + " tidak ditemukan"));
        pembayaran.setRef_number(ref_number);
        pembayaran.setTgl_pembayaran(tgl_pembayaran);
        pembayaran.setStatus(status);
        pembayaran.setTotal(total);
    }
}