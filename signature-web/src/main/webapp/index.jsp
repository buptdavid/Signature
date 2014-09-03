<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.juicy.signature.service.session.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.juicy.signature.persist.po.SignatureClass" %>
<%@ page import="com.juicy.signature.persist.po.Activity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <META name=Keywords content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
 <META name=description content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
<title>签名门户-陕西联通</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-i18n.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shareJs.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/cybanner.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/liucheng.js" charset="utf-8"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js" charset="utf-8"></script>
<script language="javascript" type="text/javascript">
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
	
	//设置默认签名
	function setDefault(content){
		if(content == ''){
			alert('签名内容不能为空！');
			return;
		}		
		if (confirm('您确定使用此签名吗？')) {
			 var url = "check_session.html";		 
			 $j.post(url,{},function(data,textStatus){
	        	 if(textStatus == "success"){
	        		 var success = data.success;
	            	 if(success == true){      
	            			//访问url
	            			var urlSet = "set_default.html";            			
	            			 //jQuery AJAX请求
	            	        $j.post(urlSet,{
	            	       	 content:content
	            	        },function(data,textStatus){
	            	       	 if(textStatus == "success"){
	            	       		 var success = data.success;
	            	           	 var message = data.message;
	            	           	 //无论成功与否,均弹出信息
	            	           	 alert(message);
	            	           	 
	            	       	 }
	            	       	 
	            	        },"json");
	            		 
	            	 }else{
	            		 //转向登录
	            		 login.show("index.html");
	            		 return;
	            	 }
	        	 }
	        	 
	         },"json");		 
		 
		}
	}
	
	
	//收藏签名
	function saveCollect(content){
		if(content == ''){
			alert('收藏内容不能为空！');
			return;
		}
		
		if (confirm('您确定收藏此签名吗？')) {
			var url = "check_session.html";
			 $j.get(url,{},function(data,textStatus){
				 if(textStatus == "success"){
	        	 var success = data.success;
	        	 if(success == true){
	        		 //进行收藏
	        		 var urlSet = "save_collect.html";
	        		 $j.post(urlSet,{
	        			 content:content},function(data,textStatus){
	        				 if(textStatus == "success"){
	            	       		 var success = data.success;
	            	           	 var message = data.message;
	            	           	 //无论成功与否,均弹出信息
	            	           	 alert(message);            	           	 
	            	       	 }        			 
	        		 },"json");
	        		 
	        		 
	        	 }else{
	        		//转向登录
	        		 login.show("index.html");
	        		 return;
	        	 }
				 }
			 },"json");
			
		}
		
	}
	
</script>

<script type="text/javascript">
	//跳转到我的签名
    function linkToMyCenterSubPage(requestUrl){
    	 var url = "check_session.html";
		 $j.post(url,{},function(data,textStatus){
        	 if(textStatus == "success"){
        		 var success = data.success;
            	 if(success == true){
            		 window.top.location.href = requestUrl;
            	 }else{
            		 //登录框显示
            		 login.show(requestUrl);
            	 }
        	 }
        	 
         },"json");    	
    }

</script>
<script type="text/javascript">
function nTabs(thisObj,Num){
if(thisObj.className == "active")return;
var tabObj = thisObj.parentNode.id;
var tabList = document.getElementById(tabObj).getElementsByTagName("li");
for(i=0; i <tabList.length; i++)
{
  if (i == Num)
  {
   thisObj.className = "active"; 
      document.getElementById(tabObj+"_Content"+i).style.display = "block";
  }else{
   tabList[i].className = "normal"; 
   document.getElementById(tabObj+"_Content"+i).style.display = "none";
  }
} 
}
</script>   

    </head>
    <body class="bodymain"><div style="z-index: 999; position: absolute; border-top-width: 2px; border-right-width: 2px; border-bottom-width: 2px; border-left-width: 2px; border-top-style: solid; border-right-style: solid; border-bottom-style: solid; border-left-style: solid; border-top-color: rgb(204, 204, 204); border-right-color: rgb(204, 204, 204); border-bottom-color: rgb(204, 204, 204); border-left-color: rgb(204, 204, 204); opacity: 0.5; top: 415px; width: 956px; height: 52px; left: -9999px; "></div><div class="absolute" style="position: absolute; width: 48px; height: 19px; background-image: url(gd/images/f_replay.gif); cursor: pointer; display: none; left: 1109px; top: 403px; "></div>   


