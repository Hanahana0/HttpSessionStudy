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
 * Servlet implementation class Ex2_HttpSession2
 */
@WebServlet("/Ex2_HttpSession2")
public class Ex2_HttpSession2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2_HttpSession2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답시 한글 처리
		response.setContentType("text/html; charset=utf-8");
		
		//HttpSession얻기
		HttpSession session = request.getSession();
		
		
		ExVO vo = (ExVO) session.getAttribute("user");
		
		//응답을 위한 스트림준비
		PrintWriter out = response.getWriter();
		
		//응답시작
		if(vo !=null) {
			out.println("<h2>저장된 값: "+vo.getUser_id()+","+
					vo.getUser_name()+","+vo.getEmail()+"</h2>");
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
