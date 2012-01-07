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
    
		public final static short MALEORFEMALE = 0;
		public final static short MALE = 1;
		public final static short FEMALE = 2;
	  public static String EMAIL_SENDNAME = "site.name";
	    
		public static final int MAIL_PRIORITY_HIGH = 1;
		public static final int MAIL_PRIORITY_MIDDLE = 2;
		public static final int MAIL_PRIORITY_LOW = 3;
		
		// request quality control settings
		//table BNS_REQUEST column PRIORITY
		public static final short REQUEST_PRIORITY_LOW = 0;
		public static final short REQUEST_PRIORITY_HIGH = 1;
		// table BNS_REQUEST column FLAG
		public static final short REQUEST_RULE_DEFAULT = 0;
    public static final short REQUEST_RULE_EMAIL = 1; //4.閫氳繃杈撳叆瀵规柟閭欢鍦板潃褰㈠紡鍙戦�佷竴搴︿汉鑴夎姹傛椂锛� 姝ｅ父鎯呭喌涓嬩负楂樹紭鍏堢骇锛堥珮锛�
    public static final short REQUEST_RULE_INTRO = 2; //5.閫氳繃寮曡崘鍜屼富鍔ㄤ粙缁嶇殑涓�搴︿汉鑴夎姹傛甯告儏鍐典笅涓洪珮浼樺厛绾э紙楂橈級
    public static final short REQUEST_RULE_PREF_UNMATCH = 3; //7.褰撶敤鎴疯缃竴搴︾敵璇蜂负鈥滈珮鈥濈骇鍒椂锛屼笉婊¤冻鐢ㄦ埛鑷畾涔夎缃殑涓�搴︿汉鑴夎姹傛潯浠剁殑涓�搴︾敵璇凤紙渚嬪鏈嬪弸浠嬬粛锛夛紝琚爣璁颁负浣庝紭鍏堢骇锛堥珮锛�
    public static final short REQUEST_RULE_FEW_CONN = 4; //1.鍚戜竴搴︿汉鑴夊皯浜�10鐨勭敤鎴峰彂閫佺殑涓�搴︿汉鑴夎姹傛甯告儏鍐典笅琚爣璁颁负楂樹紭鍏堢骇锛堜腑锛�
    public static final short REQUEST_RULE_MATCH_PYMK = 5; //3.鍚戞帹鑽愪綋绯讳腑鏉冮噸鎸囨暟闈�5,6,7,8,9,14鎺ㄨ崘鍑烘潵鐨勭敤鎴峰彂閫佷竴搴︿汉鑴夎姹傦紝姝ｅ父鎯呭喌涓嬭鏍囪涓洪珮浼樺厛绾э紙涓級
    public static final short REQUEST_RULE_SCHOOL_MATE = 6; //4.鐢ㄦ埛鍙戦�佷竴搴︿汉鑴夎姹傛椂閫夋嫨鎴戜滑鏄悓瀛︼紝浣嗘槸鎵�濉暀鑲茬粡鍘嗕腑娌℃湁涓庤璇锋眰鑰呯浉鍚岀殑瀛︽牎锛堟湁鐩稿悓瀛︽牎锛屼絾鏄椂闂存棤閲嶅悎鏃跺彲浠ヨ涓哄悓瀛︼級鏃讹紝鍙兘琚爣璁颁负浣庝紭鍏堢骇锛堜腑锛�
    public static final short REQUEST_RULE_IGNORED_MANY = 7; //1.鐩墠涓�搴﹁姹傚彂閫佽鍒欎腑鍙戦�佺殑涓�搴︿汉鑴夎姹傝鎺ユ敹鑰呬富鍔ㄥ拷鐣�5娆″悗锛屼粖鍚�14澶╁啀鍙戣捣鐨勪竴搴︿汉鑴夎姹傚皢鍙兘琚爣璁颁负浣庝紭鍏堢骇锛堜腑锛�
    public static final short REQUEST_RULE_REQUEST_MANY = 8; //2.褰撳ぉ涓�搴︿汉鑴夎姹傛鏁板ぇ浜�50娆″悗锛屽綋澶╁啀鍙戦�佺殑涓�搴︿汉鑴夎姹傚皢鍙兘琚爣璁颁负浣庝紭鍏堢骇锛堜腑锛�
    public static final short REQUEST_RULE_VIP = 9; //2.浠樿垂鐢ㄦ埛鍙戣捣鐨勪竴搴︿汉鑴夎姹傛甯告儏鍐典笅琚爣璁颁负楂樹紭鍏堢骇锛堜綆锛�
    public static final short REQUEST_RULE_DEFAULT_TEXT = 10; //6.鍙戦�佷竴搴︿汉鑴夎姹傛椂锛屼娇鐢ㄤ釜鎬у寲鐨勭畝鐭暀瑷�鏃讹紝姝ｅ父鎯呭喌涓嬩负楂樹紭鍏堢骇锛堜綆锛�
    public static final short REQUEST_RULE_SPAM = 11; //2.褰撳ぉ涓�搴︿汉鑴夎姹傛鏁板ぇ浜�50娆″悗锛屽綋澶╁啀鍙戦�佺殑涓�搴︿汉鑴夎姹傚皢鍙兘琚爣璁颁负浣庝紭鍏堢骇锛堜腑锛�
    public static final short REQUEST_RULE_14DAYS = 12; //濡傛灉鍦�14澶╋紝鐩存帴浣庝紭鍏堢骇
	// table BNS_REQUEST column status
	public static final short REQUEST_STATUS_APPROVED = 0;
	public static final short REQUEST_STATUS_WAITING = 1;
	public static final short REQUEST_STATUS_IGNORED = 2;
	public static final short REQUEST_STATUS_SYSTEM_IGNORED = 3;
		
	
	public static final short MEMBERSHIP_COMMON = 0;
	public static final short MEMBERSHIP_PLATINUM = 1;
	public static final short MEMBERSHIP_DIAMOND = 2;
	public static final short MEMBERSHIP_USHITONG=3;
	
	
	public static final short PROFILE_FILLPERCENT_CAREER = 1;
	public static final short PROFILE_FILLPERCENT_EDUCATION = 2;
	public static final short PROFILE_FILLPERCENT_AVATAR = 4;
	public static final short PROFILE_FILLPERCENT_CONTACT = 8;
	public static final short PROFILE_FILLPERCENT_CAREERSUM = 16;
	public static final short PROFILE_FILLPERCENT_EXPERTSKILL = 32;

	public static final short SNS_REQUESTSTATUS_ACTIVE = 1;
	public static final short SNS_REQUESTSTATUS_INACTIVE = 0;

	
	public static class Group {
		public final static String SESSION_GROUP_NAME = "sessionGroupName";
		public static int CACHETIMESECONDS = 3600 * 10;
		public static int LASTGROUPMEMBERCNT = 6;
		public static boolean CHCHEABLE = true;
		public static short FLAG_UNAPPROVED = 0;
		public static short FLAG_APPROVED = 1;
		public static short FLAG_SUSPICION = 2;
		public static short FLAG_APPLY_REJECT = 3;
		// match the grpmember table , field type
		public static short OWER = 1;
		public static short ADMINISTATOR = 2;
		public static short MEMBER = 4;
		public static short NOTMEMBER = 5;
		// event person mark
		public static short TAKEPART = 1;
		public static short INTS = 0;
		// match the grpmember table ,field status
		public static short DISABLE = 8;
		public static short QUIT = 16;
		public static String requesturl = DOMAINNAME + "/msg/request!listNewRequest.jhtml";
		// about group feed practise index
		public final static String MEMBER_CREATE_GROUP = "group.create";
		public final static String MEMBER_JOIN_GROUP = "group.join";
		public final static String MEMBER_POST_TOPIC = "group.post.topic";
		public final static String MEMBER_CREATE_EVENT = "group.create.event";
		public final static String MEMBER_SHARE_DOCUMENT = "group.share.document";
		public final static String MEMBER_SHARE_LINKURL = "group.share.linkurl";
		public final static String MEMBER_SHARE_TEXT = "group.share.text";
		public final static String MEMBER_TOPIC_REPLY = "group.topic.reply";
		public final static String MEMBER_SHARE_IMAGE= "group.share.image";
		//for the event
		public final static String MEMBER_EVENT_SHARE = "group.event.share";
		//for the job
		public final static String MEMBER_JOB_SHARE = "group.job.share";
		// feed / doc pageunit
		public final static int GROUPNEWSFEED_PAGEUNIT = 20;
		public final static int GROUPNEWSFEEDDOC_PAGEUNIT = 5;
		// 0:week 1:month 2:year
		public static String NEWSFEEDCOUNT_OF_WEEK = "0";
		// invite
		public final static String GROUPOUTERINCVITE_LINK = DOMAINNAME + "/invite/group/zh_CN/";

		public final static short NOTIFICATIONTYPE_REPLYTOPIC = 2;
		public final static short NOTIFICATIONTYPE_APPLYGROUP = 3;
		public final static short NOTIFICATIONTYPE_APPLY_APPROVED = 4;
		public final static short NOTIFICATIONTYPE_APPLY_REJECT = 5;
		public final static short NOTIFICATIONTYPE_EVENT_CANCEL = 9;
		public final static short NOTIFICATIONTYPE_REMOVE_GROUP = 25;

		public final static short TOPICORREPLY_FROMWHERE_DEFAUTL = 0;
		public final static short TOPICORREPLY_FROMWHERE_GROUPMAIL = 1;
		public final static short TOPICORREPLY_FROMWHERE_WEBSITE = 2;

		public static String CREATE_GROUP_APPLIES_FLAG_PROCESS = "0";
		public static String CREATE_GROUP_APPLIES_FLAG_UNPROCESS = "1";
	}

	// invite
	public final static String INVITE_PRIVATE_KEY = "bns2009invite";

	// email verify
	public final static String EMAILVERIFY_PRIVATE_KEY = "zyemailverify";

	// 1 send invite success 2 regesiter success 4 delete
	public static enum InviteStatus {
		INVITE_SEND_SUCCESS {
			@Override
			public short getStatus() {
				return 1;
			}
		},
		INVITE_REG_SUCCESS {
			@Override
			public short getStatus() {
				return 2;
			}
		},
		INVITE_DELETE {
			@Override
			public short getStatus() {
				return 4;
			}
		};
		public abstract short getStatus();
	}

	public static enum InviteType {
		INVITE_BY_LINK {
			@Override
			public String getInviteType() {
				return "INVITEBYLINK";
			}
		},
        INVITE_BY_MAIL {
            @Override
            public String getInviteType() {
                return "INVITEBYMAIL";
            }
        },
        INVITE_BY_REQUEST_MAIL {
            @Override
            public String getInviteType() {
                return "INVITEBYREQUESTMAIL";
            }
        },
		INVITE_BY_ADDRESSBOOK {
			@Override
			public String getInviteType() {
				return "INVITEBYADDRESSBOOK";
			}
		},
		INVITE_BY_MSN {
			@Override
			public String getInviteType() {
				return "INVITEBYMSN";
			}
		},
		INVITE_BY_OUTLOOK {
			@Override
			public String getInviteType() {
				return "INVITEBYOUTLOOK";
			}
		},
		INVITE_BY_LINKEDIN {
			@Override
			public String getInviteType() {
				return "INVITEBYLINKEDIN";
			}
		},
		INVITE_BY_MOBILE {
			@Override
			public String getInviteType() {
				return "INVITEBYMOBILE";
			}
		},
		GRP_INVITE_BY_LINK {
			@Override
			public String getInviteType() {
				return "GRPINVITEBYLINK";
			}
		},
		GRP_INVITE_BY_MAIL {
			@Override
			public String getInviteType() {
				return "GRPINVITEBYMAIL";
			}
		},
		INVITE_BY_EVENT_LINK {
			@Override
			public String getInviteType() {
				return "INVITEBYEVENTLINK";
			}
		};
		public abstract String getInviteType();

	}

	// 0 unavailable 1 available 2 isOurMember
	public static enum InviteLinkStatus {
		INVITE_LINK_UNAVAILABLE {
			@Override
			public short getStatus() {
				return 0;
			}
		},
		INVITE_LINK_AVAILABLE {
			@Override
			public short getStatus() {
				return 1;
			}
		},
		INVITE_LINK_REG {
			@Override
			public short getStatus() {
				return 2;
			}
		};
		public abstract short getStatus();
	}

	public static final String USER_SESSION_KEY = "user";

	public static final String USERID_SESSION_KEY = "userid";

	public static final String USER_VERIFY_EMAIL_KEY = "verifyemail";
	public static final String USER_VERIFY_CAREER_KEY = "verifycareer";
	public static final String USER_CS_BACKEND_KEY = "csbackendkey";

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

	/**
	 * career
	 */
	public final static short CAREER_ISNOTCURRENT_JOB = 0;
	public final static short CAREER_ISCURRENT_JOB = 1;

	/***************************************************************************
	 * 
	 * Privacy setting contact request and feed setting
	 * 
	 * Profile settting 1:鍩烘湰淇℃伅 2:澶村儚 4:鑱屼笟姒傝堪 8:鑱屼笟鎬荤粨 16:宸ヤ綔缁忓巻 32:浠呮樉绀哄綋鍓嶅伐浣滅粡鍘� 64:鏁欒偛缁忓巻
	 * 128:浠呮樉绀烘渶鏂版暀鑲茬粡鍘� 256:鍏磋叮鐖卞ソ 512:鑽ｈ獕濂栧姳 1024:缇ょ粍淇℃伅
	 */

	public static short PRIVACY_PUBPROFILE_BASIC = 1;
	public static short PRIVACY_PUBPROFILE_LOGO = 2;
	public static short PRIVACY_PUBPROFILE_NEWSFEED = 4;
	public static short PRIVACY_PUBPROFILE_CAREERBRIEF = 8;
	public static short PRIVACY_PUBPROFILE_CAREERSUM = 16;
	public static short PRIVACY_PUBPROFILE_WORKINGEXPERIENCE = 32;
	public static short PRIVACY_PUBPROFILE_CURRENTJOB = 64;
	public static short PRIVACY_PUBPROFILE_EDUCATION = 128;
	public static short PRIVACY_PUBPROFILE_CURRENTEDUCATION = 256;
	public static short PRIVACY_PUBPROFILE_OTHER = 512;
	public static short PRIVACY_PUBPROFILE_GROUP = 1024;

	public static String HANDLE_PRIVACY_CONTACT = "PRIVACY_CONTACT";

	public static short PRIVACY_CONTACTLIST_VISIBLE_THIRDDEGREE = 1;
	public static short PRIVACY_CONTACTLIST_VISIBLE_FISRTDEGREE = 2;
	public static short PRIVACY_CONTACTLIST_VISIBLE_SELF = 3;

	public static int[] PRIVACY_PROFILE_OPTIONS = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
	public final static int[] PRIVACY_CONTACT_TYPE_OPTIONS = new int[] { 1, 2, 4, 8, 16, 32, 64 };
	// public final static int[] PRIVACY_FEED_ALL_TYPE_OPTIONS = new int[] { 1,
	// 2, 4, 8, 16, 32, 64, 128, 256 };
	
	//涓轰簡澧炲姞娲诲姩鍔ㄦ�侊紝娣诲姞16384, 32768
	public final static int[] PRIVACY_FEED_ALL_TYPE_OPTIONS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,65536, 131072, 524288 };
