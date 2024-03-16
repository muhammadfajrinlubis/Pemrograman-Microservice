/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.order.service;

import com.fajrin.order.entity.Order;
import com.fajrin.order.repository.OrderRepository;
import com.fajrin.order.vo.Produk;
import com.fajrin.order.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




/**
 *
 * @author HP14s FQ2002AU
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    public void insert(Order order) {
        orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public void update(Long orderId, int jumlah, String tanggal, String status, double total) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order tidak ada"));
        if(jumlah > 0 && (order.getJumlah() != jumlah) ){
            order.setJumlah(jumlah);
        }
        if(tanggal!=null && tanggal.length()>0 && !order.getTanggal().equals(tanggal)) {
            order.setTanggal(tanggal);
        }
        if(status!=null && status.length()>0 && !order.getStatus().equals(status)) {
            order.setStatus(tanggal);
        }
        if(jumlah > 0 && order.getTotal() != total) {
            order.setTotal(total);
        }
    }
    public Order getOderById(Long id){
        return orderRepository.findById(id).get();
    }
    
    public List<ResponseTemplate>getOrderWithProdukById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Order order = getOrderById(id);
        Produk produk = restTemplate.getForObject("http://localhost:9001/api/v1/produk"
                + order.getProdukId(), Produk.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        responseList.add(vo);
        return responseList;
    }
}