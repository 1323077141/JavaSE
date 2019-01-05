package com.atguigu.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.atguigu.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {

	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// String method = request.getParameter("method");
	//
	// switch (method) {
	// case "add":
	// add(request,response);
	// break;
	// case "query":
	// query(request,response);
	// break;
	// case "delete":
	// delete(request,response);
	// break;
	// }
	//
	// }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String servletPath = req.getServletPath();

		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "/error.jsp";
		
		String idStr = request.getParameter("id");
		
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if(customer != null){
				forwardPath = "/updatecustomer.jsp";
				request.setAttribute("customer",customer);
			}
		} catch (NumberFormatException e) {}

		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldName = request.getParameter("oldName");
		
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDAO.getCountWithName(name);
			if(count > 0){
				request.setAttribute("message", "�û��� " + name + "�Ѿ���ռ��, ������ѡ��!");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
			
			
		}
		Customer customer = new  Customer(name, address, phone);
		customer.setId(Integer.parseInt(id));
		customerDAO.update(customer);
		response.sendRedirect("query.do");
		// request.getRequestDispatcher("/success.jsp").forward(request,
		// response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String idStr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			System.out.println(id);
			customerDAO.delete(id);
		} catch (Exception e) {
		}

		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);

		List<Customer> customers = customerDAO
				.getForListWithCriteriaCustomer(cc);

		request.setAttribute("customers", customers);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");


		long count = customerDAO.getCountWithName(name);

		if (count > 0) {
			request.setAttribute("message", "�û���" + name + "�Ѿ���ռ��, ������ѡ��!");

			request.getRequestDispatcher("/newcustomer.jsp").forward(request,
					response);
			return;
		}

		Customer customer = new Customer(name, address, phone);

		customerDAO.save(customer);

		response.sendRedirect("success.jsp");
		// request.getRequestDispatcher("/success.jsp").forward(request,
		// response);

	}

}
