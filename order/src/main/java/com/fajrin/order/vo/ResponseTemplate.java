/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.order.vo;

import com.fajrin.order.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;




/**
 *
 * @author HP14s FQ2002AU
 */
public class ResponseTemplate {
    Produk produk;
    Order order;
    Pembayaran pembayaran;
    
    public ResponseTemplate(){
        
    }

    public ResponseTemplate(Order order, Produk produk,Pembayaran pembayaran) {
        this.order = order;
        this.produk = produk;
        this.pembayaran = pembayaran;
    }

    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    @Override
    public String toString() {
        return "ResponseTemplate{" + "produk=" + produk + ", order=" + order + ", pembayaran=" + pembayaran + '}';
    }
    
    @Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
  
}
