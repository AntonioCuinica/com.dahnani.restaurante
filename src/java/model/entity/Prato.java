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
public class Prato implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idprato;
    private String nome;
    private String quantidade;
    private Double preco;
    private String descricao;
    private String ingredientes;

    public Prato() {
    }

    public Prato(Integer idprato) {
        this.idprato = idprato;
    }

    public Integer getIdprato() {
        return idprato;
    }

    public void setIdprato(Integer idprato) {
        this.idprato = idprato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }



    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prato)) {
            return false;
        }
        Prato other = (Prato) object;
        if ((this.idprato == null && other.idprato != null) || (this.idprato != null && !this.idprato.equals(other.idprato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Prato[ idprato=" + idprato + " ]";
    }
    
}
