package br.ucb.sisgese.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.ucb.sisgese.model.Avaliacao;
import br.ucb.sisgese.model.CandidatoSelecionado;
import br.ucb.sisgese.model.Cargo;
import br.ucb.sisgese.model.Competencia;
import br.ucb.sisgese.model.Funcionario;
import br.ucb.sisgese.model.Horario;
import br.ucb.sisgese.model.Motivo;
import br.ucb.sisgese.model.Pendencia;
import br.ucb.sisgese.model.Pessoa;
import br.ucb.sisgese.model.ProcessoSeletivo;
import br.ucb.sisgese.model.Setor;
import br.ucb.sisgese.model.Solicitacao;
import br.ucb.sisgese.model.TipoAvaliacao;
import br.ucb.sisgese.model.Usuario;
import br.ucb.sisgese.model.Vaga;


@Component
public class DAOFactory {

	private EntityManager em;

	public DAOFactory(EntityManager em) {
		this.em = em;
	}

	public AvaliacaoDAO getAvaliacaoDAO() {
		return new AvaliacaoDAO(em, Avaliacao.class);
	}
	
	public CandidatoSelecionadoDAO getCandidatoSelecionadoDAO() {
		return new CandidatoSelecionadoDAO(em, CandidatoSelecionado.class);
	}
	
	public CargoDAO getCargoDAO() {
		return new CargoDAO(em, Cargo.class);
	}
	
	public CompetenciaDAO getCompetenciaDAO() {
		return new CompetenciaDAO(em, Competencia.class);
	}
	
	public FuncionarioDAO getFuncionarioDAO() {
		return new FuncionarioDAO(em, Funcionario.class);
	}
	
	public HorarioDAO getHorarioDAO() {
		return new HorarioDAO(em, Horario.class);
	}
	
	public MotivoDAO getMotivoDAO() {
		return new MotivoDAO(em, Motivo.class);
	}
	
	public PendenciaDAO getPendenciaDAO() {
		return new PendenciaDAO(em, Pendencia.class);
	}
	
	public PessoaDAO getPessoaDAO() {
		return new PessoaDAO(em, Pessoa.class);
	}
	
	public ProcessoSeletivoDAO getProcessoSeletivoDAO() {
		return new ProcessoSeletivoDAO(em, ProcessoSeletivo.class);
	}
	
	public SetorDAO getSetorDAO() {
		return new SetorDAO(em, Setor.class);
	}
	
	public SolicitacaoDAO getSolicitacaoDAO() {
		return new SolicitacaoDAO(em, Solicitacao.class);
	}
	
	public TipoAvaliacaoDAO getTipoAvaliacaoDAO() {
		return new TipoAvaliacaoDAO(em, TipoAvaliacao.class);
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO(em, Usuario.class);
	}
	
	public VagaDAO getVagaDAO() {
		return new VagaDAO(em, Vaga.class);
	}
}
