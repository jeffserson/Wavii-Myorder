package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Logradouro;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.reposytory.LocalidadeMyorder;
import br.com.wavii.reposytory.LogradouroMyorder2;
import br.com.wavii.reposytory.MovimentoMesaMyorder;

@FacesConverter(forClass = MovimentoMesa.class)
public class MovimentoMesaConverter2 implements Converter {

	@Inject
	private MovimentoMesaMyorder movmy;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		MovimentoMesa retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.movmy.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			MovimentoMesa lancamento = ((MovimentoMesa) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
