package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method.");
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		
		/*  */
		if (command != null && "calculate".equals(command)) {
			
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc', method='get' action='/pro06/calc' />");
		pw.print("원화: <input type='text' name='won' size=10  />");
		pw.print("<select name='operator' >");
		
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.println("<input type='submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private static String calculate(float won, String operator) {
		
		String result = null;
		
		if ("dollar".equals(operator)) {
			result = String.format("%.6f", won / 1);
		}
		else if ("en".equals(operator)) {
			result = String.format("%.6f", won / 2);
		}
		else if ("wian".equals(operator)) {
			result = String.format("%.6f", won / 3);
		}
		else if ("pound".equals(operator)) {
			result = String.format("%.6f", won / 4);
		}
		
		return result;
	}

}
