package com.zy.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zy.Constants;

public class FileUtil {

	/**
	 * 
	 * @param dir
	 * @return
	 */
	public static List<String> getFilesName(File dir) {
		List<String> list = new ArrayList<String>();
		if ((dir == null) || !dir.isDirectory()) {
			System.out.println("Argument " + dir + " is not a directory. ");
		} else {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				list.add(files[i].getName());
			}
		}
		return list;
	}

	/**
	 * 
	 * @param upFile
	 * @param filePath
	 * @throws IOException
	 */
	public static void makeOImage(File upFile, String filePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(upFile);
			int len = fis.available();
			byte[] by = new byte[len];
			fis.read(by);
			fos = new FileOutputStream(filePath);
			fos.write(by);
		} catch (IOException e) {
			LogUtil.error(e);
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				LogUtil.error(e);
			}
		}
	}

	/**
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void deleteDirectory(File dir) {
		if ((dir == null) || !dir.isDirectory()) {
			LogUtil.info("Argument " + dir + " is not a directory. ");
		} else {
			File[] entries = dir.listFiles();
			int sz = entries.length;
			for (int i = 0; i < sz; i++) {
				if (entries[i].isDirectory()) {
					deleteDirectory(entries[i]);
				} else {
					entries[i].delete();
				}
			}
			dir.delete();
			LogUtil.info("Argument " + dir + " is deleted. ");
		}
	}

	private static final int BUFFER_SIZE = 16 * 1024;

	/**
	 * write file
	 * 
	 * @param src
	 * @param rp
	 * @param fn
	 * @return
	 */
	public static boolean copy(File src, String rp, String fn) {
		boolean result = false;
		InputStream in = null;
		OutputStream out = null;
		try {
			String datedir = DateUtil.formatDate(new Date());
			File dstFile = new File(rp + File.separator + datedir);
			if (!dstFile.exists()) {
				dstFile.mkdirs();
			}
			dstFile = new File(rp + File.separator + datedir + File.separator + fn);
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dstFile), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			result = true;
		} catch (Exception e) {
			LogUtil.error(e);
			result = false;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
		return result;
	}

	/**
	 * jpg or png
	 * 
	 * @param type
	 * @return
	 */
	public static String isJPGorPNG(String type) {
//		if (Constants.FILE_JPG.indexOf(type) >= 0) {
//			return Constants.IMG_TYPE_JPG;
//		} else if (Constants.FILE_PNG.indexOf(type) >= 0) {
//			return Constants.IMG_TYPE_PNG;
//		}
		if (type.equals("image/pjpeg")||type.equals("image/jpeg")) {
			return Constants.IMG_TYPE_JPG;
		}else if (type.equals("image/x-png")||type.equals("image/png")) {
			return Constants.IMG_TYPE_PNG;
		}
		return null;
	}
	
	public static String getContentImageType(String filetype) {
//		if (Constants.FILE_JPG.indexOf(type) >= 0) {
//			return Constants.IMG_TYPE_JPG;
//		} else if (Constants.FILE_PNG.indexOf(type) >= 0) {
//			return Constants.IMG_TYPE_PNG;
//		}
		if (filetype.equals(".jpg")) {
			return "image/jpeg";
		} else if (filetype.equals(".png")) {
			return "image/png";
		} 
		return null;
	}
	
	public static String isLogoType(String type) {
		if (type.equals("image/pjpeg")||type.equals("image/jpeg")) {
			return Constants.IMG_TYPE_JPG;
		}else if (type.equals("image/x-png")||type.equals("image/png")) {
			return Constants.IMG_TYPE_PNG;
		}else if (type.equals("image/gif")) {
			return Constants.IMG_TYPE_GIF;
		}
		return null;
	}

	public static String checkDocType(String type) {
		if (type.equals("application/msword")) {
			return ".doc";
		} else if (type.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
			return ".docx";
		} else if (type.equals("application/vnd.ms-powerpoint")) {
			return ".ppt";
		} else if (type.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
			return ".pptx";
		} else if (type.equals("application/vnd.ms-excel")) {
			return ".xls";
		} else if (type.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return ".xlsx";
		} else if (type.equals("application/pdf") || type.equals("application/octet-stream")) {
			return ".pdf";
		}
		return null;
	}
	
	public static String checkResumeDocType(String type) {
		if (type.equals("application/msword")) {
			return ".doc";
		} else if (type.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
			return ".docx";
		} else if (type.equals("application/pdf")) {
			return ".pdf";
		} 
		return null;
	}

	public static String getContentType(String filetype) {
		if (filetype.equals(".doc")) {
			return "application/msword";
		} else if (filetype.equals(".docx")) {
			return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		} else if (filetype.equals(".ppt")) {
			return "application/vnd.ms-powerpoint";
		} else if (filetype.equals(".pptx")) {
			return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
		} else if (filetype.equals(".xls")) {
			return "application/vnd.ms-excel";
		} else if (filetype.equals(".xlsx")) {
			return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		} else if (filetype.equals(".pdf")) {
			return "application/pdf";
		}
		return null;
	}
	
	public static String getDocType(String filetype) {
		if (filetype.equals(".doc")||filetype.equals(".docx")) {
			return "doc";
		} else if (filetype.equals(".ppt")||filetype.equals(".pptx")) {
			return "ppt";
		} else if (filetype.equals(".xls")||filetype.equals(".xlsx")) {
			return "xls";
		} else if (filetype.equals(".pdf")) {
			return "pdf";
		}
		return null;
	}

	public static void emptyDirectory(String dirname) {
		try {
			File dir = new File(dirname);
			if (!dir.exists())
				dir.mkdirs();
			dir.deleteOnExit();
			String[] info = dir.list();
			LogUtil.info("----dir---"+dirname);
			for (int i = 0; i < info.length; i++) {
				File n = new File(dirname + File.separator + info[i]);
				if (!n.isFile()) // skip ., .., other directories too
					continue;
				LogUtil.info("----file---"+info[i]);
				n.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
	}

	public static void copyDirectoryContents(String fromdir, String todir) {
		try {
			File dir = new File(fromdir);
			if (!dir.exists())
				dir.mkdirs();
			String[] info = dir.list();
			for (int i = 0; i < info.length; i++) {
				String fromfile = fromdir + "/" + info[i];
				String tofile = todir + "/" + info[i];
				FileChannel in = new FileInputStream(fromfile).getChannel(), out = new FileOutputStream(tofile).getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				while (in.read(buffer) != -1) {
					buffer.flip(); // Prepare for writing
					out.write(buffer);
					buffer.clear(); // Prepare for reading
				}
				in.close();
				out.close();
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
	}
	/**
	* 删除单个文件
	* @param fileName 要删除的文件的文件名
	* @return 单个文件删除成功返回true，否则返回false
	*/
	public static boolean deleteFile(String fileName) {
	File file = new File(fileName);
	
	// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	if(file.exists() && file.isFile()) {
	if(file.delete()) {
	System.out.println("删除单个文件" + fileName + "成功！");
	return true;
	} else {
	System.out.println("删除单个文件" + fileName + "失败！");
	return false;
	}
	} else {
	System.out.println("删除单个文件失败：" + fileName + "不存在！");
	return false;
	}
	}
	/**
	 * Bing
	 * 删除以这个文件开头的，相同目录下的所有文件
	 * 2011-6-9
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFiles(String fileName)
	{
		File f = new File(fileName);
		File [] files=getFiles(getDirectory(f),getFileNameExceptFileType(f.getName())+"*");
		if(files != null)
		{
			for(int i=0;i<files.length;i++)
			{
				File file=files[i];
				if(file.exists() && file.isFile()) {
					if(file.delete()) {
					System.out.println("删除文件" + file.getName() + "成功！");
					} else {
					System.out.println("删除单个文件" + fileName + "失败！");
					}
					} else {
					System.out.println("删除单个文件失败：" + fileName + "不存在！");
					}
			}
		}
		return true;
		
	}
	/**
	    * 获取文件
	    * 可以根据正则表达式查找
	    * @param dir String 文件夹名称
	    * @param s String 查找文件名，可带*.?进行模糊查询
	    * @return File[] 找到的文件
	    */
	   public static File[] getFiles(String dir,String s) {
	     //开始的文件夹
	     File file = new File(dir);

	     s = s.replace('.', '#');
	     s = s.replaceAll("#", "\\\\.");
	     s = s.replace('*', '#');
	     s = s.replaceAll("#", ".*");
	     s = s.replace('?', '#');
	     s = s.replaceAll("#", ".?");
	     s = "^" + s + "$";

	     Pattern p = Pattern.compile(s);
	     ArrayList list = filePattern(file, p);

	     File[] rtn = new File[list.size()];
	     list.toArray(rtn);
	     return rtn;
	   }
	   public static String getDirectory(File file)
	   {
		   return file.getPath().substring(0,file.getPath().length()-file.getName().length());
	   }
	   /**
	    * @param file File 起始文件夹
	    * @param p Pattern 匹配类型
	    * @return ArrayList 其文件夹下的文件夹
	    */

	   private static ArrayList filePattern(File file, Pattern p) {
	     if (file == null) {
	       return null;
	     }
	     else if (file.isFile()) {
	       Matcher fMatcher = p.matcher(file.getName());
	       if (fMatcher.matches()) {
	         ArrayList list = new ArrayList();
	         list.add(file);
	         return list;
	       }
	     }
	     else if (file.isDirectory()) {
	       File[] files = file.listFiles();
	       if (files != null && files.length > 0) {
	         ArrayList list = new ArrayList();
	         for (int i = 0; i < files.length; i++) {
	           ArrayList rlist = filePattern(files[i], p);
	           if (rlist != null) {
	             list.addAll(rlist);
	           }
	         }
	         return list;
	       }
	     }
	     return null;
	   }
	public static String getFileType(String fileName){
	   int lastIndexOfDot = fileName.lastIndexOf('.');
       int fileNameLength = fileName.length();
       String extension = fileName.substring(lastIndexOfDot+1, fileNameLength);
	   return extension;
	}
	public static String getFileNameExceptFileType(String filename)
	{
		String name=filename.substring(0,filename.lastIndexOf(getFileType(filename))-1);
		if(name.lastIndexOf("_") != -1)
		{
			name=name.substring(0,name.lastIndexOf("_"));
		}
		return name;
	}

	public static void main(String[] args) {
	//emptyDirectory("d:\\index\\profile_live1");
//D:\opt\data\public\photos\2011\04\21
	
//	 File f=new File("E:\\opt\\data\\public\\photos\\2011\\06\\13\\6e02b0ca-d644-43fa-afcd-24c3f22a11d2_110.jpg");
//	 System.out.println(getFileNameExceptFileType(f.getName()));
	 System.out.println(deleteFiles("E:\\opt\\data\\public\\photos\\2011\\06\\13\\afd7c6c5-44fb-444a-ac63-97469769d9af.jpg"));
	}

}
