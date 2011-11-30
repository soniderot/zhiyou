package com.zy.common.util;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnProtocol;
import net.sf.jml.MsnUserStatus;
import net.sf.jml.impl.MsnMessengerFactory;

public class MsnContactsTool {
	private static MsnMessenger messenger;

	public static void main(String[] args) {
		try {
			messenger = MsnMessengerFactory.createMsnMessenger(
					"kelvin_shpd@hotmail.com","hahawhoami");
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
				}
			}
			messenger.logout();
			//System.exit(0);
			return;
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}
}