//	public final static int[] PRIVACY_FEED_ALL_TYPE_OPTIONS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
	public final static int[] PRIVACY_FEED_ALL_TYPE_OPTIONS_SETTING = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072,262144, 524288,1048576 };
	public final static int[] PRIVACY_FEED_1D_TYPE_OPTIONS = new int[] { 1, 2, 4, 8, 512, 1024, 4096, 16384,262144, 524288 };
//	public final static int[] PRIVACY_FEED_1D_TYPE_OPTIONS = new int[] { 1, 2, 4, 8, 512, 1024, 4096 };
	public final static int[] PRIVACY_FEED_FOLLOWER_TYPE_OPTIONS = new int[] { 16, 32, 2048, 8192, 32768 };
//	public final static int[] PRIVACY_FEED_FOLLOWER_TYPE_OPTIONS = new int[] { 16, 32, 2048, 8192 };
	public final static int[] PRIVACY_FEED_GROUP_TYPE_OPTIONS = new int[] {0, 64, 128, 256, 131072 }; //131072:group.event.share
	
	public final static int[] PRIVACY_FEED_EVENT = new int[] {16384, 32768 };
	public final static int[] PRIVACY_FEED_EXCEPT_EVENT = new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
	public final static int[] PRIVACY_FEED_1D_EVENT = new int[] {16384 };
	public final static int[] PRIVACY_FEED_1D_EXCEPT_EVENT = new int[] {1, 2, 4, 8, 512, 1024, 4096 };
	public final static int[] PRIVACY_FEED_FOLLOWER_EVENT = new int[] {32768 };
	public final static int[] PRIVACY_FEED_FOLLOWER_EXCEPT_EVENT = new int[] {16, 32, 2048, 8192 };
	
    public final static short PRIVACY_WHOVIEWEDMYPROFILE_FULL = 1;
    public final static short PRIVACY_WHOVIEWEDMYPROFILE_PARTIAL = 2;
    public final static short PRIVACY_WHOVIEWEDMYPROFILE_NONE = 3;
	
	public final static int FEED_LIST_FRIENDS = 1;
	public final static int FEED_LIST_FOLLOWERS = 2;
	public final static int FEED_LIST_FRIENDS_FOLLOWERS = 3;

	// 2 groups of constants to define the status of Company and School
	// combinatedly
	/**
	 * unapproved/approved is only used for "flag" column
	 */
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

	// backend tables
	public static final String BACKEND_TABLE_COMPANY = "BNS_COMPANY";
	public static final String BACKEND_TABLE_SCHOOL = "BNS_SCHOOL";
	public static final String BACKEND_TABLE_VERIFIEDCOMPANY = "BNS_VERIFIEDCOMPANY";
	public static final String BACKEND_TABLE_VERIFIEDSCHOOL = "BNS_VERIFIEDSCHOOL";
	public static final String BACKEND_TABLE_JOBCOMPANY = "JOB_COMPANY";
    public static final String BACKEND_TABLE_JOBDETAIL = "JOB_DETAIL";
    public static final String BACKEND_TABLE_JOBAPPLY = "JOB_APPLY";
    public static final String BACKEND_TABLE_PRODETAIL = "PRO_DETAIL";
	// backend operations
	public static final String BACKEND_OPERATION_VERIFIEDCOMPANY_ADD = "Add verified company";
	public static final String BACKEND_OPERATION_VERIFIEDCOMPANY_UPDATE = "Update verified company";
	public static final String BACKEND_OPERATION_VERIFIEDCOMPANY_ASSOCIATE = "Associate verified company";
	public static final String BACKEND_OPERATION_VERIFIEDSCHOOL_ADD = "Add verified school";
	public static final String BACKEND_OPERATION_VERIFIEDSCHOOL_UPDATE = "Update verified school";
	public static final String BACKEND_OPERATION_VERIFIEDSCHOOL_ASSOCIATE = "Associate verified school";
	public static final String BACKEND_OPERATION_COMPANY_ASSOCIATE = "Associate company";
	public static final String BACKEND_OPERATION_SCHOOL_ASSOCIATE = "Associate school";
    public static final String BACKEND_OPERATION_JOBCOMPANY_ADD = "Add job company";
    public static final String BACKEND_OPERATION_JOBCOMPANY_UPDATE = "Update job company";
    public static final String BACKEND_OPERATION_JOBCOMPANY_DELETE = "Delete job company";
    public static final String BACKEND_OPERATION_JOBDETAIL_ADD = "Add job detail";
    public static final String BACKEND_OPERATION_JOBDETAIL_UPDATE = "Update job detail";
    public static final String BACKEND_OPERATION_JOBDETAIL_REMOVE = "Delete job detail";
    public static final String BACKEND_OPERATION_JOBAPPLY_REMOVE = "Delete job apply";
    public static final String BACKEND_OPERATION_PRODETAIL_ADD = "Add pro detail";
    public static final String BACKEND_OPERATION_PRODETAIL_ADD_RELEASE = "Add & release pro detail";
    public static final String BACKEND_OPERATION_PRODETAIL_UPDATE = "Update pro detail";
    public static final String BACKEND_OPERATION_PRODETAIL_ON = "On pro detail";
    public static final String BACKEND_OPERATION_PRODETAIL_OFF = "Off pro detail";
    public static final String BACKEND_OPERATION_PRODETAIL_REMOVE = "Delete pro detail";
    
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
	
	// 1mb
	public static final long RESUME_FILE_MAX_LEN = 1024 * 1000;
	// 2mb
	public static final long FILE_MAX_LEN = 2048 * 1000;
	// 5MB
	public static final long FEED_FILE_MAX_LEN = 5120 * 1000;

	// email
	public static String SMTP_SERVER = "127.0.0.1";
	public static String TEMPLATE_PATH = "\\templates";
	// image dir
	public static String IMG_STORE_DIR = "D:\\photos\\";
	public static String IMG_ACCESS_DIR = "http://127.0.0.1:8080/photos/g/";
	public static String IMG_AVATAR_DEFAULT_120 = "http://www.ushi.com/images/face_120.png";
	public static String IMG_AVATAR_DEFAULT_50 = "http://www.ushi.com/images/face_50.png";
	public static String IMG_AVATAR_DEFAULT_30 = "http://www.ushi.com/images/face_30.png";
	public static String GROUP_LOGO_DEFAULT_50 = "";
	public static String GROUP_EVENT_LOGO_DEFAULT_80 = "";
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
	public static String INDEX_DIR_JOB_MASTER = "d:\\index\\job";
	public static String INDEX_JOB_LIVE1 = "job_live1";
	public static String INDEX_JOB_LIVE2 = "job_live2";
	public static String INDEX_DIR_JOB_LIVE = "d:\\index\\";
	public static String MEMCACHED_SERVER = "";
	public static String INDEX_DIR_JOBCOMPANY = "/opt/index/jobcompany";

	// system email
	public static String SYSTEM_EMAIL_ADDRESS = "";
	public static String EMAILTEMPLATE_EMAIL_VERIFY = "emailverify";
	public static String EMAILTEMPLATE_EMAIL_VERIFY_HBY = "emailverify_hby";
	public static String EMAIL_VERIFY_SENDERNAME = "email.verify.sendername";
	public static String EMAIL_VERIFY_SUBJECT = "email.verify.subject";

	public static String DOMAINNAME = "http://127.0.0.1";
	public static String USHI_PORT = "8080";
	public static String FEEDBACK_EMAIL_ADDRESS = "";
	public static String BNSCLASSPATH;
	public static String JMLPATH;
	public static String HOSTS = "";

	// group mail list setting
	public static String GRPMAILLIST_MAILSERVER = "mail.test.worldfriends.tv";
	public static String GRPMAILLIST_ACCOUNT = "grpr";
	public static String GRPMAILLIST_MAILPOSTFIX = "@test.worldfriends.tv";
	public static String GRPMAILLIST_PASSWORD = "grpr.123";
	public static String GRPMAILLIST_SEND_USERNAME = "grps";
	public static String GRPMAILLIST_SEND_PASSWORD = "grps.123";
	
	// chinese split
	public static int CHINESE_BYTES = 2;
	
	public static int[] JOB_COMMON_AREAS;
	public static int[] JOB_DIRECTLY_CITY_REGIONS;
	public static String PROMOTION_MACRO;
	
	public static int JOB_APPLY_QUOTA;
	public static Date JOB_APPLY_START_PRESENT;
	public static Date JOB_APPLY_END_PRESENT;
	//Email tracking
	public static String TRK_URL_PREFIX="http://localhost:9999";
	public static String[] EMAIL_TRACK_INVITE_KEYWORDS;
	//cm2
	public static String cmStartDate;
	public static String cmEndDate;
	public static boolean SMS_SENDMODE=true;
	public static String SMS_APINAME="ushi";
	public static String SMS_PWD="ushi%^&123456";
	public static String MESSAGE_USERNAME;
	public static String MESSAGE_PASSWORD;
	//ipad2 user
	public static String IPAD_TOP_USERS;
    public static String IPAD_PERIOD_START_DATE;
    public static String IPAD_PERIOD_CURRENT_START_DATE;
    public static String STATIC_WEB_URL="";
    public static boolean RECOMMEND_DB_SWITCH=false;
    public static String RECOMMEND_DB_DS="dataSource";
    //open reg
    public static Date OPEN_REG_RELEASE_DATE;
    //mail optimized
    public static double SNS_INVITE_QUALITY;
    public static String EMAIL_ANALY_URL;
    //鍚屽煄娲诲姩鐩稿叧start
    public static Integer[] SAME_CITY_EVENT_MAIN_CITIES=new Integer[0];
    public static Integer[] SAME_CITY_EVENT_DIRECT_CITIES=new Integer[0];
    //鍚屽煄娲诲姩鐩稿叧end
	static {
//		InputStream in = Constants.class.getClassLoader().getResourceAsStream("bns.properties");
//		pro = new Properties();
//		PAYMENTRETURNDOMAIN = pro.getProperty("PAYMENTRETURNDOMAIN", "http://www.ushi.com");
		SMTP_SERVER = pro.getProperty("SMTP_SERVER", "");
		TEMPLATE_PATH = pro.getProperty("TEMPLATE_PATH", "");
		IMG_STORE_DIR = pro.getProperty("IMG_STORE_DIR", "");
		IMG_ACCESS_DIR = pro.getProperty("IMG_ACCESS_DIR", "");
		IMG_AVATAR_DEFAULT_120 = pro.getProperty("IMG_AVATAR_DEFAULT_120", "");
		IMG_AVATAR_DEFAULT_50 = pro.getProperty("IMG_AVATAR_DEFAULT_50", "");
		IMG_AVATAR_DEFAULT_30 = pro.getProperty("IMG_AVATAR_DEFAULT_30", "");
		GROUP_LOGO_DEFAULT_50 = pro.getProperty("GROUP_LOGO_DEFAULT_50", "");
		GROUP_EVENT_LOGO_DEFAULT_80 = pro.getProperty("GROUP_EVENT_LOGO_DEFAULT_80", "");
		INDEX_DIR_SCHOOL = pro.getProperty("INDEX_DIR_SCHOOL", "");
		INDEX_DIR_COMPANY = pro.getProperty("INDEX_DIR_COMPANY", "");
		INDEX_DIR_VERIFIEDSCHOOL = pro.getProperty("INDEX_DIR_VERIFIEDSCHOOL", "");
		INDEX_DIR_VERIFIEDCOMPANY = pro.getProperty("INDEX_DIR_VERIFIEDCOMPANY", "");
		INDEX_DIR_PROFILE_MASTER = pro.getProperty("INDEX_DIR_PROFILE_MASTER", "");
		//INDEX_DIR_PROFILE_LIVE = pro.getProperty("INDEX_DIR_PROFILE_LIVE", "");
		INDEX_DIR_JOB_MASTER = pro.getProperty("INDEX_DIR_JOB_MASTER", "");
		INDEX_DIR_JOB_LIVE = pro.getProperty("INDEX_DIR_JOB_LIVE", "");
		INDEX_DIR_JOBCOMPANY = pro.getProperty("INDEX_DIR_JOBCOMPANY", "");
		FILE_STORE_ACCESS_DIR = pro.getProperty("FILE_STORE_ACCESS_DIR", "");
		MEMCACHED_SERVER = pro.getProperty("MEMCACHED_SERVER", "");
		SYSTEM_EMAIL_ADDRESS = pro.getProperty("SYSTEM_EMAIL_ADDRESS", "");
		FEEDBACK_EMAIL_ADDRESS = pro.getProperty("FEEDBACK_EMAIL_ADDRESS", "");
		DOMAINNAME = pro.getProperty("DOMAINNAME", "");
		USHI_PORT = pro.getProperty("USHI_PORT","");
		BNSCLASSPATH = pro.getProperty("BNSCLASSPATH");
		JMLPATH = pro.getProperty("JMLPATH");
		HOSTS = pro.getProperty("HOSTS");

		GRPMAILLIST_MAILSERVER = pro.getProperty("GRPMAILLIST_MAILSERVER");
		GRPMAILLIST_ACCOUNT = pro.getProperty("GRPMAILLIST_ACCOUNT");
		GRPMAILLIST_MAILPOSTFIX = pro.getProperty("GRPMAILLIST_MAILPOSTFIX");
		GRPMAILLIST_PASSWORD = pro.getProperty("GRPMAILLIST_PASSWORD");
		GRPMAILLIST_SEND_USERNAME = pro.getProperty("GRPMAILLIST_SEND_USERNAME");
		GRPMAILLIST_SEND_PASSWORD = pro.getProperty("GRPMAILLIST_SEND_PASSWORD");
		
		CHINESE_BYTES = Integer.parseInt(pro.getProperty("CHINESE_BYTES"));
		
		String jobCommonAreas = pro.getProperty("JOB_COMMON_AREAS");
		if(jobCommonAreas != null){
			String[] aJobCommonArea = jobCommonAreas.split(",");
			JOB_COMMON_AREAS = new int[aJobCommonArea.length];
			for(int i=0; i<aJobCommonArea.length; i++){
				JOB_COMMON_AREAS[i] = Integer.parseInt(aJobCommonArea[i]);
			}
		}
		
		String jobDirectCitys = pro.getProperty("JOB_DIRECTLY_CITY_REGIONS");
		if(jobDirectCitys != null){
			String[] aArea = jobDirectCitys.split(",");
			JOB_DIRECTLY_CITY_REGIONS = new int[aArea.length];
			for(int i=0; i<aArea.length; i++){
				JOB_DIRECTLY_CITY_REGIONS[i] = Integer.parseInt(aArea[i]);
			}
		}
		PROMOTION_MACRO = pro.getProperty("PROMOTION_MACRO");
		
		
		MESSAGE_USERNAME = pro.getProperty("MESSAGE_USERNAME");
		MESSAGE_PASSWORD = pro.getProperty("MESSAGE_PASSWORD");
		
		IPAD_TOP_USERS = pro.getProperty("IPAD_TOP_USERS");
		IPAD_PERIOD_START_DATE = pro.getProperty("IPAD_PERIOD_START_DATE");
		IPAD_PERIOD_CURRENT_START_DATE = pro.getProperty("IPAD_PERIOD_CURRENT_START_DATE");
		STATIC_WEB_URL = pro.getProperty("STATIC_WEB_URL");
		
		RECOMMEND_DB_SWITCH= Boolean.parseBoolean(pro.getProperty("RECOMMEND_DB_SWITCH", ""));
		RECOMMEND_DB_DS = pro.getProperty("RECOMMEND_DB_DS");
		OPEN_REG_RELEASE_DATE = DateUtil.getDate(pro.getProperty("OPEN_REG_RELEASE_DATE"), DateUtil.patternDate);
		
		
		String sameCityEventMainCities = pro.getProperty("SAME_CITY_EVENT_MAIN_CITIES");
		if(sameCityEventMainCities != null){
			String[] arr = sameCityEventMainCities.split(",");
			SAME_CITY_EVENT_MAIN_CITIES = new Integer[arr.length];
			for(int i=0; i<arr.length; i++){
				SAME_CITY_EVENT_MAIN_CITIES[i] = Integer.parseInt(arr[i]);
			}
		}
		String sameCityEventDirectCities = pro.getProperty("SAME_CITY_EVENT_DIRECT_CITIES");
		if(sameCityEventDirectCities != null){
			String[] arr = sameCityEventDirectCities.split(",");
			SAME_CITY_EVENT_DIRECT_CITIES = new Integer[arr.length];
			for(int i=0; i<arr.length; i++){
				SAME_CITY_EVENT_DIRECT_CITIES[i] = Integer.parseInt(arr[i]);
			}
		}
	}

	// user logo size
	public final static String USER_LOGO_SMALL = "_s.jpg";// 120
	public final static String USER_LOGO_200 = "_200";
	public final static String USER_LOGO_ICON = "_icon.jpg"; // 50
	public final static String USER_LOGO_THUMB = "_thumb.jpg";// 30
	public final static short USER_LOGO_STATUS_UNMAGICK = 0; // not magick
	public final static short USER_LOGO_STATUS_MAGICK = 1; // done magick
	public final static short USER_LOGO_SETTING_ALL = 1;// all registered users
	public final static short USER_LOGO_SETTING_3D = 2;// 3DEGEREE
	public final static short USER_LOGO_SETTING_1D = 3;// 1 DEGEREE
	public final static int USER_LOGO_SIZE_200 = 200;
	public final static int USER_LOGO_SMALL_SIZE = 120;
	public final static int USER_LOGO_ICON_SIZE = 50;
	public final static int USER_LOGO_THUMB_SIZE = 30;

	// Email verified
	public final static short USER_EMAIL_UNVERIFIED = 0;
	public final static short USER_EMAIL_VERIFIED = 1;

	public final static short SNS_INTRODUCE_PENDING = 0;
	public final static short SNS_INTRODUCE_FORWARED = 1;
	public final static short SNS_INTRODUCE_DECLINED = 2;
	public final static short SNS_INTRODUCE_ACCEPTED = 3;
	public final static short SNS_INTRODUCE_TERMINATED = 4;

	// ajax return value(feed module and etc)
	public final static String AJAX_RETURN_SUCCESS = "success";
	public final static String AJAX_RETURN_FAILURE = "failure";

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
	
	//for the event
	public final static String SNS_EVENT_CREATE = "sns.event.create";
	public final static String SNS_EVENT_JOIN = "sns.event.join";
	public final static String SNS_EVENT_SIGNIN = "sns.event.signin";
	public final static String SNS_EVENT_SHARE = "sns.event.share";
	public final static String EVENT_SHARE_TEXT = "event.share.text";
	public final static String EVENT_SHARE_DOCUMENT = "event.share.document";
	public final static String EVENT_SHARE_LINKURL = "event.share.linkurl";
    public final static String SNS_SHARE_EXTERNAL = "sns.share.external"; //璇ュ父閲忓湪BNS_NEWSFEEDTYPE涓篃瀛樺湪
	
	// add for endorse
    public final static String GROUP_SHARE_TOPIC = "group.share.topic";//缇ょ粍鍒嗕韩
	public final static String SNS_ENDORSE_SEND = "sns.endorse.send";
	public final static String SNS_ENDORSE_RECEIVE = "sns.endorse.receive";
	public final static String SNS_SHARE_BADGE = "sns.share.badge";
	public final static String SNS_SHARE_BADGE_MIGS = "sns.share.badge.migs";
	// job
	public final static String SNS_RELEASE_JOB = "sns.release.job";
	
	public final static String SNS_SHARE_JOB = "sns.share.job";	
	//coffee badge
	public final static String COFFEE_FEED_TYPE = "coffee.feed.type";
	public final static String SNS_RELEASE_JOB_MICROBLOG = "sns.release.job.microblog";
	// home page news update for profile page and home page and mobile api
    public final static String SNS_MYSELF_NEWS = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + SNS_SHARE_DOCUMENT + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL + "','" + SNS_RELEASE_JOB_MICROBLOG + "','" + SNS_SHARE_JOB + "','" + EVENT_SHARE_DOCUMENT + "'";
    public final static String SNS_MYSELF_NEWS_MOBILE = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL + "'";
    public final static String SNS_MYSELF_NEWS_EXTERNAL = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + SNS_SHARE_DOCUMENT + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL + "','" + EVENT_SHARE_DOCUMENT + "','" + SNS_RELEASE_JOB_MICROBLOG  + "','" + SNS_SHARE_JOB + "','" + SNS_SHARE_EXTERNAL + "'";
    public final static String SNS_MYSELF_NEWS_EXTERNAL_MOBILE = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL + "','" + SNS_SHARE_EXTERNAL + "'";
    public final static String SNS_MYSELF_NEWS_DELL = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + SNS_SHARE_DOCUMENT + "'";
	public final static String EVENT_NEWS = "'" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL + "','" + EVENT_SHARE_DOCUMENT + "'";

	// ushi event
	public final static String SNS_USHIEVENT_DELL = "sns.share.ushievent.dell";
	public final static String SNS_USHIEVENT_ECARD = "sns.share.ushievent.ecard";
	public final static String SNS_USHIEVENT_IPAD = "sns.share.ushievent.ipad";
	public final static String SNS_USHIEVENT_SUMMERDRINK = "sns.share.ushievent.drink";
	
	// mobile status;
	public final static short MOBILE_UNVERIFIED = 0;
	public final static short MOBILE_VERIFIED = 1;

	public final static short SNS_INVITE_CLASSMATE = 1;
	public final static short SNS_INVITE_COLLEAGUE = 2;
	public final static short SNS_INVITE_COOPERATION = 3;
	public final static short SNS_INIVTE_OTHERS = 4;
	public final static short SNS_INIVTE_CONFERENCE = 5;
	public final static short SNS_INIVTE_NOT_KNOWN = 6;
	
	// 0 INVISIABLE 1 VISIABLE
	public final static short PROFILE_INVISIABLE = 0;
	public final static short PROFILE_VISIABLE = 1;

	// profile status
	public final static short PROFILE_STATUS_FM = 50;
	public final static short PROFILE_STATUS_CM = 51;
	public final static short PROFILE_STATUS_PM = 52;

	// profile csstatus
	public final static short PROFILE_CSSTATUS_APPROVED = 1;
	public final static short PROFILE_CSSTATUS_DEACTIVED = 2;
	public final static short PROFILE_CSSTATUS_REACTIVED = 3;
	public final static short PROFILE_CSSTATUS_DELETED = 4;

	// Match backend cs deactived status and table option
	public final static int PROFILE_OPTIONID_UPDATED = 0;
	public final static int PROFILE_OPTIONID_AVATAR = 1;
	public final static int PROFILE_OPTIONID_FULLNAME = 2;
	public final static int PROFILE_OPTIONID_CAREER = 3;
	public final static int PROFILE_OPTIONID_EDU = 4;
	public final static int PROFILE_OPTIONID_ABUSE = 100;
	


	/*
	 * table: bns_recommendprofile, column: flag
	 */
	// 0 灞忚斀 1 閭�璇峰垪琛ㄥ悕鍗曚腑 2 IP 3 鍜屾暀鑲茬粡鍘� 4 鏈夌浉鍚岀殑宸ヤ綔缁忓巻 5 涓庡綋鍓嶇敤鎴烽噸鍚堢殑濂藉弸澶氫簬5涓� 100 澶╀娇鐢ㄦ埛锛屽叕浼楃殑鍟嗕笟浜虹墿
	// 101 涓�搴︽湅鍙嬫墍鍏虫敞鏈�澶氱殑鐢ㄦ埛   6:褰撳墠鑱屼笟澶磋鐩稿悓
    public final static int RECOMMEND_PROFILE_ERROR = -1; //only used in Bns_Recommendqueue flag column
