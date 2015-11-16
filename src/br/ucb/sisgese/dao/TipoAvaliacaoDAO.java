package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.TipoAvaliacao;

public class TipoAvaliacaoDAO extends DAOGenerico<TipoAvaliacao> {

	public TipoAvaliacaoDAO(EntityManager em, Class<TipoAvaliacao> classe) {
		super(em, classe);
		// TODO Auto-generated constructor stub
	}

}
