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
    private static final long serialVersionUID = 1L;
    private Date data;
    private Double precoTodal;
    private Integer nrPedidos;
    private Factura facturaIdfactura;
    private RequisitarPedido requisitarPedido;

    public Conta() {
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

    public Integer getNrPedidos() {
        return nrPedidos;
    }

    public void setNrPedidos(Integer nrPedidos) {
        this.nrPedidos = nrPedidos;
    }

    public Factura getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(Factura facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

    public RequisitarPedido getRequisitarPedido() {
        return requisitarPedido;
    }

    public void setRequisitarPedido(RequisitarPedido requisitarPedido) {
        this.requisitarPedido = requisitarPedido;
    }

   

    @Override
    public String toString() {
        return "model.entity.Conta[ contaPK=" + contaPK + " ]";
    }
    
}
