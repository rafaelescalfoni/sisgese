package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pendencia")
@NamedQueries({
    @NamedQuery(name = "Pendencia.findById", query = "SELECT p FROM Pendencia p WHERE p.id = :id"),
    @NamedQuery(name = "Pendencia.findByNome", query = "SELECT p FROM Pendencia p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pendencia.findByDescricao", query = "SELECT p FROM Pendencia p WHERE p.descricao = :descricao")})
public class Pendencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "pendenciaList")
    private List<CandidatoSelecionado> candidatoSelecionadoList;

    public Pendencia() {
    }

    public Pendencia(Long id) {
        this.id = id;
    }

    public Pendencia(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<CandidatoSelecionado> getCandidatoSelecionadoList() {
        return candidatoSelecionadoList;
    }

    public void setCandidatoSelecionadoList(List<CandidatoSelecionado> candidatoSelecionadoList) {
        this.candidatoSelecionadoList = candidatoSelecionadoList;
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
        if (!(object instanceof Pendencia)) {
            return false;
        }
        Pendencia other = (Pendencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Pendencia[ id=" + id + " ]";
    }
    
}
