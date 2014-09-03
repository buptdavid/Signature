<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META name=Keywords content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
<META name=description content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
<title>签名门户</title>
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<script language="javascript" type="text/javascript">
var $j = jQuery.noConflict();
//原创签名设置默认签名
function setDefaultOriginal(content,originalId){
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

//原创签名设置收藏签名
function saveCollectOriginal(originalId,content,classId){
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

//签名盒设置默认签名
function setDefaultLibrary(content,libraryId){
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

//签名盒签名收藏
function saveCollectLibrary(libraryId,content,classId){
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

//搜索标签切换
function searchTab(searchFlag){
	var searchTab = document.getElementById("search_tab");
	document.getElementById("flag").value = searchFlag;
	searchTab.submit();
}

</script>

</head>
<body class="bodymain">

	<div class="body960center">
		<!-- 顶部页面 -->
		<jsp:include page="header.jsp">
    	<jsp:param value="0" name="index"/>
    </jsp:include>
		
		<!-- 搜索form表单，用于搜索标签切换 -->
		<form id="search_tab" action="search.html" method="post">
			<input id="flag" value="" type="hidden" name="searchFlag">			
			<input value="<s:property value='keyWord'/>" type="hidden" name="keyWord">
		</form>
		
		<div class="body960center">
			<div class="ad954x95" style="display: none" id="div950x95_hiden">
				<img src="nsearch_files/div950x95.jpg" height="95" width="950">
			</div>

			<div class="sub01" style="background-color: #FFFFFF">

				<div id="searchResult">
					<div class="left710px">
						<div class="qmcenter_mid">
							<div class="qmcentertab_a">
								<div id="divMainTab">
									<ul
										style="list-style: none; margin: 0px; padding: 0px; border-collapse: collapse;">
										<li id="li_1" class="${(searchFlag == null || searchFlag == '1')?'selected09':'normal09'}" onclick="searchTab(1)">签名列表</li>
										<li id="li_2" class="${(searchFlag == '2')?'selected09':'normal09'}" onclick="searchTab(2)">签名盒列表</li>
									</ul>
								</div>
								<div class="qmcenter_tj" style="margin-top: 5px;">
									<span class="colora3a3a3">关键字: </span>
									<span class="color14F29400"><s:property value="keyWord" /> </span> 
									<span class="color0167B2">${(searchFlag== null || searchFlag == '1')?'签名内容搜索':'签名盒搜索'}：</span>
									<span class="colora3a3a3">共找到</span> 
									<span class="color14F29400"><s:property value="page.totalCount"/> </span>
									<span class="colora3a3a3">条记录</span>
								</div>
							</div>

							<div class="qmcenterright29">

								<div id="div1" style="display: ${(searchFlag== null || searchFlag == '1')?'block':'none'}">
									<s:iterator value="originals" id="original">
									<div class="mqcentercontlist99">
										<div class="mqcentercontlist2">
											<span id="searchRes_0"><s:property value="#original.content"/> </span>
										</div>
										<div class="mqcentercontlist31">
											<div class="todaytop03_5">
												<a href="javascript:void(0)" class="link0167B2" title="点击把签名设置为我的通用签名"
													onclick="return setDefaultOriginal('<s:property value="#original.content"/>',<s:property value='#original.id'/>);">
													我要用
												</a>
											</div>
											<div class="todaytop03_5">
												<a href="javascript:void(0)" title="点击收藏此签名"	class="link0167B2" onclick="return saveCollectOriginal(<s:property value='#original.id'/>,'<s:property value="#original.content"/>',<s:property value='#original.signatureClass.id'/>);">
													收藏
												</a>
											</div>
										</div>
									</div>
									</s:iterator>
									
									<div class="qmcenter_fy">
										<!-- 分页 -->
										<s:include value="page.jsp">
											<s:param name="pageUrl"
												value="'search.html?searchFlag=1&keyWord='+#request.keyWord+'&'">
											</s:param>
										</s:include>

									</div>
								</div>


								<div id="div2" style="display: ${searchFlag == '2'?'block':'none'}">

									<div class="qmcenterright2_0">
										<div class="qmcenterright2_1_1 color0167B2">
											<strong>编号</strong>
										</div>
										<div class="qmcenterright2_1_3 color0167B2">
											<strong>签名盒</strong>
										</div>
										<div class="qmcenterright2_1_4 color0167B2">
											<strong>签名内容</strong>
										</div>
										<div class="qmcenterright2_1_5 color0167B2">
											<strong>操作栏</strong>
										</div>
									</div>

									<s:iterator value="librarys" id="library">
									<div class="qmcenterright2_1" onmouseover="this.className='qmcenterright2_1_over'" onmouseout="this.className='qmcenterright2_1'">
										<div class="qmcenterright2_1_1">
											<a class="linkblue02" title="点击查看签名盒详情" href="javascript:sAlert('view_library_signature.html?library.id=' +  <s:property value='#library.signatureClass.id'/>, 700, 580,'签名盒详情', 20, 110);">
												<s:property value="#library.id"/>
											</a>
										</div>
										<div class="qmcenterright2_1_3">
											<a class="linkblue02"
												href="javascript:sAlert('view_library_signature.html?library.id=' +  <s:property value='#library.signatureClass.id'/>, 700, 580,'签名盒详情', 20, 110);"
												title='<s:property value="#library.signatureClass.name"/>'>
												<s:property value="#library.signatureClass.name"/>
											</a>
										</div>
										<div class="qmcenterright2_1_4" title="<s:property value='#library.content'/>"><s:property value="#library.content"/> </div>
										<div class="qmcenterright2_1_5">
											<a href="javascript:void(0)" title="点击使用此签名" onclick="return setDefaultLibrary('<s:property value="#library.content"/>',<s:property value='#library.id'/>);">
											<img src="images/qmjh-wyy.gif" alt="点击使用" border="0" height="16" width="16">
											</a> 
											<a href="javascript:void(0)" title="点击收藏此签名" onclick="return saveCollectLibrary(<s:property value='#library.id'/>,'<s:property value="#library.content"/>',<s:property value='#library.signatureClass.id'/>);">
											<img src="images/icon02.gif" alt="点击收藏" border="0" height="16" width="16">
											</a> 
											<a title="点击查看签名盒详情" href="javascript:sAlert('view_library_signature.html?library.id=' +  <s:property value='#library.signatureClass.id'/>, 700, 580,'签名盒详情', 20, 110);">
											<img src="images/icon_21.gif" alt="查看详情" border="0" height="17" width="20">
											</a>
										</div>
									</div>
									</s:iterator>
									<div class="qmcenter_fy">
										<!-- 分页 -->
										<!-- 分页 -->
										<s:include value="page.jsp">
											<s:param name="pageUrl"
												value="'search.html?searchFlag=2&keyWord='+#request.keyWord+'&'">
											</s:param>
										</s:include>

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="qmbox00">
					<div class="qmcentersub05" id="commendSign">
						<div class="qmcentersub05_1">临时功能</div>
						<div class="qmcentersub05_2">
							<div class="qmcentersub05_3">

								<div class="qmcentersub05_4">
									<div class="qmcentersub05_4_2">
										<span id="commendSign_0">愿所有的好梦依偎你，入睡是甜，醒来成真，愿所有的好运笼罩你：日出遇贵，日落见财。</span>
									</div>
								</div>
								<div class="qmcentersub05_4"></div>
								<div class="qmcentersub05_4"></div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- 底部页面 -->
			<%@include file="footer.jsp"%>
			<br>&nbsp;<br>
		</div>
</body>
</html>
</body>
</html>