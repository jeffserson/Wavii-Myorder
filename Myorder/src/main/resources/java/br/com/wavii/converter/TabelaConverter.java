package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Produto;
import br.com.wavii.model.Tabela;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;
import br.com.wavii.reposytory.TabelaMyorder;

@FacesConverter(forClass = Tabela.class)
public class TabelaConverter implements Converter {

	@Inject
	private TabelaMyorder tabela;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Tabela retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.tabela.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Tabela lancamento = ((Tabela) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
