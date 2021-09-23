package am;

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
 * Servlet implementation class Ex2_HttpSession
 */
@WebServlet("/Ex2_HttpSession")
public class Ex2_HttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2_HttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession에 저장할 ExVO객체 생성
		ExVO vo = new ExVO("admin", "어두일미", "admin@korea.com");
		
		//HttpSession얻기
		HttpSession session = request.getSession();
		//이미 사용되고있는것이 있다면 그 자원을 주고
		// 없다면 ! 새로 만들어준다!
		
		//얻어낸 HttpSession에 vo객체 저장
		session.setAttribute("user", vo);
		
		//응답시 한글 처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 하기위한 스트립준비
		PrintWriter out = response.getWriter();
		
		out.println("<h1>vo저장</h1>");
		out.println("<a href='Ex2_HttpSession2'>[Next]</a>");
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
