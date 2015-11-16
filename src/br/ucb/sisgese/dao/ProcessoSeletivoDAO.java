package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.ucb.sisgese.model.ProcessoSeletivo;

public class ProcessoSeletivoDAO extends DAOGenerico<ProcessoSeletivo> {

	public ProcessoSeletivoDAO(EntityManager em, Class<ProcessoSeletivo> classe) {
		super(em, classe);
	}

}
