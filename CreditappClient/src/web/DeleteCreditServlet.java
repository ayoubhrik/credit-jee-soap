package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CreditServiceStub;
import service.CreditServiceStub.DeleteCredit;


/**
 * Servlet implementation class DeleteCreditServlet
 */
@WebServlet("/deletecredit")
public class DeleteCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CreditServiceStub css = new CreditServiceStub();
		DeleteCredit dc = new DeleteCredit();
		int id = Integer.parseInt(request.getParameter("id"));
		dc.setNumcredit(id);
		css.deleteCredit(dc);

		response.sendRedirect("credit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
