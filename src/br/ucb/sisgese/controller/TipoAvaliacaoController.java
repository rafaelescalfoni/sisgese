package br.ucb.sisgese.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ucb.sisgese.components.UserSession;
import br.ucb.sisgese.dao.DAOFactory;
import br.ucb.sisgese.model.TipoAvaliacao;

@Resource
public class TipoAvaliacaoController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;
	
	public TipoAvaliacaoController(Result result, DAOFactory dao, UserSession userSession) {
		this.result = result;
		this.daoFactory = dao;
		this.userSession = userSession;
	}
	
	@Get @Path("/tipoAvaliacao/{tipoId}")
	public void formulario(Long tipoId) {
		result.include("tipoAvaliacao", daoFactory.getTipoAvaliacaoDAO().get(tipoId));
		result.include("tipoAvaliacaoList", daoFactory.getTipoAvaliacaoDAO().list());
	}
	
	@Get @Path("/tipoAvaliacao/remove/{tipoId}")
	public void formExclusao(Long tipoId) {
		result.include("tipoAvaliacao", daoFactory.getTipoAvaliacaoDAO().get(tipoId));
	}
	
	@Get @Path("/tipoAvaliacao/add")
	public void formulario() {
		result.include("tipoAvaliacaoList", daoFactory.getTipoAvaliacaoDAO().list());
	}

	@Post @Path("/tipoAvaliacao")
	public void add(TipoAvaliacao tipoAvaliacao){
		daoFactory.getTipoAvaliacaoDAO().add(tipoAvaliacao);
		result.redirectTo(this).formulario();
	}
	
	@Put @Path("/tipoAvaliacao/{tipoAvaliacao.id}")
	public void update(TipoAvaliacao tipoAvaliacao) {
		daoFactory.getTipoAvaliacaoDAO().update(tipoAvaliacao);
		result.redirectTo(this).formulario(tipoAvaliacao.getId());
	}
	
	@Delete @Path("/tipoAvaliacao/{tipoAvaliacao.id}")
	public void delete(TipoAvaliacao tipoAvaliacao) {
		daoFactory.getTipoAvaliacaoDAO().delete(tipoAvaliacao);
		result.forwardTo(this).formulario();
	}
}
