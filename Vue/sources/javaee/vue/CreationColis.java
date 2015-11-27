package javaee.vue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interfaces.EJBInterface;

import model.Client;

/**
 * Servlet implementation class CreationColis
 */
@WebServlet("/CreationColis")
public class CreationColis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBInterface bean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationColis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Clients", bean.getAllClients());
		this.getServletContext().getRequestDispatcher("/creationColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		String test = request.getParameter("client");
		bean.createColis(new BigDecimal(request.getParameter("poids")), request.getParameter("valeur"), request.getParameter("origine"), request.getParameter("destination"), Integer.parseInt(request.getParameter("client")));
		this.getServletContext().getRequestDispatcher("/").forward(request, response);
	}

}