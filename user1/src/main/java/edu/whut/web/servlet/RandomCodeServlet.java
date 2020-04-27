package edu.whut.web.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomCodeServlet extends HttpServlet {
	// 验证码图片宽度
	private int width = 60;
	// 验证码图片高度
	private int height = 20;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
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
		// 四位数字验证码保存在Session中
		HttpSession session = req.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		// 禁止图像缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet的输出流中
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

	}
}