<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript">
//保存
function save(){
	var name = document.getElementById("name");
	if(name.value == null || name.value == ""){
		alert("请输入敏感词类型");
		return;
	}
	
	var content = document.getElementById("content");
	if(content.value == null || content.value == ""){
		alert("请输入敏感词内容");
		return;
	}
	
	//提交
	document.getElementById("saveform").submit();
}

</script>
</head>
<body>
<div id="postion_nav">
您的位置：内容审核管理 -&gt; 敏感词管理 -&gt; 添加敏感词
</div>
<form id="saveform" action="add_keyword.html" method="post">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    添加敏感词
    </caption>
    <tbody>
     <div style="color:red;font-size:14px" align="center"> <s:property value="message"/> </div>
      <tr>
        <td align="right">敏感词类型</td>
        <td colspan="3" align="left">
        	<input type="text" id="name" name="keyword.keyWordName" maxlength="10"/>
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">敏感词内容</td>
        <td colspan="3" align="left">
        	<input type="text" id="content" name="keyword.KeyWordContent" maxlength="50"/>
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input type="button" class="b_tianjia" value="保存" onClick="save()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>