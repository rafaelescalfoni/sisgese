package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Usuario;

public class UsuarioDAO extends DAOGenerico<Usuario> {

	public UsuarioDAO(EntityManager em, Class<Usuario> classe) {
		super(em, classe);
	}

}
