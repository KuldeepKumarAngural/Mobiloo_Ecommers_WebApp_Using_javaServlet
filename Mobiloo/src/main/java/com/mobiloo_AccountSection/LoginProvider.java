package com.mobiloo_AccountSection;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

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
import javax.servlet.http.HttpSession;

@WebServlet(value = "/Action_Login")
public class LoginProvider extends HttpServlet implements Serializable {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("kuldeep22");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		
		
		if (email.equals(validator(email)) && password.equals(validator2(email))) {
			session.setAttribute("kuldeep", email);
			RequestDispatcher dispatcher = req.getRequestDispatcher("Uploaditem.html");
			dispatcher.forward(req, resp);
			System.out.println("LoginSuccessFully");

		}
		
		else {
			pw.write("<html><body>");
			pw.write(" <style>h1{\r\n" + "        box-sizing: border-box;\r\n" + "    top: 58px;\r\n"
					+ "    position: relative;\r\n" + "    text-align: center;\r\n" + "    \r\n"
					+ "    height: 50px;\r\n" + "    width: 430px;\r\n" + "    right: -438px;\r\n" + "}\r\n"
					+ "        \r\n" + "        </style>\r\n" + "<h1>" +"Invalid Credential <a href=\"ForgotPassword.html\"> <br>Click Here To Forgot PassWard</a> <br> <a href=\"Account.html\"> <br>Click Here To Try Again</a> " );

			
		}

	}

	public static String validator(String email) {

		SignUpDetails details = em.find(SignUpDetails.class, email);
		
		if(details.getEmail()!=null)
		{
			return details.getEmail();
		}
		else {
			return null;
		}
	}

	public static String validator2(String email) {

		SignUpDetails details=em.find(SignUpDetails.class, email);
		
		PasswordClass class1 = em.find(PasswordClass.class,details.getPassword().getPassword() );

		if (class1.getPassword() != null) {
			return class1.getPassword();
		} else {
			return null;
		}

	}

}
