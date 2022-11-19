package com.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.model.Product;
import com.pms.dao.ProductDAO;
import com.pms.dao.ProductDAOImpl;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet(name="./create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ProductDAO dao = new ProductDAOImpl();
		Product p = new Product();
		p.setPid(Integer.parseInt(request.getParameter("pid")));
		p.setPname(request.getParameter("pname"));
		p.setQty(Integer.parseInt(request.getParameter("qty")));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		String message = dao.createProduct(p);
		if(message!=null) {
			out.println("<h2 style=color:green>"+message+"</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("./createproduct.html");
			rd.include(request, response);
		}else {
			out.println("<h2 style=color:red>"+message+"</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("./createproduct.html");
			rd.include(request, response);
		}
	}
	
	}


