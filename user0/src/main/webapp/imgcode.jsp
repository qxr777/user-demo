<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*" %>   
<%
int width = 60;
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
// 四位数字验证码保存在Session中
session.setAttribute("randomCode", randomCode.toString());
// 禁止图像缓存
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "cache");
response.setDateHeader("Expires", 0);
response.setContentType("image/jpeg");
// 将图像输出到Servlet的输出流中
ServletOutputStream sos = response.getOutputStream();
ImageIO.write(buffImg, "jpeg", sos);
sos.close();
out.clear();
%>