package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pool.Constant;

public class Command {
	public static void move(HttpServletRequest request,	HttpServletResponse response, String dir, String page) throws ServletException, IOException {
		System.out.println("***Command에 진입***");
		
		String dispatcher = Constant.VIEW + dir+"/"+page + Constant.JSP;
		if(page.equals("index")) {
			dispatcher = "index"+Constant.JSP;
		}else {
			dispatcher = Constant.VIEW + dir+"/"+page + Constant.JSP;
		}
		System.out.println(">>>>>>>"+dispatcher);
		request.getRequestDispatcher(Constant.VIEW + dir+"/"+page + Constant.JSP)
		.forward(request, response);
		
		//(path.equals("index")) ? "/index.jsp" : VIEW + "path" + JSP;
		
		
	}
}
