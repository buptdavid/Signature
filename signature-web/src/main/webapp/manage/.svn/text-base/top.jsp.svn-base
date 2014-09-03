<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.juicy.signature.service.session.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>顶部导航设计</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript">
//退出登录
function logout(){
	if(confirm('您确认退出吗？')){
		 window.location.href="manage_logout.html"; 
	}else{
		return;
	}
}

function topmenu(a){
    selectlink(a);
	if(a==1){
	  
	  parent.frames[1].location.href="left_1.html";
	  parent.frames[3].location.href="view_activity.html";
	}
	if(a==2){
	  
	  parent.frames[1].location.href="left_2.html";
	  parent.frames[3].location.href="view_all_original.html?classId=0";
	}
	if(a==3){
	 
	  parent.frames[1].location.href="left_3.html";
	  parent.frames[3].location.href="view_all_library.html?classId=0";
	}
	if(a==4){
	 
	  parent.frames[1].location.href="left_4.html";
	  parent.frames[3].location.href="view_all_activity.html";
	}
	if(a==5){
	  
	  parent.frames[1].location.href="left_5.html";
	  parent.frames[3].location.href="view_all_keyword.html";
	}
	if(a==6){
	
	  parent.frames[1].location.href="left_6.html";
	  parent.frames[3].location.href="view_all_customer.html";
	}
	if(a==7){	
	  
	  parent.frames[1].location.href="left_7.html";
	  parent.frames[3].location.href="view_portal_parameter.html";
	}
}

function selectlink(num){
		
		for(i=1;i<=7;i++){		
			if (i==num){
			    var menulink=document.getElementById("link_0"+i);										
					menulink.setAttribute("className", "aselect"); 
                    menulink.setAttribute("class", "aselect"); 					
			}else{	
			  // alert(i);		
					var menulink=document.getElementById("link_0"+i);					
					menulink.setAttribute("className", "auselect"); //for IE
                    menulink.setAttribute("class", "auselect"); 									
		    }
		}
}
</script>
</head>

<body>
<!--顶部logo-->
<div id="dxlogo_mbg">
<div id="dxlogo_rbg">
<div id="dxlogo_lay">
		<div class="dxlogo"></div>
		<div class="dxflash" style="text-align:center; margin:0 auto;"></div>
	</div>
</div>
</div>

<!--顶部logo结束-->
<!--一级导航菜单开始-->
<div id="dxnav_bg">

<div id="dxmainbg">

	<div id="dxnav_lay">
	  <ul class="ulnav">
       <li class="nav_user"><div class="nav_user_text">管理员：<% User user = (User)session.getAttribute("user"); if(user == null || user.getUserNick().length() == 0){ %>${user.loginName } <% } else { %> ${user.userNick }<% } %></div></li>
        <li class="nav_out"><input type="button" id="map" name="map"   onClick="logout()" class="btn_login_out"/></li>
		<li class="nav_dxyl"><a class="aselect"  id="link_01"  href="javascript:topmenu(1);"  >首页管理</a></li>
		<li class="nav_dxsc"><a class="auselect"  id="link_02" href="javascript:topmenu(2);" >情景签名管理</a></li>
		<li class="nav_dxaq"><a class="auselect"  id="link_03" href="javascript:topmenu(3);" >签名盒管理</a> </li>
		<li class="nav_dxsb"><a class="auselect"  id="link_04" href="javascript:topmenu(4);" >优惠活动管理</a></li>
		<li class="nav_dxwx"><a class="auselect"  id="link_05" href="javascript:topmenu(5);" >内容审核管理</a></li>
		<li class="nav_dxzh"><a class="auselect"  id="link_06" href="javascript:topmenu(6);" >统计管理</a></li>
		<li class="nav_dxjc"><a class="auselect"  id="link_07" href="javascript:topmenu(7);" >系统管理</a></li>
		
	  </ul>
	</div>
</div>

</div>
<!--一级导航菜单开始结束-->
</body>
</html>


