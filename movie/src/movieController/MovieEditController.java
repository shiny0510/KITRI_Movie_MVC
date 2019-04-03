package movieController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Movie.Movie;
import Movie.MovieDaoImpl;
import Movie.MovieService;
import Movie.MovieServiceImpl;

/**
 * Servlet implementation class ProductEditController
 */
@MultipartConfig(location = "C:\\temp", maxFileSize = -1)
public class MovieEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieEditController() {
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
		MovieService service = new MovieServiceImpl(new MovieDaoImpl());
		Movie m = new Movie();
		
		int num = Integer.parseInt(request.getParameter("num"));		
		
		m.setNum(num);
		System.out.println(request.getParameter("title"));
		m.setTitle(request.getParameter("title"));
		System.out.println(request.getParameter("title"));
		m.setCate1(Integer.parseInt(request.getParameter("cate1")));

		m.setCate2(Integer.parseInt(request.getParameter("cate2")));

		m.setCate3(Integer.parseInt(request.getParameter("cate3")));
		
		m.setRuntime(Integer.parseInt(request.getParameter("runtime")));
		m.setDirector(request.getParameter("director"));
		m.setMcast(request.getParameter("mcast"));
		m.setGenre(request.getParameter("genre"));
		m.setGenre(request.getParameter("counter"));
		String path = "C:\\Users\\KITRI\\Desktop\\java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img2\\movie2\\";	
		String name1 = m.getNum()+"_";
		String name2 = "";	
		Movie m2 = service.getMovie(num);
		m.setPath1(m2.getPath1());
		m.setPath2(m2.getPath2());
		m.setPath3(m2.getPath3());
		m.setPath4(m2.getPath4());
		for (int i = 0; i < 4; i++) {
			Part file = request.getPart("path" + (i + 1));
			if (file != null && file.getSize()>0) {
				String[] header = file.getHeader("Content-Disposition").split(";");
				for (String a : header) {
					// 파일 확장자 저장
					if (a.trim().startsWith("filename")) {						
						name2 = a.substring(a.lastIndexOf("."), a.length() - 1).trim();
					}
				}
				// 파일크기를 size에 저장
				long size = file.getSize();
				if (size > 0) {
					String name = name1+(i+1)+name2;
					System.out.println(name);
					// 업로드된 파일을 저장
					file.write(path + name);
					// 임시저장된 파일(c:\\temp) 삭제
					switch(i) {
					case 0:
						m.setPath1(name);
						break;
					case 1:
						m.setPath2(name);
						break;
					case 2:
						m.setPath3(name);
						break;
					case 3:
						m.setPath4(name);
						break;
					}
					
					file.delete();
				}
			}
		}
		System.out.println("dd");
		
		System.out.println(m);
		service.editMovie(m);
		System.out.println("cc");
		response.sendRedirect("MovieAllListController"); //클라이언트한테 
	/*	RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/MovieAllListController"); //서버내에서
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
