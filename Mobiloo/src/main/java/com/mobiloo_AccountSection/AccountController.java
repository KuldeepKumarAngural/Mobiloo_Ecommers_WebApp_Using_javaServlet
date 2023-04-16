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
@WebServlet(value = "/Action_SignUp")
public class AccountController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String date=req.getParameter("dob");
		String password=req.getParameter("password");
		
		
		SignUpDetails signUpDetails=new SignUpDetails();
		PasswordClass  class1=new  PasswordClass();
		
		signUpDetails.setDateOfBirth(date);
		signUpDetails.setEmail(email.toLowerCase());
		signUpDetails.setMobile(mobile);
		signUpDetails.setName(name.toUpperCase());
		class1.setPassword(password);
		class1.setDetails(signUpDetails);
		signUpDetails.setPassword(class1);
		
		
		PrintWriter pw=resp.getWriter();
		
		if(signUpDetails!=null)
		{
			signupGenerator(signUpDetails , class1);
			RequestDispatcher dispatcher = req.getRequestDispatcher("Account.html");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("SignUp.html");
			dispatcher.include(req, resp);
		}
		
		
		
	}
	
	
	public static void signupGenerator(SignUpDetails details , PasswordClass class1)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("kuldeep22");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(details);
		em.persist(class1);
		et.commit();
		System.out.println("SignUp SuccessFully");
	}
	

}
