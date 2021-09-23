package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import vo.ExVO;

/**
 * Servlet implementation class Ex3_Login
 */
@WebServlet("/Ex3_Login")
public class Ex3_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		//아이디와 비밀번호를 받는다.
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		
		//**************응답
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답에 필요한 스트림
		PrintWriter out = response.getWriter();
				
		//DB로부터 확인을 해야함 !(생략)
		// id:admin pw:1234인 경우만 로그인 허용하기로 해 보자!
		if(id.equalsIgnoreCase("admin") && pw.equals("1234")) { //equalsIgnoreCase : 대/소문자를 비교하지 않는다.
			//로그인에 성공한 경우
			ExVO vo = new ExVO(id,"어두일미","11akfaos11@naver.com");
			
			HttpSession session = request.getSession();
			
			//세션에 정보 저장하기
			session.setAttribute("tvo",vo);
			
//			out.println("<a href='Ex3_Main'>[메인]</a>");
//			response.sendRedirect("Ex3_Main"); //이동!
			out.println("1");
		}else {
			//로그인에 실패한 경우
//			out.println("<h2>아이디 또는 비밀번호가 틀립니다.</h2>");
//			out.println("<a href='ex3_login.html'>[로그인]</a>");
			out.println("0");
			
		}
		
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
