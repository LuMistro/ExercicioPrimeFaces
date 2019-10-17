package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.cadastropessoa.dao.IBaseDao;
import sc.senac.br.cadastropessoa.dao.ProfissaoDao;
import sc.senac.br.cadastropessoa.model.Profissao;

@ViewScoped
@ManagedBean
public class CadastroProfissaoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Profissao profissao;
	private IBaseDao<Profissao> dao;
	private List<Profissao> profissoes;
	
	@PostConstruct
	public void init() {
		dao = new ProfissaoDao();
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (profissao.getCodigo() == null) {
			dao.salvar(profissao);
		} else {
			dao.alterar(profissao);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		dao.excluir(profissao);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Profissão excluída com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		profissao = new Profissao();
	}
	
	public void buscar() {
		profissoes = dao.buscarTodos();
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	public List<Profissao> getProfissoes() {
		return profissoes;
	}

}
