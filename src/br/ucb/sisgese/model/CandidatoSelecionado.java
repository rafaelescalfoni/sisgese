package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.List;
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

@Entity
@Table(name = "candidato_selecionado")
@NamedQueries({
    @NamedQuery(name = "CandidatoSelecionado.findById", query = "SELECT c FROM CandidatoSelecionado c WHERE c.id = :id"),
    @NamedQuery(name = "CandidatoSelecionado.findByCpf", query = "SELECT c FROM CandidatoSelecionado c WHERE c.cpf = :cpf")})
public class CandidatoSelecionado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cpf")
    private int cpf;
    @JoinTable(name = "candidato_selecionado_tem_pendencia", joinColumns = {
        @JoinColumn(name = "candidato_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "pendencia_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Pendencia> pendenciaList;
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vaga vaga;

    public CandidatoSelecionado() {
    }

    public CandidatoSelecionado(Long id) {
        this.id = id;
    }

    public CandidatoSelecionado(Long id, int cpf) {
        this.id = id;
        this.cpf = cpf;
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

    public List<Pendencia> getPendenciaList() {
        return pendenciaList;
    }

    public void setPendenciaList(List<Pendencia> pendenciaList) {
        this.pendenciaList = pendenciaList;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
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
        return "br.ucb.model.CandidatoSelecionado[ id=" + id + " ]";
    }
    
}
