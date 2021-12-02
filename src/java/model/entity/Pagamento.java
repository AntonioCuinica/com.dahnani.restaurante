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
public class Pagamento  {
    private static final long serialVersionUID = 1L;
    private Double valor;
    private Date data;
    private Factura factura;
    private Recibo recibo;

    public Pagamento() {
    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }


    @Override
    public String toString() {
        return "model.entity.Pagamento[ pagamentoPK=" + pagamentoPK + " ]";
    }
    
}
