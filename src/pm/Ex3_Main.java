package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ExVO;

/**
 * Servlet implementation class Ex3_Main
 */
@WebServlet("/Ex3_Main")
public class Ex3_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 하기위한 스트림
		PrintWriter out = response.getWriter();
		
		//각 접속자들마다 하나씩 가지는 HttpSession 얻기
		HttpSession session = request.getSession();
		
		//로그인이 되었다면 session에 tvo가 저장되어 있지만
		//그렇지 않다면 tvo가 없다.
		ExVO tvo = (ExVO) session.getAttribute("tvo");
		
		if(tvo == null) {
			//로그인이 안된 경우
			out.println("<a href='ex3_login.html'>[로그인]</a>");
			
		}else {
			//로그인을 된 상태
			out.println("<a href='Ex3_Logout'>[로그아웃]</a>");
			
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
