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
import service.CreditServiceStub.AddCredit;
import service.CreditServiceStub.AddCreditResponse;
import service.CreditServiceStub.Duree;
import service.CreditServiceStub.DureeResponse;

/**
 * Servlet implementation class DureeServlet
 */
@WebServlet("/duree")
public class DureeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DureeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("duree.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {
			String tauxS = request.getParameter("taux");
			String capitalS = request.getParameter("capital");
			String annuiteS = request.getParameter("annuite");
			try {
				double taux = Double.parseDouble(tauxS);
				double capital = Double.parseDouble(capitalS);
				double annuite = Double.parseDouble(annuiteS);

				CreditServiceStub css = new CreditServiceStub();
				Duree an = new Duree();
				an.setAnnuite(annuite);
				an.setCapital(capital);
				an.setT(taux);
				DureeResponse res = css.duree(an);
				int duree = res.get_return();
				request.setAttribute("duree",duree);
				
				HttpSession session  = request.getSession();
				Client client = (Client) (session.getAttribute("client"));

				service.CreditServiceStub.Credit c = new service.CreditServiceStub.Credit();
				c.setAnnuite(annuite);
				c.setDatecredit(null);
				c.setDateprever(null);
				c.setDuree(duree);
				c.setMontant(capital);
				c.setTaux(taux);
				c.setUsername(client.getUsername());
				AddCredit ac = new AddCredit();
				ac.setCredit(c);
				AddCreditResponse addcredit = css.addCredit(ac);
				addcredit.get_return();
			}catch(NumberFormatException e) {
				
			}
			
			RequestDispatcher view = request.getRequestDispatcher("duree.jsp");
            view.forward(request, response);
		}
	}

}
