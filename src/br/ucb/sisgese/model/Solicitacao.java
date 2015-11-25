/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author claudio.souza
 */
@Entity
@Table(name = "solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id"),
    @NamedQuery(name = "Solicitacao.findByDataCriacao", query = "SELECT s FROM Solicitacao s WHERE s.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Solicitacao.findByDataFim", query = "SELECT s FROM Solicitacao s WHERE s.dataFim = :dataFim"),
    @NamedQuery(name = "Solicitacao.findByTipoRecrutamento", query = "SELECT s FROM Solicitacao s WHERE s.tipoRecrutamento = :tipoRecrutamento")})
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "data_criacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Basic(optional = false)
    @Column(name = "tipo_recrutamento")
    private String tipoRecrutamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacaoId")
    private Collection<Vaga> vagaCollection;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Setor setorId;
    @JoinColumn(name = "motivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Motivo motivoId;

    public Solicitacao() {
    }

    public Solicitacao(Long id) {
        this.id = id;
    }

    public Solicitacao(Long id, Date dataCriacao, String tipoRecrutamento) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.tipoRecrutamento = tipoRecrutamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getTipoRecrutamento() {
        return tipoRecrutamento;
    }

    public void setTipoRecrutamento(String tipoRecrutamento) {
        this.tipoRecrutamento = tipoRecrutamento;
    }

    @XmlTransient
    public Collection<Vaga> getVagaCollection() {
        return vagaCollection;
    }

    public void setVagaCollection(Collection<Vaga> vagaCollection) {
        this.vagaCollection = vagaCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Setor getSetorId() {
        return setorId;
    }

    public void setSetorId(Setor setorId) {
        this.setorId = setorId;
    }

    public Motivo getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Motivo motivoId) {
        this.motivoId = motivoId;
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
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.sisgese.model.Solicitacao[ id=" + id + " ]";
    }
    
}
