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
public class Garson  {
    private static final long serialVersionUID = 1L;
    private Integer idGarson;
    private String nome;
    private String apelido;
    private String nascimento;
    private String nacionalidade;
    private String provincia;
    private String cidade;
    private String distrito;
    private String bairro;
    private String quarteirao;
    private String casa;
    private String nuit;
    private String bi;
    private String telefone;
    private String email;
    private String garsoncol;

    public Garson() {
    }

    public Garson(Integer idGarson) {
        this.idGarson = idGarson;
    }

    public Integer getIdGarson() {
        return idGarson;
    }

    public void setIdGarson(Integer idGarson) {
        this.idGarson = idGarson;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(String quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGarsoncol() {
        return garsoncol;
    }

    public void setGarsoncol(String garsoncol) {
        this.garsoncol = garsoncol;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garson)) {
            return false;
        }
        Garson other = (Garson) object;
        if ((this.idGarson == null && other.idGarson != null) || (this.idGarson != null && !this.idGarson.equals(other.idGarson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Garson[ idGarson=" + idGarson + " ]";
    }
    
}
