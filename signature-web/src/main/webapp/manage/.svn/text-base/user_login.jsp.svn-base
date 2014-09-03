<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录情况</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
</head>

<body>
<div id="body_top_bg">
	<div id="body_right_bg">
	
	
<div id="postion_nav">
您的位置：统计管理 -&gt; 用户管理 -&gt; 用户登录情况
</div>

<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">用户登录情况</a>
    </caption>
    
    <thead>
      <tr>
        <th width="15%">用户号码</th>
        <th width="15%">登录次数</th>
        <th width="15%">最后一次登录时间</th>        
        </tr>
    </thead>
    <tbody>
       <tr>
        <s:set value="#request.user" name="user"></s:set>
        <td align="center"><s:property value="#request.loginName"/></td>
        <td align="center"><s:if test="#user == null || #user.loginCount == null">0</s:if><s:else><s:property value="#user.loginCount"/></s:else></td>
        <td align="center"><s:if test="#user == null || #user.lastLoginTime == null">无</s:if><s:else><s:date name="#user.lastLoginTime" format="yyyy-MM-dd HH:mm"/></s:else></td>
        </tr>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7" class="list_aselect">      
        	<a href="javascript:history.back()" class="link000">返回</a>
        </td>
    </tr>
    </tfoot>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
</div>
</div>
</body>
</html>
