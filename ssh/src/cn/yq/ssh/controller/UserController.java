package cn.yq.ssh.controller;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.yq.ssh.domain.User;
import cn.yq.ssh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController implements Serializable {
	

	// 引入业务层
	@Resource
	private UserService service;

	// 登录方法
	@RequestMapping(value = "/login.do", method = RequestMethod.POST, params = { "username", "password" })
	public String login(String username, String password, HttpSession session) {
		System.out.println(username);
		System.out.println(password);
		// TODO 取数据库验证账号秘密

		// 将账号保存到Session对象中
		session.setAttribute("username", username);
		// 登录成功，跳转到用户列表页面
		return "redirect:/user/list.do";
	}

	@RequestMapping("/list.do")
	public String userList(Model m) {
		
		// 调用业务层方法查询所有用户信息
		List<User> users = service.list();

		// 共享数据
		m.addAttribute("users", users);

		return "userList";
	}

	@RequestMapping("/delete.do")
	public String deleteUser(Integer id) {
		// 调用业务层方法删除
		// TODO 数据校验
		service.delete(id);

		// 一定是重定向
		return "redirect:/user/list.do";
	}

	// 导出excel文件

	@RequestMapping("/export.do")
	public void export(HttpServletResponse response) throws IOException {

		// 调用业务层方法查询所有用户信息
		List<User> users = service.list();

		// 使用POI创建工作集
		HSSFWorkbook book = new HSSFWorkbook();

		// 创建一个Sheet
		HSSFSheet sheet = book.createSheet();
		
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		
		// 创建标题头的行
		titleRow.createCell(0).setCellValue("编号");
		titleRow.createCell(1).setCellValue("姓名");
		titleRow.createCell(2).setCellValue("密码");
		titleRow.createCell(3).setCellValue("邮箱");

		// 循环集合，将每个User对象数据封装对应的一行excel中
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);

			// 创建一行
			HSSFRow row = sheet.createRow(i + 1);
			
			row.createCell(0).setCellValue(u.getId());
			row.createCell(1).setCellValue(u.getUsername());
			row.createCell(2).setCellValue(u.getPassword());
			row.createCell(3).setCellValue(u.getEmail());
		}

		// UTF-8编码
		String fileName = "用户信息.xlsx";
		// 下载文件的文件名称的编码是ISO-8859-1
		byte[] bytes = fileName.getBytes("UTF-8");
		fileName = new String(bytes, "ISO-8859-1");
		// 3.响应的内容应该是以附件的形式响应给浏览器(设置响应头)
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

		// 获取响应对象的输出流
		ServletOutputStream outputStream = response.getOutputStream();
		book.write(outputStream);

	}

}
