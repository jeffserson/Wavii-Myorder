package br.com.wavii.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void timeout() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext()
	            .invalidateSession();
	    FacesContext.getCurrentInstance().getExternalContext()
	            .redirect("login.xhtml");
	   

	}
	
}
