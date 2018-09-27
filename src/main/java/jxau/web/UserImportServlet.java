package jxau.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;

import jxau.dao.UserDao;
import jxau.model.User;
import jxau.util.ExcelUtil;
import jxau.util.ResponseUtil;


public class UserImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 上传时生成的临时文件保存目录
				String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");// "/WEB-INF/temp"
				File tmpFile = new File(tempPath);
				if (!tmpFile.exists()) {
					// 创建临时目录
					tmpFile.mkdir();
				}
				// 使用Apache文件上传组件处理文件上传步骤：
				// 1、创建一个DiskFileItemFactory工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
				factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
				// 设置上传时生成的临时文件的保存目录
				factory.setRepository(tmpFile);
				// 2、创建一个文件上传解析器
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 解决上传文件名的中文乱码
				upload.setHeaderEncoding("UTF-8");
				// 3、判断提交上来的数据是否是上传表单的数据
				if (!ServletFileUpload.isMultipartContent(request)) {
					// 按照传统方式获取数据
					return;
				}

				// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
				upload.setFileSizeMax(1024 * 1024);
				// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
				upload.setSizeMax(1024 * 1024 * 10);

				// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
				List<FileItem> list = null;
				try {
					list = upload.parseRequest(request);
					for (FileItem item : list) {
						// 如果fileitem中封装的是普通输入项的数据
						if (item.isFormField()) {
							String name = item.getFieldName();
							// 解决普通输入项的数据的中文乱码问题
							String value = item.getString("UTF-8");
//			                String value = item.getString("gbk");
							// value = new String(value.getBytes("iso8859-1"),"UTF-8");
							System.out.println(name + "=" + value);
						} else {// 如果fileitem中封装的是上传文件
								// 得到上传的文件名称，
							String filename = item.getName();
							System.out.println(filename + "..");
							if (filename == null || filename.trim().equals("")) {
								continue;
							}
							// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
							// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
							filename = filename.substring(filename.lastIndexOf("\\") + 1);
							// 得到上传文件的扩展名
							String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
							// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
							System.out.println("上传的文件的扩展名是：" + fileExtName);
							// 获取item中的上传文件的输入流
							InputStream in = item.getInputStream();
							Workbook workbook = ExcelUtil.getWorkBook(in, fileExtName);
							Sheet sheet = workbook.getSheetAt(0);
							if(sheet != null) {
								for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
									Row row = sheet.getRow(rowNum);
									User user = new User();
									user.setName(ExcelUtil.fomatCell(row.getCell(0)));
									System.out.println(ExcelUtil.fomatCell(row.getCell(1)));
									user.setPhone(ExcelUtil.fomatCell(row.getCell(1)));
									user.setEmail(ExcelUtil.fomatCell(row.getCell(2)));
									user.setQq(ExcelUtil.fomatCell(row.getCell(3)));
									System.out.println(ExcelUtil.fomatCell(row.getCell(3)));
									userDao.addUser(user);
								}
							}
							JSONObject result = new JSONObject();
							result.put("success", "true");
							ResponseUtil.write(response, result);
						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}

}
