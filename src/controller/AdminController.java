package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;


@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("(1)관리자서블릿으로 들어옴!!");
		String cmd = request.getParameter("cmd");
		cmd =(cmd ==null) ? "move":cmd;
		System.out.println("(2)cmd :"+ cmd);
		String page = request.getParameter("page");
		if(page == null) {page = "main";}
		System.out.println("(3)page :"+page);
		String dir = request.getParameter("dir");
		
		if(dir == null) {
			String sPath = request.getServletPath();
			//System.out.println("*****"+sPath+"****");
			sPath = sPath.replace(".do", "");
			dir = sPath.substring(1);
			System.out.println("(4)dir :"+dir);
		}
		switch((cmd == null) ? "move": cmd) {
		case "move":
			Command.move(request, response, dir, page);
			break;
		}
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
