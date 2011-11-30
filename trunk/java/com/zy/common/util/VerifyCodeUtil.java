package com.zy.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class VerifyCodeUtil {
	static Random r = new Random();
	static String ssource = "abcdefghijklmnopqrstuvwxyz" + "0123456789";
	static char[] src = ssource.toCharArray();

	private int codeLength = 4;

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;

	public VerifyCodeUtil(){}
	
	public VerifyCodeUtil(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		this.request = request;
		this.response = response;
		String code = getCode(this.codeLength);
		this.createImage(code);
	}

	public VerifyCodeUtil(HttpServletRequest request, HttpServletResponse response, Integer codeLength)throws Throwable {
		this.codeLength = codeLength.intValue();
		this.request = request;
		this.response = response;
		String code = getCode(this.codeLength);
		this.createImage(code);
	}

	/**
	 * 产生随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public String getCode(int length) {
		char[] buf = new char[length];
		int rnd;
		for (int i = 0; i < length; i++) {
			rnd = Math.abs(r.nextInt()) % src.length;

			buf[i] = src[rnd];
		}
		return new String(buf);
	}

	/**
	 * 给定范围获得随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 调用该方法将得到的验证码生成图象
	 * 
	 * @param sCode
	 *            验证码
	 * @return
	 */
	private void createImage(String sCode) throws Throwable {
		this.response.setContentType("image/jpeg");
		// 设置页面不缓存
		this.response.setHeader("Pragma", "No-cache");
		this.response.setHeader("Cache-Control", "no-cache");
		this.response.setDateHeader("Expires", 0);
		// 图象宽度与高度
		int width = 15 * this.codeLength;
		int height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1)

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		for (int i = 0; i < this.codeLength; i++) {
			String rand = sCode.substring(i, i + 1);
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(60), 20 + random.nextInt(120), 20 + random.nextInt(180)));
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 图象生效
		g.dispose();
		this.request.getSession().setAttribute("rand", sCode);
		ServletOutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outStream);
			encoder.encode(image);
		} finally {
			if (outStream != null)
				outStream.close();
		}
	}

}