//    public final static int RECOMMEND_PROFILE_DISABLE = 0; // user 2nd time disable
//    public final static int RECOMMEND_PROFILE_DISABLE_TEMP = -2; // user 1st time disable 
//    public final static int RECOMMEND_PROFILE_DISABLE_RESET = 999; // system reset from user 1st time disable after 14 days 
	//people you may know
    public final static int RECOMMEND_PROFILE_INVITE = 1;
	public final static int RECOMMEND_PROFILE_IP = 2;
	public final static int RECOMMEND_PROFILE_EDU = 3;
	public final static int RECOMMEND_PROFILE_CAREER = 4;
    public final static int RECOMMEND_PROFILE_SEARCH_HISTORY = 10;
    public final static int RECOMMEND_PROFILE_EMAILDOMAIN = 11;
    public final static int RECOMMEND_PROFILE_COMMENT_MESSAGE = 12;
    public final static int RECOMMEND_PROFILE_MESSAGE = 13;
    public final static int RECOMMEND_PROFILE_FOLLOWER = 15;
    public final static int RECOMMEND_PROFILE_SINA_FRIEND = 16;
    //people you may want to know
    public final static int RECOMMEND_PROFILE_MUTUAL_FRIEND = 5;
    public final static int RECOMMEND_PROFILE_TITLE = 6;
    public final static int RECOMMEND_PROFILE_MUTUAL_FRIEND_INDUSTRY = 7;
    public final static int RECOMMEND_PROFILE_MUTUAL_GROUP = 8;
    public final static int RECOMMEND_PROFILE_MUTUAL_EVENT = 9;
    public final static int RECOMMEND_PROFILE_NEWUSER = 14;
    public final static int RECOMMEND_PROFILE_ALL = 0; //only used in code, doesn't exist in db
    
    
    //column status
    public final static int RECOMMEND_PROFILE_NORMAL = 0;
    public final static int RECOMMEND_PROFILE_SUCCESS = 1; // recommend succeeded
    public final static int RECOMMEND_PROFILE_SUCCESS_CONNECTED = 2;
    public final static int RECOMMEND_PROFILE_SUCCESS_FOLLOWED = 3;
    public final static int RECOMMEND_PROFILE_DISABLE = -1; // user 2nd time disable
    public final static int RECOMMEND_PROFILE_DISABLE_TEMP = -99; // user 1st time disable 
    public final static int RECOMMEND_PROFILE_DISABLE_RESET = 99; // system reset from user 1st time disable after 14 days 

    /*
     * table: bns_recommendprofile, column: score
     */
    // people you may know
    public final static int RECOMMEND_WEIGHT_INVITE = 8; //9;
    public final static int RECOMMEND_WEIGHT_IP = 10; //5;
    public final static int RECOMMEND_WEIGHT_EDU = 9; //10;
    public final static int RECOMMEND_WEIGHT_CAREER = 9; //10;
    public final static int RECOMMEND_WEIGHT_SEARCH_HISTORY = 5; //3;
    public final static int RECOMMEND_WEIGHT_EMAILDOMAIN = 9; //5;
    public final static int RECOMMEND_WEIGHT_COMMENT_MESSAGE = 7;
    public final static int RECOMMEND_WEIGHT_MESSAGE = 6;
    public final static int RECOMMEND_WEIGHT_DISABLE_RESET = 3; //reset recommend item should be assigned with a low score
    // people you may want to know
    public final static int RECOMMEND_WEIGHT_TITLE = 8;
    public final static int RECOMMEND_WEIGHT_MUTUAL_FRIEND = 6;
    public final static int RECOMMEND_WEIGHT_MUTUAL_FRIEND_INDUSTRY = 7;
    public final static int RECOMMEND_WEIGHT_MUTUAL_GROUP = 4;
    public final static int RECOMMEND_WEIGHT_MUTUAL_EVENT = 4;
    public final static int RECOMMEND_WEIGHT_NEWUSER = 6;
    
    public final static int TOP_KEYWORDS_LIMIT = 50;
    public final static int FEED_COMMENT_LIMIT = 2;
    
    public final static int RECOMMEND_THRESHOLD_MUTUAL_FRIEND = 5;
    public final static int RECOMMEND_THRESHOLD_MUTUAL_GROUP = 5;
    public final static int RECOMMEND_THRESHOLD_MUTUAL_EVENT = 5;
    
    public final static String RECOMMEND_SESSION_KEY = "RECOMMEND_SESSION_KEY";
    public final static String RECOMMEND_OFFSET_SESSION_KEY = "RECOMMEND_OFFSET_SESSION_KEY";
    
    // Recommendation Constants
    public final static int RECOMMEND_THREAD_NUMBER = 10;
    
    /*
     * table: job_recommend, column: flag
     */    
    public final static int RECOMMEND_JOB_SEARCHER = 1;
    public final static int RECOMMEND_JOB_CURRENTCAREER = 2;
    public final static int RECOMMEND_JOB_NOCURRENTCAREER = 3;
    public final static int RECOMMEND_JOB_INDUSTRY = 4;
    public final static int RECOMMEND_JOB_GENERALINDUSTRY = 5;
    public final static int RECOMMEND_JOB_CLICKED_COMMON = 11; //鏅�氱敤鎴风偣鍑�
    public final static int RECOMMEND_JOB_FAVORITE_COMMON = 12; //鏅�氱敤鎴锋敹钘�
    public final static int RECOMMEND_JOB_BROWSED_PAYED = 13; //浠樿垂鐢ㄦ埛娴忚
    public final static int RECOMMEND_JOB_FAVORITE_PAYED = 14; //浠樿垂鐢ㄦ埛鏀惰棌
    public final static int RECOMMEND_JOB_APPLIED = 15;
    public final static int RECOMMEND_JOB_APPLY_SUCCESS = 16;
    public final static int RECOMMEND_JOB_SEARCHCLICK = 17;
    //column status
    public final static int RECOMMEND_JOB_IRRELATED = -2;
    public final static int RECOMMEND_JOB_UNINTERESTED = -1;
    public final static int RECOMMEND_JOB_NORMAL = 0;
    public final static int RECOMMEND_JOB_SUCCESS = 1;
    
    //JOB_BEHAVIORLOG FLAG
    public final static short JOB_BEHAVIORLOG_IRRELATED = -2;
    public final static short JOB_BEHAVIORLOG_UNINTERESTED = -1;
    public final static short JOB_BEHAVIORLOG_CLICKED_COMMON = 11;
    public final static short JOB_BEHAVIORLOG_FAVORITE_COMMON = 12;
    public final static short JOB_BEHAVIORLOG_BROWSED_PAYED = 13;
    public final static short JOB_BEHAVIORLOG_FAVORITE_PAYED = 14;
    public final static short JOB_BEHAVIORLOG_APPLIED = 15;
    public final static short JOB_BEHAVIORLOG_SUCCEEDED = 16;
    
    //JOB BEHAVIORS
    public final static String JOB_BEHAVIOR_CLICK = "click";
    public final static String JOB_BEHAVIOR_FAVORITE = "favorite";
    public final static String JOB_BEHAVIOR_APPLY = "apply";
    public final static String JOB_BEHAVIOR_SUCCESS = "success";
    public final static String JOB_RELEASE_MICROBLOG = "1";
    /*
     * table: job_recommend, column: score
     */    
    public final static int RECOMMEND_WEIGHT_SEARCHER = 5;
    public final static int RECOMMEND_WEIGHT_CURRENTCAREER = 4;
    public final static int RECOMMEND_WEIGHT_NOCURRENTCAREER = 3;
    public final static int RECOMMEND_WEIGHT_INDUSTRY = 2;
    public final static int RECOMMEND_WEIGHT_GENERALINDUSTRY = 1;
    public final static int RECOMMEND_WEIGHT_CLICKED_COMMON = 11;
    public final static int RECOMMEND_WEIGHT_FAVORITE_COMMON = 12;
    public final static int RECOMMEND_WEIGHT_BROWSED_PAYED = 13;
    public final static int RECOMMEND_WEIGHT_FAVORITE_PAYED = 14;
    public final static int RECOMMEND_WEIGHT_APPLIED = 15;
    public final static int RECOMMEND_WEIGHT_SUCCEEDED = 16;
    public final static int RECOMMEND_WEIGHT_SEARCHCLICK = 6;
    
    public final static int RECOMMEND_JOB_FLAGNUMBER = 20; // make 3 recommendations for each rule
    
	// friends
	public final static String RECOMMEND_FRIENDS = Constants.RECOMMEND_PROFILE_INVITE + "," + Constants.RECOMMEND_PROFILE_IP + "," + RECOMMEND_PROFILE_EDU
			+ "," + RECOMMEND_PROFILE_CAREER + "," + RECOMMEND_PROFILE_MUTUAL_FRIEND + "," + RECOMMEND_PROFILE_TITLE + "," + RECOMMEND_PROFILE_MUTUAL_FRIEND_INDUSTRY
			+ "," + RECOMMEND_PROFILE_MUTUAL_GROUP + "," + RECOMMEND_PROFILE_MUTUAL_EVENT + "," + RECOMMEND_PROFILE_SEARCH_HISTORY;

	public final static String RECOMMEND_PROFILE_TOP = PROFILE_STATUS_FM + "," + PROFILE_STATUS_CM;
	public final static int RECOMMEND_PROFILE_MOSTLYFOLLOWERS = 101;
	// followers
	public final static String RECOMMEND_FOLLOWERS = Constants.RECOMMEND_PROFILE_TOP + "," + Constants.RECOMMEND_PROFILE_MOSTLYFOLLOWERS;

	// group recommend
	public final static short RECOMMEND_GROUP_DISABLE = 0;
	// 0 灞忚斀,1 鏁欒偛缁忓巻鐩稿悓 2 涓�搴﹀ソ鍙嬪弬涓庢渶澶氱殑缇ょ粍
	public final static short RECOMMEND_GROUP_ENDUCATION = 1;
	public final static short RECOMMEND_GROUP_1DEGREEJOIN = 2;
	
	/*
	 * recommend based on email domain initialization
	 */
	public static final Set<String> excludedEMails4Recommend = new HashSet<String>();
	

	// Message
	public final static short MESSAGE_REPLIED = 1;

	// Validation tips type
	public final static String VALIDATION_SUCCESS = "success";
	public final static String VALIDATION_ERROR = "error";
	public final static String VALIDATION_INFO = "tipsbox";
	public final static String VALIDATION_WARN = "notice";

	public final static int SCHOOL_DEFAULT_ORDER = 100;

	public final static int tokenSessionTime = 1000 * 60 * 5;

	// mobile register
	public final static String MOBILE_REG_REGISTERED = "registered";
	public final static String MOBILE_REG_INVALID = "invalid";

	public final static short NOTIFICATION_NOT_READ = 0;
	public final static short NOTIFICATION_IS_READ = 1;

	public final static short NOTIFICATION_NOT_DELETED = 0;
	public final static short NOTIFICATION_IS_DELETED = 1;

    public final static short NOTIFICATION_NOT_OLD = 0;
    public final static short NOTIFICATION_IS_OLD = 1;
    
    public final static short NOTIFICATION_DISPLAY_TIME_LIMIT = 30; // DAYS
	// 3 all 2 3d 1 1d for search scope
	public final static int SEARCH_SCOPE_ALL = 5;//鎵�鏈変汉鑴�
	public final static int SEARCH_SCOPE_3MD = 4;//3搴︿汉鑴夊強浠ヤ笂
	public final static int SEARCH_SCOPE_3D = 3;//3搴�
	public final static int SEARCH_SCOPE_2D = 2;
	public final static int SEARCH_SCOPE_1D = 1;

	public final static String REFER_RECENT_INDUSTRY = "S002";
	public final static String REFER_RECENT_INDUSTRY_2D = "S003";

	// group mail list constant definition
	public final static short GRP_SUBSCRIPTION_TYPE_COMBINE_INSTANT = 9;

	public final static short GRP_SUBSCRIPTION_TYPE_NONE = 0;
	public final static short GRP_SUBSCRIPTION_TYPE_ALL_INSTANT = 1;
	public final static short GRP_SUBSCRIPTION_TYPE_SELF_INSTANT = 2;
	public final static short GRP_SUBSCRIPTION_TYPE_DAILY = 3;
	public final static short GRP_SUBSCRIPTION_TYPE_WEEKLY = 4;

	public final static ThreadLocal<HashMap> cache = new ThreadLocal<HashMap>();

	public final static short CATEGORY_CAREER = 0; // exclude the classmate
	public final static short CATEGORY_COLLEAGUE = 1;
	public final static short CATEGORY_CLASSMATE = 2;
	public final static short CATEGORY_EMPLOYER = 3;
	public final static short CATEGORY_COOPERATE = 4;

	public final static short ENDORSE_STATUS_ALL = -2;
	public final static short ENDORSE_STATUS_SHOW_AND_HIDE = -1;
	public final static short ENDORSE_STATUS_UNHANDLE = 0;
	public final static short ENDORSE_STATUS_SHOW = 1;
	public final static short ENDORSE_STATUS_HIDE = 2;
	public final static short ENDORSE_STATUS_NO_CLASS = 3;

	public final static int ENDORSE_PAGE_SIZE = 5;
	public final static int ENDORSE_PAGE_NO_1 = 1;

	public final static short INVITE_FIREND_REWARD_COINS = 10;
	public final static short ACCEPT_INVITE_REWARD_COINS = 68;
	public final static short COINSEVENT_INVITEFRIEND = 10;
	public final static short COINSEVENT_ACCEPTINVITE = 11;
	public final static short COINSEVENT_SENDFORBIDSNSIVITE = 12;
	public final static short COINSEVENT_JOBPAY = 13;
	
	public final static short ACCEPT_INVITE_REWARD_COINS_NOTI = 17;
	public final static short INVITE_FIREND_REWARD_COINS_NOTI = 18;

	// USER MULTIPLE EMAIL
	public final static short USER_EMAIL_ISMAIN = 1;
	public final static short USER_EMAIL_ISNOTMAIN = 0;

	// for badge
	public final static int BADGE_EVENT_SPECIAL_MEMBERSHIP = 1;
	public final static int BADGE_EVENT_ACTIVE_INVITER = 2;
	public final static int BADGE_EVENT_DILIGENT_MICROBLOGGER = 3;
	public final static int BADGE_EVENT_PERFECT_PROFILE = 4;
	public final static int BADGE_EVENT_BROKER = 5;
	public final static int BADGE_EVENT_POPULAR_MICROBOLGGER = 6;
	public final static int BADGE_EVENT_GOOD_PUBLIC_PRAISE = 7;
	public final static int BADGE_EVENT_ACTIVE_REFERRER = 8;
	public final static int BADGE_EVENT_FM_CM_FOLLOWER = 9;
	public final static int BADGE_EVENT_TEAM_BUILDER = 10;
	public final static int BADGE_EVENT_MOBILE_USHI = 11;
	public final static int BADGE_EVENT_MEMBER_IN_GOOD_STANDING =12;
	public final static int BADGE_EVENT_OUTSTANDING_CONTRIBUTION =13;
	public final static int BADGE_EVENT_EVENT_INVITE =14;	//鍙戝竷娲诲姩澶т簬3涓紝3涓椿鍔ㄥぇ浜庣瓑浜�5浜哄弬鍔�
	public final static short NOTIFICATION_TYPE_BADGE = 19;

	public final static short[] BADGE_EVENT_LEVEL = { 1, 2, 3 };

	public final static int[] BADGE_EVENT_ACTIVE_INVITER_COUNT = { 10, 50, 150 };
	public final static int[] BADGE_EVENT_DILIGENT_MICROBLOGGER_COUNT = { 30, 120, 500 };
	public final static int[] BADGE_EVENT_BROKER_COUNT = { 5, 10, 50 };
	public final static int[] BADGE_EVENT_FOLLOWER_COUNT = { 20, 100, 200 };
	public final static int[] BADGE_EVENT_GOOD_PUBLIC_PRAISE_COUNT = { 5, 20 };
	public final static int[] BADGE_EVENT_ACTIVE_REFERRER_COUNT = { 5, 20 };

	public final static int BADGE_USER_COUNT = 1000;

	public final static short NOTIFICATIONTYPE_MICROBLOG_COMMENT = 20;
	public final static short NOTIFICATIONTYPE_MICROBLOG_COMMENT_1 = 30;
	public final static short NOTIFICATIONTYPE_MICROBLOG_COMMENT_2 = 31;

	//REQUEST CONTROL
	public final static short ONE_D_REQUEST_CALCULATE_DAYS = 7;
	public final static short ONE_D_REQUEST_FORBID_DAYS = 14;
	public final static short ONE_D_IGNORE_TIMES = 5;
	
	public final static short REQUEST_FORBID_APPROVED_STATUS = 0;
	public final static short REQUEST_FORBID_FORBID_STATUS = 1;
	public final static short REQUEST_FORBID_1D_EVENT_KEY = 1;
	
	public final static short PLATINUM_WARN_SPAM_TIMES = 3;
	public final static short PLATINUM_FORBID_SPAM_TIMES = 5;
	public final static short DIAMOND_WARN_SPAM_TIMES = 10;
	public final static short DIAMOND_FORBID_SPAM_TIMES = 15;
	public final static short COINS_FORBID_SPAM_TIMES = 3;
	
	public final static short MESSAGE_FORBID_QUOTE = 2;
	public final static short MESSAGE_FORBID_COINS = 1;
	
	public final static short MESSAGE_FORBID_STATUS_APPROVED = 0;
	public final static short MESSAGE_FORBID_STATUS_WARN = 1;
	public final static short MESSAGE_FORBID_STATUS_FORBID = 2;
	
	public final static short MESSAGE_FORBID_PUBNISH_WITH_COIN = 30;
	public final static short MESSAGE_SPAMED = 1;
	
	public final static short MAX_INVITED_REQUEST_ONE_DAY = 50;
	
	public final static short SNS_INVITE_DEAL_WARN_VAL = 5;
	
	public final static short EXE_RESULT_SUCCESS = 0;
	public final static short EXE_RESULT_ERROR = 1;
	
	public final static String DEGREE_ADORN_1_D_EN = "st";
	public final static String DEGREE_ADORN_2_D_EN = "nd";
	public final static String DEGREE_ADORN_3_D_EN = "rd";
	
	// user behavior type
	public final static String BEHAVIOR_LOG_LOGIN = "login";
	
	//micro blog api ---- begin
	public final static short MICROBLOG_SYNCHRONOUS_TYPE_UP=1; //from ushi to ext
	public final static short MICROBLOG_SYNCHRONOUS_TYPE_DOWN=2; //from ext to ushi
	
	//extfrom and exttype
	public final static short MICROBLOG_SYNCHRONOUS_FROM_USHI=0;
	public final static short MICROBLOG_SYNCHRONOUS_FROM_SINA=1;
	public final static short MICROBLOG_SYNCHRONOUS_FROM_163=2;
	public final static short MICROBLOG_SYNCHRONOUS_FROM_SOHU=3;
	public final static short MICROBLOG_SYNCHRONOUS_FROM_PHONE=4;//浼樺＋鎵嬫満鐗�
	
	public final static short MICROBLOG_EXTSOURCE_STATUS_NORMAL=0;
	public final static short MICROBLOG_EXTSOURCE_STATUS_PAUSE=1;
	public final static short MICROBLOG_EXTSOURCE_STATUS_ERROR=2;///////
	
