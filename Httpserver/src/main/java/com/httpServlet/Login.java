package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		try {
			 resp.setContentType("text/html");
			 PrintWriter out = resp.getWriter();
			 
			 String sid = req.getParameter("id");
			 int id = Integer.parseInt(sid);
			 
			 
			 
			 String password = req.getParameter("password");
			 Emp e = new Emp();
			 e.setId(id);
			 e.setPassword(password);
			 ResultSet rs = EmpDao.Login(e);
			 //System.out.println(rs);
			while(rs.next()) {
				System.out.println(rs.getString(1));
				if(rs.getString(1)==null) {
					out.print("No data");
				}
				else  {
					req.getRequestDispatcher("httpServlet.html").include(req, resp);
				}
			}
			 
			
		}catch(Exception ex) {ex.printStackTrace();}
	}

	
}
