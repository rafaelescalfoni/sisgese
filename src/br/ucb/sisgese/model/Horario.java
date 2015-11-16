package br.ucb.sisgese.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findById", query = "SELECT h FROM Horario h WHERE h.id = :id"),
    @NamedQuery(name = "Horario.findByEntrada", query = "SELECT h FROM Horario h WHERE h.entrada = :entrada"),
    @NamedQuery(name = "Horario.findBySaida", query = "SELECT h FROM Horario h WHERE h.saida = :saida")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "entrada")
    @Temporal(TemporalType.TIME)
    private Date entrada;
    @Column(name = "saida")
    @Temporal(TemporalType.TIME)
    private Date saida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private List<Vaga> vagaList;

    public Horario() {
    }

    public Horario(Long id) {
        this.id = id;
    }

    public Horario(Long id, Date entrada, Date saida) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Horario[ id=" + id + " ]";
    }
    
}
