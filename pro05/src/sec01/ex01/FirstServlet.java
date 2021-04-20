package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	public FirstServlet() {
		System.out.println("FirstServlet constructor.");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init method call");
	}
	
	/* 宏扼快历狼 夸没阑 贸府 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("req: " + req + "\nres: " + res);
		System.out.println("doGet method call");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method call");
	}

}
