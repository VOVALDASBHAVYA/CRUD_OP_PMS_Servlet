package com.ojas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.UsersDAOImpl;
import com.ojas.model.Users;

/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UsersDAOImpl dao = new UsersDAOImpl();
		Users user = new Users();
		user.setUserName(request.getParameter("uname"));
		user.setType(request.getParameter("type"));
		String password = dao.forgot(user.getUserName(), user.getType());
		if(password!=null) {
			out.println("<h5>Your Password : </h5>"+password);
			RequestDispatcher rd = request.getRequestDispatcher("./forgot.jsp");
			rd.include(request, response);
		}else {
			out.println("<h5>User doesn't exists.please check once again</h5>");
			RequestDispatcher rd = request.getRequestDispatcher("./forgot.jsp");
			rd.include(request, response);
		}
	
	}

}
