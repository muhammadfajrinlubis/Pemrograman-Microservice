/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fajrin.produk.service;

import com.fajrin.produk.entity.Produk;
import com.fajrin.produk.repository.ProdukRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP14s FQ2002AU
 */

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
    
    public List<Produk> getAll(){
        return produkRepository.findAll();
    }
    
    @Transactional
    public void insert(Produk produk){
        produkRepository.save(produk);
    }
    
    @Transactional
    public void editProduk(String id, Produk updatedProduk) {
        Produk existingProduk = produkRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Produk not found"));
        existingProduk.setKode(updatedProduk.getKode());
        existingProduk.setNama(updatedProduk.getNama());
        existingProduk.setSatuan(updatedProduk.getSatuan());
        produkRepository.save(existingProduk);
    }
    
    @Transactional
    public void deleteProduk(String id) {
        Produk existingProduk = produkRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Produk not found"));
        produkRepository.delete(existingProduk);
    }
}
