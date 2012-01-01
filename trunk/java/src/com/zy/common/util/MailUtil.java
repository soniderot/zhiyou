package com.zy.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zy.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MailUtil {
	private static String CHARSET = "utf-8";
	
	private static Configuration cfg = null;

	public static void send(String from, String senderName, String to,
			String subject, String message) {
		String l_host = Constants.SMTP_SERVER;
		l_host = "smtp.hungryforwords.com";
		Properties l_props = System.getProperties();
		l_props.put("mail.smtp.host", l_host);
		l_props.put("mail.smtp.auth","false");
		Session l_session = Session.getDefaultInstance(l_props);
		l_session.setDebug(true);
		try {
			MimeMessage l_msg = new MimeMessage(l_session);
			
			InternetAddress address = new InternetAddress();
			
			address.setPersonal(senderName, CHARSET);
			address.setAddress(from);
			
			l_msg.setFrom(address);
			l_msg.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(to, false));
			
			l_msg.setSubject(subject, CHARSET);
			l_msg.setContent(message, "text/html;charset=" + CHARSET);
			l_msg.setSentDate(new Date());
			Transport.send(l_msg);
		} catch (MessagingException mex) {
			System.out.println("---------[receiver==]"+to);
			mex.printStackTrace();
			LogUtil.fatal(mex);
		} catch (Exception e) {
			System.out.println("---------[receiver==]"+to);
			e.printStackTrace();
			LogUtil.fatal(e);
		}
	}

	public static String merge(String templateName, Map root) {
		try {
			if(MailUtil.cfg == null){
				Configuration ncfg = new Configuration();
				ncfg.setDefaultEncoding(CHARSET);
				ncfg.setClassForTemplateLoading(MailUtil.class,
						Constants.TEMPLATE_PATH);
				ncfg.setObjectWrapper(new DefaultObjectWrapper());
				ncfg.setNumberFormat("#");
				if(MailUtil.cfg == null)
					MailUtil.cfg = ncfg;
			}
			
			Template temp = MailUtil.cfg.getTemplate(templateName);
			temp.setEncoding(CHARSET);

			//ByteArrayOutputStream bos = new ByteArrayOutputStream();
			Writer out = new StringWriter();// OutputStreamWriter(bos, CHARSET);
			temp.process(root, out);
			out.flush();
			// String content = bos.toString();
			// System.out.println("content:"+content);
			// out.close();
			return out.toString();
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.fatal(e);
		} catch (TemplateException e) {
			LogUtil.fatal(e);
		}
		return null;
	}

	public static void sendFormatEmail(String from, String senderName,
			String to, String subject, String templateName, Map root) {
		System.out.println("-----------templateName-----"+templateName);
		String message = merge(templateName, root);
//		System.out.println("from:" + from + ";\n senderName:" + senderName
//				+ ";\n to:" + to + ";\n subject:" + subject + ";\n message:"
//				+ message);

		send(from, senderName, to, subject, message);
	}
	
	//send the mail without template
	public static void sendNoTemplateEmail(String from, String senderName,
			String to, String subject, String message) {
		send(from, senderName, to, subject, message);
	}
	
	public static String fetchEMailDomain(String email) {
	    return email.substring(email.indexOf("@")+1);
	}

	public static void main(String[] args) {
		// MailUtil.send("test@abc.com","test", "steele@meta4-group.com",
		// "测试","sdf");
		Map root = new HashMap();
		root.put("country", "中国");

		/*
		MailThread mailThread = new MailThread();
		mailThread.setFrom("test@abc.com");
		mailThread.setSenderName("测试w");
		mailThread.setTo("bill.tian@meta4-group.com");
		mailThread.setSubject("测试");
		mailThread.setTemplateName("test_en_US.ftl");
		mailThread.setRoot(root);
		//new Thread(mailThread).start();*/
		MailUtil.sendFormatEmail("test@abc.com", "test",
				"bill.tian@meta4-group.com", "测试", "test_en_US.ftl", root);

	}
}
