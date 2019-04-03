package areaController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import area.Area;
import area.areaDaoImpl;
import area.areaService;
import area.areaServiceImpl;
import location.Location;
import location.locationDaoImpl;
import location.locationService;
import location.locationServiceImpl;


/**
 * Servlet implementation class areaAddController
 */
@WebServlet("/areaAddController")
@MultipartConfig(location="C:\\temp", maxFileSize=-1)
public class areaAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public areaAddController() {
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
		locationService locationService=new locationServiceImpl(new locationDaoImpl());
		String area=request.getParameter("area");
		String name=request.getParameter("name");
		int x=Integer.parseInt(request.getParameter("x"));
		int y=Integer.parseInt(request.getParameter("y"));
		
		if(locationService.get(area)==null) {
		Part file=request.getPart("File");
		String fileName="";
		String []header=file.getHeader("Content-Disposition").split(";");
		for (String a : header) {
			if (a.trim().startsWith("filename")) {
				fileName = a.substring(a.lastIndexOf("=") + 2, a.length()-1).trim();	
			}
		}
		long size = file.getSize();
		if (size > 0) {
			file.write("C:\\Users\\KITRI\\Desktop\\java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\areaPicture\\areaPicture\\" + fileName);
			file.delete();
		}				
		locationService.add(new Location(area,fileName));
		service.add(new Area(name,area,x,y));
		}else {
		service.add(new Area(name,area,x,y));
		}
		String view="/locationListController?type=1";
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(view);
		if(dispatcher!=null) {
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
