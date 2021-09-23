package pm;

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
 * Servlet implementation class Ex3_Main
 */
@WebServlet("/Ex3_Main")
public class Ex3_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����� �ѱ�ó��
		response.setContentType("text/html; charset=utf-8");
		
		//������ �ϱ����� ��Ʈ��
		PrintWriter out = response.getWriter();
		
		//�� �����ڵ鸶�� �ϳ��� ������ HttpSession ���
		HttpSession session = request.getSession();
		
		//�α����� �Ǿ��ٸ� session�� tvo�� ����Ǿ� ������
		//�׷��� �ʴٸ� tvo�� ����.
		ExVO tvo = (ExVO) session.getAttribute("tvo");
		
		if(tvo == null) {
			//�α����� �ȵ� ���
			out.println("<a href='ex3_login.html'>[�α���]</a>");
			
		}else {
			//�α����� �� ����
			out.println("<a href='Ex3_Logout'>[�α׾ƿ�]</a>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
