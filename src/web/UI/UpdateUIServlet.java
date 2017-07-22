package web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;

import service.ServiceInter;
import service.impl.Service;
import utils.JspData;

public class UpdateUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		ServiceInter service=new Service();
		
		Customer customer=service.find(id);
		request.setAttribute("customer", customer);//ÐÞ¸Ä¶ÔÏó
		request.setAttribute("preferences", JspData.preferences);
		request.setAttribute("types", JspData.types);
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
