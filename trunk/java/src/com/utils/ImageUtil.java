package com.utils;

import java.awt.Rectangle;

import magick.ImageInfo;
import magick.MagickApiException;
import magick.MagickException;
import magick.MagickImage;

public class ImageUtil {
	public static void main(String[] args) throws Exception{
		//resetsize("d:\\BEIBEI.JPG", "d:\\aaa.jpg");
		
		String fileName = "D:\\aaa.jpg";
		magick.ImageInfo info = new magick.ImageInfo(fileName);
		Rectangle rect = new Rectangle(0,0,100,100);
		MagickImage image = new MagickImage(info);
		MagickImage cropped = image.cropImage(rect);
		cropped.setFileName("d:\\bbb.jpg");
		cropped.writeImage(info);
	}
	
	public static void cropPic(String srcPic,String targetPic,int x,int y,int width,int height) throws Exception{
		magick.ImageInfo info = new magick.ImageInfo(srcPic);
		Rectangle rect = new Rectangle(x,y,width,height);
		MagickImage image = new MagickImage(info);
		MagickImage cropped = image.cropImage(rect);
		cropped.setFileName(targetPic);
		cropped.writeImage(info);
	}

	public static void resetsize(String picFrom, String picTo) {
		resetsize(picFrom,picTo,640,640);
	}
	
	public static void resetsize(String picFrom, String picTo,int newWidth,int newHeight) {
		try {
			ImageInfo info = new ImageInfo(picFrom);
			MagickImage image = new MagickImage(new ImageInfo(picFrom));
			System.out.println("width---------"
					+ image.getDimension().getWidth());
			System.out.println("height---------"
					+ image.getDimension().getHeight());

			double width = image.getDimension().getWidth();
			double height = image.getDimension().getHeight();

			int targetW = newWidth;
			int targetH = newHeight;

			double sx = (double) targetW / width;
			double sy = (double) targetH / height;
			// reduce not expend
			if (sx > sy) {
				if (sy > 1) {
					targetW = (int)width;
					targetH = (int)height;
				} else {
					targetW = (int) (sy * width);
					targetH = (int) (sy * height);
				}
			} else if (sx <= sy) {
				if (sx > 1) {
					targetW = (int)width;
					targetH = (int)height;
				} else {
					targetW = (int) (sx * width);
					targetH = (int) (sx * height);
				}
			}

			System.out.println("-----targetwidth------"+targetW);
			System.out.println("-----targetheight------"+targetH);
			MagickImage scaled = image.scaleImage(targetW, targetH);
			scaled.setFileName(picTo);
			scaled.writeImage(info);
		} catch (MagickApiException ex) {
			ex.printStackTrace();
		} catch (MagickException ex) {
			ex.printStackTrace();
		}
	}
}