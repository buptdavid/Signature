<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <META name=Keywords content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
 <META name=description content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
  <script type="text/javascript" src="js/js-i18n.js"></script>
 <script type="text/javascript" src="js/shareJs.js"></script>
 <link href="css/qmstyle.css" rel="stylesheet" type="text/css" />
 <title>情景签名-陕西联通</title>
 <script type="text/javascript">
  function SwitchMenu(obj) 
  {
   if (document.getElementById) 
   {
    var el = document.getElementById(obj);
    var ar = document.getElementById("left_box_bar").getElementsByTagName("span"); 
    if (el.style.display != "block") 
    { 
     for (var i = 0; i < ar.length; i++) 
     {
      if (ar[i].className == "left_box_bar_submenu")
       ar[i].style.display = "none";
     }
     el.style.display = "block";
    }
    else 
    {
     el.style.display = "none";
    }
   }
  }
 </script>
 </head>
 <body  class=bodymain onload="javascript:SwitchMenu('sub<s:property value="#request.signatureClassId"/>');">
<div class="body960center">
   <!-- 顶部页面 -->
   <jsp:include page="header.jsp">
    	<jsp:param value="3" name="index"/>
    </jsp:include>
      
   
   <div class="ad954x95" style="display:none" id="div950x95_hiden"> <img src="images/div950x95.jpg" height="95" width="950"> </div>
   <div class="sub01">
    <div id="leftBlock">
       <div class="qmcenter_mid_left">
        <div class="qmcenter_mid_left1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情景签名分类</div>
        <div class="qmcenter_mid_left2">
           <div id="left_box_bar" class="left">
            
            <s:iterator value="firstClasses" id="firstClass" status="st">            
            <div class="qmcenter_mid_left2_1" onClick="SwitchMenu('sub<s:property value="#firstClass.id"/>')" style="cursor: pointer;"> 
            	<a class="link000" href="original_right.html?firstOrSecond=1&signatureClassId=<s:property value='#firstClass.id'/>&className=<s:property value='#firstClass.name'/>" target="iframepage"><s:property value="#firstClass.name"/></a> 
            </div>
            
            <span class="left_box_bar_submenu" id="sub<s:property value='#firstClass.id'/>" <s:if test="#st.count > 0">style="display:none"</s:if>>
            	<s:iterator value="#firstClass.secondClasses" id="secondClass">
             	  <div>
             	  	<a href="original_right.html?firstOrSecond=2&signatureClassId=<s:property value='#secondClass.id'/>&className=<s:property value='#secondClass.name'/>" class="sn2" target="iframepage"> <s:property value="#secondClass.name"/> </a>
             	  </div>
            	</s:iterator>             
             </span>
             
            </s:iterator>
            
            </div>
         </div>
        <div class="qmcenter_mid_left3"></div>
      </div>
       <div class="qmcenterright12">       
        <iframe    scrolling="no" frameborder="0"  src="original_right.html?firstOrSecond=1&signatureClassId=<s:property value='signatureClassId'/>&className=<s:property value='className'/>"  id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="100%" height="700">
        </iframe>
      </div>
     </div>
  </div>
  
    <!-- 底部页面 -->
	<%@include file="footer.jsp"%>
   <br>
   &nbsp;<br>
 </div>
<div hiding="true" style="position: absolute; display: block; z-index: 9999; top: 175px; left: 1111.5px; opacity: 0.8;"></div>
</body>
</html>