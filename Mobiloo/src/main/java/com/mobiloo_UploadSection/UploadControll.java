package com.mobiloo_UploadSection;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16324 * 16324)
@WebServlet(value = "/actionpage")
public class UploadControll extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UploadDto dto = new UploadDto();
		String brand = req.getParameter("brand");
		String price = req.getParameter("price");
		String grade = req.getParameter("grade");
		String description = req.getParameter("description");
		HttpSession session = req.getSession();

		PrintWriter writer = resp.getWriter();

		// image upload

		Part file = req.getPart("file");// Here image is Catch from fronted and Stored into Part file

		String imageFileName = file.getSubmittedFileName();
		System.out.println(imageFileName);
		InputStream is = null;
		is = file.getInputStream();
		if (is != null) {
			byte[] Data = new byte[is.available()];
			is.read(Data);
			dto.setData(Data);
			
			dto.setBrand(brand);
			dto.setDescription(description);
			dto.setGrade(grade);
			dto.setPrice(price);

		}
		PrintWriter pw = resp.getWriter();
		pw.write("<html><body>");
		if (dto != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage.jsp");
			dispatcher.include(req, resp);
			insertData(dto);
			
		} else if(dto==null){
			pw.write(" <style>h1{\r\n" + "        box-sizing: border-box;\r\n" + "    top: 588px;\r\n"
					+ "    position: relative;\r\n" + "    text-align: center;\r\n" + "    \r\n"
					+ "    height: 50px;\r\n" + "    width: 430px;\r\n" + "    right: -438px;\r\n" + "}\r\n"
					+ "        \r\n" + "        </style>\r\n" + "<h1>Please fill all Details");

			RequestDispatcher dispatcher = req.getRequestDispatcher("Uploaditem.html");
			dispatcher.include(req, resp);

		}
		
		pw.write("</body></html>");

	}

	// Hibernate code to Save Data into DataBase
	public void insertData(UploadDto dto2) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("kuldeep22");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(dto2);
		et.commit();

	}

	public List<UploadDto> publish() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("kuldeep22");
		EntityManager em = emf.createEntityManager();

		List list = em.createQuery("select u From UploadDto u", UploadDto.class).getResultList();

		System.out.println(list);

		return list;

	}

}
