package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.CandidatoSelecionado;

public class CandidatoSelecionadoDAO extends DAOGenerico<CandidatoSelecionado> {

	public CandidatoSelecionadoDAO(EntityManager em,
			Class<CandidatoSelecionado> classe) {
		super(em, classe);
	}

}
