package com.gqx.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthImageServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=gb2312";     
    //������ĸ�Ĵ�С,��С     
    private Font mFont = new Font("Times New Roman", Font.PLAIN, 24);     
    public void init() throws ServletException     
    {     
        super.init();     
    }     
    //ָ����Χ������rgb��ɫ
    Color getRandColor(int fc,int bc)     
    {     
        Random random = new Random();     
        if(fc>255) fc=255;     
        if(bc>255) bc=255;     
        int r=fc+random.nextInt(bc-fc);     
        int g=fc+random.nextInt(bc-fc);     
        int b=fc+random.nextInt(bc-fc);     
        return new Color(r,g,b);     
    }     
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     
    {     
    	//no-cacheָʾ�������Ӧ��Ϣ���ܻ���
        response.setHeader("Pragma","No-cache");     
        response.setHeader("Cache-Control","no-cache");     
        response.setDateHeader("Expires", 0);     
        //�������ɵ���Ӧ��ͼƬ     
        response.setContentType("image/jpeg");     
             
        int width=100, height=25;     
      //����һ��ͼƬ������
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);     
      //��ȡͼƬ�������     
        Graphics g = image.getGraphics();     
      //��䱳��ɫ
        Random random = new Random();     
        g.setColor(getRandColor(200,250));     
        g.fillRect(1, 1, width-1, height-1);   
        //�趨�߿���ɫ
        g.setColor(new Color(102,102,102));     
        g.drawRect(0, 0, width-1, height-1); 
        
      //�������     
        for (int i=0;i<15;i++)     
        {     
            int x = random.nextInt(width - 1);     
            int y = random.nextInt(height - 1);     
            int xl = random.nextInt(6) + 1;     
            int yl = random.nextInt(12) + 1;     
            g.drawLine(x,y,x + xl,y + yl);     
        }     
    
        //����һ���������     
        for (int i = 0;i < 10;i++)     
        {     
            int x = random.nextInt(width - 1);     
            int y = random.nextInt(height - 1);     
            int xl = random.nextInt(12) + 1;     
            int yl = random.nextInt(6) + 1;     
            g.drawLine(x,y,x - xl,y - yl);     
        }    
        
        
      //д������
        g.setFont(mFont);     
        //���������,�����������ת��Ϊ��ĸ     
        String sRand="";     
        for (int i=0;i<4;i++)     
        {     
            int itmp = random.nextInt(26) + 65;     
            char ctmp = (char)itmp;     
            sRand += String.valueOf(ctmp);    
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110))); 
            //ʹ�ô�ͼ�������ĵĵ�ǰ�������ɫ������ָ�� string �������ı���
            //void drawString(String str, int x,int y)		str - Ҫ���Ƶ� string�� x - x ���ꡣ   y - y ����
            g.drawString(String.valueOf(ctmp),22*i+10,22);     
        }     
    
        HttpSession session = request.getSession(true);     
        session.setAttribute("rand",sRand);     
        g.dispose(); 
        //ʹ��֧�ָ�����ʽ������ ImageWriter ��һ��ͼ��д�� OutputStream��
        ImageIO.write(image, "JPEG", response.getOutputStream());     
    }     
}
