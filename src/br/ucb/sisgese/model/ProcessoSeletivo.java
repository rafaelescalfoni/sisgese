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
@Table(name = "processo_seletivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessoSeletivo.findAll", query = "SELECT p FROM ProcessoSeletivo p"),
    @NamedQuery(name = "ProcessoSeletivo.findById", query = "SELECT p FROM ProcessoSeletivo p WHERE p.id = :id"),
    @NamedQuery(name = "ProcessoSeletivo.findByAprovado", query = "SELECT p FROM ProcessoSeletivo p WHERE p.aprovado = :aprovado"),
    @NamedQuery(name = "ProcessoSeletivo.findByData", query = "SELECT p FROM ProcessoSeletivo p WHERE p.data = :data")})
public class ProcessoSeletivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "aprovado")
    private short aprovado;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processoSeletivoId")
    private Collection<Avaliacao> avaliacaoCollection;
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vaga vagaId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public ProcessoSeletivo() {
    }

    public ProcessoSeletivo(Long id) {
        this.id = id;
    }

    public ProcessoSeletivo(Long id, short aprovado, Date data) {
        this.id = id;
        this.aprovado = aprovado;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getAprovado() {
        return aprovado;
    }

    public void setAprovado(short aprovado) {
        this.aprovado = aprovado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    public Vaga getVagaId() {
        return vagaId;
    }

    public void setVagaId(Vaga vagaId) {
        this.vagaId = vagaId;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
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
        if (!(object instanceof ProcessoSeletivo)) {
            return false;
        }
        ProcessoSeletivo other = (ProcessoSeletivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.sisgese.model.ProcessoSeletivo[ id=" + id + " ]";
    }
    
}
