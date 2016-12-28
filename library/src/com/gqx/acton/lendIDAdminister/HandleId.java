package com.gqx.acton.lendIDAdminister;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gqx.entity.Reader;
import com.gqx.service.lendIDAdminister.LendIDAdministerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 上传头像
 * @author GQXing
 *
 */
public class HandleId extends ActionSupport{
		//对应表单中 的文件:<input type="file1" name="file1">
		private File photo;
		//文件名(此格式要固定即name+FileName)
		private String photoFileName;
		//文件的类型（MIME)
		private String photoContentType;
		private Reader reader=new Reader();
		public void setPhoto(File photo) {
			this.photo = photo;
		}
		public void setPhotoFileName(String photoFileName) {
			this.photoFileName = photoFileName;
		}
		public void setPhotoContentType(String photoContentType) {
			this.photoContentType = photoContentType;
		}
		public File getPhoto() {
			return photo;
		}
		public String getPhotoFileName() {
			return photoFileName;
		}
		public String getPhotoContentType() {
			return photoContentType;
		}
		//	封装对象
		
		public void setReader(Reader reader) {
			this.reader = reader;
		};
		public Reader getReader() {
			return reader;
		}
		LendIDAdministerService service=new LendIDAdministerService();
		public String Add(){
			//把文件上传到upload目录
			//1、获取上传的目录的路径
			String path=ServletActionContext.getServletContext().getRealPath("/UploadImg");
			System.out.println(path);
			//创建文件对象
			File destFile=new File(path,photoFileName);
			//2、把上传的文件拷贝到目标文件
			try {
				FileUtils.copyFile(photo, destFile);
				Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
				if (reader!=null) {
					reader.setRdPhoto("http://localhost:8080/library/UploadImg/"+photoFileName);
					reader.setRdStatus("1");
					if (reader.getRdType()==1) {
						reader.setRdBorrowQty(60);
					}else {
						reader.setRdBorrowQty(30);
					}
					reader.setRdAdminRoles(0);
					service.InsertReader(reader);
					
					requestMap.put("AddRessult", "您好！"+reader.getRdName()+"的读者证已经办理好啦！");
					return "AddSuccess";
				}
				requestMap.put("AddRessult", "读者证办理失败，请重试！");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			return "AddSuccess";
			
		}
		
		
		//挂失状态的账号
		public String modify(){
			boolean flag=service.Update(reader.getRdID(), reader);
			return "AddSuccess";
		}
}
