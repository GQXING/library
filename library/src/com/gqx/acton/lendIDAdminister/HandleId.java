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
 * �ϴ�ͷ��
 * @author GQXing
 *
 */
public class HandleId extends ActionSupport{
		//��Ӧ���� ���ļ�:<input type="file1" name="file1">
		private File photo;
		//�ļ���(�˸�ʽҪ�̶���name+FileName)
		private String photoFileName;
		//�ļ������ͣ�MIME)
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
		//	��װ����
		
		public void setReader(Reader reader) {
			this.reader = reader;
		};
		public Reader getReader() {
			return reader;
		}
		LendIDAdministerService service=new LendIDAdministerService();
		public String Add(){
			//���ļ��ϴ���uploadĿ¼
			//1����ȡ�ϴ���Ŀ¼��·��
			String path=ServletActionContext.getServletContext().getRealPath("/UploadImg");
			System.out.println(path);
			//�����ļ�����
			File destFile=new File(path,photoFileName);
			//2�����ϴ����ļ�������Ŀ���ļ�
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
					
					requestMap.put("AddRessult", "���ã�"+reader.getRdName()+"�Ķ���֤�Ѿ����������");
					return "AddSuccess";
				}
				requestMap.put("AddRessult", "����֤����ʧ�ܣ������ԣ�");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			return "AddSuccess";
			
		}
		
		
		//��ʧ״̬���˺�
		public String modify(){
			boolean flag=service.Update(reader.getRdID(), reader);
			return "AddSuccess";
		}
}
