package com.mobiloo_FeedbackSection;

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

@WebServlet(value = "/action_Feedback")
public class FeedBack extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		String message = req.getParameter("message");

		FeedbackDto dto = new FeedbackDto();

		dto.setName(name.toUpperCase());
		dto.setEmail(email.toLowerCase());
		dto.setMessage(message);
		dto.setCountry(country);
		dto.setNumber(mobile);

		PrintWriter pw = resp.getWriter();
		pw.write("<html><body>");
		if (dto != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Feedback.html");
			dispatcher.include(req, resp);

			feedbackInserter(dto);

		}

	}

	public static void feedbackInserter(FeedbackDto feedback) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("kuldeep22");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(feedback);
		et.commit();
		System.out.println("Thx for feedback ");
	}

}
