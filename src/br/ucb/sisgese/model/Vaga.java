package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ucb.sisgese.components.StatusVagaEnum;

@Entity
@Table(name = "vaga")
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v"),
    @NamedQuery(name = "Vaga.findById", query = "SELECT v FROM Vaga v WHERE v.id = :id"),
    @NamedQuery(name = "Vaga.findByNome", query = "SELECT v FROM Vaga v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vaga.findByStatus", query = "SELECT v FROM Vaga v WHERE v.status = :status")})
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private String status;
    @JoinTable(name = "vaga_tem_cargo", joinColumns = {
        @JoinColumn(name = "vaga_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "cargo_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Cargo> cargoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
    private List<CandidatoSelecionado> candidatoSelecionadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
    private List<ProcessoSeletivo> processoSeletivoList;
    @JoinColumn(name = "solicitacao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitacao solicitacao;
    @JoinColumn(name = "horario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horario;

    public Vaga() {
    }

    public Vaga(Long id) {
        this.id = id;
    }

    public Vaga(Long id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(StatusVagaEnum statusEnum) {
        this.status = statusEnum.getNome();
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public List<CandidatoSelecionado> getCandidatoSelecionadoList() {
        return candidatoSelecionadoList;
    }

    public void setCandidatoSelecionadoList(List<CandidatoSelecionado> candidatoSelecionadoList) {
        this.candidatoSelecionadoList = candidatoSelecionadoList;
    }

    public List<ProcessoSeletivo> getProcessoSeletivoList() {
        return processoSeletivoList;
    }

    public void setProcessoSeletivoList(List<ProcessoSeletivo> processoSeletivoList) {
        this.processoSeletivoList = processoSeletivoList;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Vaga[ id=" + id + " ]";
    }
    
}
