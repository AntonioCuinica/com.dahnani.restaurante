/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;


/**
 *
 * @author CUINIC4
 */

public class Pedido  {
    private int idpedido;
    private Bebida bebidaIdbebida;
    private Mesa mesaIdmesa;
    private Prato pratoIdprato;

    public Pedido() {
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    
    public Bebida getBebidaIdbebida() {
        return bebidaIdbebida;
    }

    public void setBebidaIdbebida(Bebida bebidaIdbebida) {
        this.bebidaIdbebida = bebidaIdbebida;
    }

    public Mesa getMesaIdmesa() {
        return mesaIdmesa;
    }

    public void setMesaIdmesa(Mesa mesaIdmesa) {
        this.mesaIdmesa = mesaIdmesa;
    }

    public Prato getPratoIdprato() {
        return pratoIdprato;
    }

    public void setPratoIdprato(Prato pratoIdprato) {
        this.pratoIdprato = pratoIdprato;
    }


    @Override
    public String toString() {
        return "model.entity.Pedido[ pedidoPK=" + idpedido + " ]";
    }
    
}
