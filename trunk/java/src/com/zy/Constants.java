package com.zy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.zy.common.util.DateUtil;

public class Constants {
	//public static String PAYMENTRETURNDOMAIN = "http://116.247.118.82:8888/";
    private static Properties pro = new Properties();
    static {
        InputStream in = Constants.class.getClassLoader().getResourceAsStream("zy.properties");
        pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public final static short INVITEFRIEND_REQ =1 ;
    public final static short INVITEEVENT_REQ = 5;
    
	public final static short MALEORFEMALE = 0;
	public final static short MALE = 1;
	public final static short FEMALE = 2;
	 
	public static final short REQUEST_STATUS_APPROVED = 0;
	public static final short REQUEST_STATUS_WAITING = 1;
	public static final short REQUEST_STATUS_IGNORED = 2;
	public static final short REQUEST_STATUS_SYSTEM_IGNORED = 3;
	
	// email verify
	public final static String EMAILVERIFY_PRIVATE_KEY = "zyemailverify";

	public static final String USER_SESSION_KEY = "user";
	public static final String USERID_SESSION_KEY = "userid";

	public final static int SNS_ADD2SNSGROUP = 0;
	public final static int SNS_REMOVE_FROM_SNSGROUP = 1;

	/**
	 * lucene index
	 * 
	 */
	public static enum IndexFlag {
		FLAG_UNAPPROVED {
			@Override
			public short getFlag() {
				return 0;
			}
		},
		FLAG_APPROVED {
			@Override
			public short getFlag() {
				return 1;
			}
		};
		public abstract short getFlag();
	}

	
	public final static int FEED_LIST_FRIENDS = 1;
	public final static int FEED_LIST_FOLLOWERS = 2;
	public final static int FEED_LIST_FRIENDS_FOLLOWERS = 3;

	public final static short SCHOOL_COMPANY_UNAPPROVED = 0;
	public final static short SCHOOL_COMPANY_APPROVED = 1;
	/**
	 * unverified is only used for "verifiedcompanyid" column, and the default
	 * value of this column is just 0
	 */
	public final static short SCHOOL_COMPANY_UNVERIFIED = 0; // no 0 means
	// VERIFIED
	/**
	 * undefined works for both "flag" and "verifiedcompanyid", currently both
	 * of the 2 column equal -1 means it is ignored
	 */
	public final static short SCHOOL_COMPANY_UNDEFINED = -1;

	  
    public static List<String> selectYears = new ArrayList<String>();
	static {
		int endYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = endYear; i >= 1940; i--) {
			selectYears.add(i + "");
		}
	}

	public static List<String> selectEduYears = new ArrayList<String>();
	static {
		int endYear = 2015;
		for (int i = endYear; i >= 1960; i--) {
			selectEduYears.add(i + "");
		}
	}

	public static List<Integer> selectMonths = new ArrayList<Integer>();
	static {
		for (int i = 1; i < 13; i++) {
			selectMonths.add(i);
		}
	}

	public static List<Integer> selectDays = new ArrayList<Integer>();
	static {
		for (int i = 1; i < 32; i++) {
			selectDays.add(i);
		}
	}

	// imgage type
	public static final String FILE_PNG = "image/x-png,image/png";
	public static final String FILE_JPG = "image/pjpeg,image/jpeg";
	public static final String FILE_GIF = "image/gif";
	
	public static final String IMG_TYPE_JPG = ".jpg";
	public static final String IMG_TYPE_PNG = ".png";
	public static final String IMG_TYPE_GIF = ".gif";
	
	// email
	public static String SMTP_SERVER = "127.0.0.1";
	public static String TEMPLATE_PATH = "\\templates";
	// image dir
	public static String IMG_STORE_DIR = "D:\\photos\\";
	public static String IMG_ACCESS_DIR = "http://127.0.0.1:8080/photos/g/";
	// document dir
	public static String FILE_STORE_ACCESS_DIR = "D:\\file\\";

	// index dir
	public static String INDEX_DIR_SCHOOL = "d:\\index\\school";
	public static String INDEX_DIR_COMPANY = "d:\\index\\company";
	public static String INDEX_DIR_VERIFIEDSCHOOL = "d:\\index\\verifiedschool";
	public static String INDEX_DIR_VERIFIEDCOMPANY = "d:\\index\\verifiedcompany";
	public static String INDEX_DIR_PROFILE_MASTER = "d:\\index\\profile";
	public static String INDEX_DIR_PROFILE_LIVE = "d:\\index\\";
	public static String INDEX_LIVE1 = "profile_live1";
	public static String INDEX_LIVE2 = "profile_live2";
	public static String MEMCACHED_SERVER = "";
	
	// system email
	public static String SYSTEM_EMAIL_ADDRESS = "";
	public static String EMAILTEMPLATE_EMAIL_VERIFY = "emailverify";
	public static String EMAILTEMPLATE_EMAIL_VERIFY_HBY = "emailverify_hby";
	public static String EMAIL_VERIFY_SENDERNAME = "email.verify.sendername";
	public static String EMAIL_VERIFY_SUBJECT = "email.verify.subject";

	public static String DOMAINNAME = "http://127.0.0.1";
	public static String BNSCLASSPATH;
	public static String JMLPATH;
	public static String HOSTS = "";
	
	// chinese split
	public static int CHINESE_BYTES = 2;
	
