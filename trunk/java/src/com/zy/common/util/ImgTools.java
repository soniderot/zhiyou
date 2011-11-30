package com.zy.common.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import magick.CompressionType;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import magick.PreviewType;

public class ImgTools {

	private int width = 1;

	private int height = 1;
	
	private String path;

	private ImageInfo info;

	public static String GRP_LOGO_ICON = "_icon.jpg";
	public static String GRP_EVENT_PHOTO_SMALL = "_s.jpg";
	public static String GRP_EVENT_PHOTO_LARGE = "_l.jpg";
	
	// photo size
	public final static int GRP_EVENT_PHOTO_SMALL_SIZE = 120;
	public final static int GRP_EVENT_PHOTO_LARGE_SIZE = 500;
	public final static int GRP_LOGO_ICON_SIZE = 50;
	public final static int GRP_EVENT_LOGO_ICON_SIZE = 80;
	

	public ImgTools(int width, int height, String oldFileName) {
		try {
			LogUtil.info("---jmagick--" + System.getProperty("jmagick.systemclassloader"));
			System.setProperty("jmagick.systemclassloader", "no");
			info = new ImageInfo(oldFileName);
			info.setCompression(CompressionType.JPEGCompression);
			info.setPreviewType(PreviewType.JPEGPreview);
			this.width = width;
			this.height = height;
		} catch (MagickException e) {
			LogUtil.error(e);
		}
	}
	public ImgTools(String path) throws Exception
	{
		System.setProperty("jmagick.systemclassloader", "no");
		info = new ImageInfo(path);
		info.setCompression(CompressionType.JPEGCompression);
		info.setPreviewType(PreviewType.JPEGPreview);
		File file = new File(path);
		ImageInputStream iis = null;
		if (file != null && file.length() != 0) {
			iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			if (readers.hasNext()) {
				ImageReader reader = (ImageReader) readers.next();
				reader.setInput(iis);
				this.width=reader.getWidth(0);
				this.height=reader.getHeight(0);
				reader.dispose();
			}
			if(iis != null)
			{
				iis.close();
				iis=null;
			}
		}
	}
	// 120*120
	public void MakeSmallByJMagick(String newFileName, int size, boolean quality) {
		try {
			if (quality) {
				info.setQuality(90);
			}
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage scaled = null;
			double proportion = 0;
			if (width == height) {
				scaled = image.scaleImage(size, size);
				// } else {
			} else if (width > size || height > size) {
				if (width > height) {
					if (width > size) {
						proportion = (double) size / width;
					} else {
						proportion = width / (double) size;
					}
					scaled = image.scaleImage(size, (int) (height * proportion));
				} else {
					if (height > size) {
						proportion = (double) size / height;
					} else {
						proportion = height / (double) size;
					}
					scaled = image.scaleImage((int) (width * proportion), size);
				}
			} else {
				scaled = image.scaleImage(width, height);
			}
			scaled = scaled.sharpenImage(1.0, 5.0);
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
			scaled.destroyImages();
		} catch (MagickException e) {
			LogUtil.error(e);
		}
	}

	// 600 ,240
	public void MakeBigByJMagick(String newFileName, int size, boolean quality) {
		try {
			if (quality) {
				info.setQuality(90);
			}
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage scaled = null;
			double proportion = 0;
			if (width == height) {
				if (width > size) {
					scaled = image.scaleImage(size, size);
				} else {
					scaled = image.scaleImage(width, height);
				}
			} else {
				if (width > height) {
					if (width > size) {
						proportion = (double) size / width;
						scaled = image.scaleImage(size, (int) (height * proportion));
					} else {
						scaled = image.scaleImage(width, height);
					}
				} else {
					if (height > size) {
						proportion = (double) size / height;
						scaled = image.scaleImage((int) (width * proportion), size);
					} else {
						scaled = image.scaleImage(width, height);
					}
				}
			}
			scaled = scaled.sharpenImage(1.0, 5.0);
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
			scaled.destroyImages();
		} catch (MagickException e) {
			LogUtil.error(e);
		}
	}

