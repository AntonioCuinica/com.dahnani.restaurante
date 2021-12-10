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

public class Bebida {
    
    private int idbebida;
    private String nome;
    private Double preco;
    private String marca;
    private String quantidade;
    private String dataExpiracao;

    public Bebida() {
    }

    public Bebida(int idbebida) {
        this.idbebida = idbebida;
    }

    public int getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(int idbebida) {
        this.idbebida = idbebida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }


    @Override
    public String toString() {
        return "model.entity.Bebida[ idbebida=" + idbebida + " ]";
    }
    
}
