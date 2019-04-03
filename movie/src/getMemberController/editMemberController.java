package getMemberController;

import java.io.IOException;

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
 * Servlet implementation class editMemberController
 */
@WebServlet("/editMemberController")
public class editMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMemberController() {
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
		String pwd="";
		String tel="";
		String address="";
		String id=request.getParameter("id");
		Service service=new ServiceImpl(new DaoImpl());
		Member m=service.getMember(id);
		int point=Integer.parseInt(request.getParameter("point"));
		if(point==0) {
			if(request.getParameter("pwd")==null||request.getParameter("pwd").equals("")) {
				}else {
					pwd=request.getParameter("pwd");
					m.setPwd(pwd);
				}
				if(request.getParameter("tel")==null||request.getParameter("tel").equals("")) {
				}else {
					tel=request.getParameter("tel");
					m.setTel(tel);
					
				}
				if(request.getParameter("address")==null||request.getParameter("address").equals("")) {
				}else {
					address=request.getParameter("address");
					m.setAddress(address);
				}
		}else {
			m.setPoint(point);
		}
		service.editInfo(m);
		
		String view="movie/Main.jsp?sub=mainDown.jsp";
		response.sendRedirect(view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
