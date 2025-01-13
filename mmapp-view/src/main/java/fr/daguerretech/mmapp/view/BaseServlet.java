package fr.daguerretech.mmapp.view;

import java.util.logging.Logger;

import jakarta.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected final transient Logger logger = Logger.getLogger(this.getClass().getName());
	
	public Logger getLogger() {
		return logger;
	}
	
	

}
