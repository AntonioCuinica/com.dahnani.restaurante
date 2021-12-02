/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CUINIC4
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoPK pedidoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<RegistarPedido> registarPedidoList;
    @JoinColumn(name = "bebida_idbebida", referencedColumnName = "idbebida")
    @ManyToOne(optional = false)
    private Bebida bebidaIdbebida;
    @JoinColumn(name = "mesa_idmesa", referencedColumnName = "idmesa")
    @ManyToOne(optional = false)
    private Mesa mesaIdmesa;
    @JoinColumn(name = "prato_idprato", referencedColumnName = "idprato")
    @ManyToOne(optional = false)
    private Prato pratoIdprato;

    public Pedido() {
    }

    public Pedido(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Pedido(int idPedido, int associarmesaId) {
        this.pedidoPK = new PedidoPK(idPedido, associarmesaId);
    }

    public PedidoPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public List<RegistarPedido> getRegistarPedidoList() {
        return registarPedidoList;
    }

    public void setRegistarPedidoList(List<RegistarPedido> registarPedidoList) {
        this.registarPedidoList = registarPedidoList;
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
    public int hashCode() {
        int hash = 0;
        hash += (pedidoPK != null ? pedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoPK == null && other.pedidoPK != null) || (this.pedidoPK != null && !this.pedidoPK.equals(other.pedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Pedido[ pedidoPK=" + pedidoPK + " ]";
    }
    
}
