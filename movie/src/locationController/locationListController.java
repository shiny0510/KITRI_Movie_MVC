package locationController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.Location;
import location.locationDaoImpl;
import location.locationService;
import location.locationServiceImpl;

/**
 * Servlet implementation class locationListController
 */
@WebServlet("/locationListController")
public class locationListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public locationListController() {
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
		locationService service=new locationServiceImpl(new locationDaoImpl());
		ArrayList<Location> list=new ArrayList<Location>();
		list=service.getAll();
		request.setAttribute("list", list);
		String type=request.getParameter("type");
		String view="";
		if(type.equals("1")) {
			view="movie/Main.jsp?sub=/area/menu.jsp";
		}else if(type.equals("2")){
			view="movie/Main.jsp?sub=/area/editForm.jsp";
		}else if(type.equals("3")){
			view="area/areaList_json.jsp";
		}
		
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
