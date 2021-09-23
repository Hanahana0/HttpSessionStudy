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
		
		//HttpSession�� ��´�
		//���� ������ִ� ���� �ƴ϶� �̹� ���ǰ� �ִ�
		//������ �ִٸ� �װ��� �����Ѵ�.
		HttpSession session = request.getSession();
		
		//���ǿ��� ����� ���� �� �̸��� "user_id"��� �̸����� �����
		//���� �����´�
		String s_id = (String) session.getAttribute("user_id");
		String s_name = (String) session.getAttribute("user_name");
		
		//����� �ѱ� ó��
		response.setContentType("text/html; charset=utf-8");
		
		//������ �ϱ����� ��Ƽ�� �غ�
		PrintWriter out = response.getWriter();
		
		//�������
		out.println("<h2>���̵�:"+s_id+"<br/>"+"�̸�:"+s_name+"</h2>");
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
