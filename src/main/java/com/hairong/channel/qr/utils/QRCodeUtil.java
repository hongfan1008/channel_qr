
package com.hairong.channel.qr.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import cn.hutool.extra.qrcode.BufferedImageLuminanceSource;


public class QRCodeUtil {

	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 690;
	// LOGO宽度
	private static final int WIDTH = 240;
	// LOGO高度
	private static final int HEIGHT = 240;
	//二维码编码宽度
	private static final int WIDTH_NUM=690;
	//二维码编码高度
	private static final int HEIGHT_NUM=30;

	private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage(image, imgPath, needCompress);
		return image;
	}

	private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
 		System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	private static void insertImage2(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
 			System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE+100 - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	private static void insertImage2Small(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
 			System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	public static void encode(String content, String imgPath, String destPath, String fileName, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
		mkdirs(destPath);
		String file = fileName + ".jpg";
		ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
	}
	
	public static BufferedImage createImageWithNumber(String number,String content, String imgPath, boolean needCompress) throws Exception{
		 
		BufferedImage image1 = createImageNumber(number);//生称编码图片
		
        BufferedImage image2 = createImageBig(content, imgPath, needCompress);//生成的二维码
        
        Graphics2D graph = image2.createGraphics();
        int x1 = 0;
        int y1 = 660;
        graph.drawImage(image1, x1, y1, WIDTH_NUM, HEIGHT_NUM, null);
        Shape shape = new RoundRectangle2D.Float(x1, y1, WIDTH_NUM, WIDTH_NUM, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
        
        return image2;
	}
	public static BufferedImage createImageWithNumberSmall(String number,String content, String imgPath, boolean needCompress) throws Exception{
		 
		BufferedImage image1 = createImageNumber(number);//生称编码图片
		
        BufferedImage image2 = createImageBigSmall(content, imgPath, needCompress);//生成的二维码
        
        Graphics2D graph = image2.createGraphics();
        int x1 = 0;
        int y1 = 665;
        graph.drawImage(image1, x1, y1, WIDTH_NUM, HEIGHT_NUM, null);
        Shape shape = new RoundRectangle2D.Float(x1, y1, WIDTH_NUM, WIDTH_NUM, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
        
        return image2;
	}
	
	private static BufferedImage createImageNumber(String number){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<number.length();i++){
        	char charAt = number.charAt(i);
        	buffer.append("  "+charAt);
        }
        String newNum =  ""+ buffer;
           
        Font font = new Font("Serif", Font.PLAIN, 16);   
        BufferedImage image = new BufferedImage(WIDTH_NUM, HEIGHT_NUM, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)image.getGraphics();   
        g2.setBackground(Color.WHITE); 
        g2.setFont(font);
        g2.clearRect(0, 0, WIDTH_NUM, HEIGHT_NUM);
        g2.setPaint(Color.black);   
           
        FontRenderContext context = g2.getFontRenderContext();   
        Rectangle2D bounds = font.getStringBounds(newNum, context);   
        double x = (WIDTH_NUM - bounds.getWidth()) / 2;   
        double y = (HEIGHT_NUM - bounds.getHeight()) / 2;   
        double ascent = -bounds.getY();   
        double baseY = y + ascent;   
           
        g2.drawString(newNum, (int)x, (int)baseY); 
        
        return image;
	}
	
	private static BufferedImage createImageBig(String content, String imgPath, boolean needCompress) throws Exception {
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE+100,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if(y==50||y==650){
					image.setRGB(x, y,  0xCCCCCC);
				}else{
					image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
					
				}
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage2(image, imgPath, needCompress);
		return image;
	}
	private static BufferedImage createImageBigSmall(String content, String imgPath, boolean needCompress) throws Exception {
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage2Small(image, imgPath, needCompress);
		return image;
	}
	/**
	 * 生成有上下分割线的二维码，同时二维码中有编号
	 * @param number
	 * @param content
	 * @param imgPath
	 * @param destPath
	 * @param fileName
	 * @param needCompress
	 * @throws Exception
	 */
	public static void encodeWithNumber(String number,String content, String imgPath, String destPath, String fileName, boolean needCompress) throws Exception{
		BufferedImage image = QRCodeUtil.createImageWithNumber(number,content, imgPath, needCompress);
		mkdirs(destPath);
		String file = fileName + ".jpg";
		ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
	}
	/**
	 * 生成正方形的二维码，同时二维码中有编号
	 * @param number
	 * @param content
	 * @param imgPath
	 * @param destPath
	 * @param fileName
	 * @param needCompress
	 * @throws Exception
	 */
	public static void encodeWithNumberSmall(String number,String content, String imgPath, String destPath, String fileName, boolean needCompress) throws Exception{
		BufferedImage image = QRCodeUtil.createImageWithNumberSmall(number,content, imgPath, needCompress);
		mkdirs(destPath);
		String file = fileName + ".jpg";
		ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
	}

	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		// 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable hints = new Hashtable();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	public static String decode(String path) throws Exception {
		return QRCodeUtil.decode(new File(path));
	}
	 
	 
		
}

 