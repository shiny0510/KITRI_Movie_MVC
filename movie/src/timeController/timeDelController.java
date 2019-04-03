package timeController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.DaoImpl;
import member.Service;
import member.ServiceImpl;
import time.Time;
import time.timeDaoImpl;
import time.timeService;
import time.timeServiceImpl;

/**
 * Servlet implementation class timeDelController
 */
@WebServlet("/timeDelController")
public class timeDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timeDelController() {
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
		String area=request.getParameter("area");
		int screen=Integer.parseInt(request.getParameter("screen"));
		String time=request.getParameter("time");
		Time t=service.getInfo(area, screen, time);
		int num=t.getNum();
		service.del(num);
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
