package com.ojas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.UsersDAOImpl;
import com.ojas.model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="./login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("----controller------");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		UsersDAOImpl dao=new UsersDAOImpl();
		Users user=new Users();
		user.setUserName(request.getParameter("uname"));
		user.setPassWord(request.getParameter("pwd"));
		String type=dao.login(user.getUserName(), user.getPassWord());
		if(type.equals("admin")){
			out.println("<center><h1>WELCOME TO ADMIN HOME PAGE</h1></center>");
			
		}else if(type.equals("user")){
			out.println("<center><h1>WELCOME TO USERS HOME PAGE</h1></center>");
		}else{
			out.println("<h5 style=color:red>Invalid Username/Password. Please try again</h5>");
			RequestDispatcher rd=request.getRequestDispatcher("./login.jsp");
			rd.include(request, response);
		}
	}

}
