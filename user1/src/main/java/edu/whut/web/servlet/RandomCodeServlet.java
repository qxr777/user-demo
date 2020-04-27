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
	// ��֤��ͼƬ���
	private int width = 60;
	// ��֤��ͼƬ�߶�
	private int height = 20;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// ����һ�������������
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// ���壬��С�Ȳ���
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		// ��������
		g.setFont(font);
		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// �������160��������
		g.setColor(Color.GRAY);
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}
		// randomCode���ڱ��������������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// ���������֤������
		for (int i = 0; i < 4; i++) {
			String strRand = String.valueOf(random.nextInt(10));
			// �����������ɫ������������ɫֵ
			red = random.nextInt(10);
			green = random.nextInt(50);
			blue = random.nextInt(50);
			// �������������ɫ����֤�������ͼ����
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, 13 * i + 6, 16);
			// ���������ĸ�����������һ��
			randomCode.append(strRand);
		}
		// ��λ������֤�뱣����Session��
		HttpSession session = req.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		// ��ֹͼ�񻺴�
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// ��ͼ�������Servlet���������
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

	}
}