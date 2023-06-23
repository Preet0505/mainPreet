package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
//			out.println("<a href='httpServlet.html'>Add New Employee</a>");  
			
			String fname = req.getParameter("fname");
			
			 
			String email = req.getParameter("email");
			
			
			String password = req.getParameter("password");
			
			
			
			out.println("Getting User Detail... ");// TODO Auto-generated method stub
			
			Emp e = new Emp();
			e.setName(fname);
			e.setEmail(email);
			e.setPassword(password);
			
			System.out.println(fname);
			System.out.println(email);
			System.out.println(password);
			
			int Status = EmpDao.Save(e);
			
			if(Status>0) {
				out.println("<p>Record Saved Successfully!</p>");
				}else {
					out.println("<br>Sorry Unable to save record.</br>");
				}
			out.println("<a href='httpServlet.html'>Add New Employee</a><br>");  
			out.close();
	}

}
