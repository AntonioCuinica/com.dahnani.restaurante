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
@Table(name = "requisitar_pedido")
@NamedQueries({
    @NamedQuery(name = "RequisitarPedido.findAll", query = "SELECT r FROM RequisitarPedido r")})
public class RequisitarPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitarPedidoPK requisitarPedidoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitarPedido")
    private List<Conta> contaList;
    @JoinColumn(name = "Garson_idGarson", referencedColumnName = "idGarson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Garson garson;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public RequisitarPedido() {
    }

    public RequisitarPedido(RequisitarPedidoPK requisitarPedidoPK) {
        this.requisitarPedidoPK = requisitarPedidoPK;
    }

    public RequisitarPedido(int idrequisitarPedido, int garsonidGarson, int clienteIdcliente) {
        this.requisitarPedidoPK = new RequisitarPedidoPK(idrequisitarPedido, garsonidGarson, clienteIdcliente);
    }

    public RequisitarPedidoPK getRequisitarPedidoPK() {
        return requisitarPedidoPK;
    }

    public void setRequisitarPedidoPK(RequisitarPedidoPK requisitarPedidoPK) {
        this.requisitarPedidoPK = requisitarPedidoPK;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public Garson getGarson() {
        return garson;
    }

    public void setGarson(Garson garson) {
        this.garson = garson;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitarPedidoPK != null ? requisitarPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitarPedido)) {
            return false;
        }
        RequisitarPedido other = (RequisitarPedido) object;
        if ((this.requisitarPedidoPK == null && other.requisitarPedidoPK != null) || (this.requisitarPedidoPK != null && !this.requisitarPedidoPK.equals(other.requisitarPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.RequisitarPedido[ requisitarPedidoPK=" + requisitarPedidoPK + " ]";
    }
    
}
