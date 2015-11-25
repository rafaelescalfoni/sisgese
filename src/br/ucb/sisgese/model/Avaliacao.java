/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author claudio.souza
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findById", query = "SELECT a FROM Avaliacao a WHERE a.id = :id"),
    @NamedQuery(name = "Avaliacao.findByData", query = "SELECT a FROM Avaliacao a WHERE a.data = :data"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliacao.findByObservacao", query = "SELECT a FROM Avaliacao a WHERE a.observacao = :observacao")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "nota")
    private float nota;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "tipo_avaliacao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacaoId;
    @JoinColumn(name = "processo_seletivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProcessoSeletivo processoSeletivoId;
    @JoinColumn(name = "avaliador_id", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Funcionario avaliadorId;

    public Avaliacao() {
    }

    public Avaliacao(Long id) {
        this.id = id;
    }

    public Avaliacao(Long id, Date data, float nota) {
        this.id = id;
        this.data = data;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoAvaliacao getTipoAvaliacaoId() {
        return tipoAvaliacaoId;
    }

    public void setTipoAvaliacaoId(TipoAvaliacao tipoAvaliacaoId) {
        this.tipoAvaliacaoId = tipoAvaliacaoId;
    }

    public ProcessoSeletivo getProcessoSeletivoId() {
        return processoSeletivoId;
    }

    public void setProcessoSeletivoId(ProcessoSeletivo processoSeletivoId) {
        this.processoSeletivoId = processoSeletivoId;
    }

    public Funcionario getAvaliadorId() {
        return avaliadorId;
    }

    public void setAvaliadorId(Funcionario avaliadorId) {
        this.avaliadorId = avaliadorId;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.sisgese.model.Avaliacao[ id=" + id + " ]";
    }
    
}
