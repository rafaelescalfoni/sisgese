package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Competencia;

public class CompetenciaDAO extends DAOGenerico<Competencia> {

	public CompetenciaDAO(EntityManager em, Class<Competencia> classe) {
		super(em, classe);
	}

}
