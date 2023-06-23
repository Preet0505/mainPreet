package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.lang.ProcessHandle.Info;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getemployee")
public class getemployee extends HttpServlet {

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
		
		out.println("<h1>Employee info. Table</h1>");
		
		List<Emp> list = EmpDao.getemployee();
		
		out.println("<table border = '1' width='50%' ");
		out.println("<tr><th>Id</th>"
				+ "<th>Name</th>"
				+ "<th>Email</th>"
				+ "<th>Password</th>"
				+ "<th>Delete</th></tr>");
		
		for(Emp e :list) {
			out.print("<tr><th>"+e.getId()+"</th><th>"+e.getName()+ "</th><th>"+e.getEmail()+"</th><th>"+e.getPassword()+"</th><th><a href=delete?id="+e.getId()+">Delete</a></th></tr>");
		}
		
		out.print("</table>");
		out.print("<br>");
		out.println("<a href='httpServlet.html'><Button>Add New Employee</Button></a><br>");  
		out.close();
	}

}
