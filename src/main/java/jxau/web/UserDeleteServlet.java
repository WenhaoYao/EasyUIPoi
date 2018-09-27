package jxau.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jxau.dao.UserDao;
import jxau.util.ResponseUtil;

/**
 * Servlet implementation class UserDeleteServlet
 */
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String delId = request.getParameter("delId");
		JSONObject result = new JSONObject();
		if (userDao.deleteUser(Integer.parseInt(delId)) == 1) {
			result.put("success", "true");
		} else {
			result.put("errorMsg", "delete failed");
		}
		ResponseUtil.write(response, result);
	}

}
