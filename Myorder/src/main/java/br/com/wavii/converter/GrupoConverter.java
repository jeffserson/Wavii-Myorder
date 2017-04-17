package br.com.wavii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Grupo;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Usuario1;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.FuncionarioMyorder;
import br.com.wavii.reposytory.Grupos;
import br.com.wavii.reposytory.ProdutoMyorder;
import br.com.wavii.reposytory.Usuarios;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	@Inject
	private Grupos funcmy;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.funcmy.pegaid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Grupo lancamento = ((Grupo) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
