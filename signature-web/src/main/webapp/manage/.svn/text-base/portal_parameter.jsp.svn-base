<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="javascript">

//保存
function save(){
	var re = /^[1-9]\d*$/;
	
	var maxDefaultCount = document.getElementById("maxDefaultCount");
	if(maxDefaultCount.value == null || maxDefaultCount.value == ""){				
		alert("请输入默认签名日设置最大量！");
		maxDefaultCount.focus();
		return false;
	}else if(!re.test(maxDefaultCount.value)){
		alert("必须为正整数--默认签名日设置最大量！");
		maxDefaultCount.focus();
		return false;
	}
	
	var maxPersonalizeCount = document.getElementById("maxPersonalizeCount");
	if(maxPersonalizeCount.value == null || maxPersonalizeCount.value == ""){
		alert("请输入个性化签名设置最大量！");
		maxPersonalizeCount.focus();
		return false;
	}else if(!re.test(maxPersonalizeCount.value)){
		alert("必须为正整数--个性化签名设置最大量！");
		maxPersonalizeCount.focus();
		return false;
	}
	
	var maxNum = document.getElementById("maxNum");
	if(maxNum.value == null || maxNum.value == ""){
		alert("请输入黑白名单设置最大量！");
		maxNum.focus();
		return false;
	}else if(!re.test(maxNum.value)){
		alert("必须为正整数--黑白名单设置最大量！");
		maxNum.focus();
		return false;
	}
	
	var experienceDay = document.getElementById("experienceDay");
	if(experienceDay.value == null || experienceDay.value == ""){
		alert("请输入免费体验天数！");
		experienceDay.focus();
		return false;
	}else if(!re.test(experienceDay.value)){
		alert("必须为正整数--免费体验天数！");
		experienceDay.focus();
		return false;
	}
	
	var maxCountOriginal = document.getElementById("maxCountOriginal");
	if(maxCountOriginal.value == null || maxCountOriginal.value == ""){
		alert("请输入原创签名日创建最大量！");
		maxCountOriginal.focus();
		return false;
	}else if(!re.test(maxCountOriginal.value)){
		alert("必须为正整数--原创签名日创建最大量！");
		maxCountOriginal.focus();
		return false;
	}
	
		
	//提交
	document.getElementById("saveform").submit();
}


</script>
</head>
<body>
<div id="postion_nav">
您的位置：系统管理 -&gt; 系统参数管理 -&gt; 门户参数管理
</div>
<form id="saveform" action="save_portal_parameter.html" method="post" >
 <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
   	门户参数
    </caption>
    <tbody>
      <tr>
        <td align="right">默认签名日设置最大量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="maxDefaultCount" name="portal.maxDefaultCount" value="<s:property value='portal.maxDefaultCount' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">个性化签名设置最大量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="maxPersonalizeCount" name="portal.maxPersonalizeCount" value="<s:property value='portal.maxPersonalizeCount' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">黑白名单设置最大量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="maxNum" name="portal.maxNum" value="<s:property value='portal.maxNum' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">免费体验天数：</td>
        <td colspan="3" align="left">
        	<input type="text" id="experienceDay" name="portal.experienceDay" value="<s:property value='portal.experienceDay' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">原创签名日创建最大量:</td>
        <td colspan="3" align="left">
        	<input type="text" id="maxCountOriginal" name="portal.maxCountOriginal" value="<s:property value='portal.maxCountOriginal' />" />
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input id="id" type="hidden" name="portal.id" value="<s:property value='portal.id' />" />
        	<input type="button" class="b_tianjia" value="保存" onClick="save()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>