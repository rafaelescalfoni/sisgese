package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Horario;

public class HorarioDAO extends DAOGenerico<Horario> {

	public HorarioDAO(EntityManager em, Class<Horario> classe) {
		super(em, classe);
	}

}
