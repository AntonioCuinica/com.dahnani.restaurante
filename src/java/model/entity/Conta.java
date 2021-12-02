/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author CUINIC4
 */
public class Conta  {
    private int idconta;
    private Date data;
    private Double precoTodal;
    private int nrPedidos;
    private Factura facturaIdfactura;

    public Conta() {
    }

    public int getIdconta() {
        return idconta;
    }

    public void setIdconta(int idconta) {
        this.idconta = idconta;
    }

    public int getNrPedidos() {
        return nrPedidos;
    }

    public void setNrPedidos(int nrPedidos) {
        this.nrPedidos = nrPedidos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPrecoTodal() {
        return precoTodal;
    }

    public void setPrecoTodal(Double precoTodal) {
        this.precoTodal = precoTodal;
    }

    public Factura getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(Factura facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

   
    @Override
    public String toString() {
        return "model.entity.Conta[ contaPK=" + idconta + " ]";
    }
    
}
