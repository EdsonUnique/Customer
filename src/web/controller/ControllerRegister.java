package web.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exceptions.CustomerExistsException;
import Exceptions.DaoException;

import service.ServiceInter;
import service.impl.Service;
import utils.BeanDataUtil;
import utils.JspData;

import domain.Customer;
import domain.Formbean;

public class ControllerRegister extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("preferences", JspData.preferences);
		request.setAttribute("types", JspData.types);
		
		Customer customer=BeanDataUtil.request2bean(request, Customer.class);
		Formbean bean=BeanDataUtil.request2bean(request, Formbean.class);
		customer.setId(BeanDataUtil.getId());
		ServiceInter service=new Service();
		
		try{
			if(bean.checkForm(bean)){
				service.add(customer);
			}else{
				request.setAttribute("customer", bean);
				request.setAttribute("errors", bean.getErrors());
				request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
				return ;
			}
			
			request.setAttribute("message", "注册成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		}catch (CustomerExistsException e) {
			e.printStackTrace();
			request.setAttribute("message", "注册失败！用户已存在");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "用户操作错误");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();

			request.setAttribute("message", "注册失败！系统内部问题");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
