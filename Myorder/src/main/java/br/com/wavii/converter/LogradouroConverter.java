package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Logradouro;
import br.com.wavii.reposytory.LocalidadeMyorder;
import br.com.wavii.reposytory.LogradouroMyorder2;

@FacesConverter(forClass = Logradouro.class)
public class LogradouroConverter implements Converter {

	@Inject
	private LogradouroMyorder2 empresa;;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Logradouro retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresa.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Logradouro lancamento = ((Logradouro) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
