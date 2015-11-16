package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.Solicitacao;

public class SolicitacaoDAO extends DAOGenerico<Solicitacao> {

	public SolicitacaoDAO(EntityManager em, Class<Solicitacao> classe) {
		super(em, classe);
	}

}
