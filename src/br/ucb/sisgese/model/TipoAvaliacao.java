package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_avaliacao")
@NamedQueries({
    @NamedQuery(name = "TipoAvaliacao.findById", query = "SELECT t FROM TipoAvaliacao t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAvaliacao.findByNome", query = "SELECT t FROM TipoAvaliacao t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoAvaliacao.findByDuracao", query = "SELECT t FROM TipoAvaliacao t WHERE t.duracao = :duracao"),
    @NamedQuery(name = "TipoAvaliacao.findByDescricao", query = "SELECT t FROM TipoAvaliacao t WHERE t.descricao = :descricao")})
public class TipoAvaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "duracao")
    private int duracao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAvaliacao")
    private List<Avaliacao> avaliacaoList;

    public TipoAvaliacao() {
    }

    public TipoAvaliacao(Long id) {
        this.id = id;
    }

    public TipoAvaliacao(Long id, String nome, int duracao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.descricao = descricao;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof TipoAvaliacao)) {
            return false;
        }
        TipoAvaliacao other = (TipoAvaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.TipoAvaliacao[ id=" + id + " ]";
    }
    
}
