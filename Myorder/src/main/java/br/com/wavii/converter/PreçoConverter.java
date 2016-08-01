package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Tabela;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.PreçoMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;
import br.com.wavii.reposytory.TabelaMyorder;

@FacesConverter(forClass = Preço.class)
public class PreçoConverter implements Converter {

	@Inject
	private PreçoMyorder preco;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Preço retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.preco.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Preço lancamento = ((Preço) value); 
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}
	
	
}
