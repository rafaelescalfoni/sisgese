package br.ucb.sisgese.controller;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.IsNull;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ucb.sisgese.components.UserSession;
import br.ucb.sisgese.dao.DAOFactory;
import br.ucb.sisgese.model.Usuario;

@Resource
public class IndexController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;
	
	public IndexController(Result result, DAOFactory daoFactory, UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}
	
	@Get("/")
	public void login() {
		
	}
	
	public void login(String mensagemErro) {
		result.include("mensagemErro", mensagemErro);
	}
	
	@Post @Path("/autenticar")
	public void autenticar(Usuario usuario) {
		String strQuery = "FROM Usuario u WHERE u.matricula = :matricula AND u.senha = :senha";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("matricula", usuario.getMatricula());
		params.put("senha", usuario.getSenha());
		Usuario usuarioEncontrado = daoFactory.getUsuarioDAO().get(strQuery, params);
		
		if(usuarioEncontrado != null) {
			userSession.setUsuario(usuarioEncontrado);
			result.redirectTo(this).home();
		} else {
			result.redirectTo(this).login("Matricula ou senha invalida");
		}
	}
	
	public void home() {
		
	}
}
