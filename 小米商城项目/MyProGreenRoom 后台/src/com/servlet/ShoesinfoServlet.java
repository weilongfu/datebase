package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.Shoes;
import com.bean.Shoesinfo;
import com.service.ShoesinfoService;
import com.service.impl.ShoesinfoServiceImpl;

public class ShoesinfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		// 获取请求页面的参数
		String method = request.getParameter("method");
		switch (method) {
		case "query":
			query(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "update" :
			update(request, response);
			break;
		case "updateShoes":
			updateShoes(request, response);
			break;
		case "toAddShoes":
			toAddShoes(request, response);
			break;
		case "AddShoes":
			AddShoes(request, response);
			break;
		default:
			break;
		}
	}

	// 查看所有商品信息的方法
	protected void query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		// 调用查询所有商品信息的方法
		ArrayList<Shoesinfo> list = service.query();
		// 绑定到作用域
		request.setAttribute("list", list);
		// 转发到首页
		request.getRequestDispatcher("GreenGoom/index.jsp").forward(request,
				response);
	}

	// 删除商品的方法
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取传过来的商品编号
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
        //调用根据商品编号删除商品信息的方法
		service.delete(shoesid);
		//转发到后台主页
		query(request, response);
	}
	
	
	//进入修改商品信息的方法
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取传过来的商品编号
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用通过编号查询商品信息
		Shoesinfo shoes=service.queryById(shoesid);
		//绑定到作用域
		request.setAttribute("shoes", shoes);
		//转发到修改商品页面
		request.getRequestDispatcher("GreenGoom/UpdateShoesinfo.jsp").forward(request, response);
	}
	
	
	//修改商品信息的方法
	protected void updateShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取传过来的商品编号
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		//获取请求页面的参数
		String shoesname=request.getParameter("shoesname");
		double shoesprice=Double.parseDouble(request.getParameter("shoesprice"));
		int shoescount=Integer.parseInt(request.getParameter("shoescount"));
		String release=request.getParameter("release");
		String color=request.getParameter("color");
		String shoesstate=request.getParameter("shoesstate");
		//实例化商品对象
		Shoesinfo shoes=new Shoesinfo();
		shoes.setShoesid(shoesid);
		shoes.setShoesname(shoesname);
		shoes.setShoesprice(shoesprice);
		shoes.setShoescount(shoescount);
		shoes.setRelease(release);
		shoes.setColor(color);
		shoes.setShoesstate(shoesstate);
		//实例化数据库操作对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用数据库修改商品信息的方法
		int num=service.updateShoes(shoes);
		if(num>0){
			//转发到后台主页
			query(request, response);
		}else{
			out.print("<script type='text/javascript'>alert('修改失败！');window.location ='shoes.do?method=query'</script>");
		}
	}
	
	
	//进入添加商品页面
	protected void toAddShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("GreenGoom/AddShoesinfo.jsp").forward(request, response);
	}
	
	//添加商品的方法
	protected void AddShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		   Shoes shoes=new Shoes();
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建一个文件上传的解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析请求
			List<FileItem> items = upload.parseRequest(request);
			//遍历集合
			for(FileItem fileItem:items){
				
				if(fileItem.isFormField()){
					//如果是普通表单控件
					System.out.println("控件名:"+fileItem.getFieldName());
					//解决中文，需要这里指定UTF-8
					System.out.println("该控件的值:"+fileItem.getString("UTF-8"));
					if(fileItem.getFieldName().equals("shoesname")){
						shoes.setShoesname(fileItem.getString("UTF-8"));
					}else if(fileItem.getFieldName().equals("shoesprice")){
						shoes.setShoesprice(Double.parseDouble(fileItem.getString("UTF-8")));
					}
					else if(fileItem.getFieldName().equals("introduce")){
						shoes.setIntroduce(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("shoesintr")){
						shoes.setShoesintr(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("shoescount")){
						shoes.setShoescount(Integer.parseInt(fileItem.getString("UTF-8")));
					}
					else if(fileItem.getFieldName().equals("release")){
						shoes.setRelease(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("color")){
						shoes.setColor(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("shoesType")){
						shoes.setShoesType(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("keyword")){
						shoes.setKeyword(fileItem.getString("UTF-8"));
					}
					else if(fileItem.getFieldName().equals("shoesstate")){
						shoes.setShoesstate(fileItem.getString("UTF-8"));
					}
				}else{
					//是file控件
					String oldName=fileItem.getName();
					System.out.println("文件名:"+oldName);
				if(!"".equals(oldName)){   
					//得到images在本机的绝对路径
					String realpath="E:/workspace/MyProGreenRoom/WebRoot/images";
				 
					//得到唯一的文件名(毫秒数+原来文件名），考虑原图片名中有中文
					String newName=System.currentTimeMillis()+oldName;
					//得到存储文件的绝对路径
					String path=realpath+"/"+newName;
					//实现文件复制
					fileItem.write(new File(path));
					//设置商品对象的图片
					shoes.setShoesimg(newName);
				}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//实例化数据库操作对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用数据库添加商品信息的方法
		service.addShoes(shoes);
		//转发到后台主页
		query(request, response);
	}
}