<div class="body960center">
    <!-- 顶部页面 -->
    <jsp:include page="header.jsp">
    	<jsp:param value="1" name="index"/>
    </jsp:include>

<div class="banner01">
    <div class="banner03">
    
  
<div class="banner03_1">
          <div class="banner_new1">
          <div class="banner_new1_1"><a href="javascript:linkToMyCenterSubPage('mine.html?frameUrl=view_personalized.html&menuId=2');">设置推送时间</a></div>
          <div class="banner_new1_1"><a href="javascript:linkToMyCenterSubPage('mine.html?frameUrl=view_personalized.html&menuId=2');">设置特定号码</a></div>
          <div class="banner_new1_1"><a href="javascript:linkToMyCenterSubPage('mine.html?frameUrl=list_default.html&menuId=1');">创作你的签名</a></div>
          <div class="banner_new1_1"><a href="javascript:linkToMyCenterSubPage('mine.html?frameUrl=manage_list.html&menuId=5');">设置黑白名单</a></div>
          <div class="banner_new1_1"><a href="javascript:linkToMyCenterSubPage('mine.html?frameUrl=my_info.html&menuId=8');">修改昵称</a></div>
          </div>
<div class="banner_new2">
<div class="slider_show" id="slider" style="overflow-x: hidden; overflow-y: hidden; position: relative; ">
<div class="contentslider" style="position: relative; width: 3550px; left: -1020px; ">
<% List<Activity> activityList = (List<Activity>)request.getAttribute("activityList"); 
 int num = 0;
if(activityList != null){
	num = activityList.size();
}

 for(int i=0;i<num;i++){ %>
	 <a id="linkl<%=i+1 %>" href="view_activity_detail.html?activityId=<%=activityList.get(i).getId() %>" target="_blank" title="<%=activityList.get(i).getName() %>" style="float: left; ">	
		<img id="img51" src="<%=request.getContextPath()%>/<%=activityList.get(i).getIndexImage() %>" border="0" height="200" width="510">
	</a>
<% } %>

<%for(int i=num;i<5;i++){%>
	<a id="linkl<%=i+1 %>" href="" target="_self" title="敬请期待" style="float: left; "><img id="img52" src="images/02.jpg" border="0" height="200" width="510"></a>	
<% } %>

</div>
<div class="pagination" id="paginate_slider">


<% for(int i=0;i<num;i++){%>
	<a href="view_activity_detail.html?activityId=<%=activityList.get(i).getId() %>"  target="_blank" class=""><%=activityList.get(i).getName() %></a> 	
<%}  %>

<%for(int i=num;i<5;i++){%>
<a href=""  class="">敬请期待</a>
 <% } %>
</div>
<div class="slider_line_l"></div>
<div class="slider_line_r"></div>
</div>
</div>

</div>
      <div id="indexPortletBlock">

 <div class="newlogin">
    
    <div class="newlogin5" style="align:center;">      
       <span style="width:220px;text-align:center;align:center;">
             <% User user = (User)session.getAttribute("user"); if(user == null){ %>
            修改签名，请先&nbsp;&nbsp;<a href="javascript:login.show('index.html');" class=" link0167B2">登录</a>！
            <%} else{ %>
            欢迎您：<% if(user.getUserNick().length() == 0){ %>
            <%=user.getLoginName() %> <%}else{ %>
            <%=user.getUserNick() %>
            <%}%>
            &nbsp;&nbsp;<a href="javascript:logout();">退 出</a>
            <%} %>
       </span>
    </div>

    <div class="newlogin1"> 
        <div class="newlogin1_1" onmouseover="this.className='newlogin1_2'" onmouseout="this.className='newlogin1_1'">
            <a href="javaScript:linkToMyCenterSubPage('mine.html?frameUrl=list_default.html&menuId=1');">
            	<img src="images/newlogin2.gif" >
            </a>
        </div>
    </div>
    
    <div class="newlogin2"> 
        <a href="original.html" class="link0167B2">情景签名</a>　
         <a href="library.html" class="link0167B2">签名地带</a>
        <a href="help.html" class="link0167B2">获取帮助</a>
    </div>
    
    <div class="newlogin3">我要优惠：</div>
    <div class="newlogin4">
    <a href="activity.html" target="_blank" class="link0167B2">优惠活动</a>　|　
    <a href="activity.html" target="_blank" class="link0167B2">优惠活动</a>  |　
    <a href="activity.html" target="_blank" class="link0167B2">优惠活动</a>
    </div>
    <div class="newlogin3">关注我们：<a href="http://weibo.com/2371224587" target="_blank"><img src="images/icon_sina1.gif" alt="手机签名新浪微博" style="vertical-align: middle;" border="0" height="21" width="25"></a> </div> 
