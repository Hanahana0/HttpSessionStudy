package pm;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import vo.EmpVO;

/**
 * Servlet implementation class Ex4_EmpAll
 */
@WebServlet("/Ex4_EmpAll")
public class Ex4_EmpAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex4_EmpAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSessionFactory factory = null;
		try {
			Reader r = Resources.getResourceAsReader("config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//응답시 한글 처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 위한 스트립준비
		PrintWriter out = response.getWriter();
		
		//sql문장을 호출할 수 있는 SqlSession
		SqlSession ss = factory.openSession();
		
		List<EmpVO> list = ss.selectList("emp.all");
		
		StringBuffer sb = new StringBuffer();
		for(EmpVO vo :list) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(vo.getemployee_id());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(vo.getFirst_name());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(vo.getJob_id());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(vo.getDepartment_id());
			sb.append("</td>");
			sb.append("</tr>");
		}
		//응답하기
		out.println(sb.toString());
		out.close();
		ss.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
