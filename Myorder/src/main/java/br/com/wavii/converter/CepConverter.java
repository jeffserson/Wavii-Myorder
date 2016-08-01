package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Cep;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Logradouro;
import br.com.wavii.reposytory.CepMyorder;
import br.com.wavii.reposytory.EmpresaMyorder;

@FacesConverter(forClass = Cep.class)
public class CepConverter implements Converter {

	@Inject
	private CepMyorder empresa;;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cep retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cep lancamento = ((Cep) value); 
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}
	
	
}
