<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.juicy.signature.service.session.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的签名-陕西联通</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<SCRIPT src="<%=request.getContextPath()%>/js/js-i18n.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/js/shareJs.js" type=text/javascript></SCRIPT>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<SCRIPT type=text/javascript>

	//自定义jQuery的快捷方式，以避免与其它库的冲突
	var $j = jQuery.noConflict();

	//退出登录
	function logout(){
		if(confirm('您确认退出签名门户吗？')){
			//退出请求url
			var url = "logout.html";
			//jQuery AJAX请求
	         $j.post(url,{},function(data,textStatus){
	        	 if(textStatus == "success"){
	        		 var success = data.success;
	        		 if(success == true){
	        			 //退出成功,置Cookie中的islogin为false
	        			 //setCookie("isLogin","false");
	        			//跳转到首页
	        			window.top.location.href = "index.html";
	        		 }else{
	        			 alert("退出失败");
	        			 return;
	        		 }
	        	 }
	        	 
	         },"json");
		}else{
			return;
		}
		
	}
	
	//从其它页面跳转后的iFrame控制
	function homeFresh(){		
	   var reqFrameUrl=getUrlParamValue('frameUrl');
	   var menuId=getUrlParamValue('menuId');
	   if(reqFrameUrl!=null){
	        if(menuId!=null){
	        	clickMenuItem(menuId,10);
	        }
	        window.frames['rightFrame'].location.href = reqFrameUrl;
	        return ;
	   }else{
		   clickMenuItem(1,10);
		   window.frames['rightFrame'].location.href = "list_default.html";
	        return ;
	   }
	  
	}

	//改变菜单样式
	function clickMenuItem(menuItemIndex,maxItemsNum){
	    var obj;
	    //同级下所有菜单，去掉选中样式与隐藏控件
	    for ( var i = 1; i <= maxItemsNum; i++) {
	        obj = getHtmlObj("S_Menu_"+ i);
	        if (obj) {
	            obj.className ="item";
	        }
	    }
	    //对选中的菜单作高亮显示
	        obj = getHtmlObj("S_Menu_" + menuItemIndex);
	        if (obj) {
	            obj.className ="item_over";
	        }
	}
	
	//按id或name获取对应的html对象
	function getHtmlObj(objName) {
	    if (document.getElementById) {
	        return document.getElementById(objName);
	    } else {
	        return document.all.objName;
	    }
	}

</SCRIPT>
</head>

<body class=bodymain onload="javascript:homeFresh();">
<div class="body960center">
   <!-- 顶部页面 -->
   <jsp:include page="header.jsp">
    	<jsp:param value="2" name="index"/>
    </jsp:include>

<div id="main">
	<div id="MyqmLeft">
    	
    <div id="login_tips_left">
				<div id="login_tips_left_top">
					<span class="margin_left">欢迎您:</span><strong><% User user = (User)session.getAttribute("user"); if(user == null || user.getUserNick().length() == 0){ %>${user.loginName } <% } else { %> ${user.userNick }<% } %> </strong>
				</div>
				<div id="login_tips_left_end">
					<span class="margin_left">上次登录：<s:date name="#session.user.lastLoginTime" format="yyyy-MM-dd HH:mm"/></span><br />
					<span class="margin_left">登录次数：${user.loginCount }</span>
				<div class="mycmccqm_left1_2">
					<div onmouseout="this.className='botton_bg'" onmouseover="this.className='botton_bg_over'" class="botton_bg">
					<a class="link000" href="javascript:logout();">退 出</a></div>
	  			</div>
				</div>
	</div>
     
     <div id="S_Menu_1" class="item"><a href="list_default.html" onclick="clickMenuItem(1,10)" target="rightFrame">修改默认签名</a></div>
     <div id="S_Menu_2" class="item"><a href="list_personalized.html" onclick="clickMenuItem(2,10)" target="rightFrame">设置个性化签名</a></div>
     <div id="S_Menu_3" class="item"><a href="my_original.html" onclick="clickMenuItem(3,10)" target="rightFrame">我的原创签名</a></div>
     <div id="S_Menu_4" class="item"><a href="my_collect.html" onclick="clickMenuItem(4,10)" target="rightFrame">管理我的收藏</a></div>
	 <div id="S_Menu_5" class="item"><a href="manage_list.html" onclick="clickMenuItem(5,10)" target="rightFrame">管理黑白名单</a></div>
	 <div id="S_Menu_6" class="item"><a href="manage_refuse.html" onclick="clickMenuItem(6,10)" target="rightFrame">拒接签名设置</a></div>
     <div id="S_Menu_7" class="item"><a href="business.html" onclick="clickMenuItem(7,10)" target="rightFrame">启用|暂停服务</a></div>
     <div id="S_Menu_8" class="item"><a href="my_info.html" onclick="clickMenuItem(8,10)" target="rightFrame">我的个人资料</a></div>
     <div id="S_Menu_9" class="item"><a href="my_password.html" onclick="clickMenuItem(9,10)" target="rightFrame">修改登录密码</a></div>
     <div id="S_Menu_10" class="item"><a href="suggest.html" onclick="clickMenuItem(10,10)" target="rightFrame">我要提意见</a></div>

    
  </div>
    <div id="MyqmRight">
    <IFRAME id=rightFrame class=t_iframe height=960 src="" frameBorder=0 width=755 allowTransparency name=rightFrame scrolling=no></IFRAME>
    </div>

</div>
		<!-- 页面尾部 -->
		<%@include file="footer.jsp"%>
</body>
</html>