package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Pessoa;

public class PessoaDAO extends DAOGenerico<Pessoa> {

	public PessoaDAO(EntityManager em, Class<Pessoa> classe) {
		super(em, classe);
	}

}