 	static {
//		InputStream in = Constants.class.getClassLoader().getResourceAsStream("bns.properties");
//		pro = new Properties();
//		PAYMENTRETURNDOMAIN = pro.getProperty("PAYMENTRETURNDOMAIN", "http://www.ushi.com");
		SMTP_SERVER = pro.getProperty("SMTP_SERVER", "");
		TEMPLATE_PATH = pro.getProperty("TEMPLATE_PATH", "");
		IMG_STORE_DIR = pro.getProperty("IMG_STORE_DIR", "");
		IMG_ACCESS_DIR = pro.getProperty("IMG_ACCESS_DIR", "");
		INDEX_DIR_SCHOOL = pro.getProperty("INDEX_DIR_SCHOOL", "");
		INDEX_DIR_COMPANY = pro.getProperty("INDEX_DIR_COMPANY", "");
		INDEX_DIR_VERIFIEDSCHOOL = pro.getProperty("INDEX_DIR_VERIFIEDSCHOOL", "");
		INDEX_DIR_VERIFIEDCOMPANY = pro.getProperty("INDEX_DIR_VERIFIEDCOMPANY", "");
		INDEX_DIR_PROFILE_MASTER = pro.getProperty("INDEX_DIR_PROFILE_MASTER", "");
		INDEX_DIR_PROFILE_LIVE = pro.getProperty("INDEX_DIR_PROFILE_LIVE", "");
		FILE_STORE_ACCESS_DIR = pro.getProperty("FILE_STORE_ACCESS_DIR", "");
		MEMCACHED_SERVER = pro.getProperty("MEMCACHED_SERVER", "");
		SYSTEM_EMAIL_ADDRESS = pro.getProperty("SYSTEM_EMAIL_ADDRESS", "");
		DOMAINNAME = pro.getProperty("DOMAINNAME", "");
		BNSCLASSPATH = pro.getProperty("BNSCLASSPATH");
		JMLPATH = pro.getProperty("JMLPATH");
		HOSTS = pro.getProperty("HOSTS");
		CHINESE_BYTES = Integer.parseInt(pro.getProperty("CHINESE_BYTES"));	
	}


	// Email verified
	public final static short USER_EMAIL_UNVERIFIED = 0;
	public final static short USER_EMAIL_VERIFIED = 1;

	public final static short SNS_INTRODUCE_PENDING = 0;
	public final static short SNS_INTRODUCE_FORWARED = 1;
	public final static short SNS_INTRODUCE_DECLINED = 2;
	public final static short SNS_INTRODUCE_ACCEPTED = 3;
	public final static short SNS_INTRODUCE_TERMINATED = 4;

	// sns feed
	public final static String SNS_SHARE_TEXT = "sns.share.text";
	public final static String SNS_SHARE_DOCUMENT = "sns.share.document";
	public final static String SNS_SHARE_LINKURL = "sns.share.linkurl";
	public final static String SNS_SHARE_CAREER = "sns.share.career";
	public final static String SNS_SHARE_EDUCATION = "sns.share.education";
	public final static String SNS_SHARE_PROFILE = "sns.share.profile";
	public final static String SNS_CREATE_GROUP = "sns.create.group";
	public final static String SNS_JOIN_GROUP = "sns.join.group";
	public final static String SNS_JOIN_GROUP_EVENT = "sns.join.group.event";
	public final static String SNS_SHARE_CONNECTION = "sns.share.connection";
	public final static String SNS_INIT_INTRODUCE = "sns.init.introduce";
	
    // 3 all 2 3d 1 1d for search scope
	public final static int SEARCH_SCOPE_ALL = 5;
	public final static int SEARCH_SCOPE_3MD = 4;
	public final static int SEARCH_SCOPE_3D = 3;
	public final static int SEARCH_SCOPE_2D = 2;
	public final static int SEARCH_SCOPE_1D = 1;

	public final static ThreadLocal<HashMap> cache = new ThreadLocal<HashMap>();

	public final static String UNPAIRED_PARENTHESIS = "UNPAIRED_PARENTHESIS";
    public final static String INVALID_FAMILY_NAME = "INVALID_FAMILY_NAME";
    public final static String FORBIDDEN_WORDS = "FORBIDDEN_WORDS";
    public final static String SUCCESS_VALIDATION = "SUCCESS_VALIDATION";
	
    public final static String INVALID_NAME_NOTIC_HAS_BEEN_CLOSED = "INVALID_NAME_NOTIC_HAS_BEEN_CLOSED";
	
    public static final Set<String> chineseFamilyNameSet = new HashSet<String>();
    public static final Set<String> forbiddenWordSet = new HashSet<String>();
   
	public final static int REQUEST_LIST_CONTENT_MAX_SIZE = 300; 
	
	public final static short REQUEST_TYPE_1D_INVITE_REQUEST = 1;
		
	public final static short RECOMMEND_ITEM_TYPE_FRIEND = 1; // friend recommendation item
    
    public static long FEED_MERGE_MINUTE = 5 * 60 * 1000;	
    
    //FROM HERE!!
    public final static String LOGO_PATH = "/";
    
    // QUESTION TYPE
    public final static short QUESTION_TYPE_COMMON = 1;
    public final static short QUESTION_TYPE_OPTIONS = 2;
    
    public final static String realPath = "D:/workspace/zy/zhiyou/";
}