</div>

           </div>
    </div>
</div>


<!--玩转签名流程开始-->
<div style="width:960px; float:left;">
<div id="liucheng_cy" style="margin-bottom: 10px; overflow-x: hidden; overflow-y: hidden; position: relative; display: block; height: 56px; "><object data="images/liucheng.jpg" style="width:960px;height:56px;"><param name="quality" value="high"><param name="allowscriptaccess" value="always"><param name="wmode" value="opaque"><param name="swliveconnect" value="true"><param name="flashvars" value="adlink=%23"><param name="type" value="application/x-shockwave-flash"></object><div class="absolute" style="position:absolute;width:19px;height:19px;right:4px;top:4px;background-image:url(gd/images/f_close.gif);cursor:pointer;"></div></div>
<script type="text/javascript">(function(){
var a = AD2, dom = a.DomUtil, evt = a.DomEventUtil;
a.area({
    id: 'liucheng_cy'
})({
    monitor_url: '',
    display: 'fullscreen',
    display_config: {
        delay: 1, // 延迟时间
        duration: 20, // 显示时间
        show_duration: .5,
        hide_duration: .6
    },
    fodder: [{
        type: 'images',
        resource_url: 'images/liucheng.jpg',
        link_to: '#',
        width: 960,
        height: 56,
        cover: false
    }]
});
a.render('liucheng_cy');
a.ping.flush();
})();
</script>
</div>


<div class="sub01">

<div class="left710px" style="height:246px;">
  <!-- 选项卡开始 -->
  <div class="nTab">
    <!-- 标题开始 -->
    <div class="TabTitle">
      <ul id="Tab0">
        <li class="active" onmouseover="nTabs(this,0);">精彩签名</li>
        <!--  <li class="normal" onmouseover="nTabs(this,1);"><a href="" class="link000" target="_blank">签名活动</a></li> -->
      </ul>
          
      </div>
    <!-- 内容开始 -->
    <div class="TabContent">
      <div id="Tab0_Content0">
        <div class="TabContent1_1">
           <div class="TabContent1_1_title">精彩推荐</div>
          <div class="sub03_2" style="margin-top:0px;" id="indexCommendBlock" onmouseout="removeTipsAlert('selectCommedSigninfoTitle')">
	    
	    <s:iterator value="wonderfulList_1" id="wonderful" status="w">
<div class="sub03_2_1">
    <div class="sub03_2_2">
      				<input type="radio" onclick="$('selectCommedSigninfo').value='<s:property value="#wonderful.content" />'" name="radiobutton" value="radiobutton" id="selectCommedSigninfo_<s:property value='#w.index' />">
    </div>
		    <div class="sub03_2_3" onmouseover="showTipsAlertAtFocus('selectCommedSigninfoTitle','签名详细内容',true,false,'<s:property value="#wonderful.content" />',300,0,'selectCommedSigninfo_<s:property value="#w.index" />',100,10);">
		    <s:set name="content" value="#wonderful.content"></s:set>
		    <s:if test="%{#content.length()>22}">
		    	 <s:property value="content.substring(0,22)+'...'" />
		    </s:if>
		    <s:else>
		    	<s:property value="#content" />
		    </s:else>
