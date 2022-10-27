package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// applicationScopeから、呟きリストを取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterlist");
		
		// 呟きリストがなければ、新たに作成し、applicationScopeに格納
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		// loginUserがいるか確認
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		// いなければログインページへ遷移させる。いた場合、メインページへ遷移させる
		if(loginUser == null) {
			response.sendRedirect("/sampleTsubu");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}	
	}	
}
