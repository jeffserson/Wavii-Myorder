package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;




import br.com.wavii.model.Produto;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter2 implements Converter {

	@Inject
	private ProdutoMyorder produto;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.produto.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto lancamento = ((Produto) value); 
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}
	
	
}
