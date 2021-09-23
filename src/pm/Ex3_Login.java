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

		//��û�� �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		//���̵�� ��й�ȣ�� �޴´�.
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		
		//**************����
		//����� �ѱ�ó��
		response.setContentType("text/html; charset=utf-8");
		
		//���信 �ʿ��� ��Ʈ��
		PrintWriter out = response.getWriter();
				
		//DB�κ��� Ȯ���� �ؾ��� !(����)
		// id:admin pw:1234�� ��츸 �α��� ����ϱ�� �� ����!
		if(id.equalsIgnoreCase("admin") && pw.equals("1234")) { //equalsIgnoreCase : ��/�ҹ��ڸ� ������ �ʴ´�.
			//�α��ο� ������ ���
			ExVO vo = new ExVO(id,"����Ϲ�","11akfaos11@naver.com");
			
			HttpSession session = request.getSession();
			
			//���ǿ� ���� �����ϱ�
			session.setAttribute("tvo",vo);
			
//			out.println("<a href='Ex3_Main'>[����]</a>");
//			response.sendRedirect("Ex3_Main"); //�̵�!
			out.println("1");
		}else {
			//�α��ο� ������ ���
//			out.println("<h2>���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.</h2>");
//			out.println("<a href='ex3_login.html'>[�α���]</a>");
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
