package edu.whut.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RandomCodeAction extends ActionSupport {
	private ByteArrayInputStream inputStream;

	@Override
	public String execute() throws Exception {
		// 验证码图片宽度
		int width = 60;
		// 验证码图片高度
		int height = 20;
		
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 创建一个随机数生成器
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 字体，大小等参数
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		// 设置字体
		g.setFont(font);
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生160条干扰线
		g.setColor(Color.GRAY);
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}
		// randomCode用于保存随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// 随机产生验证码数字
		for (int i = 0; i < 4; i++) {
			String strRand = String.valueOf(random.nextInt(10));
			// 产生随机的颜色分量来构造颜色值
			red = random.nextInt(10);
			green = random.nextInt(50);
			blue = random.nextInt(50);
			// 用随机产生的颜色将验证码绘制在图像中
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, 13 * i + 6, 16);
			// 将产生的四个随机数组合在一起
			randomCode.append(strRand);
		}
		
//      将认证码存入SESSION  
       ActionContext.getContext().getSession().put("randomCode",randomCode.toString());		
       
//     图象生效  
      g.dispose();  
      ByteArrayOutputStream output = new ByteArrayOutputStream();  
      ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);  
      ImageIO.write(buffImg, "JPEG", imageOut);  
      imageOut.close();  
      ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());  
      this.setInputStream(input);  
      return SUCCESS;       
       
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}  
	

}
