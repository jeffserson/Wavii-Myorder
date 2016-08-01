package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;



import br.com.wavii.model.Empresa;
import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Uf;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.UfMyorder;

@FacesConverter(forClass = Uf.class)
public class UfConverter implements Converter {

	@Inject
	private UfMyorder empresa;;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Uf retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.empresa.PorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Uf lancamento = ((Uf) value); 
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}
	
	
}
