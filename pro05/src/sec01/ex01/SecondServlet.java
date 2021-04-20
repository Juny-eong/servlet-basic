package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	public SecondServlet() {
		System.out.println("SecondServlet constructor.");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("[servlet-2] init method call");
	}
	
	/* 宏扼快历狼 夸没阑 贸府 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[servlet-2] req: " + req + "\n[servlet-2] res: " + res);
		System.out.println("[servlet-2] doGet method call");
	}
	
	@Override
	public void destroy() {
		System.out.println("[servlet-2] destroy method call");
	}

}
