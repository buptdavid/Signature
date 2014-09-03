<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-i18n.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shareJs.js"></script>
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<title>情景签名</title>
<script type="text/javascript">
//自定义jQuery的快捷方式，以避免与其它库的冲突
var $j = jQuery.noConflict();

//设置默认签名
function setDefault(content,originalId){
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
            	       	 content:content,
            	       	 originalId:originalId
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
            		 login.show();
            		 return;
            	 }
        	 }
        	 
         },"json");		 
	 
	}
}

//收藏签名
function saveCollect(originalId,content,classId){
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
        			 originalId:originalId,
        			 content:content,
        			 classId:classId},function(data,textStatus){
        				 if(textStatus == "success"){
            	       		 var success = data.success;
            	           	 var message = data.message;
            	           	 //无论成功与否,均弹出信息
            	           	 alert(message);            	           	 
            	       	 }        			 
        		 },"json");
        		 
        		 
        	 }else{
        		//转向登录
        		 login.show();
        		 return;
        	 }
			 }
		 },"json");
		
	}
	
}
 
 </script>
    </head>
    <body>   
<div class="body960center">

<div class="ad954x95" style="display:none" id="div950x95_hiden">
        <img src="images/div950x95.jpg" height="95" width="950">
    </div>

<div id="page_div" class="sub01">
    <div id="leftBlock"><div class="qmcenterright1"><img src="images/jiantou.gif" height="7" width="4"> 
          <s:property value="className"/> </div>
        <div class="qmcenterright2">
    <s:iterator value="originals" id="original">    
    <div class="mqcentercontlist" onmouseover="this.className='mqcentercontlist_over'" onmouseout="this.className='mqcentercontlist'">
        <div class="mqcentercontlist2"><img src="images/bg_01_1.gif" alt=""> <span id="scene_0"> <s:property value="#original.content"/> </span></div>
        <div class="mqcentercontlist3">        	
              <a href="javascript:void(0)" class="link0167B2" title="点击把签名设置为我的通用签名" onclick="return setDefault('<s:property value="#original.content"/>',<s:property value='#original.id'/>);">
			  我要用</a>　
            
               <a href="javascript:void(0)" title="点击收藏此签名" class="link0167B2" onclick="return saveCollect(<s:property value='#original.id'/>,'<s:property value="#original.content"/>',<s:property value='#original.signatureClass.id'/>);">
			   收藏</a>　

 		</div>
	</div>
	</s:iterator>

    <div class="qmcenter_fy">
		<!-- 分页 -->
    	<s:include value="page.jsp">        	
			<s:param name="pageUrl" value="'original_right.html?firstOrSecond='+#request.firstOrSecond+'&signatureClassId='+#request.signatureClassId+'&className='+#request.className+'&'">
			</s:param>
		</s:include>	 
    </div> 
 	</div>
 </div>
</div>
<br>&nbsp;<br>
</div>

<div hiding="true" style="position: absolute; display: block; z-index: 9999; top: 175px; left: 1111.5px; opacity: 0.8;"></div>
</body>
</html>