package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Setor;

public class SetorDAO extends DAOGenerico<Setor> {

	public SetorDAO(EntityManager em, Class<Setor> classe) {
		super(em, classe);
	}

}
