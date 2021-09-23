package am;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex1_HttpSession2
 */
@WebServlet("/Ex1_HttpSession2")
public class Ex1_HttpSession2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_HttpSession2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession을 얻는다
		//새로 만들어주는 것이 아니라 이미 사용되고 있는
		//세션이 있다면 그것을 전달한다.
		HttpSession session = request.getSession();
		
		//세션에서 저장된 값들 중 이름이 "user_id"라는 이름으로 저장된
		//값을 가져온다
		String s_id = (String) session.getAttribute("user_id");
		String s_name = (String) session.getAttribute("user_name");
		
		//응답시 한글 처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 하기위한 스티림 준비
		PrintWriter out = response.getWriter();
		
		//응답시작
		out.println("<h2>아이디:"+s_id+"<br/>"+"이름:"+s_name+"</h2>");
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