	// 75*75
	public void MakeLittleByJMagick(String newFileName, int size) {
		Rectangle rect = null;
		if (width < size && height < size) {
			rect = new Rectangle(0, 0, size, size);
		} else {
			if (width < height) {
				int beginPoint = (height - width) / 2;
				rect = new Rectangle(0, beginPoint, width, width);
			} else {
				int beginPoint = (width - height) / 2;
				rect = new Rectangle(beginPoint, 0, height, height);
			}
		}
		try {
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage cropped = image.cropImage(rect).scaleImage(size, size);
			cropped.setFileName(newFileName);
			cropped.writeImage(info);
			cropped.destroyImages();
		} catch (MagickException e) {
			LogUtil.error(e);
		}
	}

	/**
	 * @param x
	 *            the specified X coordinate
	 * @param y
	 *            the specified Y coordinate
	 * @param newFileName
	 *            store path
	 * @param proportion
	 * @param size
	 *            userlogo=120
	 */
	public void makeLogoByJMagick(int x, int y, String newFileName, double proportion, int size) {
		MagickImage cropped =null;
		MagickImage scaled =null;
		try {
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			int w = (int) (width * proportion);
			int h = (int) (height * proportion);
			scaled = image.scaleImage(w, h);
			Point p = new Point(x, y);
			Dimension d = new Dimension(size, size);
			if (p.x + size > w && p.x <= w)
				d.width = w - p.x;
			if (p.y + size > h && p.y <= h)
				d.height = h - p.y;
			Rectangle rect = new Rectangle(p, d);
			cropped = scaled.cropImage(rect).scaleImage(d.width, d.height);
			if(proportion != 1)
			{
				//这句话会使头像模糊
				//cropped = cropped.sharpenImage(1.0, 5.0);
			}
			cropped.setFileName(newFileName);
			cropped.writeImage(info);
			
		} catch (MagickException e) {
			LogUtil.error(e);
		}
		finally
		{
			if(cropped != null)
			{
				cropped.destroyImages();
				cropped=null;
			}
			if(scaled != null)
			{
				scaled.destroyImages();
				scaled=null;
			}
		}
	}
	public void makeLogoByJMagick(String newFileName, double proportion) {
		try {
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			int w = (int) (width * proportion);
			int h = (int) (height * proportion);
			MagickImage scaled = image.scaleImage(w, h);
			scaled = scaled.sharpenImage(1.0, 5.0);
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
			scaled.destroyImages();
		} catch (MagickException e) {
			LogUtil.error(e);
		}
	}
	public void scale(String newFileName,int size)
	{
		MagickImage cropped =null;
		try {
			double proportion=Double.valueOf(width)/Double.valueOf(size);
			System.out.println(proportion);
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			int w = (int) (width /proportion);
			int h = (int) (height /proportion);
			if(width < size)
			{
				w=width;
				h=height;
			}
			System.out.println(w+"----"+h);
			cropped = image.sharpenImage(1.0, 5.0).scaleImage(w, h);
			cropped.setFileName(newFileName);
			cropped.writeImage(info);
			this.width=w;
			this.height=h;
			this.path=newFileName;
		} catch (MagickException e) {
			LogUtil.error(e);
		}
		finally
		{
			if(cropped != null)
			{
				cropped.destroyImages();
				cropped=null;
			}
		}
	}
	public static void main(String [] args)
	{
		ImgTools t=new ImgTools(488,686,"C:\\Documents and Settings\\admin\\My Documents\\My Pictures\\logo\\20070816_1d4073ae95db16def5cervwhVIEACJzW.jpg");
		//t.makeLogoByJMagick(0,0,"C:\\Documents and Settings\\admin\\My Documents\\My Pictures\\logo\\fff.jpg",1,200);
		t.scale("C:\\Documents and Settings\\admin\\My Documents\\My Pictures\\logo\\fff1.jpg", 200);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getPath() {
		return path;
	}
}