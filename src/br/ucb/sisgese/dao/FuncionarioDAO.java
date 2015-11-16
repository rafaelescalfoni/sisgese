package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Funcionario;

public class FuncionarioDAO extends DAOGenerico<Funcionario> {

	public FuncionarioDAO(EntityManager em, Class<Funcionario> classe) {
		super(em, classe);
	}

}
