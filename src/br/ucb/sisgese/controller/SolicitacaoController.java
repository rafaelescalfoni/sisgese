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
import br.ucb.sisgese.model.Solicitacao;
import br.ucb.sisgese.dao.DAOFactory;
import br.ucb.sisgese.components.UserSession;


@Resource
public class  SolicitacaoController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;

	
	public  SolicitacaoController(Result result, DAOFactory daoFactory, UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}
	

	@Get
	("/solicitacao/formulario")
	public void formulario(){	
	}
	    
	@Get
	("/solicitacao/lista/{solicitacao.id}")
    public void lista(Long id) {
    	Solicitacao solicitacao = daoFactory.getSolicitacaoDAO().get(id);
		result.include("solicitacao", solicitacao); 
    }

    @Get
    @Path("/solicitacao/lista")
	public void lista(){
		result.include("solicitacaoList", daoFactory.getSolicitacaoDAO().list());
	}
    
        
    @Get
    @Path("/solicitacao/edicao/{id}")
	public void edicao(Long id){
		result.include("solicitacao", daoFactory.getSolicitacaoDAO().get(id));
		System.out.println("\nchamou o metodo edicao update");
	  
    }
    
    //MÉTODO CRUD
    
    @Post // MÉTODO @Post - Salva uma entidade
    @Path("/solicitacao/formulario")
	public void add(Solicitacao solicitacao) {
		daoFactory.getSolicitacaoDAO().add(solicitacao);
		result.include("mensagem", "Usuario cadastrado com sucesso!");
		result.redirectTo(this).lista();
	}	
	
    
	@Post
    @Path("/solicitacao/update/{solicitacao.id}")
    public void update (Solicitacao solicitacao) {
    	daoFactory.getSolicitacaoDAO().update(solicitacao);
    	System.out.println("\nchamou o metodo update");
		result.redirectTo(this).lista();
    }

	
	
	@Get
    @Path("/solicitacao/exclui/{solicitacao.id}")
    public void excluir (Solicitacao solicitacao) {
    	this.daoFactory.getSolicitacaoDAO().delete(solicitacao);
    	System.out.println("\nchamou o metodo exclusao delete");
    	result
    	.include("mensagem", "Solicitação removida com sucesso!")
        .use(Results.logic()).redirectTo(getClass()).lista();
        
    }


    @Get //MÉTODO @Get - Lista dados e acessa links
    @Path("/solicitacao/pesquisa")
  	public void lista(String palavraChave){ 
  		String strQuery = "FROM Solicitacao s "
  						  + "WHERE s.id LIKE :trechoChave OR"
  						  + "	   s.tipoRecutamento LIKE :trechoChave OR"
  						  + "	   s.dataCriacao LIKE :trechoChave OR"
  						  + "	   s.setor.nome LIKE :trechoChave OR"
  						  + "	   s.motivo.nome LIKE :trechoChave OR"
  						  + "	   s.usuario.nome LIKE :trechoChave OR"
  						  + "	   s.dataFim LIKE :trechoChave ";
  						
  		
  		Map<String, Object> params = new HashMap<String, Object>();
  		params.put("trechoChave", "%" + palavraChave + "%");
  		//params.put("chave", palavraChave);
  		List<Solicitacao>solicitacoesEncontradas = daoFactory.getSolicitacaoDAO().list(strQuery, params);
  		result.include("solicitacaoEncontradas", solicitacoesEncontradas);
  			
  		}
    
}
