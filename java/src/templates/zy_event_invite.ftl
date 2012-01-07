<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>活动邀请通知信</title>
</head>

<body>
<table width="700" border="0" align="center" cellpadding="5" cellspacing="0" style="font-family:Arial, Helvetica, sans-serif; font-size:12px; line-height:1.4; color:rgb(45, 45, 45); text-align:left; border:solid 4px rgb(230, 230, 230); background:rgb(255, 255, 255);">
  <tr>
    <td valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="5" style="border-bottom:solid 3px rgb(163, 194, 224);">
     <tr>
        <td width="80" align="left"><img src="${domainname}/images/logo.JPG" width="62" height="44" alt="知友网" /></td>
        <td height="50">&nbsp;</td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="5"  style="margin-top:10px;">
        <tr>
          <td>
          <p style="font-size:12px;font-weight:bold;margin:0;">你好,${receiverName}</p>
          
          <p style="font-size:12px;margin:15px 0;line-height:1.5;">${profile.username}邀请你参加活动：<a style="color:rgb(0, 102, 170);text-decoration:underline;"  href="${domainname}/event/event!viewEvent.jhtml?eventId=${event.id}">${event.eventname}</a>。</p>
          
          
          <p style="font-size:12px;margin:15px 0;line-height:1.5;">以下是本次活动的简单介绍：</p>
          
          <table width="100%" border="0" cellpadding="4" cellspacing="0" style="margin:10px 0; border-collapse:collapse;background:rgb(244,248,253); border-top:solid 2px rgb(186,205,218); border-bottom:solid 2px rgb(186,205,218);">
            <tr style="border-bottom:solid 1px rgb(210,225,235);">
              <td width="80" align="right" valign="top">活动名称：</td>
              <td><strong>${event.eventname}</strong></td>
            </tr>
            <tr style="border-bottom:solid 1px rgb(210,225,235);">
              <td align="right" valign="top">活动时间：</td>
              <td>${begintime}---${endintime}</td>
            </tr>
            <tr style="border-bottom:solid 1px rgb(210,225,235);">
              <td align="right" valign="top">活动地址：</td>
              <td>${event.address}</td>
            </tr>
            <tr>
              <td align="right" valign="top">内容：</td>
              <td>${detail}</td>
            </tr>
          </table>
          
           <p style="font-size:12px;margin:25px 0 0;">如果你感兴趣，请点击以下链接接受活动邀请： </p>
           <p style="font-size:12px;margin:5px 0;"><a style="color:rgb(0, 102, 170);text-decoration:underline;" href="${domainname}/usr/request.jhtml">接受邀请</a></p>
          
          
          </td>
        </tr>
    </table>
    
       </td>
  </tr>
</table>
</body>
</html>

