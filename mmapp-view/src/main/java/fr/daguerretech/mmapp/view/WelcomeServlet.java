package fr.daguerretech.mmapp.view;

import java.io.IOException;
import java.util.logging.Level;

import fr.daguerretech.mmapp.view.form.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private final User user = new User();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/welcome.jsp");
		getLogger().log(Level.INFO, this.getClass().getEnclosingMethod().getName());
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			getLogger().log(Level.SEVERE, "" , e);
			e.printStackTrace();
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		getLogger().fine("doPost");
		user.setNom(req.getParameter("name"));
		if("".equals(user.getNom())) user.setNom("aaa");
		getLogger().info(user.getNom());
		req.setAttribute("name", user.getNom());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/welcome.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			getLogger().log(Level.SEVERE, "" , e);
			e.printStackTrace();
		} 
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		getLogger().log(Level.INFO, this.getClass().getEnclosingMethod().getName());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/welcome.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			getLogger().log(Level.SEVERE, "" , e);
			e.printStackTrace();
		} 
	}

}
