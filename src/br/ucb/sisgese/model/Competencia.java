package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "competencia")
@NamedQueries({
    @NamedQuery(name = "Competencia.findById", query = "SELECT c FROM Competencia c WHERE c.id = :id"),
    @NamedQuery(name = "Competencia.findByNome", query = "SELECT c FROM Competencia c WHERE c.nome = :nome"),
    @NamedQuery(name = "Competencia.findByDescricao", query = "SELECT c FROM Competencia c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Competencia.findByObrigatoria", query = "SELECT c FROM Competencia c WHERE c.obrigatoria = :obrigatoria")})
public class Competencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "obrigatoria")
    private boolean obrigatoria;
    @ManyToMany(mappedBy = "competenciaList")
    private List<Cargo> cargoList;

    public Competencia() {
    }

    public Competencia(Long id) {
        this.id = id;
    }

    public Competencia(Long id, String nome, boolean obrigatoria) {
        this.id = id;
        this.nome = nome;
        this.obrigatoria = obrigatoria;
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

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public void getObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
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
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Competencia[ id=" + id + " ]";
    }
    
}
