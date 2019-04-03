package getMemberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.DaoImpl;
import member.Member;
import member.Service;
import member.ServiceImpl;

/**
 * Servlet implementation class getMemberController1
 */
@WebServlet("/getMemberController1")
public class getMemberController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMemberController1() {
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
		Service service=new ServiceImpl(new DaoImpl());
		HttpSession session=request.getSession(false);
		String id="";
		if(session!=null) {
		id=(String)session.getAttribute("id");
		}
		Member m=service.getMember(id);
		request.setAttribute("m",m);
		String view="movie/Main.jsp?sub=myInfo.jsp";
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
