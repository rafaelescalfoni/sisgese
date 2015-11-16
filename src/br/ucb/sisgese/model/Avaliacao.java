package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Calendar;

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

@Entity
@Table(name = "avaliacao")
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findById", query = "SELECT a FROM Avaliacao a WHERE a.id = :id"),
    @NamedQuery(name = "Avaliacao.findByData", query = "SELECT a FROM Avaliacao a WHERE a.data = :data"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliacao.findByObservacao", query = "SELECT a FROM Avaliacao a WHERE a.observacao = :observacao")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Calendar data;
    @Column(name = "nota")
    private float nota;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "processo_seletivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProcessoSeletivo processoSeletivo;
    @JoinColumn(name = "tipo_avaliacao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAvaliacao tipoAvaliacao;
    @JoinColumn(name = "avaliador_id", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Funcionario avaliador;

    public Avaliacao() {
    }

    public Avaliacao(Long id) {
        this.id = id;
    }

    public Avaliacao(Long id, Calendar data, float nota) {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
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

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Funcionario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Funcionario avaliador) {
        this.avaliador = avaliador;
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
        return "br.ucb.model.Avaliacao[ id=" + id + " ]";
    }
    
}
