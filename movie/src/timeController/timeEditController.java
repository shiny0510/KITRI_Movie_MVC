package timeController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import time.Time;
import time.timeDaoImpl;
import time.timeService;
import time.timeServiceImpl;

/**
 * Servlet implementation class timeEditController
 */
@WebServlet("/timeEditController")
public class timeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timeEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		timeService service=new timeServiceImpl(new timeDaoImpl());
		String area1=request.getParameter("area1");
		int screen1=Integer.parseInt(request.getParameter("screen1"));
		String time1=request.getParameter("time1");
		Time t=service.getInfo(area1, screen1, time1);
		
		int screen=Integer.parseInt(request.getParameter("screen"));
		String movie=request.getParameter("movie");
		String time=request.getParameter("time");
		String sort=request.getParameter("sort");
		t.setScreen(screen);
		t.setMovie(movie);
		t.setTime(time);
		t.setSort(sort);
		service.edit(t);
		
		String view="";
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
