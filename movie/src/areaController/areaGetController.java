package areaController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import area.Area;
import area.areaDaoImpl;
import area.areaService;
import area.areaServiceImpl;


/**
 * Servlet implementation class areaGetController
 */
@WebServlet("/areaGetController")
public class areaGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public areaGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		areaService service=new areaServiceImpl(new areaDaoImpl());
		HttpSession session=request.getSession(false);
		String area="";
		if(session!=null) {
			area=(String)session.getAttribute("area");
		}
		String type=request.getParameter("type");
		String view="";
		if(type.equals("1")) {
			view="movie/Main.jsp?sub=/screen/addForm.jsp";
			if(service.get(area)==null) {
				view="movie/Main.jsp?sub=/screen/false.jsp";
			}
		}else if(type.equals("2")){
			view="movie/Main.jsp?sub=/screen/editForm.jsp";
			if(service.get(area)==null) {
				view="movie/Main.jsp?sub=/screen/false.jsp";
			}
		}else if(type.equals("3")){
			view="movie/Main.jsp?sub=/time/addForm.jsp";
			if(service.get(area)==null) {
				view="movie/Main.jsp?sub=/time/false.jsp";
			}
		}else if(type.equals("4")){
			view="movie/Main.jsp?sub=/time/editForm.jsp";
			if(service.get(area)==null) {
				view="movie/Main.jsp?sub=/time/false.jsp";
			}
		}
		
		Area a=null;
		if(!area.equals("°í°´") && !area.equals("3")) {
		a=service.get(area);
		}
		request.setAttribute("a",a);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
