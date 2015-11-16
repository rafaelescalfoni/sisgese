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

import br.ucb.sisgese.components.TipoRecrutamentoEnum;

@Entity
@Table(name = "solicitacao")
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id"),
    @NamedQuery(name = "Solicitacao.findByDataCriacao", query = "SELECT s FROM Solicitacao s WHERE s.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Solicitacao.findByDataFim", query = "SELECT s FROM Solicitacao s WHERE s.dataFim = :dataFim"),
    @NamedQuery(name = "Solicitacao.findByTipoRecrutamento", query = "SELECT s FROM Solicitacao s WHERE s.tipoRecrutamento = :tipoRecrutamento")})
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_criacao")
    @Temporal(TemporalType.DATE)
    private Calendar dataCriacao;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Calendar dataFim;
    @Column(name = "tipo_recrutamento")
    private String tipoRecrutamento;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "motivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Motivo motivo;
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Setor setor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacao")
    private List<Vaga> vagaList;

    public Solicitacao() {
    }

    public Solicitacao(Long id) {
        this.id = id;
    }

    public Solicitacao(Long id, Calendar dataCriacao, TipoRecrutamentoEnum tipoRecrutamento) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.tipoRecrutamento = tipoRecrutamento.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public String getTipoRecrutamento() {
        return tipoRecrutamento;
    }

    public void setTipoRecrutamento(TipoRecrutamentoEnum tipoRecrutamentoEnum) {
        this.tipoRecrutamento = tipoRecrutamentoEnum.getNome();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Vaga> getVagaList() {
        return vagaList;
    }

    public void setVagaList(List<Vaga> vagaList) {
        this.vagaList = vagaList;
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
        return "br.ucb.model.Solicitacao[ id=" + id + " ]";
    }
    
}
