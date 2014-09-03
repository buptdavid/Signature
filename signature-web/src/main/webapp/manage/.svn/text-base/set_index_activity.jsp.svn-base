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
	var indexUpload = document.getElementById("indexUpload");
	if(indexUpload.value == null || indexUpload.value == ""){
		alert("请选择首页图片");
		return false;
	}
	
	//提交
	document.getElementById("saveform").submit();
}

</script>
</head>
<body>
<div id="postion_nav">
您的位置：优惠活动管理 -&gt; 活动管理 -&gt; 设置首页显示
</div>
<form id="saveform" action="set_index_activity.html" method="post" enctype="multipart/form-data">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    设置首页显示
    </caption>
    <tbody>
    	<s:set value="#request.activity" name="activity"></s:set>
      <tr>
        <td align="right">活动名称</td>
        <td colspan="3" align="left">
        	<s:property value="#activity.name" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">首页图片</td>
        <td colspan="3" align="left">
        	<input id="indexUpload" name="indexUpload" type="file" />
        </td>
      </tr>
       <tr align="right">
        <th colspan="4"></th>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input type="hidden" name="activity.id" value="<s:property value='#activity.id' />" />
        	<input type="button" class="b_tianjia" value="设置" onClick="save()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>