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
		// ���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		// ��ȡ����ҳ��Ĳ���
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

	// �鿴������Ʒ��Ϣ�ķ���
	protected void query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		// ���ò�ѯ������Ʒ��Ϣ�ķ���
		ArrayList<Shoesinfo> list = service.query();
		// �󶨵�������
		request.setAttribute("list", list);
		// ת������ҳ
		request.getRequestDispatcher("GreenGoom/index.jsp").forward(request,
				response);
	}

	// ɾ����Ʒ�ķ���
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����������Ʒ���
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
        //���ø�����Ʒ���ɾ����Ʒ��Ϣ�ķ���
		service.delete(shoesid);
		//ת������̨��ҳ
		query(request, response);
	}
	
	
	//�����޸���Ʒ��Ϣ�ķ���
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����������Ʒ���
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//����ͨ����Ų�ѯ��Ʒ��Ϣ
		Shoesinfo shoes=service.queryById(shoesid);
		//�󶨵�������
		request.setAttribute("shoes", shoes);
		//ת�����޸���Ʒҳ��
		request.getRequestDispatcher("GreenGoom/UpdateShoesinfo.jsp").forward(request, response);
	}
	
	
	//�޸���Ʒ��Ϣ�ķ���
	protected void updateShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ����������Ʒ���
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		//��ȡ����ҳ��Ĳ���
		String shoesname=request.getParameter("shoesname");
		double shoesprice=Double.parseDouble(request.getParameter("shoesprice"));
		int shoescount=Integer.parseInt(request.getParameter("shoescount"));
		String release=request.getParameter("release");
		String color=request.getParameter("color");
		String shoesstate=request.getParameter("shoesstate");
		//ʵ������Ʒ����
		Shoesinfo shoes=new Shoesinfo();
		shoes.setShoesid(shoesid);
		shoes.setShoesname(shoesname);
		shoes.setShoesprice(shoesprice);
		shoes.setShoescount(shoescount);
		shoes.setRelease(release);
		shoes.setColor(color);
		shoes.setShoesstate(shoesstate);
		//ʵ�������ݿ��������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//�������ݿ��޸���Ʒ��Ϣ�ķ���
		int num=service.updateShoes(shoes);
		if(num>0){
			//ת������̨��ҳ
			query(request, response);
		}else{
			out.print("<script type='text/javascript'>alert('�޸�ʧ�ܣ�');window.location ='shoes.do?method=query'</script>");
		}
	}
	
	
	//���������Ʒҳ��
	protected void toAddShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("GreenGoom/AddShoesinfo.jsp").forward(request, response);
	}
	
	//�����Ʒ�ķ���
	protected void AddShoes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		   Shoes shoes=new Shoes();
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			// ����һ���ļ��ϴ��Ľ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			//��������
			List<FileItem> items = upload.parseRequest(request);
			//��������
			for(FileItem fileItem:items){
				
				if(fileItem.isFormField()){
					//�������ͨ���ؼ�
					System.out.println("�ؼ���:"+fileItem.getFieldName());
					//������ģ���Ҫ����ָ��UTF-8
					System.out.println("�ÿؼ���ֵ:"+fileItem.getString("UTF-8"));
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
					//��file�ؼ�
					String oldName=fileItem.getName();
					System.out.println("�ļ���:"+oldName);
				if(!"".equals(oldName)){   
					//�õ�images�ڱ����ľ���·��
					String realpath="E:/workspace/MyProGreenRoom/WebRoot/images";
				 
					//�õ�Ψһ���ļ���(������+ԭ���ļ�����������ԭͼƬ����������
					String newName=System.currentTimeMillis()+oldName;
					//�õ��洢�ļ��ľ���·��
					String path=realpath+"/"+newName;
					//ʵ���ļ�����
					fileItem.write(new File(path));
					//������Ʒ�����ͼƬ
					shoes.setShoesimg(newName);
				}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ʵ�������ݿ��������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//�������ݿ������Ʒ��Ϣ�ķ���
		service.addShoes(shoes);
		//ת������̨��ҳ
		query(request, response);
	}
}
