<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>

<title>无标题文档</title>
<script type="text/javascript">
//启动业务
function doMyRestart() {
    if(confirm('您确认启动签名业务吗？')) {
    	document.businessForm.action = "restart.html"
    	document.businessForm.submit();       
    }   
}

//暂停业务
function doMyPause() {
    if(confirm('您确认暂停签名业务吗？')) {
    	document.businessForm.action = "pause.html"
    	document.businessForm.submit();       
    }
}
</script>
</head>

<body>
<div id="RightMain_top"><span class="margin_left">启用暂停服务</span></div>

<div id="RightMain_end">

<form action="" name="businessForm"  method="POST">
  <div class="mycmccqm_right2">   
    <div class="rightsub2_0" style="margin-top:30px; margin-left:20px; width:300px; padding-bottom:30px; padding-left:30px;"> 
    	<div style="color:red;font-size:14px" align="center"><s:property value="message"/> </div>
	  <div style="float:left; width:280px; margin-bottom:15px; margin-top:15px;" ><strong>当前业务状态：</strong>  <span class="color14F29400"> <%Integer customerStat = (Integer)request.getAttribute("customerStat"); if(customerStat==null || customerStat>7){ %>尚未通过短信开通,&nbsp;&nbsp;<a href="help.html" target="_blank">开通帮助</a> <%}else if(customerStat.equals(1)){ %>正常使用<%}else if(customerStat.equals(3)){ %>已暂停<%} else if(customerStat.equals(2)){ %>已退订<%} else if(customerStat.equals(4)){ %>有效期已过<%} else if(customerStat.equals(6)){ %>免费体验<%} else if(customerStat.equals(7)){ %>免费体验结束<%} %> <strong>&nbsp;</strong></span></div> 
	  <% if(customerStat != null){ if(customerStat.equals(3)){%>
	  <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:doMyRestart()" class="link000">启用业务</a></div> 
	  <% }if(customerStat.equals(1)){ %>
	  <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:doMyPause()" class="link000">暂停业务</a></div> 
	  <% }}%>
	</div> 
   </div> 
</form>
</div> 
