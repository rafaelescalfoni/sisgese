package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Vaga;

public class VagaDAO extends DAOGenerico<Vaga> {

	public VagaDAO(EntityManager em, Class<Vaga> classe) {
		super(em, classe);
	}

}
