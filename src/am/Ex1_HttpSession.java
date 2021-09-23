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
 * Servlet implementation class Ex1_HttpSession
 */
@WebServlet("/Ex1_HttpSession")
public class Ex1_HttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_HttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		//요청한 곳으로부터 파라미터들 받기
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
	
		// DB 작업 ....
		
		//HttpSession얻기
		HttpSession session = request.getSession();
		
		//HttpSession에 값을 저장
		//user_id라는 이름으로 u_id가 기억하고있는 값을 저장한다.
		session.setAttribute("user_id", u_id);
		session.setAttribute("user_name", "마루치");
		
		//위에 HttpSession에 값을 저장하는 내용에서 Map구조와 유사하다.
		//앞에 key값으로 쌍을 이루어서 저장되는 모습과 유사하다. 그리고 저장되는 값은
		//자바에서 인식하는 모~든객체를 저장가능하다.
		
		
		// ====================== 응답
		//응답시 한글처리
		response.setContentType("text/html;charset=utf-8");
		
		//응답을 위한 스트림 준비
		PrintWriter out = response.getWriter();
		
		//응답 시작
		out.println("<h2>저장완료</h2>");
		out.println("<a href='Ex1_HttpSession2'>[다음 서블릿]</a>");
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
