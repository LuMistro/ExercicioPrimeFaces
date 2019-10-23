package sc.senac.br.cadastropessoa.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sc.senac.br.cadastropessoa.dao.ProfissaoDao;
import sc.senac.br.cadastropessoa.model.Profissao;

@FacesConverter(forClass = Profissao.class)
public class ProfissaoConverter implements Converter {

	private ProfissaoDao dao;
	
	public ProfissaoConverter() {
		dao = new ProfissaoDao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		return dao.buscarPorID(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		
		return ((Profissao) value).getCodigo().toString();
	}

	
}
