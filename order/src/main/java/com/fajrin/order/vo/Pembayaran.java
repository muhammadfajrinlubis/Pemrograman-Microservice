/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.order.vo;



/**
 *
 * @author HP14s FQ2002AU
 */

public class Pembayaran {
 
    private Long id;
    private Long oerder_Id;
    private String mode_pemabayaran;
    private int ref_number;
    private String tgl_pembayaran;
    private String status;
    private double total;
    
    public Pembayaran(){
        
    }

    public Pembayaran(Long id, Long oerder_Id, String mode_pemabayaran, int ref_number, String tgl_pembayaran, String status, double total) {
        this.id = id;
        this.oerder_Id = oerder_Id;
        this.mode_pemabayaran = mode_pemabayaran;
        this.ref_number = ref_number;
        this.tgl_pembayaran = tgl_pembayaran;
        this.status = status;
        this.total = total;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOerder_Id() {
        return oerder_Id;
    }

    public void setOerder_Id(Long oerder_Id) {
        this.oerder_Id = oerder_Id;
    }

    public String getMode_pemabayaran() {
        return mode_pemabayaran;
    }

    public void setMode_pemabayaran(String mode_pemabayaran) {
        this.mode_pemabayaran = mode_pemabayaran;
    }

    public int getRef_number() {
        return ref_number;
    }

    public void setRef_number(int ref_number) {
        this.ref_number = ref_number;
    }

    public String getTgl_pembayaran() {
        return tgl_pembayaran;
    }

    public void setTgl_pembayaran(String tgl_pembayaran) {
        this.tgl_pembayaran = tgl_pembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

