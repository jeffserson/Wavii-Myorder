package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Mesa;
import br.com.wavii.model.Produto;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.MesasMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;

@FacesConverter(forClass = Mesa.class)
public class MesaConverter3 implements Converter {

	@Inject
	private MesasMyorder produto;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Mesa retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.produto.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Mesa lancamento = ((Mesa) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
