package areaController;

import java.io.IOException;
import java.util.ArrayList;

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
import member.DaoImpl;
import member.Member;
import member.Service;
import member.ServiceImpl;
import screen.Screen;
import screen.screenDaoImpl;
import screen.screenService;
import screen.screenServiceImpl;
import time.Time;
import time.timeDaoImpl;
import time.timeService;
import time.timeServiceImpl;





/**
 * Servlet implementation class areaEditController
 */
@WebServlet("/areaEditController")
public class areaEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public areaEditController() {
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
		areaService service=new areaServiceImpl(new areaDaoImpl());
		String name=request.getParameter("name");
		String editName="";
		Area a=null;
	
		if(service.get(name)!=null) {
			a=service.get(name);
			if(request.getParameter("x")==null && request.getParameter("y")==null) {
				
			}
			else if(request.getParameter("x")!=null && request.getParameter("y")!=null) {
				int x=Integer.parseInt(request.getParameter("x"));
				int y=Integer.parseInt(request.getParameter("y"));
				a.setX(x);
				a.setY(y);
			service.editXY(a);
			}else if(request.getParameter("x")!=null) {
				int x=Integer.parseInt(request.getParameter("x"));
				a.setX(x);
				service.editXY(a);
			}else if(request.getParameter("y")!=null) {
				int y=Integer.parseInt(request.getParameter("y"));
				a.setY(y);
				service.editXY(a);
			}
		}
		
		if(request.getParameter("editName")!=null) {
			editName=request.getParameter("editName");
			service.editName(editName, name);
			HttpSession session=request.getSession(false);
			if(session!=null) {
				String id=(String)session.getAttribute("id");
				Service serviceMember=new ServiceImpl(new DaoImpl());
				timeService serviceTime=new timeServiceImpl(new timeDaoImpl());
				
				ArrayList<Time> list2=serviceTime.getAreaList(name);
				if(list2!=null) {
					for(int i=0; i<list2.size();i++) {
						Time t1=list2.get(i);
						int num=t1.getNum();
						serviceTime.editName(editName, num);
					}
				}
				
				ArrayList<Member> list=serviceMember.getList(name);
				if(list!=null) {
					for(int i=0; i<list.size();i++) {
						Member m1=list.get(i);
						m1.setArea(editName);
						serviceMember.editInfo(m1);
					}
				}
				screenService serviceScreen=new screenServiceImpl(new screenDaoImpl());
				ArrayList<Screen> list1=serviceScreen.getAllScreen(name);
				if(list1!=null) {
					for(int i=0; i<list1.size();i++) {
						Screen s1=list1.get(i);
						serviceScreen.editScreen(s1, editName);
					}
				}
			}
			}
		String view="locationListController?type=1";
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
