<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
			<table width="100%" border="0" cellspacing="0" cellpadding="5" style="margin-top:10px;">
				<tr>
					<td valign="top" width="20%">
						<p style="margin:0 0 10px 0;"><a href="${domainname}/profile/profile!viewProfileInfo.jhtml?userid=${profile.userid}"><img src="${domainname}/${profile.avatar}" alt="" width="80" height="80" style="border:1px solid rgb(127,178,212);" /></a></p>
						<h2 style="font-size:14px;margin:0 0 5px 0;">${senderName}</h2>
						<p style="font-size:12px;margin:0;color:#888888;">来加入我们吧</p></td>
					<td valign="top" width="80%">
						<h2 style="font-size:14px;margin:0 0 10px 0;">Hi ${receiverName}：</h2>
						<p style="font-size:12px;margin:0 0 5px 0;">知友网是一个帮你拓展人脉网络，提供丰富的交际活动，集吃喝玩乐于一身的网站，现在有朋友邀请你加入！</p>
						<p><a style="display:inline-block;background:rgb(224,238,255); color:rgb(0,50,130); padding:3px 20px; text-align:center; text-decoration:none; font-weight:bold; font-size:12px; border:solid 1px rgb(119,158,200); border-bottom:solid 2px rgb(73,127,179); border-right:solid 2px rgb(73,127,179);" href="${acceptLink}">接受邀请</a></p>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


</body>
</html>
