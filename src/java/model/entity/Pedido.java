/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.ArrayList;


/**
 *
 * @author CUINIC4
 */

public class Pedido  {
    private int idpedido;
    private String data;
    private ArrayList<Bebida> bebidaIdbebida;
    private ArrayList<Mesa> mesaIdmesa;
    private ArrayList<Prato> pratoIdprato;

    public Pedido() {
    }

    public int getIdpedido() {
        return idpedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    
    public ArrayList<Bebida> getBebidaIdbebida() {
        return bebidaIdbebida;
    }

    public void setBebidaIdbebida(ArrayList<Bebida> bebidaIdbebida) {
        this.bebidaIdbebida = bebidaIdbebida;
    }

    public ArrayList<Mesa> getMesaIdmesa() {
        return mesaIdmesa;
    }

    public void setMesaIdmesa(ArrayList<Mesa> mesaIdmesa) {
        this.mesaIdmesa = mesaIdmesa;
    }

    public ArrayList<Prato> getPratoIdprato() {
        return pratoIdprato;
    }

    public void setPratoIdprato(ArrayList<Prato> pratoIdprato) {
        this.pratoIdprato = pratoIdprato;
    }


    @Override
    public String toString() {
        return "model.entity.Pedido[ pedidoPK=" + idpedido + " ]";
    }
    
}
