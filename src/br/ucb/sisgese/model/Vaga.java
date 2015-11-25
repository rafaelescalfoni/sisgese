/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author claudio.souza
 */
@Entity
@Table(name = "vaga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v"),
    @NamedQuery(name = "Vaga.findById", query = "SELECT v FROM Vaga v WHERE v.id = :id"),
    @NamedQuery(name = "Vaga.findByNome", query = "SELECT v FROM Vaga v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vaga.findByStatus", query = "SELECT v FROM Vaga v WHERE v.status = :status")})
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @ManyToMany(mappedBy = "vagaCollection")
    private Collection<Cargo> cargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vagaId")
    private Collection<ProcessoSeletivo> processoSeletivoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vagaId")
    private Collection<CandidatoSelecionado> candidatoSelecionadoCollection;
    @JoinColumn(name = "solicitacao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitacao solicitacaoId;
    @JoinColumn(name = "horario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horarioId;

    public Vaga() {
    }

    public Vaga(Long id) {
        this.id = id;
    }

    public Vaga(Long id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @XmlTransient
    public Collection<ProcessoSeletivo> getProcessoSeletivoCollection() {
        return processoSeletivoCollection;
    }

    public void setProcessoSeletivoCollection(Collection<ProcessoSeletivo> processoSeletivoCollection) {
        this.processoSeletivoCollection = processoSeletivoCollection;
    }

    @XmlTransient
    public Collection<CandidatoSelecionado> getCandidatoSelecionadoCollection() {
        return candidatoSelecionadoCollection;
    }

    public void setCandidatoSelecionadoCollection(Collection<CandidatoSelecionado> candidatoSelecionadoCollection) {
        this.candidatoSelecionadoCollection = candidatoSelecionadoCollection;
    }

    public Solicitacao getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Solicitacao solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Horario getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Horario horarioId) {
        this.horarioId = horarioId;
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
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.sisgese.model.Vaga[ id=" + id + " ]";
    }
    
}
