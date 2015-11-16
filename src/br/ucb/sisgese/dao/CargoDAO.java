package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Cargo;

public class CargoDAO extends DAOGenerico<Cargo> {

	public CargoDAO(EntityManager em, Class<Cargo> classe) {
		super(em, classe);
	}

}