</div>
		    <span style="display:none" id="selectCommedSigninfo20115">
		    	<s:property value="#wonderful.content" />
		    </span>
    </div>
		</s:iterator>
		
<input type="hidden" id="selectCommedSigninfo">

<div class="sub03_2_4">
	  <a href="javascript:void(0)" title="点击把签名设置为我的通用签名" onclick="if($('selectCommedSigninfo').value==''){alert('请选择您要进行操作的签名！');return false;} setDefault($('selectCommedSigninfo').value);">
    <img src="images/btn01.gif" alt="" width="62" height="22" border="0">
  </a> 
	  <a href="javascript:void(0)" title="点击收藏此签名" onclick="if($('selectCommedSigninfo').value==''){alert('请选择您要进行操作的签名！');return false;} saveCollect($('selectCommedSigninfo').value);">
    <img src="images/btn02.gif" alt="" width="51" height="22" border="0">
  </a> 

</div>

</div>
        </div>
        
        <div class="TabContent1_1">
          <div class="sub03_2" style="margin-top:0px;" id="indexCorpCultureSign" onmouseout="removeTipsAlert('selectCorpCultureTitle')">
		<div class="TabContent1_1_title">热门推荐</div> 
	<s:iterator value="wonderfulList_2" id="wonderful" status="w">
<div class="sub03_2_1">
    <div class="sub03_2_2">
	        <input type="radio" onclick="$('selectCorpCulture').value='<s:property value="#wonderful.content"/>';" name="radiobutton" value="radiobutton" id="selectCorpCulture_<s:property value='#w.index' />">
    </div>
	    <div class="sub03_2_3" onmouseover="showTipsAlertAtFocus('selectCorpCultureTitle','签名详细内容',true,false,'<s:property value="#wonderful.content"/>',300,0,'selectCorpCulture_<s:property value="#w.index" />',100,10);">
	    	<s:set name="content" value="#wonderful.content"></s:set>
		    <s:if test="%{#content.length()>22}">
		    	 <s:property value="content.substring(0,22)+'...'" />
		    </s:if>
		    <s:else>
		    	<s:property value="#content" />
		    </s:else>
</div>
	        <span style="display:none" id="selectCorpCulture877"><s:property value="#wonderful.content"/></span>
    </div>
	</s:iterator>
	
<input type="hidden" id="selectCorpCulture">

<div class="sub03_2_4">
	  <a href="javascript:void(0)" title="点击把签名设置为我的通用签名" onclick="if($('selectCorpCulture').value==''){alert('请选择您要进行操作的签名！');return false;} setDefault($('selectCorpCulture').value);">
    <img src="images/btn01.gif" alt="" width="62" height="22" border="0">
  </a> 
	  <a href="javascript:void(0)" title="点击收藏此签名" onclick="if($('selectCorpCulture').value==''){alert('请选择您要进行操作的签名！');return false;} saveCollect($('selectCorpCulture').value);">
    <img src="images/btn02.gif" alt="" width="51" height="22" border="0">
  </a> 

</div>

</div>
        </div>
      </div>
  
        </div>
        </div>
  <!-- 选项卡结束 -->
