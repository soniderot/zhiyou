package com.zy.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import octazen.addressbook.Contact;
import octazen.addressbook.SimpleAddressBookImporter;

import com.huangzhimin.contacts.ContactsImporter;
import com.huangzhimin.contacts.ContactsImporterFactory;
import com.zy.Constants;


public class ImportAddressUtil {

	public static final int SINA = 1;
	public static final int SOHU = 2;
	public static final int TOM = 3;
	public static final int ONESIXTHREE = 4;
	public static final int ONETWOSIX = 5;
	public static final int YEAH = 6;
	public static final int MSN = 20;
	// public static final int HOTMAIL = 21;
	public static final int GMAIL = 22;

	public static final java.util.HashMap<String, Integer> map = new java.util.HashMap<String, Integer>();

	static {
		map.put("@SINA.COM", SINA);
		map.put("@SOHU.COM", SOHU);
		map.put("@TOM.COM", TOM);
		map.put("@163.COM", ONESIXTHREE);
		map.put("@126.COM", ONETWOSIX);
		map.put("@YEAH.NET", YEAH);
		map.put("@MSN", MSN);
		map.put("@HOTMAIL", MSN);
		map.put("@LIVE", MSN);
		map.put("@GMAIL", GMAIL);
	}

	private static int getEmailType(String email, boolean flag) {
		java.util.Set<java.util.Map.Entry<String, Integer>> sets = map
				.entrySet();
		java.util.Iterator<java.util.Map.Entry<String, Integer>> iter = sets
				.iterator();
		while (iter.hasNext()) {
			java.util.Map.Entry<String, Integer> obj = iter.next();
			if (email.toUpperCase().indexOf(obj.getKey()) > 0) {
				return obj.getValue();
			}
		}
		if (flag) {
			return 0;
		}
		return 100;
	}

	private static List<Contact> getExternalContacts(String email,
			String password) throws Exception {
		try {
			System.out.println("into external");
			List<octazen.addressbook.Contact> list = SimpleAddressBookImporter
					.fetchContacts(email, password);
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("can't import emai:" + email + "\n"
					+ ex.toString());
		}
	}

	private static List<Contact> getDomesticContacts(String email,
			String password, int type) throws Exception {
		List<Contact> results = new java.util.ArrayList<Contact>();
		try {
			//List<Contact> results = new java.util.ArrayList<Contact>();
			ContactsImporter importer = null;
			int domain = type;
			/*
			 * if(type==MSN){ int tempType = getEmailType(email,true);
			 * if(tempType>MSN){ return getExternalContacts(email, password); } }
			 */

			switch (domain) {
			case SINA:
				importer = ContactsImporterFactory.getSinaContacts(email,
						password);
				break;

			case SOHU:
				importer = ContactsImporterFactory.getSohuContacts(email,
						password);
				break;

			case TOM:
				importer = ContactsImporterFactory.getTomContacts(email,
						password);
				break;

			case ONESIXTHREE:
				importer = ContactsImporterFactory.getOneSixThreeContacts(
						email, password);
				break;

			case ONETWOSIX:
				importer = ContactsImporterFactory.getOneTwoSixContacts(email,
						password);
				break;

			case YEAH:
				importer = ContactsImporterFactory.getOneSixThreeContacts(
						email, password);
				break;

			 case MSN:
				 importer = ContactsImporterFactory.getHotmailContacts(email,
						 password);
				 break;
			}

			if (importer != null) {
				List<com.huangzhimin.contacts.Contact> tempContacts = importer
						.getContacts();
				// if (domain != MSN) {
				for (int i = 0; tempContacts != null && i < tempContacts.size(); i++) {
					Contact contact = new Contact(tempContacts.get(i)
							.getUsername(), tempContacts.get(i).getEmail());
					results.add(contact);
				}
				// } else {
				// for (int i = 0; tempContacts != null
				// && i < tempContacts.size(); i++) {
				// if (tempContacts.get(i).getUsername().indexOf("@") > 0) {
				// Contact contact = new Contact(tempContacts.get(i)
				// .getUsername(), tempContacts.get(i)
				// .getUsername());
				// results.add(contact);
				// }
				// }
				// }
			}
			return results;
		} catch (Throwable ex) {
			ex.printStackTrace();
			if(type==MSN){
				return results;
			}
			throw new Exception("can't import emai:" + email + "\n"
					+ ex.toString());
		}
	}

	public static List<Contact> importAddress(String email, String password)
			throws Exception {
		int emailType = getEmailType(email, false);
		return importAddress(email, password, emailType);
	}

	public static List<Contact> importAddress(String email, String password,
			int importType) throws Exception {
		if (importType > MSN) {
			return getExternalContacts(email, password);
		} else if (importType == MSN) {
			List<Contact> results = getDomesticContacts(email, password, importType);
			//if(true)return results;
			if(results!=null&&results.size()>0){
				boolean flag = true;
				for(int i=0;i<results.size();i++){
					if(results.get(i).getEmail().indexOf("@")<=0){
						flag = false;
						break;
					}
				}
				if(flag){
					return results;
				}
			}
			return getMsnContacts(email, password);
		} else {
			return getDomesticContacts(email, password, importType);
		}
	}

	private static List<Contact> getMsnContacts(String email, String password)
			throws Exception {
		//if(true) return null;
		BufferedReader br = null;
		try {
			ArrayList<Contact> contacts = new ArrayList<Contact>();

			String classPath = Constants.BNSCLASSPATH;
			String jmlPath = Constants.JMLPATH;
			String separator = ":";
			
			if(System.getProperty("os.name")!=null&&System.getProperty("os.name").indexOf("Win")>=0){
				separator = ";";
			}
			String command = "java -classpath " + jmlPath + separator
					+ classPath
					+ " com.m4g.bns.common.util.MsnContactsTool";
			command = command + " " + email + " " + password;
			
			System.out.println(command);

			// System.out.println(command);
			Process p = Runtime.getRuntime().exec(command);
			
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			br = new BufferedReader(new InputStreamReader(in));

			while (true) {
				String name = br.readLine();
				if (name == null) {
					break;
				}
				String contactEmail = br.readLine();
				if (contactEmail == null) {
					break;
				}
				
				Contact contact = new Contact(name, contactEmail);
				//System.out.println("name=="+name1);
				contacts.add(contact);
				
			}
			if (contacts.size() == 0) {
				throw new Exception("can't import msn account:" + email);
			}
			return contacts;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("can't import msn account:"+email);
		}finally{
			if(br!=null){
				try{
					br.close();
				}catch(Throwable ex){
					ex.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		List<Contact> contacts = ImportAddressUtil.importAddress(
				"kwong-tai@hotmail.com", "634461");
		for (int i = 0; contacts != null && i < contacts.size(); i++) {
			//System.out.println("name==" + contacts.get(i).getName());
			System.out.println("email==" + contacts.get(i).getEmail());
		}
		
		
	}
}
