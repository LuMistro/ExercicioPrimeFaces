package sc.senac.br.cadastropessoa.dao;

import java.util.List;

import sc.senac.br.cadastropessoa.model.IBaseModel;

public interface IBaseDao<T extends IBaseModel> {

	public abstract void salvar(T model);
	
	public abstract void alterar(T model);
	
	public abstract void excluir(T model);
	
	public abstract T buscarPorID(Long id);
	
	public abstract List<T> buscarTodos();
	
}
