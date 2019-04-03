package cateController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cate.Cate;
import cate.DaoImpl;
import cate.Service;
import cate.ServiceImpl;

/**
 * Servlet implementation class CateAddController
 */
public class CateAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CateAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add controller");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		Service service = new ServiceImpl(new DaoImpl());
		String table = request.getParameter("table");
		String name = request.getParameter("name");
		int parent = Integer.parseInt(request.getParameter("parent"));
		Cate c = new Cate(0, name, parent);
		service.addCate(c, table);
		System.out.println(c);
//		response.sendRedirect("CateListController?table=" + table 
//				+ "&parent=" + parent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
