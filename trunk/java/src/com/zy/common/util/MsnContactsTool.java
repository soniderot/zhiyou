package com.zy.common.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnProtocol;
import net.sf.jml.MsnUserStatus;
import net.sf.jml.impl.MsnMessengerFactory;
import octazen.addressbook.Contact;

public class MsnContactsTool {
	private static MsnMessenger messenger;

	public static List<Contact> getAddress(String email,String password) {
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			messenger = MsnMessengerFactory.createMsnMessenger(
					email,password);
			messenger
					.setSupportedProtocol(new MsnProtocol[] { MsnProtocol.MSNP11 });
			messenger.getOwner().setInitStatus(MsnUserStatus.ONLINE);
			messenger.setLogIncoming(false);
			messenger.setLogOutgoing(false);
			messenger.login();

			try {
				Thread.sleep(10 * 1000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			/*
			 * try{ for(int i=0;i<8;i++){ Thread.sleep(1000); MsnContact[] cons =
			 * messenger.getContactList().getContacts();
			 * if(cons!=null&&cons.length>0){ break; } } }catch(Exception ex){
			 * ex.printStackTrace(); }
			 */

			MsnContact[] cons = messenger.getContactList().getContacts();
			for (MsnContact con : cons) {
				if (con.getDisplayName() != null && con.getEmail() != null) {
					System.out.println(con.getDisplayName());
					System.out.println(con.getEmail().toString());
					//String str = new String(con.getDisplayName().getBytes("gbk"),"utf-8");
					Contact contact = new Contact(con.getDisplayName(),con.getEmail().toString());
					contacts.add(contact);
				}
			}
			messenger.logout();
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		return contacts;
	}
	
	public static void main(String[] args){
		getAddress("kelvin_shpd@hotmail.com","hahawhoami");
	}
}
