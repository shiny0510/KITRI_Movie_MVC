package movieBoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import movieBoard.MovieBoard;
import movieBoard.MovieBoardDaoImpl;
import movieBoard.MovieBoardService;
import movieBoard.MovieBoardServiceImpl;

/**
 * Servlet implementation class movieBoardAddController
 */
@MultipartConfig(location = "C:\\temp", maxFileSize = -1)
@WebServlet("/MovieBoardWriteController")
public class MovieBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieBoardWriteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		MovieBoardService service = new MovieBoardServiceImpl(new MovieBoardDaoImpl());
		// num,writer,type,title,content,path,date
		String writer = request.getParameter("writer");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part file2 = request.getPart("file");
		String name = "";
		String[] header = file2.getHeader("Content-Disposition").split(";");
		for (String a : header) {
			if (a.trim().startsWith("filename")) {
				name = a.substring(a.lastIndexOf("=") + 2, a.length()-1).trim();	
			}
		}	
		long size = file2.getSize();
		if (size > 0) {
		file2.write("C:\\Users\\KITRI\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\movie" + name);
		file2.delete();
	}

//int num, String writer, String type, String title, String content, String path, Date w_date, int rep_num, int lv
		MovieBoard b = new MovieBoard(0, writer, type, title, content, null, null, 0, 0, 0);
		service.writeBoard(b);
		response.sendRedirect("movieBoard/MovieBoardComplete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
