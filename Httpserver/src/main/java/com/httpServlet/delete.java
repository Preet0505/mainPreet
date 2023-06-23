package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class delete extends HttpServlet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		System.out.println(id);
		EmpDao.delete(id);
		out.println("Delete has been successfully...");
//		resp.sendRedirect("httpServlet.html");
//		req.getRequestDispatcher("httpServlet.html").include(req, resp);
		
		out.println("<a href=httpServlet.html>Add New Employee</a><br>");

		
		
	
	}
	
	
}
