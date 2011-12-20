package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Import {
	public static void main(String[] args) throws Exception{
		String filename = "E:\\region.txt";
		File fCmd = new File (filename);
	    FileReader reader = new FileReader (fCmd);
	    BufferedReader b = new BufferedReader(reader);
	    Class.forName("com.mysql.jdbc.Driver");
	    String url = "jdbc:mysql://localhost:3306/zy?useUnicode=true&amp;characterEncoding=utf-8";
	    
	    Connection con = DriverManager.getConnection(url, "root", "root");
	    
	    

	    while(true){
	    	String sql = "INSERT INTO ZY_REGION(ID,COUNTRYID,REGIONNAME) VALUES(aaa,bbb,ccc);";
	 	   
	    	String line = b.readLine();
	    	if(line==null){
	    		break;
	    	}
	    	String[] array = line.split("	");
	    	int id = Integer.valueOf(array[0]);
	    	int countryId = Integer.valueOf(array[1]);
	    	String cityname = array[2].trim();
	    	
	    	
	    	
	    	sql = sql.replaceFirst("aaa",""+id);
	    	sql = sql.replaceFirst("bbb",""+countryId);
	    	sql = sql.replaceFirst("ccc","'"+cityname+"'");
	    	
	    	
	    	System.out.println(sql);
	    }
	}
}
