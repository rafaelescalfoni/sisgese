package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Pendencia;

public class PendenciaDAO extends DAOGenerico<Pendencia> {

	public PendenciaDAO(EntityManager em, Class<Pendencia> classe) {
		super(em, classe);
	}

}
