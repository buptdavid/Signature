<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script language="javascript">

//保存
function saveDefault(){
	
	var content = document.getElementById("content");
	if(content.value == null || content.value == ""){
		alert("请输入默认签名！");
		content.focus();
		return;
	}
	
	//提交
	document.getElementById("saveform").submit();
}


</script>
</head>
<body onload="loadTxLisnter('content');">
<div id="postion_nav">
您的位置：系统管理 -&gt; 系统参数管理 -&gt; 默认签名管理
</div>
<form id="saveform" action="save_default_content.html" method="post" >
 <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
   	默认签名
    </caption>
    <tbody>
    <tr>
        <td align="right" scope="col">
        	<label for="actionForm_dwdepid">系统默认签名：</label>
        </td>
        <td colspan="3"  align="left" scope="col"> 
        	<textarea id="content" name="defaultContent.defcontent" rows="5" cols="40" maxlength="70" ><s:property value='defaultContent.defcontent' /></textarea>
        	 <span class="color14F29400_2"> *</span>&nbsp;<span id="cur_num">0</span> / <span id="max_num">70</span>
        </td>
      </tr>
    
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input id="id" type="hidden" name="defaultContent.id" value="<s:property value='defaultContent.id' />" />
        	<input type="button" class="b_tianjia" value="保存" onClick="saveDefault()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>