package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Empresa;
import br.com.wavii.model.Logradouro;
import br.com.wavii.reposytory.EmpresaMyorder;

@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	@Inject
	private EmpresaMyorder empresa;;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Empresa lancamento = ((Empresa) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
