package jxau.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

import jxau.dao.UserDao;
import jxau.util.ExcelUtil;
import jxau.util.ResponseUtil;

/**
 * Servlet implementation class UserExportServlet
 */
public class UserExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] head = {"编号", "姓名", "电话", "Email", "QQ"};
		try {
			Workbook workbook = ExcelUtil.generateExcel(userDao.userList(null), head);
			ResponseUtil.exportExcel(response, workbook, "所有用户.xls");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
