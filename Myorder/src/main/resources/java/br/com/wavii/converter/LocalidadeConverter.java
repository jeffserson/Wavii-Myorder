package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.wavii.model.Localidade;
import br.com.wavii.reposytory.LocalidadeMyorder;

@FacesConverter(forClass = Localidade.class)
public class LocalidadeConverter implements Converter {

	@Inject
	private LocalidadeMyorder empresa;;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Localidade retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Localidade lancamento = ((Localidade) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
