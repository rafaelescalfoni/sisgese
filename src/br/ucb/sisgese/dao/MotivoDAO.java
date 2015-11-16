package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Motivo;

public class MotivoDAO extends DAOGenerico<Motivo> {

	public MotivoDAO(EntityManager em, Class<Motivo> classe) {
		super(em, classe);
	}

}
