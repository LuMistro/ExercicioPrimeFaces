package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.cadastropessoa.dao.IBaseDao;
import sc.senac.br.cadastropessoa.dao.PessoaDao;
import sc.senac.br.cadastropessoa.dao.ProfissaoDao;
import sc.senac.br.cadastropessoa.model.Pessoa;
import sc.senac.br.cadastropessoa.model.Profissao;

@ViewScoped
@ManagedBean
public class CadastroPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Profissao> profissoes;
	private IBaseDao<Pessoa> dao;
	private IBaseDao<Profissao> profissaoDao;
	
	@PostConstruct
	public void init() {
		dao = new PessoaDao();
		profissaoDao = new ProfissaoDao();
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (pessoa.getCodigo() == null) {
			dao.salvar(pessoa);
		} else {
			dao.alterar(pessoa);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		dao.excluir(pessoa);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Pessoa excluída com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		pessoa = new Pessoa();
	}
	
	public void buscar() {
		pessoas = dao.buscarTodos();
		profissoes = profissaoDao.buscarTodos();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public List<Profissao> getProfissoes() {
		return profissoes;
	}

}
