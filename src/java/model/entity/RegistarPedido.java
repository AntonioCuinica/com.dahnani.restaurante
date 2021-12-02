/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author CUINIC4
 */
@Entity
@Table(name = "registar_pedido")
@NamedQueries({
    @NamedQuery(name = "RegistarPedido.findAll", query = "SELECT r FROM RegistarPedido r")})
public class RegistarPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistarPedidoPK registarPedidoPK;
    @JoinColumn(name = "Garson_idGarson", referencedColumnName = "idGarson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Garson garson;
    @JoinColumn(name = "Pedido_idPedido", referencedColumnName = "idPedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    public RegistarPedido() {
    }

    public RegistarPedido(RegistarPedidoPK registarPedidoPK) {
        this.registarPedidoPK = registarPedidoPK;
    }

    public RegistarPedido(int idregistarPedido, int garsonidGarson, int pedidoidPedido) {
        this.registarPedidoPK = new RegistarPedidoPK(idregistarPedido, garsonidGarson, pedidoidPedido);
    }

    public RegistarPedidoPK getRegistarPedidoPK() {
        return registarPedidoPK;
    }

    public void setRegistarPedidoPK(RegistarPedidoPK registarPedidoPK) {
        this.registarPedidoPK = registarPedidoPK;
    }

    public Garson getGarson() {
        return garson;
    }

    public void setGarson(Garson garson) {
        this.garson = garson;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registarPedidoPK != null ? registarPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistarPedido)) {
            return false;
        }
        RegistarPedido other = (RegistarPedido) object;
        if ((this.registarPedidoPK == null && other.registarPedidoPK != null) || (this.registarPedidoPK != null && !this.registarPedidoPK.equals(other.registarPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.RegistarPedido[ registarPedidoPK=" + registarPedidoPK + " ]";
    }
    
}
