/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author CUINIC4
 */
public class Conta  {
    private String idconta;
    private String data;
    private String precoTotal;
    private String nrPedidos;
    private String estado;
    private Factura facturaIdfactura;
    private String pedidoId;
    private String clienteId;
    private String garsonId;

    public String getGarsonId() {
        return garsonId;
    }

    public void setGarsonId(String garsonId) {
        this.garsonId = garsonId;
    }
    
    
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
    
    
    public String getIdconta() {
        return idconta;
    }

    public void setIdconta(String idconta) {
        this.idconta = idconta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getNrPedidos() {
        return nrPedidos;
    }

    public void setNrPedidos(String nrPedidos) {
        this.nrPedidos = nrPedidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Factura getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(Factura facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String toString() {
        return "model.entity.Conta[ contaPK=" + idconta + " ]";
    }
    
}
