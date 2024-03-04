package com.fajrin.order.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.fajrin.order.entity.Order;
import com.fajrin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 *
 * @author HP14s FQ2002AU
 */

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }
            
}