package sc.senac.br.cadastropessoa.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sc.senac.br.cadastropessoa.model.Profissao;

@FacesConverter(forClass = Profissao.class)
public class ProfissaoConverter implements Converter {

    private sc.senac.br.cadastropessoa.dao.IBaseDao<Profissao> profissaoDao;

    public ProfissaoConverter() {
        profissaoDao = new sc.senac.br.cadastropessoa.dao.ProfissaoDao();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (profissaoDao.buscarPorID(Long.valueOf(s)) == null) {
            return null;
        } else {
            Profissao profissao = (Profissao) profissaoDao.buscarPorID(Long.valueOf(s));
            return profissao;
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Profissao profissao = (Profissao) o;
        profissao = profissaoDao.buscarPorID(profissao.getCodigo());
        if (profissao == null) {
            return null;
        } else {
            return profissao.getCodigo().toString();
        }
    }
}	