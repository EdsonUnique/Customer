package web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Page;

import service.ServiceInter;
import service.impl.Service;

public class ViewCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ServiceInter service=new Service();
		String pagenum=request.getParameter("pagenum");
		Page page=service.getPageData(pagenum);
		page.setUrl(request.getContextPath()+"/servlet/"+this.getServletName());
		
		request.setAttribute("page",page );
		request.getRequestDispatcher("/WEB-INF/jsp/ListCustomer.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
