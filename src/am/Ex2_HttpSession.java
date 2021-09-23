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
		//HttpSession�� ������ ExVO��ü ����
		ExVO vo = new ExVO("admin", "����Ϲ�", "admin@korea.com");
		
		//HttpSession���
		HttpSession session = request.getSession();
		//�̹� ���ǰ��ִ°��� �ִٸ� �� �ڿ��� �ְ�
		// ���ٸ� ! ���� ������ش�!
		
		//�� HttpSession�� vo��ü ����
		session.setAttribute("user", vo);
		
		//����� �ѱ� ó��
		response.setContentType("text/html; charset=utf-8");
		
		//������ �ϱ����� ��Ʈ���غ�
		PrintWriter out = response.getWriter();
		
		out.println("<h1>vo����</h1>");
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
