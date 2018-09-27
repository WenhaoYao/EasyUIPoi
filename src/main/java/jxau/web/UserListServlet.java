package jxau.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import jxau.dao.UserDao;
import jxau.model.PageBean;
import jxau.util.JsonUtil;
import jxau.util.ResponseUtil;

/**
 * Servlet implementation class UserListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		JSONArray array = JsonUtil.JsonFomatter(userDao.userList(pageBean));
		int total = userDao.userCount();
		JSONObject result = new JSONObject();
		result.put("rows", array);
		result.put("total", total);
//		ZuiUtil.Zui(array, total, Integer.parseInt(page))
		ResponseUtil.write(response, result);
	}

}
