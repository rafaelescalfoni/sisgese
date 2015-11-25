package br.ucb.sisgese.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ucb.sisgese.model.Usuario;
import br.ucb.sisgese.dao.DAOFactory;
import br.ucb.sisgese.components.UserSession;


@Resource
public class UsuarioController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;

	
	public UsuarioController(Result result, DAOFactory daoFactory, UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}
	

	@Get
	("/usuario/formulario")
	public void formulario(){	
	}
	    
	@Get
	("/usuario/lista/{usuario.id}")
    public void lista(Long id) {
    	Usuario usuario = daoFactory.getUsuarioDAO().get(id); //pesquisar o livro no bd
		result.include("usuario", usuario); //botar o livro a disposiçào da jsp
    }

    @Get
    @Path("/usuario/lista")
	public void lista(){
    	result.include("usuarioList", daoFactory.getUsuarioDAO().list());
	}
    
        
    @Get
    @Path("/usuario/edicao/{id}")
	public void edicao(Long id){
		result.include("usuario", daoFactory.getUsuarioDAO().get(id));
		System.out.println("\nchamou o metodo edicao update");
	  
    }
    
    //MÉTODO CRUD
    
    @Post // MÉTODO @Post - Salva uma entidade
    @Path("/usuario/formulario")
	public void add(Usuario usuario) {
		daoFactory.getUsuarioDAO().add(usuario);
		result.include("mensagem", "Usuario cadastrado com sucesso!");
		result.redirectTo(this).lista();
	}	
	
    
	@Post
    @Path("/usuario/update/{usuario.id}")
    public void update (Usuario usuario) {
    	daoFactory.getUsuarioDAO().update(usuario);
    	System.out.println("\nchamou o metodo update");
		result.redirectTo(this).lista();
    }

	
	
	@Get
    @Path("/usuario/exclui/{usuario.id}")
    public void excluir (Usuario usuario) {
    	this.daoFactory.getUsuarioDAO().delete(usuario);
    	System.out.println("\nchamou o metodo exclusao delete");
    	result
    	.include("mensagem", "Usuario removido com sucesso!")
        .use(Results.logic()).redirectTo(getClass()).lista();
        
    }


    @Get //MÉTODO @Get - Lista dados e acessa links
    @Path("/usuario/pesquisa")
  	public void lista(String palavraChave){ 
  		String strQuery = "FROM Usuario u "
  						  + "WHERE u.matricula LIKE :trechoChave OR"
  						  + "	   u.senha LIKE :trechoChave OR"
  						  + "	   u.nome LIKE :trechoChave OR"
  						  + "      u.perfil LIKE :trechoChave";
  		
  		Map<String, Object> params = new HashMap<String, Object>();
  		params.put("trechoChave", "%" + palavraChave + "%");
  		//params.put("chave", palavraChave);
  		List<Usuario>usuariosEncontrados = daoFactory.getUsuarioDAO().list(strQuery, params);
  		result.include("usuariosEncontrados", usuariosEncontrados);
  			
  		}
    
    
    
}
