package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Uf;
import br.com.wavii.reposytory.PaisMyorder2;
import br.com.wavii.reposytory.UfMyorder;

@FacesConverter(forClass = Pais.class)
public class PaisConverter implements Converter {

	@Inject
	private PaisMyorder2 empresa;;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pais retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pais lancamento = ((Pais) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
