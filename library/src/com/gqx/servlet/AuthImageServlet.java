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
    //设置字母的大小,大小     
    private Font mFont = new Font("Times New Roman", Font.PLAIN, 24);     
    public void init() throws ServletException     
    {     
        super.init();     
    }     
    //指定范围内生成rgb颜色
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
    	//no-cache指示请求或响应消息不能缓存
        response.setHeader("Pragma","No-cache");     
        response.setHeader("Cache-Control","no-cache");     
        response.setDateHeader("Expires", 0);     
        //表明生成的响应是图片     
        response.setContentType("image/jpeg");     
             
        int width=100, height=25;     
      //创建一个图片缓冲区
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);     
      //获取图片处理对象     
        Graphics g = image.getGraphics();     
      //填充背景色
        Random random = new Random();     
        g.setColor(getRandColor(200,250));     
        g.fillRect(1, 1, width-1, height-1);   
        //设定边框颜色
        g.setColor(new Color(102,102,102));     
        g.drawRect(0, 0, width-1, height-1); 
        
      //画随机线     
        for (int i=0;i<15;i++)     
        {     
            int x = random.nextInt(width - 1);     
            int y = random.nextInt(height - 1);     
            int xl = random.nextInt(6) + 1;     
            int yl = random.nextInt(12) + 1;     
            g.drawLine(x,y,x + xl,y + yl);     
        }     
    
        //从另一方向画随机线     
        for (int i = 0;i < 10;i++)     
        {     
            int x = random.nextInt(width - 1);     
            int y = random.nextInt(height - 1);     
            int xl = random.nextInt(12) + 1;     
            int yl = random.nextInt(6) + 1;     
            g.drawLine(x,y,x - xl,y - yl);     
        }    
        
        
      //写入文字
        g.setFont(mFont);     
        //生成随机数,并将随机数字转换为字母     
        String sRand="";     
        for (int i=0;i<4;i++)     
        {     
            int itmp = random.nextInt(26) + 65;     
            char ctmp = (char)itmp;     
            sRand += String.valueOf(ctmp);    
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110))); 
            //使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。
            //void drawString(String str, int x,int y)		str - 要绘制的 string。 x - x 坐标。   y - y 坐标
            g.drawString(String.valueOf(ctmp),22*i+10,22);     
        }     
    
        HttpSession session = request.getSession(true);     
        session.setAttribute("rand",sRand);     
        g.dispose(); 
        //使用支持给定格式的任意 ImageWriter 将一个图像写入 OutputStream。
        ImageIO.write(image, "JPEG", response.getOutputStream());     
    }     
}
