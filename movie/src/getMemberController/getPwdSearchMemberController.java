package getMemberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.DaoImpl;
import member.Member;
import member.Service;
import member.ServiceImpl;

/**
 * Servlet implementation class getPwdSearchMemberController
 */
@WebServlet("/getPwdSearchMemberController")
public class getPwdSearchMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPwdSearchMemberController() {
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
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String id=request.getParameter("id");
		String id1=service.getId(name, tel);
		String view="";
		Member m=null;
		if(id.equals(id1)) {
			m=service.getMember(id);
			view="/movie/getMember_json.jsp";
		}
		request.setAttribute("m", m);
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
