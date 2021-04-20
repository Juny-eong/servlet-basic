package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	
	public ThirdServlet() {
		System.out.println("ThirdServlet constructor.");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("[servlet-3] init method call");
	}
	
	/* 宏扼快历狼 夸没阑 贸府 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[servlet-3] req: " + req + "\n[servlet-3] res: " + res);
		System.out.println("[servlet-3] doGet method call");
	}
	
	@Override
	public void destroy() {
		System.out.println("[servlet-3] destroy method call");
	}

}
