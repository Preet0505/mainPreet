package com.curd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name  = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(name.equalsIgnoreCase("Delete")) {
			EmpDao.deleteUser(id);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		else if(name.equalsIgnoreCase("Update")) {
			Emp idDetails = EmpDao.getIdDetails(id);
			request.setAttribute("idDetails", idDetails);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		}
		else if(name.equalsIgnoreCase("GetId")) {
			Emp idDetails = EmpDao.getIdDetails(id);
			request.setAttribute("idDetails", idDetails);
			request.getRequestDispatcher("getid.jsp").forward(request, response);
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		
		Emp e = new Emp();
		e.setName(fname);
		e.setEmail(email);
		e.setPassword(password);

		String work  = request.getParameter("work");
	
		if(work.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			e.setId(id);
			EmpDao.updateDetails(e);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		else if(work.equalsIgnoreCase("create")) {
			EmpDao.save(e);
//			request.getRequestDispatcher("Index.jsp").forward(request, response);
			response.sendRedirect("Index.jsp");
		}
		
	}catch(Exception e) {
		System.out.println("Exception in dopost method");
		e.getStackTrace();
	}

}
}