</div>


  
  <div class="sub05">
      <div class="sub05_1">热门话题</div>
      <div class="sub05_2">
      <div class="newtags">
      		<% List<SignatureClass> classList = (List<SignatureClass>)request.getAttribute("classList"); 
      			int size = classList.size();
      		%>
      	  <%if(size >= 1 && classList.get(0) != null){ %>
          <div class="newtags1" style=" left: 0px; top: 150px; width:50px;"><a title="<%=classList.get(0).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(0).getId() %>&className=<%=classList.get(0).getName() %>" class="linkfff"><%=classList.get(0).getName() %></a></div>
          <%}if(size >= 2 && classList.get(1) != null){%>
          <div class="newtags2" style="left: 35px; top: 0px; width:50px;"><a title="<%=classList.get(1).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(1).getId() %>&className=<%=classList.get(1).getName() %>" class="linkfff"><%=classList.get(1).getName() %></a></div>
          <%}if(size >= 3 && classList.get(2) != null){%>
          <div class="newtags3" style="left: 160px; top: 10px; width:50px;"><a title="<%=classList.get(2).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(2).getId() %>&className=<%=classList.get(2).getName() %>" class="linkfff"><%=classList.get(2).getName() %></a></div>
          <%}if(size >= 4 && classList.get(3) != null){%>
          <div class="newtags4" style=" left: 10px; top: 35px; width:50px; "><a title="<%=classList.get(3).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(3).getId() %>&className=<%=classList.get(3).getName() %>" class="linkfff"><%=classList.get(3).getName() %></a></div>
          <%}if(size >= 5 && classList.get(4) != null){%>
          <div class="newtags5" style=" left: 110px; top: 45px; width:50px;"><a title="<%=classList.get(4).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(4).getId() %>&className=<%=classList.get(4).getName() %>" class="linkfff"><%=classList.get(4).getName() %></a></div>
          <%}if(size >= 6 && classList.get(5) != null){%>
          <div class="newtags6" style="left: 150px; top: 85px; width:50px;"><a title="<%=classList.get(5).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(5).getId() %>&className=<%=classList.get(5).getName() %>" class="linkfff"><%=classList.get(5).getName() %></a></div>
          <%}if(size >= 7 && classList.get(6) != null){%>
          <div class="newtags7" style="left: 40px; top: 65px; width:50px;"><a title="<%=classList.get(6).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(6).getId() %>&className=<%=classList.get(6).getName() %>" class="linkfff"><%=classList.get(6).getName() %></a></div>
          <%}if(size >= 8 && classList.get(7) != null){%>
          <div class="newtags8" style="left: 140px; top: 120px; width:50px;"><a title="<%=classList.get(7).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(7).getId() %>&className=<%=classList.get(7).getName() %>" class="linkfff"><%=classList.get(7).getName() %></a></div>
            <%}if(size >= 9 && classList.get(8) != null){%>
            <div class="newtags1" style="left: 75px; top: 100px; width:50px;height:20px;font-size:14px;">
      			<a title="<%=classList.get(8).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(8).getId() %>&className=<%=classList.get(8).getName() %>" class="linkfff"><%=classList.get(8).getName() %></a> 
            </div>
            <%}if(size >= 10 && classList.get(9) != null){%>            
           <div class="newtags3" style="left: 2px; top: 105px; width:60px;height:25px;font-size:14px;line-height:20px;">
           		<a title="<%=classList.get(9).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(9).getId() %>&className=<%=classList.get(9).getName() %>" class="linkfff"><%=classList.get(9).getName() %></a>
            </div>  
            <%}if(size >= 11 && classList.get(10) != null){%>
            <div class="newtags5" style="left: 105px; top: 160px;height:25px;font-size:16px;line-height:25px;">
            	<a title="<%=classList.get(10).getName() %>" target="_blank" href="original.html?signatureClassId=<%=classList.get(10).getId() %>&className=<%=classList.get(10).getName() %>" class="linkfff"><%=classList.get(10).getName() %></a></div>
      </div>
            <%}%>
      </div>

   </div> 
   
</div>
<div class="ad954x95" style="display:none" id="div950x95_hiden">
      <img src="images/div950x95.jpg" width="950" height="95">
    </div>

