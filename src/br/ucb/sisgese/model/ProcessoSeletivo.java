package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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

@Entity
@Table(name = "processo_seletivo")
@NamedQueries({
    @NamedQuery(name = "ProcessoSeletivo.findById", query = "SELECT p FROM ProcessoSeletivo p WHERE p.id = :id"),
    @NamedQuery(name = "ProcessoSeletivo.findByAprovado", query = "SELECT p FROM ProcessoSeletivo p WHERE p.aprovado = :aprovado"),
    @NamedQuery(name = "ProcessoSeletivo.findByData", query = "SELECT p FROM ProcessoSeletivo p WHERE p.data = :data")})
public class ProcessoSeletivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "aprovado")
    private boolean aprovado;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Calendar data;
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vaga vaga;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa candidato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processoSeletivo")
    private List<Avaliacao> avaliacaoList;

    public ProcessoSeletivo() {
    }

    public ProcessoSeletivo(Long id) {
        this.id = id;
    }

    public ProcessoSeletivo(Long id, boolean aprovado, Calendar data) {
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

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Pessoa getCandidato() {
        return candidato;
    }

    public void setCandidato(Pessoa candidato) {
        this.candidato = candidato;
    }

    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
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
        return "br.ucb.model.ProcessoSeletivo[ id=" + id + " ]";
    }
    
}
