package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Avaliacao;

public class AvaliacaoDAO extends DAOGenerico<Avaliacao> {

	public AvaliacaoDAO(EntityManager em, Class<Avaliacao> classe) {
		super(em, classe);
	}

}
