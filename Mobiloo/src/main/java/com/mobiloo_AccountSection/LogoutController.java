package com.mobiloo_AccountSection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(value = "/Logout")
public class LogoutController extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession();
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(req, resp);
			
			PrintWriter writer=resp.getWriter();
			if (session.getAttribute("kuldeep") != null) {
					
			} 
			else {
				writer.write("<h1> Idiot Session is closed</h1>");
				
				
				writer.write("</html></body>");
				dispatcher = req.getRequestDispatcher("HomePage.jsp");
				
				dispatcher.include(req, resp);
				session.invalidate();
				System.out.println("Invalid Credintial");
			}
			writer.write("</html></body>");

		}

		}

	


