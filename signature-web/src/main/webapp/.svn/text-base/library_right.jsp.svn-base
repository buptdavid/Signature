<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Keywords" content="">
<meta name="description" content="">
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js-i18n.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<title>情景签名</title>
<script type="text/javascript">
var $j = jQuery.noConflict();
//设置默认签名
function setDefault(content,libraryId){
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
            	       	 libraryId:libraryId
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
function saveCollect(libraryId,content,classId){
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
        			 libraryId:libraryId,
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
    <s:property value="className"/> 
    </div>
        <div class="qmcenterright2">
          <div class="qmcenterright2_0">
            <div class="qmcenterright2_1_1 color0167B2"><strong>编号</strong></div>
            <div class="qmcenterright2_1_2 color0167B2"><strong>分类</strong></div>
            <div class="qmcenterright2_1_4 color0167B2"><strong>签名</strong></div>
            <div class="qmcenterright2_1_5 color0167B2"><strong>操作栏</strong></div>
          </div>
          
          <s:iterator value="librarys" id="library" status="st">
          <div class="qmcenterright2_1" onmouseover="this.className='qmcenterright2_1_over'" onmouseout="this.className='qmcenterright2_1'">
            <div class="qmcenterright2_1_1">
              		<s:property value="#library.id"/>
            </div>
            <div class="qmcenterright2_1_3">
                  <s:property value="#library.signatureClass.name"/>
              </div>
               <div class="qmcenterright2_1_4" title="<s:property value='#library.content'/>"><s:property value="#library.content"/> </div>
              <div class="qmcenterright2_1_5">
                <a href="javascript:void(0)" title="点击使用此签名" onclick="return setDefault('<s:property value="#library.content"/>',<s:property value='#library.id'/>);"><img src="images/qmjh-wyy.gif" alt="点击使用" border="0" height="16" width="16"></a>
                &nbsp; &nbsp; 
                <a href="javascript:void(0)" title="点击收藏此签名" onclick="return saveCollect(<s:property value='#library.id'/>,'<s:property value="#library.content"/>',<s:property value='#library.signatureClass.id'/>);"><img src="images/icon02.gif" alt="点击收藏" border="0" height="16" width="16"></a> 
              </div>            
          </div>
          </s:iterator>
           
          <div class="qmcenter_fy">
             <!-- 分页 -->
	    	<s:include value="page.jsp">        	
				<s:param name="pageUrl" value="'library_right.html?firstOrSecond='+#request.firstOrSecond+'&signatureClassId='+#request.signatureClassId+'&className='+#request.className+'&'"></s:param>
			</s:include>
         </div> 
      </div></div>
</div>
<br>&nbsp;<br>
</div>


<div hiding="true" style="position: absolute; display: block; z-index: 9999; top: 175px; left: 1111.5px; opacity: 0.8;">
</div>
</body>
</html>