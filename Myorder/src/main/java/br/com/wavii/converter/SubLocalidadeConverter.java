package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Sublocalidade;
import br.com.wavii.reposytory.LocalidadeMyorder;
import br.com.wavii.reposytory.SubLocalidadeMyorder;

@FacesConverter(forClass = Sublocalidade.class)
public class SubLocalidadeConverter implements Converter {

	@Inject
	private SubLocalidadeMyorder empresa;;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Sublocalidade retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Sublocalidade lancamento = ((Sublocalidade) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
