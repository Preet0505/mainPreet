package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/getsingleUser")
public class getsingleUser extends HttpServlet{

//	private static final long serialVersionUID = -8848845320694235783L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			ResultSet rs =EmpDao.getsingleUser(id);
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<a href=httpServlet.html>Add New Employee</a><br>");
			out.println("<table border = '1' width='50%' ");
			out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th></tr>");
			
			while(rs.next()) {
			out.print("<tr><th>"+rs.getInt(1)+"</th>");
			out.print("<th>"+rs.getString(2)+"</th>");
			out.print("<th>"+rs.getString(3)+"</th>");
			out.print("<th>"+rs.getString(4)+"</th></tr>");
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//req.getRequestDispatcher("\\WEB-INF\\getsingleuser.html").forward(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<form action=getsingleUser method=post>");
		out.println("Id <input type=text name=id><br>");
		out.println("<input type=submit value=find>");
		out.println("</form>");
		
	}

	

}
