package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceInter;
import service.impl.Service;

public class ControllerDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{
			String id=request.getParameter("id");
			ServiceInter service =new Service();
			service.delete(id);
			
			request.setAttribute("message", "删除成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败！用户不存在或系统内部操作有误");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
