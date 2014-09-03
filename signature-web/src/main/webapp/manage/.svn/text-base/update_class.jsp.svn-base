<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript">

</script>
</head>
<body>
<div id="postion_nav">
您的位置：<s:if test="#request['basis'] == 1">情景签名管理</s:if><s:else>签名盒管理</s:else> -&gt; 分类管理 -&gt; 修改分类
</div>
<form name="updateform" action="update_class.html" method="post"">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    修改分类
    </caption>
    <tbody>
      <tr>
        <td align="right" scope="col"><label>分类级别：</label></td>
        <td colspan="3"  align="left" scope="col"> 
        <s:if test="#request.parentId == 0">
        一级分类
        <input type="hidden" name="classType" value="0"/>
        </s:if>
        <s:else>
        二级分类
        <input type="hidden" name="classType" value="1"/>
        </s:else> 
        </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
      <tr>
        <td align="right" scope="col"><label>选择一级分类：</label></td>
        <td colspan="3"  align="left" scope="col">
        	<!-- 首先要赋值，才能在下面进行比较 -->
        	<s:set value="#request.parentId" name="parent"></s:set>
        	<s:if test="#parent != 0">
        	<select id="id" name="parentId">
        		<s:iterator  value="signatureClasses" id="signatureClass">
                	<option value="<s:property value='#signatureClass.id'/>" <s:if test="#signatureClass.id == #parent">selected</s:if> ><s:property value="#signatureClass.name"/></option>
                </s:iterator>
        	</select>
        	</s:if>
        </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
       <tr>
        <td align="right" scope="col"><label for="actionForm_dwdepid">分类名称：</label></td>
        <td colspan="3"  align="left" scope="col"> 
        	<input type="text" name="className"  style="width;50px;" maxlength="30" value="<s:property value='#request.className'/>" />
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        <input type="hidden" name="classId" value="<s:property value='#request.classId'/>"/>
        <input type="hidden" name="basis" value="<s:property value='#request.basis'/>"/>
        <input type="submit" class="b_tianjia" value="保存" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>