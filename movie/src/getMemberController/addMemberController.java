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
 * Servlet implementation class addMemberController
 */
@WebServlet("/addMemberController")
public class addMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		Service service = new ServiceImpl(new DaoImpl());
		String id = request.getParameter("id");	
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		int point=0;
		int type = Integer.parseInt(request.getParameter("type"));
		String area="";
		if(type==1) {
			area = "고객";
		}else if(type==2){
			area = request.getParameter("area");
		}else {
			area ="없음";
		}
		
		Member m = new Member(id,pwd,name,age,tel,address,type,point,area);
		service.join(m);
		String view = "movie/Main.jsp?sub=mainDown.jsp";
		response.sendRedirect(view);
		}catch(Exception e){
			String view = "movie/Main.jsp?sub=JoinForm.jsp";
			String error="오류발생 재입력 필요";
			System.out.println(error);
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
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
