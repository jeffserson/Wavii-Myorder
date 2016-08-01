package br.com.wavii.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter(value="converter")
public class SimpleEntityConverter implements Converter {
	 public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
	        if (value != null) {  
	            return this.getAttributesFrom(component).get(value);  
	        }  
	        return null;  
	    }  
	  
	    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
	  
	        if (value != null  
	                && !"".equals(value)) {  
	  
	            BaseEntity entity = (BaseEntity) value;  
	  
	            // adiciona item como atributo do componente  
	            this.addAttribute(component, entity);  
	  
	            String id = entity.getNome();  
	            if (id != null) {  
	                return String.valueOf(id);  
	            }  
	        }  
	  
	        return (String) value;  
	    }  
	  
	    protected void addAttribute(UIComponent component, BaseEntity o) {  
	        String key = o.getNome().toString(); // codigo da empresa como chave neste caso 
	        this.getAttributesFrom(component).put(key, o);  
	    }  
	  
	    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
	        return component.getAttributes();  
	    }  
	
	                                     
	
}

