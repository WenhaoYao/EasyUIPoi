package jxau.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jxau.dao.UserDao;
import jxau.model.User;
import jxau.util.ResponseUtil;

/**
 * Servlet implementation class UserAddServlet
 */
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("phone");
		String qq = request.getParameter("qq");
		User user = new User(name, phone, email, qq);
		JSONObject result = new JSONObject();
		if(userDao.addUser(user) == 1) {
			result.put("success", "true");
		} else {
			result.put("errorMsg", "add failed");
		}
		ResponseUtil.write(response, result);
	}

}