//	public final static String MICROBLOG_API_SINA_APPKEY="3392453855";
//	public final static String MICROBLOG_API_SINA_APPSECRET="6bac170d0ece802721490606ccd06355";
	public final static String MICROBLOG_API_SINA_APPKEY="3337512654";
	public final static String MICROBLOG_API_SINA_APPSECRET="d6ce97258a0fd3639548de212a5f04ad";

	public final static String MICROBLOG_API_SOHU_APPKEY="ysIkAwlv6hYh";
	public final static String MICROBLOG_API_SOHU_APPSECRET="sG*V5tPt7vUsHkOwOkvCkaArisGRli";
	
	//micro blog api ---- end
	
	public final static int FEED_FROMWHERE_HOME=0;
	public final static int FEED_FROMWHERE_MICROBOLG=1;
	public final static int FEED_FROMWHERE_EVENT = 2;
	public final static int RETWEET_ORDERBY_LAST=1;
	public final static int RETWEET_ORDERBY_FRIST=0;

	public final static String PRIVACY_EMAILDASHBOARD="PRIVACY_EMAILDASHBOARD";
	public final static String PRIVACY_EMAILDASHBOARD_REQUEST="PRIVACY_EMAILDASHBOARD_REQUEST";
	public final static String PRIVACY_EMAILDASHBOARD_NOTIFICAT="PRIVACY_EMAILDASHBOARD_NOTIFICAT";
	public final static String PRIVACY_EMAILDASHBOARD_SUMMARY="PRIVACY_EMAILDASHBOARD_SUMMARY";
	public final static String PRIVACY_EMAILDASHBOARD_PROMOTION="PRIVACY_EMAILDASHBOARD_PROMOTION";
	public final static String PRIVACY_EMAILDASHBOARD_RECOMMEND="PRIVACY_EMAILDASHBOARD_RECOMMEND";

	public final static String UNPAIRED_PARENTHESIS = "UNPAIRED_PARENTHESIS";
    public final static String INVALID_FAMILY_NAME = "INVALID_FAMILY_NAME";
    public final static String FORBIDDEN_WORDS = "FORBIDDEN_WORDS";
    public final static String SUCCESS_VALIDATION = "SUCCESS_VALIDATION";
	
    public final static String INVALID_NAME_NOTIC_HAS_BEEN_CLOSED = "INVALID_NAME_NOTIC_HAS_BEEN_CLOSED";
	
    public static final Set<String> chineseFamilyNameSet = new HashSet<String>();
    public static final Set<String> forbiddenWordSet = new HashSet<String>();
    
    /*
     * static block used to initialize Chinese family name set
     */
		
	public final static int DEFAULT_PUBLIC_M_BLOG_LOAD_SIZE = 600;
	public final static int DEFAULT_PUBLIC_M_BLOG_LENGTH = 500;
	

	public final static int REQUEST_LIST_CONTENT_MAX_SIZE = 300; 
	
	public final static short REQUEST_TYPE_1D_INVITE_REQUEST = 1;
	public final static short REQUEST_TYPE_GROUP_INVITE_REQUEST = 4;
	
	
	public final static short APPLY_TO_JOIN_APPLY=0;
	public final static short APPLY_TO_JOIN_APROVE=1;
	public final static short APPLY_TO_JOIN_REJECT=2;
	public final static short APPLY_TO_JOIN_OTHER_WAY=3;

	public final static String LOCALE_ENGLISH_TOSTRING = "en_US";
	public final static String LOCALE_CHINA_TOSTRING = "zh_CN";
	
	public final static short JOB_MYPOST_TYPE_ALL = 0;
	public final static short JOB_MYPOST_TYPE_APPLY = 1;
	public final static short JOB_MYPOST_TYPE_FAVORITE = 2;
	
	// 鍏嶈垂浣撻獙娲诲姩涓撶敤锛屾瘡鏈堝厤璐圭敵璇锋鏁�
	public final static short JOB_MYPOST_MONTHS_FREECNT = 10;
	// 鍏嶈垂浣撻獙娲诲姩鎴嚦鏃ユ湡
	public final static int JOB_MYPOST_MONTHS_DEADLINE = 20110630;
	// 鍝佸皻浼樺＋涓撶敤锛屾瘡鏈堝厤璐圭敵璇�5娆�
	public final static short JOB_MYPOST_PSUSER_FREECNT = 5;
	// 瀹岀編妗ｆ涓撶敤锛屾瘡鏈堝厤璐圭敵璇�5娆�
	public final static short JOB_MYPOST_PERCENTAGE_FREECNT = 15;
	public final static String JOB_MYPOST_FREEFLG = "flag";
	public final static String JOB_MYPOST_FREECOUNT = "count";
	// 20110520娲诲姩
	public final static short JOB_HR_CNT = 5;
	public final static short JOB_HUNTER_CNT = 10;
	public final static short JOB_PLATINUM_MONTHS = 3;
	
	public final static short JOB_MYPOST_MONTHS_FREEFLG = 1;
	public final static short JOB_MYPOST_PSUSER_FREEFLG = 2;
	public final static short JOB_MYPOST_PERCENTAGE_FREEFLG = 3;
	public final static short JOB_MYPOST_NOFREE = 0;
	
	public final static short JOB_MYPOST_TYPE_FAV_COUNT = 20;
	
	public final static short JOB_HOME_RECOMMEND_SHOW_SIZE = 3;
	public final static short JOB_HOME_FAVORITE_SHOW_SIZE = 3;
	
	public final static short JOB_COMPANY_STATUS_NORMAL = 1;
	public final static short JOB_COMPANY_STATUS_REMOVED = 0;
	public final static short JOB_COMPANY_STATUS_UNVERIFY = 2;
	public final static short JOB_COMPANY_STATUS_FAILED = 3;
	public final static short JOB_DETAIL_STATUS_VERIFY_FAILED = 1;
	public final static short JOB_DETAIL_STATUS_UNVERIFY = 2;
	public final static short JOB_DETAIL_STATUS_OFF = 3; // 涓嬫灦
	public final static short JOB_DETAIL_STATUS_ON = 4; // 涓婃灦
	public final static short JOB_DETAIL_STATUS_REMOVED = 0;
	public final static short JOB_DETAIL_STATUS_UNRESUME = 5;
	public final static short JOB_APPLY_STATUS_REMOVED = 0;
	public final static short JOB_APPLY_STATUS_NORMAL = 1;
	
	public final static short JOB_RECOMMEND_FRIEND_INNER = 1;
	public final static short JOB_RECOMMEND_FRIEND_EXT_LINK = 2;
	public final static short JOB_RECOMMEND_FRIEND_EXT_MAIL = 3;
	public final static short JOB_RECOMMEND_DERIECT = 1;
	
	public final static String OPTION_HANDLE_JOBTYPE = "JOB_TYPE";
	public final static String OPTION_HANDLE_INBOXTYPE = "MEG_INBOXTYPE";
	public final static String OPTION_HANDLE_EXPERIENCE = "EXPERIENCE";
	public final static String OPTION_HANDLE_JOBLEVEL = "JOBLEVEL";
	public final static String OPTION_HANDLE_SALARY = "SALARY";
	public final static String OPTION_HANDLE_EDUCATION = "EDUCATION_DEGREE";
	public final static String OPTION_HANDLE_RELEASETIME = "RELEASETIME";
	public final static String OPTION_HANDLE_VALIDATETIME = "VALIDATETIME";
	public final static String OPTION_HANDLE_COMPANYTYPE = "COMPANYTYPE";
	public final static String OPTION_HANDLE_COMPANYSIZE = "COMPANY_SIZE";
	public final static String OPTION_HANDLE_SUBSCRIB_FREQUENCY = "SUBSCRIB_FREQUENCY";
	public final static String OPTION_HANDLE_DAYS_IN_WEEK = "DAYS_IN_WEEK";
	public final static String OPTION_HANDLE_GROUP_FEED_TYPE = "GROUP_FEED_TYPE";
	
	public static enum releaseTimeDays {
		TODAY{
			@Override
			public int getDays() {
				return 0;
			}
		},
		THREEDAY {
			@Override
			public int getDays() {
				return 3;
			}
		},
		WEEK{
			@Override
			public int getDays() {
				return 7;
			}
		},
		TWOWEEK{
			@Override
			public int getDays() {
				return 14;
			}
		},
		MONTH{
			@Override
			public int getDays() {
				return 30;
			}
		},
		THREEMONTH{
			@Override
			public int getDays() {
				return 90;
			}
		};
		public abstract int getDays();
	}
	
	public static enum daysInWeek {
		EVERYDAY{
			@Override
			public int getDays() {
				return 1;
			}
		},
		THREEDAY {
			@Override
			public int getDays() {
				return 3;
			}
		},
		WEEK{
			@Override
			public int getDays() {
				return 7;
			}
		};
		public abstract int getDays();
	}
	
	
	public final static String JOB_COMMON_WORKAREA_CITYIDS = "8066,8679,8843,8559,8677";
	public final static String JOB_OTHER_WORKAREA_REGIONIDS_EXCLUDEIDS = "750,842,1392"; // exclude Shanghai, Beijing, and Tianjing 
	                                                                                    //because they are already in JOB_COMMON_WORKAREA_CITYIDS
	
	public static enum JobSearchConditionType {
		JOBTYPE {
			@Override
			public String getConditionType() {
				return "JOBTYPE";
			}
		},
		INDUSTRY {
			@Override
			public String getConditionType() {
				return "INDUSTRY";
			}
		},
		CITY {
			@Override
			public String getConditionType() {
				return "CITY";
			}
		},
		EXPERIENCE {
			@Override
			public String getConditionType() {
				return "EXPERIENCE";
			}
		},
		JOBLEVEL {
			@Override
			public String getConditionType() {
				return "JOBLEVEL";
			}
		},
		SALARY {
			@Override
			public String getConditionType() {
				return "SALARY";
			}
		},
		COMPANYSIZE {
			@Override
			public String getConditionType() {
				return "COMPANYSIZE";
			}
		},
		COMPANYTYPE {
			@Override
			public String getConditionType() {
				return "COMPANYTYPE";
			}
		},
		EDUCATION {
			@Override
			public String getConditionType() {
				return "EDUCATION";
			}
		},
		RELEASETIME {
			@Override
			public String getConditionType() {
				return "RELEASETIME";
			}
		};
		public abstract String getConditionType();

	}
	
	public final static short JOB_NOTIFICATION = 21;
	
	public final static short JOB_SELECT_RESUME_MAX = 1;
	
	public final static String JOB_WORK_AREA_CITY = "CI_";
	public final static String JOB_WORK_AREA_REGION = "RE_";
	public final static String JOB_WORK_AREA_COUNTRY = "CO_";
	
	public final static int JOB_SEARCH_RESULT_INIT_SIZE = 100;
	
	public final static int CHINA_COUNTRY_ID = 156;
	
	public final static int JOB_SEARCH_RESULT_SORT_MAX = 3;
	
	public final static short JOB_SEARCHOR_MAX_NUM = 5;
	
	public final static short NEWSLETTER_STATE_NEW = 0;
	public final static short NEWSLETTER_STATE_APPROVED = 1;
	public final static short NEWSLETTER_STATE_SENDED = 2;
	
	public final static short NEWSLETTER_APPROVESTATE_CAN = 1;
	public final static short NEWSLETTER_APPROVESTATE_NOT = 0;
	
	public final static short NEWSLETTER_SEARCHTYPE_USERNAME = 1;
	public final static short NEWSLETTER_SEARCHTYPE_SENDTIME = 2;
	
	public final static short NEWSLETTER_TESTUSER_NEED = 1;
	public final static short NEWSLETTER_TESTUSER_NONEED = 0;
	
	public final static String NEWSLETTER_TEMPLATE_NAME = "newsletter_feeds";
	
	public final static String NEWSLETTER_IMAGE_DIR = "nl";
	
	//promotion 9-Nov~14-Dec
	//2010-11-10 2010-11-17 2010-11-24 2010-12-1 2010-12-8
	public static Date[] rangDate = new Date[] { DateUtil.getDate("2011-1-18", DateUtil.patternDate),
			DateUtil.getDate("2011-1-26", DateUtil.patternDate), DateUtil.getDate("2011-2-2", DateUtil.patternDate),
			DateUtil.getDate("2011-2-9", DateUtil.patternDate) };
	public final static int PRO_STATUE_ON_MAX_NUM = 5;
	
	public final static short BACKEND_GROUP_FEEDTYPE_TOPIC = 1;
	public final static short BACKEND_GROUP_FEEDTYPE_EVENT = 2;
	public final static short BACKEND_GROUP_FEEDTYPE_FEED = 3;
	public final static short BACKEND_GROUP_FEEDTYPE_TOPIC_REPLY = 4;
	public final static short BACKEND_GROUP_FEEDTYPE_EVENT_REPLY = 5;
	public final static short BACKEND_GROUP_FEEDTYPE_FEED_REPLY = 6;
	
	public final static short GROUP_MEMBER_TYPE_SEARCHADMIN = 8;
	public final static short BACKEND_GROUP_FEED_DELETE = 0;
    public final static short RECOMMEND_ITEM_TYPE_FRIEND = 1; // friend recommendation item
    public final static short RECOMMEND_ITEM_TYPE_JOB = 2; // job recommendation item
    
    // Calvin
    // project: new user guide
    // table: N/A
    public final static int GUIDE_RECOMMEND_WEIGHT_EDU = 4;
    public final static int GUIDE_RECOMMEND_WEIGHT_CAREER = 4;
    public final static int GUIDE_RECOMMEND_WEIGHT_EMAIL = 3;
    public final static int GUIDE_RECOMMEND_WEIGHT_TITLE = 2;
    public final static int GUIDE_RECOMMEND_WEIGHT_IP = 1;
    
    public final static int PROMOTION_GUIDE = 9999; //special usage of BNS_PROMOTION table for new user guide

	// optimize user experience
	public final static String IT_INTERNET = "8,4,10,12,7,49,154,3,13,9,5,6";//IT缃戠粶
	public final static String FINANCIAL = "64,66,65,63,154,152,61,60,67";//閲戣瀺鎶曡祫
	public final static String MARKET_ADVERTISEMENT  = "22,24,49,43,154,44,41,23,50";//甯傚満涓庡箍鍛�
	public final static String CULTURE_ART = "47,52,53,54,82,153,154";//鏂囧寲鑹烘湳
	public final static String LAW_CONSULTING = "16,18,20,21,27,28,69,76,77,122,154";//娉曞緥涓庡挩璇㈡湇鍔�
	public final static String REAL_ESTATE = "62,96,97,100,154";//鎴垮湴浜�
	public final static String MANUFACTURING = "89,91,104,105,106,107,109,137";//鍒堕��
	public final static String HOSPITAL_MEDICAL = "32,33,34,154";//鍖婚櫌鍖荤枟
	
	public final static int IT_INTERNET_TYPE = 1;//IT缃戠粶
	public final static int FINANCIAL_TYPE = 2;//閲戣瀺鎶曡祫
	public final static int MARKET_ADVERTISEMENT_TYPE  = 3;//甯傚満涓庡箍鍛�
	public final static int CULTURE_ART_TYPE = 4;//鏂囧寲鑹烘湳
	public final static int LAW_CONSULTING_TYPE = 5;//娉曞緥涓庡挩璇㈡湇鍔�
	public final static int REAL_ESTATE_TYPE = 6;//鎴垮湴浜�
	public final static int MANUFACTURING_TYPE = 7;//鍒堕��
	public final static int HOSPITAL_MEDICAL_TYPE = 8;//鍖婚櫌鍖荤枟
	

	//limitation of first friend
	public final static Integer LIMITATION_OF_FIRST_FRIEND=5000;
	
	//job survey
	public final static String JOB_SURVEY_INTEREST_HANDLE = "JOB_SURVEY_INTEREST_HANDLE";
	public final static short JOB_SURVEY_CALCULATE_DAYS = 7;
	public static final int COINSEVENT_JOBSURVEY = 15;
	
	//job II
	public final static short JOB_CONSULT_CALCULATE_DAYS = 7;
	public final static short BNS_EDUCATION_ORDERS[] = {5,4,3,2,1,6,7};
	
	public final static short JOB_RECRUITMENT_LIST_TITLE_ORDER = 1;
	public final static short JOB_RECRUITMENT_LIST_PROXYCOMPANY_ORDER = 2;
	public final static short JOB_RECRUITMENT_LIST_CITY_ORDER = 3;
	public final static short JOB_RECRUITMENT_LIST_RELEASETIME_ORDER = 4;
	public final static short JOB_RECRUITMENT_LIST_REFRESHTIME_ORDER = 5;
	public final static short JOB_RECRUITMENT_LIST_FINISHTIME_ORDER = 6;
	public final static short JOB_RECRUITMENT_LIST_STATUS_ORDER = 7;
	public final static short JOB_RECRUITMENT_LIST_APPLYCOUNT_ORDER = 8;
	public final static short JOB_RECRUITMENT_LIST_VISITCOUNT_ORDER = 9;
	
	public final static short JOB_RECRUITMENT_APPLY_USERNAME_ORDER = 1;
	public final static short JOB_RECRUITMENT_APPLY_BRIEFCAREER_ORDER = 2;
	public final static short JOB_RECRUITMENT_APPLY_DEGREE_ORDER = 3;
	public final static short JOB_RECRUITMENT_APPLY_COVERLETTER_ORDER = 4;
	public final static short JOB_RECRUITMENT_APPLY_RESUME_ORDER = 5;
	public final static short JOB_RECRUITMENT_APPLY_APPLYTIME_ORDER = 6;
	
	public final static int JOB_RECRUITMENT_ASC = 1;
	public final static int JOB_RECRUITMENT_DESC = 0;
	
	public final static int JOB_RECRUITMENT_JOB_SETTING_ON_STATUS_FRESH_TYPE = 1;
	public final static int JOB_RECRUITMENT_JOB_SETTING_PAUSE_STATUS_FRESH_TYPE = 2;
	public final static int JOB_RECRUITMENT_JOB_SETTING_FRESH_CONFIRM = 1;
	public final static int JOB_RECRUITMENT_JOB_SETTING_FRESH_UNCONFIRM = 0;
	
	
	public final static int JOB_APPLY_REFER_PRESENT = 1;
	
	public final static int PACKAGE_USHITONG_UPGRADE_TYPE_3M =  0;
	public final static int PACKAGE_USHITONG_UPGRADE_TYPE_1Y =  2;
	public final static short JOB_COMPANY_VERIFY_FAIL_NOTIFICATION = 33;
	public final static short JOB_DETAIL_VERIFY_FAIL_NOTIFICATION = 34;
	
	// 鎮ㄦ彁浜ょ殑{0}鍏徃淇℃伅宸茬粡閫氳繃瀹℃牳! 
	public final static short JOB_COMPANY_VERIFY_SUCCESS_NOTIFICATION = 43;
	// 鎮ㄦ彁浜ょ殑{0}鑱屼綅宸茬粡閫氳繃瀹℃牳
	public final static short JOB_DETAIL_VERIFY_SUCCESS_NOTIFICATION = 44;
	// 鎮ㄦ彁浜ょ殑{0}鑱屼綅宸茬粡杩囨湡锛�
	public final static short JOB_DETAIL_VERIFY_EXPIRES_NOTIFICATION = 45;
	// {0}鐢宠鎮ㄥ彂甯冪殑{1}鑱屼綅
	public final static short JOB_DETAIL_APPLE_NOTIFICATION = 46;
	// {0}鐢宠鎮ㄥ彂甯冪殑{1}鑱屼綅
	public final static short JOB_PLATINUM_NOTIFICATION = 59;
	public static String MODULE_EVENT = "EVENT";
	
	public static short TAG_MODE_CATEGORY = 3;  //鍒嗙被鏍囩
	public static short TAG_MODE_SYSTEM = 1;	//绯荤粺鍏宠仈鐨勬爣绛�
	public static short TAG_MODE_MANUAL = 2;	//鐢ㄦ埛鑷繁鍏宠仈鐨勬爣绛�
	public static short TAG_MODE_ALL = 999;		//鐢ㄤ簬鏌ヨ鏃跺叏閮ㄦ煡璇�
	public static short TAG_TYPE_SYSTEM = 1;	//绯荤粺鏍囩
	public static short TAG_TYPE_USER = 2;		//鐢ㄦ埛鑷畾涔夋爣绛�
	public static short TAG_STATE_NORMAL = 1;	//姝ｅ父鐘舵�佺殑鏍囩
	public static short TAG_STATE_DELETE = 1;	//宸茬粡鍒犻櫎鐨勬爣绛�
	
	public static int DROP_DOWN_SIZE_EVENT = 3;	//鍚戜笅鍖归厤鐨勪釜鏁�
	
	public static short REQUEST_EVENTKEY_EVENT_INVITE = 5;
	
	public static class Event {
		public static short NORMAL = 1;
		public static short CANCEL = 0;
		public static short TAGTYPE = 3;//鍒嗙被鏍囩
		
		public static short EVENTUSER_TO_GO = 1;//鏈鍒�
		public static short EVENTUSER_SIGNIN = 2;//绛惧埌
		
		public static short ACTION_TO_GO = 1;//鎴戣鍙傚姞
		public static short ACTION_NOT_TO_GO = 2;//鎴戜笉鍘讳簡
		public static short ACTION_TO_SIGNIN = 3;//鐜板満绛惧埌
		public static short ACTION_CANCEL = 4;//宸茬粡琚垹闄�
		
		public static int DETAILPAGE_USER_SHOW_SIZE = 30;
		public static int DETAILPAGE_JOIN_SIZE = 3;	//鍙傚姞杩欎釜娲诲姩鐨勪汉涔熷弬鍔犱簡-娲诲姩涓暟
		public static int LISTPAGE_USER_SHOW_SIZE = 10;
		public static int PAGE_USER_SHOW_ALL = 0;
		
		public static String MAIL_TEMPLATE_INVITE = "event_invite";
		public static String MAIL_TEMPLATE_UPDATE = "event_update";
		public static String MAIL_TEMPLATE_CANCEL = "event_cancel";
		
		public static Short SHARE_TO_FRIEND = 1;
		public static Short SHARE_TO_GROUP = 2;
		public static Short SHARE_TO_SINA = 3;
		public static Short SHARE_TO_KAIXIN = 4;
		public static Short SHARE_TO_RENREN = 5;
		
		public static Short EXPORT_TO_GOOGLE = 1;
		public static Short EXPORT_TO_OUTLOOK = 2;

		public static final String BEHAVOR_KEY_USERCITY="USERCITY";
		public static final String BEHAVOR_KEY_USERCOUNTRY="USERCOUNTRY";
		public static int EVENT_TAGS_DISPLAYCNT=5;
		
		public static final String MOBILE_LOGIN_IP="web2loginip";
		
		public static  short NOTIFICATIONTYPE_EVENT_DELETED4_CREATOR=38;
		public static  short NOTIFICATIONTYPE_EVENT_DELETED4_JOINER=39;
	}
	public final static String EMAIL_TEMPLATE_SESSION = "EMAIL_TEMPLATE_SESSION"; 
	public final static String EMAIL_TEMPLATE_VERSION_ONE = "1";
	public final static String EMAIL_TEMPLATE_CODE_EMAIL_VERIFY4ADD = "7";
	public final static String EMAIL_TEMPLATE_CODE_EMAIL_VERIFY4MODIFY = "8";
	public final static String EMAIL_TEMPLATE_CODE_EMAIL_VERIFY = "9";
	public final static String EMAIL_TEMPLATE_CODE_EMAIL_FETCH_PASSWORD = "16";
	
	public static short NOTIFICATIONTYPE_CAREER_UPDATE = 40;
	public static short NOTIFICATIONTYPE_GET_COIN = 41;
	public static String MAIL_TEMPLATE_CAREER_UPDATE = "career_update";
	public static String MAIL_TEMPLATE_CAREER_ANNUAL = "career_annual";
	
	//SNS_BLOCKLIST column status
	public final static short BLOCK_LIST_NORMAL = 0;
	public final static short BLOCK_LIST_DELETED = -1;
	
	//GRP_REPORT
    public final static short GRP_REPORT_NORMAL = 0;
    public final static short GRP_REPORT_DELETED = -1;
    public final static short GRP_REPORT_TOADMIN = 1;
	
	public static String TOKEN_PREFIX_GROUP = "group_";
	public static String TOKEN_PREFIX_EVENT = "event_";
	
	public static String TOKEN_FROM_EVENT = "event";
	
	public static int BACKEND_MENU_MICROBLOG = 1;
	public static int BACKEND_MENU_JOB = 2;
	public static int BACKEND_MENU_MEMBER = 4;
	public static int BACKEND_MENU_CONTENT = 8;
	public static int BACKEND_MENU_FILTER = 16;
	public static int BACKEND_MENU_GROUP = 32;
	public static int BACKEND_MENU_EVENT = 64;
	public static int BACKEND_MENU_PAYMENT = 128;
	public static int BACKEND_MENU_PROMOTION = 256;
	public static int BACKEND_MENU_DATE = 512;
	public static int BACKEND_MENU_BLOCK = 1024;
	public static int BACKEND_MENU_APPLY = 2048;
	public static int BACKEND_MENU_NEWSLETTER = 4096;
	public static int BACKEND_MENU_NEWUSERGUIDE = 8192;
	public static int BACKEND_MENU_GROUPREPORT = 16384;
	public static int BACKEND_MENU_CM2 = 32768;
	public static int BACKEND_MENU_MESSAGE = 65536;
	
	public static int[] BACKEND_MENU = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536};
	
	//cm2
    public final static short CM2_STATUS_INIT = 0;
    public final static short CM2_STATUS_APPROVE = 1;
    public final static short CM2_STATUS_REJECT = 2;
    public final static short NOTIFICATION_TYPE_CM2 = 47;
    public final static short NOTIFICATIONTYPE_EVENT_BADGEPRIZE = 67;
    
    public static short M2_PRIZE_TYPE_DAILY = 1;		//寰界珷濂栧姳,姣忔棩鐨�
    public static short M2_PRIZE_TYPE_LEVEL_1 = 2;		//寰界珷濂栧姳,鎬荤粨绠楀嚭浠曠被
    public static short M2_PRIZE_TYPE_LEVEL_2 = 3;		//寰界珷濂栧姳,鎬荤粨绠楀皢鑷ｇ被
    public static short M2_PRIZE_TYPE_LEVEL_3 = 4;		//寰界珷濂栧姳,鎬荤粨绠楃帇鑰呯被
    
    // group newsfeed status
    public final static short GRP_NEWSFEED_STATUS_NORMAL = 0;
    public final static short GRP_NEWSFEED_STATUS_DELETED = -1;
    // group newsfeedcomment status
    public final static short GRP_NEWSFEEDCOMMENT_STATUS_NORMAL = 0;
    public final static short GRP_NEWSFEEDCOMMENT_STATUS_DELETED = -1;
    
    public final static int APPROVE_REMIND_4_DAY = 4;
    public final static int APPROVE_REMIND_10_DAY = 10;
    public static String MAIL_TEMPLATE_APPROVE_REMIND = "apply_remind";
    public static int CRM_LOG_TASKID_APPROVE_RIMIND = 5;
    public static int CRM_LOG_TASKID_RECOMMEND_LESS_THAN_2 = 6;
    public static String MAIL_TEMPLATE_RECOMMEND_CONNECTION = "recommend_connection";
    public static String MAIL_TEMPLATE_RECOMMEND_NONE = "recommend_NONE";
    public static int MAIL_DASH_BOARD_OPTIONID_RECOMMEND = 20100013;
    
    public static int CRM_LOG_TASKID_CAREER_UPDATE = 7;
    public static int CRM_LOG_TASKID_CAREER_ANNUAL = 8;
    
    public static int REQUEST_LOW_TYPE_DAY_LIMIT = 14;
    public static int SNS_REQUEST_TYPE_FRIEND = 7;
    
      //鎵嬫満鎵�鏈塮eed
	public final static int[] MOBILPHONE_FEED_ALL_TYPE = new int[] {1,2,8};
	//鎵嬫満浜鸿剦 feed
	public final static int[] MOBILPHONE_FEED_CONNECTIONS_TYPE = new int[] {8};
	//鎵嬫満妗ｆfeed
	public final static int[] MOBILPHONE_FEED_PROFILE_TYPE = new int[] {2};
	//鎵嬫満寰崥feed
	public final static int[] MOBILPHONE_FEED_MICROBLOG_TYPE = new int[] {1};
	
	public final static String MOBILPHONE_FEED_MYSELF_NEWS_ALL_TYPE = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL +"'";
	
	public final static String MOBILPHONE_FEED_MYSELF_MICROBLOG_TYPE = "'" + SNS_SHARE_TEXT + "','" + SNS_SHARE_LINKURL + "','" + EVENT_SHARE_TEXT + "','" + EVENT_SHARE_LINKURL +"'";
    
    //open reg
    public static String OPEN_REG_LOCALE = "OPEN_REG_LOCALE";
    public final static int OPEN_REG_MY_STATE_WORK = 0;
    public final static int OPEN_REG_MY_STATE_COMPANY_LEADER = 1;
    public final static int OPEN_REG_MY_STATE_FIND_WORK = 2;
    public final static int OPEN_REG_MY_STATE_SOHO_WORK = 3;
    public final static int OPEN_REG_MY_STATE_STUDENT = 4;
    public final static ThreadLocal<Boolean> OPEN_REG_ADD_FIRST_DEGREE = new ThreadLocal<Boolean>();
    public final static ThreadLocal<Boolean> OPEN_REG_ADD_FIRST_DEGREE_AFTER_REQUEST = new ThreadLocal<Boolean>();
    public final static ThreadLocal<Integer> OPEN_REG_GROUP_ID = new ThreadLocal<Integer>();
    public final static ThreadLocal<Boolean> OPEN_REG_LOGIN_UNVERIFY = new ThreadLocal<Boolean>();
    public static String NEWSFEED_TYPE_SETTING_WENDA = "-1";
    public static String FEED_HANDLE_Q_TO_T = "wenda.q.to.t";	//-	闂A  琚坊鍔犲埌 璇濋B
    public static String FEED_HANDLE_ADD_A = "wenda.add.a"; //-	鐢ㄦ埛A 鍥炵瓟浜� 闂B
    public static String FEED_HANDLE_DELETE_Q = "wenda.delete.q"; //-	鐢ㄦ埛A 鍒犻櫎浜� 闂B
    public static String FEED_HANDLE_ADD_Q = "wenda.add.q"; //-	鐢ㄦ埛A 娣诲姞浜� 闂B
    public static String FEED_HANDLE_SUBSCRIBE_QUESTION = "wenda.subscribe.question"; //-	鐢ㄦ埛A 鍏虫敞浜� 闂B
    public static String FEED_HANDLE_SUBSCRIBE_TAG = "wenda.subscribe.tag"; //-	鐢ㄦ埛A 鍏虫敞浜� 璇濋B
    public static String FEED_HANDLE_SUBSCRIBE_USER = "wenda.subscribe.user"; //-	鐢ㄦ埛A 鍏虫敞浜� 鐢ㄦ埛B
    
    public static int PRIVACY_FEED_WENDA = 1048576;
    
    public static long FEED_MERGE_MINUTE = 5 * 60 * 1000;	//long绫诲瀷
    //mail optimize
    public final static ThreadLocal<Boolean> MAIL_OPTIMIZE_PRIORITY_OVER_USER = new ThreadLocal<Boolean>();
    public final static ThreadLocal<Integer> MAIL_OPTIMIZE_USER_ID = new ThreadLocal<Integer>();
    public final static int MAIL_OPTIMIZE_SOURCE_GRP_MAIL = 1;
    public final static int MAIL_OPTIMIZE_SOURCE_NORMAL_MAIL = 2;
    public final static int MAIL_OPTIMIZE_SOURCE_REAL_MAIL = 3;
    public final static int MAIL_OPTIMIZE_MAX_INVITE_MAIL_ONCE = 2000;
    public final static int MAIL_OPTIMIZE_MAX_INVITE_MAIL_DAY = 5000;
    
	//sso鍙互缁曡繃閭楠岃瘉锛屾墍浠ュ湪SESSION鍔犱竴涓狢HECK MAIL鐨勪俊鎭潵瀵归椤佃繘琛屾樉绀�
	public static final String USER_VERIFY_EMAIL_KEY_SSO = "verifyemailsso";
    
    
    public static String M2_BADGE_PRIZE_START_DATE = "2011-09-13";
    
    //FROM HERE!!
    public final static String LOGO_PATH = "/";
    public final static String PHOTO_PATH = "/";
}
