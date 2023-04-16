package com.mobiloo_AccountSection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/Action_ForgotPassword")
public class ForgotPassword extends HttpServlet {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("kuldeep22");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html><body>");
		
		if(dob.equals(validator2(email)))
		{
			
//			RequestDispatcher dispatcher=req.getRequestDispatcher("ForgotPassword.html");
			String password= validator3(email);
			
//			dispatcher.forward(req, resp);
			pw.write(" <style>h1{\r\n" + "        box-sizing: border-box;\r\n" + "    top: 58px;\r\n"
					+ "    position: relative;\r\n" + "    text-align: center;\r\n" + "    \r\n"
					+ "    height: 50px;\r\n" + "    width: 430px;\r\n" + "    right: -438px;\r\n" + "}\r\n"
					+ "        \r\n" + "        </style>\r\n" + "<h1>" +"Your Password is ["+password+"]<a href=\"Account.html\"> <br>Click Here To Login</a> " );

			
		}
		else {
			pw.write(" <style>h1{\r\n" + "        box-sizing: border-box;\r\n" + "    top: 58px;\r\n"
					+ "    position: relative;\r\n" + "    text-align: center;\r\n" + "    \r\n"
					+ "    height: 50px;\r\n" + "    width: 430px;\r\n" + "    right: -438px;\r\n" + "}\r\n"
					+ "        \r\n" + "        </style>\r\n" + "<h1>" +"Entered Information is Not Correct <a href=\"ForgotPassword.html\"> <br>Click Here To Retake</a> " );

		}
		pw.write("</html></body>");
		
		
		
	}
		
		public static String validator2(String email) {

			SignUpDetails details=em.find(SignUpDetails.class, email);
			if(details!=null)
			{
				System.out.println(details.getDateOfBirth());
				return details.getDateOfBirth(); 
			}
			else {
				return null;
			}
			
			

		}
		public static String validator3(String email) {

			SignUpDetails details=em.find(SignUpDetails.class, email);
			if(details!=null)
			{
				System.out.println(details.getPassword().getPassword());
				return details.getPassword().getPassword(); 
			}
			else {
				return null;
			}
			
		}
		
		

	

}
