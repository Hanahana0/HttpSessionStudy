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
		//��û�� �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		
		//��û�� �����κ��� �Ķ���͵� �ޱ�
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
	
		// DB �۾� ....
		
		//HttpSession���
		HttpSession session = request.getSession();
		
		//HttpSession�� ���� ����
		//user_id��� �̸����� u_id�� ����ϰ��ִ� ���� �����Ѵ�.
		session.setAttribute("user_id", u_id);
		session.setAttribute("user_name", "����ġ");
		
		//���� HttpSession�� ���� �����ϴ� ���뿡�� Map������ �����ϴ�.
		//�տ� key������ ���� �̷� ����Ǵ� ����� �����ϴ�. �׸��� ����Ǵ� ����
		//�ڹٿ��� �ν��ϴ� ��~�簴ü�� ���尡���ϴ�.
		
		
		// ====================== ����
		//����� �ѱ�ó��
		response.setContentType("text/html;charset=utf-8");
		
		//������ ���� ��Ʈ�� �غ�
		PrintWriter out = response.getWriter();
		
		//���� ����
		out.println("<h2>����Ϸ�</h2>");
		out.println("<a href='Ex1_HttpSession2'>[���� ����]</a>");
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
