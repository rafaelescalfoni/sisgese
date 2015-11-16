package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.ucb.sisgese.model.Avaliacao;
import br.ucb.sisgese.model.CandidatoSelecionado;


@Component
public class DAOFactory {

	private EntityManager em;

	public DAOFactory(EntityManager em) {
		this.em = em;
	}

	public AvaliacaoDAO getAvaliacaoDAO() {
		return new AvaliacaoDAO(em, Avaliacao.class);
	}
	
	public CandidatoSelecionadoDAO getCandidatoSelecionadoDAO() {
		return new CandidatoSelecionadoDAO(em, CandidatoSelecionado.class);
	}
}
