package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import model.Client;
import model.Credit;
import service.CreditServiceStub;

import service.CreditServiceStub.GetCreditsByUsername;
import service.CreditServiceStub.GetCreditsByUsernameResponse;

/**
 * Servlet implementation class CreditServlet
 */
@WebServlet("/credit")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		if(session.getAttribute("client")==null) {
			response.sendRedirect("login");
		}else{
		Client client = (Client) (session.getAttribute("client"));
		
		CreditServiceStub css = new CreditServiceStub();
		GetCreditsByUsername creditslist = new GetCreditsByUsername();
		creditslist.setUsername(client.getUsername());
		GetCreditsByUsernameResponse res = css.getCreditsByUsername(creditslist);
		service.CreditServiceStub.Credit[] clist = res.get_return();
		
		ArrayList<Credit> creditsarray = new ArrayList<>();
		if(clist.length>0) {
		for(int i=0;i<clist.length;i++) {
			creditsarray.add(new Credit(clist[i].getNumcredit(),clist[i].getDatecredit(),clist[i].getMontant(),clist[i].getDuree(),clist[i].getTaux(),clist[i].getAnnuite(),clist[i].getDateprever(),clist[i].getUsername()));
		}
		request.setAttribute("creditslist",creditsarray);
		}
		else {
			request.setAttribute("creditslist",null);
		}

		RequestDispatcher view = request.getRequestDispatcher("credit.jsp");
        view.forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
