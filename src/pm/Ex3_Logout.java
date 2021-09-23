package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex3_Logout
 */
@WebServlet("/Ex3_Logout")
public class Ex3_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�α׾ƿ��� �α��ν� session�� ������ ���� ����
		HttpSession session = request.getSession();
		
		//�α����� ���� ������ "tvo"����
		session.removeAttribute("tvo");
		
		//����� �ѱ�ó��
		response.setContentType("text/html; charset=utf-8");
		
		//������ ���� ��Ʈ���غ�
		PrintWriter out = response.getWriter();
		
		//�������
		out.println("<h2>�α׾ƿ��� ���������� ó���Ǿ����ϴ�.</h2>");
		out.println("<a href=Ex3_Main>[����]</a>");
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
