package com.zy.common.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zy.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @author Patrick Dong
 */
public class MailSend{
	private static String CHARSET = "UTF-8";
	
	private String from;
	private String senderName;
	private String to;
	private String receiverName;
	private String bcc;
	private String subject;
	private String templateName;
	private Map map;
//	private String mailType;	
	
	public MailSend(String from, String senderName,String to,String receiverName, String bcc,String subject, String templateName, Map map) {
		super();
		this.from = from;
		this.senderName = senderName;
		this.bcc = bcc;
		this.subject = subject;
		this.templateName = templateName;
		this.receiverName = receiverName;
		this.to = to;
		this.map = map;
	}

	public void send() {
		String message = merge(templateName,map);
		if(message==null)return;
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", Constants.GRPMAILLIST_MAILSERVER);
		prop.put("mail.smtp.auth","true");
		
		Session sess = Session.getInstance(prop, null);
		sess.setDebug(false);
		try {
			MimeMessage msg = new MimeMessage(sess);			
			InternetAddress address = new InternetAddress();
			address.setPersonal(senderName, CHARSET);
			address.setAddress(from);
			msg.setFrom(address);
			InternetAddress addressTO = new InternetAddress(to,receiverName,CHARSET);
			msg.setRecipient(Message.RecipientType.TO,addressTO);
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));
			msg.setSubject(subject, CHARSET);
			msg.setContent(message, "text/html;charset=" + CHARSET);
			msg.setSentDate(new Date());
			Transport transport = sess.getTransport("smtp");  
			System.out.println((String)prop.get("mail.smtp.host")+" "+Constants.GRPMAILLIST_SEND_USERNAME+" "+Constants.GRPMAILLIST_MAILPOSTFIX+" "+Constants.GRPMAILLIST_SEND_PASSWORD);
			transport.connect((String)prop.get("mail.smtp.host"),Constants.GRPMAILLIST_SEND_USERNAME+Constants.GRPMAILLIST_MAILPOSTFIX,Constants.GRPMAILLIST_SEND_PASSWORD);
			transport.sendMessage(msg,msg.getAllRecipients());
//			System.out.println("GROUPMAILLIST:"+new Date()+"--------"+bcc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String merge(String templateName, Map map) {
		try {
			Configuration cfg = new Configuration();
			cfg.setDefaultEncoding(CHARSET);
			cfg.setNumberFormat("#");
			cfg.setClassForTemplateLoading(MailSend.class,Constants.TEMPLATE_PATH);
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			Template temp = cfg.getTemplate(templateName);
			temp.setEncoding(CHARSET);
			Writer out = new StringWriter();
			temp.process(map, out);
			out.flush();
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public void setMailType(String mailType) {
//		this.mailType = mailType;
//	}

	
}
