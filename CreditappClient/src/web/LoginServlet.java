package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import model.Client;
import service.CreditServiceStub;

import service.CreditServiceStub.Find;
import service.CreditServiceStub.FindResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			login(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		CreditServiceStub css = new CreditServiceStub();
		Find find = new Find();
		find.setPassword(password);
		find.setUsername(username);
		FindResponse res = css.find(find);
		Client cl = new Client();
		cl.setAdresse(res.get_return().getAdresse());
		cl.setNom(res.get_return().getNom());
		cl.setPrenom(res.get_return().getPrenom());
		cl.setMail(res.get_return().getMail());
		cl.setTel(res.get_return().getTel());
		cl.setUsername(res.get_return().getUsername());
		cl.setPassword(res.get_return().getPassword());
		cl.setVille(res.get_return().getVille());

		
		if (cl != null) {
			HttpSession session = request.getSession();
            session.setAttribute("client",cl);
            response.sendRedirect("annuite");
			
		}else {
			response.sendRedirect("login");
		}
	}
	}

}
