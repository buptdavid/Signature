<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一级分类</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//删除
function deleteClass(id,parentId){
	if(confirm('您确认删除吗？')){
		 window.location.href="delete_class.html?classId="+id+"&parentId"+parentId+"&basis="+<s:property value="basis"/>; 
	}else{
		return;
	}
}

</script>
</head>

<body>
<div id="body_top_bg">
	<div id="body_right_bg">
	
	
<div id="postion_nav">
您的位置：<s:if test="#request['basis'] == 1">情景签名管理</s:if><s:else>签名盒管理</s:else> -&gt; 分类管理 -&gt; 所有分类
</div>
<form action="#" method="post" name="listform" id="listform">

<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype"><s:if test="#request['className'] == null">所有一级分类</s:if><s:else><s:property value="#request['className']"/> 所有子类</s:else> </a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="30%">分类名称</th>
        <th width="10%">子类数量</th>
        <th width="10%">所有子类</th>
        <th width="10%"> 操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="signatureClasses" id="signatureClass">
       <tr>
        <td align="center"><s:property value="#signatureClass.id"/></td>
        <td align="center"><s:property value="#signatureClass.name"/></td>
        <td align="center">
        	<s:if test="#signatureClass.secondClasses != null"><s:property value="#signatureClass.secondClasses.size"/></s:if><s:else>0</s:else>
        </td>
        <td class="list_aselect">
        	<s:if test="#signatureClass.parentId == 0 && #signatureClass.secondClasses != null">
        		<a href="view_second_class.html?basis=<s:property value='#request["basis"]'/>&classId=<s:property value='#signatureClass.id'/>&className=<s:property value='#signatureClass.name'/>">查看</a>
        	</s:if>
        </td>
        <td class="list_aselect">
        	<a href="view_update_class.html?basis=<s:property value='#request["basis"]'/>&classId=<s:property value='#signatureClass.id'/>&className=<s:property value='#signatureClass.name'/>&parentId=<s:property value='#signatureClass.parentId'/>"  >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:deleteClass(<s:property value='#signatureClass.id'/>,<s:property value='#signatureClass.parentId'/>);"  >删除</a></td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="6" class="list_aselect">
      	<s:if test="#request['className'] != null">
      		<a href="javascript:history.back()" class="link000">返回</a>
      	</s:if>     
        </td>
    </tr>
    </tfoot>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
</form>
</div>
</div>
</body>
</html>
