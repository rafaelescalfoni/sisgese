/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author claudio.souza
 */
@Entity
@Table(name = "candidato_selecionado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CandidatoSelecionado.findAll", query = "SELECT c FROM CandidatoSelecionado c"),
    @NamedQuery(name = "CandidatoSelecionado.findById", query = "SELECT c FROM CandidatoSelecionado c WHERE c.id = :id"),
    @NamedQuery(name = "CandidatoSelecionado.findByCpf", query = "SELECT c FROM CandidatoSelecionado c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "CandidatoSelecionado.findByGrauInstrucao", query = "SELECT c FROM CandidatoSelecionado c WHERE c.grauInstrucao = :grauInstrucao"),
    @NamedQuery(name = "CandidatoSelecionado.findBySexo", query = "SELECT c FROM CandidatoSelecionado c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "CandidatoSelecionado.findByIdade", query = "SELECT c FROM CandidatoSelecionado c WHERE c.idade = :idade"),
    @NamedQuery(name = "CandidatoSelecionado.findByPeso", query = "SELECT c FROM CandidatoSelecionado c WHERE c.peso = :peso")})
public class CandidatoSelecionado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cpf")
    private int cpf;
    @Basic(optional = false)
    @Column(name = "grau_instrucao")
    private String grauInstrucao;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "idade")
    private String idade;
    @Basic(optional = false)
    @Column(name = "peso")
    private String peso;
    @JoinTable(name = "candidato_selecionado_tem_pendencia", joinColumns = {
        @JoinColumn(name = "candidato_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "pendencia_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Pendencia> pendenciaCollection;
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vaga vagaId;

    public CandidatoSelecionado() {
    }

    public CandidatoSelecionado(Long id) {
        this.id = id;
    }

    public CandidatoSelecionado(Long id, int cpf, String grauInstrucao, String sexo, String idade, String peso) {
        this.id = id;
        this.cpf = cpf;
        this.grauInstrucao = grauInstrucao;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @XmlTransient
    public Collection<Pendencia> getPendenciaCollection() {
        return pendenciaCollection;
    }

    public void setPendenciaCollection(Collection<Pendencia> pendenciaCollection) {
        this.pendenciaCollection = pendenciaCollection;
    }

    public Vaga getVagaId() {
        return vagaId;
    }

    public void setVagaId(Vaga vagaId) {
        this.vagaId = vagaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatoSelecionado)) {
            return false;
        }
        CandidatoSelecionado other = (CandidatoSelecionado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.sisgese.model.CandidatoSelecionado[ id=" + id + " ]";
    }
    
}
