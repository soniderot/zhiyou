  <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
  <base href="<%=basePath%>" />
  <%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
  <meta name="robots" content="noodp,noydir" />
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <meta name="description" content="知友网 是一个以好友互动娱乐为主要功能的交友网站。围绕交友设计开发了包括美食点评、活动邀请、交友推荐、吃货配对、社交管家等线上线下互动功能，旨在促进网友间现实的互动和交流。" />
  <link href="css/U0-0hkWO0Wp.css" rel="stylesheet" type="text/css"/>
  <link href="css/ejJoiNmHkkP.css" rel="stylesheet" type="text/css"/>
  <link href="css/mrLfwWIF5PY.css" rel="stylesheet" type="text/css"/>
  <link href="css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>
  <link href="css/jquery.tipsy.css" type="text/css" rel="stylesheet"/>
  <link href="css/jquery.imgareaselect.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" language="javascript" src="js/jquery.js"></script>
  <script type="text/javascript" language="javascript" src="js/jquery.autocomplete.js"></script>
  <script type="text/javascript" language="javascript" src="js/facebox.js"></script>
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/jquery.tipsy.js"></script>
  <script type="text/javascript" language="javascript" src="js/tools.js"></script>

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
  