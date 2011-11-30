package test;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ImportTiles{
	public static void main(String[] args) throws Exception{
		import_tiles("D:\\tmp\\tiles-site.v3_1.xml");
		import_tiles("D:\\tmp\\tiles-site.v3_2.xml");
		//import_source("D:\\tmp\\tiles-site.v3.source.xml");
		//String str = "tiles.member.contacts.hotlists.remove.confirm";
		//System.out.println(str.split("\\.").length);
	}
	public static void compare(){
		String tilesSql = "";
	}
	
	public static void import_source(String fileName) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.194:3306/m4n", "m4n", "wfn");
		
		//String filename1 = "D:\tmp\tiles-site.v3.xml";
		//String filename2 = "D:\tmp\tiles-site.v3.source.xml";
		//String xmlpath= fileName;
		SAXBuilder builder=new SAXBuilder(false);
		FileReader reader = new FileReader(fileName);
		Document doc=builder.build(reader);
		Element element = doc.getRootElement();
		List list = element.getChildren();
		for(int i=0;i<list.size();i++){
				String name = null;
				
                Element et = (Element) list.get(i);
               // System.out.println("ele.name=="+et.getName());
                List atts = et.getAttributes();
                for(int j=0;j<atts.size();j++){
                	String attrname = null;
    				String attrvalue = null;
                	Attribute at1 = (Attribute)atts.get(j);
                	if(!at1.getName().equalsIgnoreCase("name")){
                		System.out.println("attrname==="+at1.getName());
                		attrname = at1.getName();
                	}else{
                		if(name==null){
                			name = at1.getValue();
                		}
                	}
                	System.out.println("name==="+name);
                	
                	
                	attrvalue = at1.getValue();
                	try{
                		if(attrname!=null){
                			PreparedStatement stat= con.prepareStatement("INSERT INTO TEMP_SITE_SOURCE VALUES(?,?,?)");
	                	
	                		stat.setString(1,name);
		                	stat.setString(2,attrname);
		                	stat.setString(3,attrvalue);
		                	stat.execute();
		                	stat.close();
                		}
                	}catch(Exception ex){
                		ex.printStackTrace();
                	}
                }
                
                List list2 = et.getChildren();
                for(int k=0;k<list2.size();k++){
                	String attrname1 = null;
                	String attrvalue1 = null;
                	Element et2 = (Element) list2.get(k);
                   // System.out.println("ele2.name=="+et2.getName());
                    
                    List atts3 = et2.getAttributes();
                    for(int m=0;m<atts3.size();m++){
                    	Attribute at2 = (Attribute)atts3.get(m);
                    	if(at2.getName().equalsIgnoreCase("name")){
                    		attrname1 = at2.getValue();
                    		System.out.println("name1==="+at2.getValue());
                    	}
                    	if(at2.getName().equalsIgnoreCase("value")){
                    		attrvalue1 = at2.getValue();
                    		System.out.println("value1==="+at2.getValue());
                    	}
                    	
                    	//System.out.println("attrvalue==="+at2.getValue());
                    	
                    }
                    try{
                    	if(attrname1!=null){
	                		PreparedStatement stat= con.prepareStatement("INSERT INTO TEMP_SITE_SOURCE VALUES(?,?,?)");
		                	stat.setString(1,name);
		                	stat.setString(2,attrname1);
		                	stat.setString(3,attrvalue1);
		                	stat.execute();
		                	stat.close();
                    	}
                	}catch(Exception ex){
                		ex.printStackTrace();
                	}
                }
		}
	}
	
	public static void import_tiles(String fileName) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.194:3306/m4n", "m4n", "wfn");
		
		//String filename1 = "D:\tmp\tiles-site.v3.xml";
		//String filename2 = "D:\tmp\tiles-site.v3.source.xml";
		//String xmlpath= fileName;
		SAXBuilder builder=new SAXBuilder(false);
		FileReader reader = new FileReader(fileName);
		Document doc=builder.build(reader);
		Element element = doc.getRootElement();
		List list = element.getChildren();
		for(int i=0;i<list.size();i++){
				String name = null;
				String dirname = null;
				String tilename = null;
                Element et = (Element) list.get(i);
               // System.out.println("ele.name=="+et.getName());
                List atts = et.getAttributes();
                for(int j=0;j<atts.size();j++){
                	String attrname = null;
    				String attrvalue = null;
                	Attribute at1 = (Attribute)atts.get(j);
                	if(!at1.getName().equalsIgnoreCase("name")){
                		System.out.println("attrname==="+at1.getName());
                		attrname = at1.getName();
                	}else{
                		if(name==null){
                			name = at1.getValue();
                		}
                	}
                	System.out.println("name==="+name);
                	if(dirname==null)
                		dirname = name.split("\\.")[0];
                	
                	
                	if(tilename==null)
                		tilename = name.replaceFirst(dirname+".","");
                	
                	attrvalue = at1.getValue();
                	try{
                		if(attrname!=null&&!dirname.equals("tiles")&&!attrname.equalsIgnoreCase("controllerClass")){
                			PreparedStatement stat= con.prepareStatement("INSERT INTO TEMP_SITE_TILES VALUES(?,?,?,?,?)");
	                	
	                		stat.setString(1,tilename);
		                	stat.setString(2,attrname);
		                	if(attrname.equalsIgnoreCase("extends")){
		                		stat.setString(3,attrvalue.replaceFirst(dirname+".",""));
		                	}else{
		                		stat.setString(3,attrvalue);
		                	}
		                	stat.setString(4,dirname);
		                	stat.setString(5,name);
		                	stat.execute();
		                	stat.close();
                		}
                	}catch(Exception ex){
                		ex.printStackTrace();
                	}
                }
                
                List list2 = et.getChildren();
                for(int k=0;k<list2.size();k++){
                	String attrname1 = null;
                	String attrvalue1 = null;
                	Element et2 = (Element) list2.get(k);
                   // System.out.println("ele2.name=="+et2.getName());
                    
                    List atts3 = et2.getAttributes();
                    for(int m=0;m<atts3.size();m++){
                    	Attribute at2 = (Attribute)atts3.get(m);
                    	if(at2.getName().equalsIgnoreCase("name")){
                    		attrname1 = at2.getValue();
                    		System.out.println("name1==="+at2.getValue());
                    	}
                    	if(at2.getName().equalsIgnoreCase("value")){
                    		attrvalue1 = at2.getValue();
                    		System.out.println("value1==="+at2.getValue());
                    	}
                    	
                    	//System.out.println("attrvalue==="+at2.getValue());
                    	
                    }
                    try{
                    	if(attrname1!=null&&!dirname.equals("tiles")){
	                		PreparedStatement stat= con.prepareStatement("INSERT INTO TEMP_SITE_TILES VALUES(?,?,?,?,?)");
		                	stat.setString(1,tilename);
		                	stat.setString(2,attrname1);
		                	stat.setString(3,attrvalue1);
		                	stat.setString(4,dirname);
		                	stat.setString(5,name);
		                	stat.execute();
		                	stat.close();
                    	}
                	}catch(Exception ex){
                		ex.printStackTrace();
                	}
                }
		}
	}
}
