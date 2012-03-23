package com.zy.common.util;

import java.awt.Rectangle;

import magick.ImageInfo;
import magick.MagickApiException;
import magick.MagickException;
import magick.MagickImage;

import com.zy.Constants;

public class ImageUtil {
	public static void main(String[] args) {
		resetsize("d:\\BEIBEI.JPG", "d:\\aaa.jpg");
	}

	public static void resetsize(String picFrom, String picTo) {
		if(picFrom.indexOf("album")<0){
			resetsize(picFrom,picTo,120,120);
		}else{
			resetsize(picFrom,picTo,320,320);
		}
	}
	
	public static void cropPic(String srcPic,String targetPic,int x,int y,int width,int height) throws Exception{
		magick.ImageInfo info = new magick.ImageInfo(srcPic);
		Rectangle rect = new Rectangle(x,y,width,height);
		MagickImage image = new MagickImage(info);
		MagickImage cropped = image.cropImage(rect);
		cropped.setFileName(targetPic);
		cropped.writeImage(info);
	}
	
	public static int[] resetsize(String picFrom, String picTo,int newWidth,int newHeight) {
		int[] result = new int[2];
		try {
			System.out.println("-----libary-------"+System.getProperty("java.library.path"));
			
			System.setProperty("jmagick.systemclassloader","false"); 
			ImageInfo info = new ImageInfo(picFrom);
			//if(true){
				//return;
			//}
			System.out.println(Constants.realPath+picFrom);
			MagickImage image = new MagickImage(new ImageInfo(Constants.realPath+picFrom));
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
			result[0] = targetW;
			result[1] = targetH;
			MagickImage scaled = image.scaleImage(targetW, targetH);
			scaled.setFileName(Constants.realPath+picTo);
			scaled.writeImage(info);
		} catch (MagickApiException ex) {
			ex.printStackTrace();
		} catch (MagickException ex) {
			ex.printStackTrace();
		}
		return result;
	}
}