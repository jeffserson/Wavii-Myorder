package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Produto;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.FuncionarioMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private FuncionarioMyorder funcmy;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.funcmy.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Funcionario lancamento = ((Funcionario) value); 
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}
	
	
}
