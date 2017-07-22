package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;

import service.ServiceInter;
import service.impl.Service;
import utils.BeanDataUtil;

public class ControllerUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
			Customer customer=BeanDataUtil.request2bean(request, Customer.class);
			ServiceInter service =new Service();
			service.update(customer);
			request.setAttribute("message", "修改成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
