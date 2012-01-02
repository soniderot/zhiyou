<%@page contentType="text/html; charset=UTF-8"%>
  <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
  <base href="<%=basePath%>" />
 
  <meta name="description" content="知友网 是一个以好友互动娱乐为主要功能的交友网站。围绕交友设计开发了包括美食点评、活动邀请、交友推荐、吃货配对、社交管家等线上线下互动功能，旨在促进网友间现实的互动和交流。" />
  <link type="text/css" rel="stylesheet" href="css/GfrxW__2wNR.css" />
  <link type="text/css" rel="stylesheet" href="css/6JziMmtqgI9.css" />
  <link type="text/css" rel="stylesheet" href="css/oKInZho4Fq0.css" />
  <link type="text/css" rel="stylesheet" href="css/B2si-Z7yw-e.css" />
  <link type="text/css" rel="stylesheet" href="css/jquery.tipsy.css"/>
  <link type="text/css" rel="stylesheet" href="css/lp74PDkdILx.css" />
  <link type="text/css" rel="stylesheet" href="css/vhaqLt4m8pH.css" />
  
  <link	type="text/css"	rel="stylesheet" href="css/B2si-Z7yw-e.css"	/>

  

  <link type="text/css" rel="stylesheet" href="css/IE/IhlLCbRnaR-.css" />
  <link type="text/css" rel="stylesheet" href="css/fkAcKjsqY28.css" />
  <link type="text/css" rel="stylesheet" href="css/Kik3stz4LwG.css" />
  <link type="text/css" rel="stylesheet" href="css/m-D37VXlUU0.css" />
  

  <link	type="text/css"	rel="stylesheet" href="css/IE/IhlLCbRnaR-.css" />
  <link	type="text/css"	rel="stylesheet" href="css/-FVr7LJfXrK.css"	/>
  <link	type="text/css"	rel="stylesheet" href="css/8oFRsy4_wEv.css"	/>
  <link	type="text/css"	rel="stylesheet" href="css/CULs4eaJW7y.css"	/>
  
  
  <link type="text/css" rel="stylesheet" href="css/GfrxW__2wNR.css" />
  <link type="text/css" rel="stylesheet" href="css/6JziMmtqgI9.css" />
  <link type="text/css" rel="stylesheet" href="css/oKInZho4Fq0.css" />




	
	<link	type="text/css"	rel="stylesheet" href="css/U0-0hkWO0Wp.css" />
	<link	type="text/css"	rel="stylesheet" href="css/lp74PDkdILx.css" />
	
	
	<link	type="text/css"	rel="stylesheet" href="css/GfrxW__2wNR.css"	/>
	<link	type="text/css"	rel="stylesheet" href="css/6JziMmtqgI9.css"	/>
	<link	type="text/css"	rel="stylesheet" href="css/oKInZho4Fq0.css"	/>
	<link	type="text/css"	rel="stylesheet" href="css/B2si-Z7yw-e.css"	/>

	
	<link	type="text/css"	rel="stylesheet" href="css/IE/IhlLCbRnaR-.css" />
	<link	type="text/css"	rel="stylesheet" href="css/U0-0hkWO0Wp.css" />
	<link	type="text/css"	rel="stylesheet" href="css/slJVV30UKWq.css" />
	<link	type="text/css"	rel="stylesheet" href="css/Mk2KsgdS1lw.css" />
	
	
	<link type="text/css" rel="stylesheet" href="css/GfrxW__2wNR.css" />
  <link type="text/css" rel="stylesheet" href="css/6JziMmtqgI9.css" />
  <link type="text/css" rel="stylesheet" href="css/oKInZho4Fq0.css" />

  
  <link type="text/css" rel="stylesheet" href="css/IE/IhlLCbRnaR-.css" />
  <link type="text/css" rel="stylesheet" href="css/fkAcKjsqY28.css" />
  <link type="text/css" rel="stylesheet" href="css/Kik3stz4LwG.css" />
  <link type="text/css" rel="stylesheet" href="css/m-D37VXlUU0.css" />
  
  <link type="text/css" rel="stylesheet" href="css/bns.css" />
 
  

  <script type="text/javascript" language="javascript" src="js/jquery.js"></script>
  <script type="text/javascript" language="javascript" src="js/jquery.autocomplete.js"></script>
  <script type="text/javascript" language="javascript" src="js/facebox.js"></script>
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/jquery.tipsy.js"></script>
  <script type="text/javascript" language="javascript" src="js/tools.js"></script>
  <script type="text/javascript" language="javascript" src="js/placeholder.js"></script>

  <title>知友</title>
  <link rel="shortcut icon" href="#" />
  <style>
    .sidebarMode #chatFriendsOnline,.sidebarMode #fbDockChatBuddylistNub.fbNub,.sidebarMode #fbChatErrorNub{display:none}
    .sidebarMode #pageHead,.sidebarMode #globalContainer{left:-90px;position:relative}
    .sidebarMode .liquid #globalContainer{margin:0 90px}
    .sidebarMode .fbDockWrapper{right:175px}
    .sidebarMode .timelineLayout .fbTimelineSideColumn{margin-right:-400px}
    .sidebarMode .fbTimelineSideAds,.sidebarMode .fbTimelineScrubber{margin-right:-400px}
    .sidebarMode .fbTimelineStickyHeader{right:310px}
    .sidebarMode #fbPhotoTheater .container{margin-left:-570px}
  </style>
  
  <%
  java.util.Map<Integer,String> years = new java.util.LinkedHashMap<Integer,String>();
  years.put(-1,"年");
  for(int i=1950;i<2012;i++){
    years.put(i,""+i);
  }
  request.setAttribute("years",years);
  %>
  
  <%
  java.util.Map<Integer,String> months = new java.util.LinkedHashMap<Integer,String>();
  months.put(-1,"月");
  for(int i=1;i<=12;i++){
    months.put(i,""+i);
  }
  request.setAttribute("months",months);
  %>
  
  <%
  java.util.Map<Integer,String> days = new java.util.LinkedHashMap<Integer,String>();
  days.put(-1,"日");
  for(int i=1;i<=31;i++){
    days.put(i,""+i);
  }
  request.setAttribute("days",days);
  %>
  
  <%
  java.util.Map<Integer,String> beginAges = new java.util.LinkedHashMap<Integer,String>();
  for(int i=18;i<45;i++){
    beginAges.put(i,""+i);
  }
  request.setAttribute("beginAges",beginAges);
  %>
  
  <%
  java.util.Map<Integer,String> endAges = new java.util.LinkedHashMap<Integer,String>();
  for(int i=18;i<45;i++){
    	endAges.put(i,""+i);
  }
  request.setAttribute("endAges",endAges);
  %>
  
  
  <%
  java.util.Map<String,String> hours = new java.util.LinkedHashMap<String,String>();
  for(int i=0;i<=23;i++){
  		
    		hours.put(""+i+":00",""+i+":00");
    		hours.put(""+i+":30",""+i+":30");
    	
  }
  request.setAttribute("hours",hours);
  %>
  