<div class="sub01">

    <div class="left710px">
        <div id="indexSceneBlock" onmouseout="removeTipsAlert('selectSceneSignTitle')">        <div class="qj01">
            <div class="qj01_1">情景签名推荐</div>
            <div class="qj01_2">
                         
              
            </break></break></break></break></break></break></break></div>
            <div class="qj01_3"><a href="original.html" target="_blank" class="linkFBFBFB">更多...</a></div>
        </div>
        
        <div class="qj02">
        	<s:iterator value="originalList" id="original" status="o">
            <div class="qj02_2_1">
               <div class="qj02_2_2" id="selectSceneSign_<s:property value='#o.index'/>">
                  <input type="radio" onclick="$('selectSceneSign').value='<s:property value="#original.content"/>';" name="radiobutton" value="radiobutton">
               </div>
               <div class="qj02_2_3" onmouseover="showTipsAlertAtFocus('selectSceneSignTitle','签名详细内容',true,false,'<s:property value="#original.content"/>',300,0,'selectSceneSign_<s:property value="#o.index"/>',300,10);">
               		<s:set name="content" value="#original.content"></s:set>
					    <s:if test="%{#content.length()>37}">
					    	 <s:property value="content.substring(0,37)+'...'" />
					    </s:if>
					    <s:else>
					    	<s:property value="#content" />
					 </s:else>
            </div>
               <div class="qj02_2_4"><s:date name="#original.time" format="yyyy-MM-dd HH:mm"/></div>
                <span style="display:none" id="selectSceneSign1928"><s:property value="#original.content"/></span>
             </div>
            </s:iterator>
            <input type="hidden" id="selectSceneSign">
            <div class="qj02_2_5">
                  <a href="javascript:void(0)" title="点击把签名设置为我的通用签名" onclick="if($('selectSceneSign').value==''){alert('请选择您要进行操作的签名！');return false;} setDefault($('selectSceneSign').value);">
                    <img src="images/btn01.gif" alt="" width="62" height="22" border="0">
                  </a> 
                  <a href="javascript:void(0)" title="点击收藏此签名" onclick="if($('selectSceneSign').value==''){alert('请选择您要进行操作的签名！');return false;} saveCollect($('selectSceneSign').value);">
                    <img src="images/btn02.gif" alt="" width="51" height="22" border="0">
                  </a> 

            </div>
        </div>
        <div class="qj03"></div></div>
        <div id="indexTopListBlock" onmouseout="removeTipsAlert('indexToplistTitle')">         <div class="qj01">
          <div class="qj01_1">&nbsp;&nbsp;今日排行榜</div>
          <div class="todaytop02">
          </div>
        </div>
        
        <div class="qj02">
        
        <s:iterator value="originalRankList" id="original" status="o">
        <div class="todaytop03_1">
                    <div class="todaytop03_2">
                        <img id="indexTopListImg_<s:property value='#o.index'/>" src="images/num_01.gif">
                    </div>
                    <div class="todaytop03_3" width="550px" onmouseover="showTipsAlertAtFocus('indexToplistTitle','签名详细内容',true,false,'<s:property value="#original.content"/>',300,0,'indexTopListImg_<s:property value="#o.index"/>',300,10);">
                    	<s:set name="content" value="#original.content"></s:set>
					    <s:if test="%{#content.length()>40}">
					    	 <s:property value="content.substring(0,40)+'...'" />
					    </s:if>
					    <s:else>
					    	<s:property value="#content" />
					    </s:else>
                    </div>
                     <span style="display:none" id="toplist_<s:property value='#o.index'/>"><s:property value="#original.content"/></span>
                    <div class="todaytop03_5">
                        <a href="javascript:void(0)">
                            <img src="images/btn01.gif" title="点击把签名设置为我的通用签名" onclick="setDefault($('toplist_<s:property value="#o.index"/>').textContent)" alt="我要用" width="62" height="22" border="0"></a></div>
                    <div class="todaytop03_5">
                        <a href="javascript:void(0)" title="点击收藏此签名" onclick="saveCollect($('toplist_<s:property value="#o.index"/>').textContent)">
                            <img src="images/btn02.gif" border="0"></a> 
                    </div>
                  
        </div>
        </s:iterator>
                  
        </div>
        <div class="qj03"></div></div>
    </div>

    <div style="float:left; width: 240px">
        <div class="qmbox00">
            <div id="commendSignpack" style="margin-top:5px">
