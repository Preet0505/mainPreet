package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		resp.setContentType("text/html");  
	    PrintWriter out=resp.getWriter();  
	    out.println("<h1>Update Employee</h1>");  
        String sid=req.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=(Emp) EmpDao.getsingleUser(id);    
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getEmail()+"'</td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}
	
	  
}