<div class="qmcentersub05_1">推荐签名盒</div>
<div class="qmcentersub05_2">      
       <div class="qmbox03">
       		<s:iterator value="libraryList" id="library" status="l">
            <div class="qmbox03_1">
              <div class="qmbox03_1_2">
                <span id="qmbox03_1_2_hot">&nbsp;</span>
                <span class="color14F29400" style="cursor:hand;" onclick="">
                  [<s:property value="#library.signatureClass.name"/>]
                  </span>
                <span title="<s:property value='#library.content' />">
                	<s:set name="content" value="#library.content"></s:set>
				    <s:if test="%{#content.length()>40}">
				    	 <s:property value="content.substring(0,40)+'...'" />
				    </s:if>
				    <s:else>
				    	<s:property value="#content" />
				    </s:else>
                  </span>
                <a title="点击使用此签名" href="javascript:void(0)" onclick="setDefault('<s:property value="#library.content" />')">
                  <img src="images/qmjh-wyy.gif" width="16" height="16" border="0"></a>
                <a title="点击收藏此签名" href="javascript:void(0)" onclick="saveCollect('<s:property value="#library.content" />')">
                  <img src="images/icon02.gif" width="16" height="16" border="0"></a>
              </div>
            </div>
            </s:iterator>
              </div>
</div>       </div>
        </div>
        
        <div class="qmbox00">
            <div class="qmbox01">
                <div class="qmbox01_2">最新提交签名</div>
            </div>
            <div class="qmbox02">
              <div class="qmbox03">
                  <div id="scrollWrap">
                    <div id="scrollMsg">
                        <div id="indexLatestBlock">
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
            
            <s:iterator value="newOriginalList" id="original" status="o">
            <div class="newqm03_1">
            <div class="newqm03_1_1"><img src="images/jiantou.gif"></div>
            <div class="newqm03_1_2"><s:property value="%{#o.index+1}" />. <span id="index_late_<s:property value='#o.index' />"><s:property value="#original.content" /> </span>
                <a title="点击把签名设置为我的通用签名" href="javascript:void(0)" onclick="setDefault($j('#index_late_<s:property value="#o.index" />').text())"><img src="images/qmjh-wyy.gif" alt="点击使用" width="16" height="16" border="0"></a>&nbsp;&nbsp;
                <a title="点击收藏此签名" href="javascript:void(0)" onclick="saveCollect($j('#index_late_<s:property value="#o.index" />').text())"><img src="images/icon02.gif" alt="点击收藏" width="16" height="16" border="0"></a> &nbsp;&nbsp;
            </div> 
            </div>
            </s:iterator>
              
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
            <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
                        <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div>
                        <div class="newqm03_1">
            <div class="newqm03_1_1">&nbsp;&nbsp;</div>
            <div class="newqm03_1_2">&nbsp;&nbsp;</div> 
            </div></div>
                    </div>
                  <div id="scrollMsg">
                        <div id="indexLatestBlock"></div>
                    </div></div>
              </div>
            </div>
        </div>
    </div>
    

</div><script type="text/javascript"> 
try{ 
     var isStoped = false; 
     var oScroll = document.getElementById("scrollWrap"); 
     with(oScroll){ 
     noWrap = true; 
 } 
 
     oScroll.onmouseover = new Function('isStoped = true'); 
     oScroll.onmouseout = new Function('isStoped = false'); 
     
     var preTop = 0; 
     var curTop = 0; 
     var stopTime = 0; 
     var oScrollMsg = document.getElementById("scrollMsg");
     
     oScroll.appendChild(oScrollMsg.cloneNode(true)); 
     init_srolltext(); 
}catch(e) {} 
 
function init_srolltext(){ 
     oScroll.scrollTop = 0; 
     setInterval('scrollUp()', 50); 
} 
 
function scrollUp(){ 
     if(isStoped) return; 
     curTop += 1; 
     if(curTop == 300) { 
     stopTime += 1; 
     curTop -= 1; 
     if(stopTime == 1) { 
     curTop = 0; 
     stopTime = 0; 
     } 
     }else{ 
     preTop = oScroll.scrollTop; 
     oScroll.scrollTop += 1; 
     if(preTop == oScroll.scrollTop){ 
     oScroll.scrollTop = 0; 
     oScroll.scrollTop += 1; 
     } 
     } 
} 
</script>

    <!-- 底部页面 -->
	<%@include file="footer.jsp"%>
    <br>&nbsp;<br>
</div>

<!--中间flash—banner-->
<script type="text/javascript">
CYPIC.ui.SlideView("slider", {effect: 'scrollx', navWrapper:"paginate_slider", navClassOn:'selected'});
</script>

</body></html>