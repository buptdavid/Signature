<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="postion_nav">
您的位置：签名盒管理 -&gt; 签名管理 -&gt; 修改签名
</div>
<form id="saveform" action="update_library.html" method="post">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    修改签名
    </caption>
    <tbody>
    <div style="color:red;font-size:14px" align="center"> <s:property value="message"/> </div>
       <tr>
        <td align="right" scope="col"><label>选择分类：</label></td>
        <td colspan="3"  align="left" scope="col"> 
       		<select name="classId">
       		<s:set value="#request.classId" name="classId_1"></s:set>
        	<s:iterator  value="classes" id="firstClass">
            	 <option <s:if test="#firstClass.id == #classId_1">selected</s:if> value="<s:property value='#firstClass.id'/>" >&nbsp;<s:property value="#firstClass.name"/></option>
                	<s:iterator value="#firstClass.secondClasses" id="secondClass">
                		<option <s:if test="#secondClass.id == #classId_1">selected</s:if> value="<s:property value='#secondClass.id'/>" >&nbsp;&nbsp;|---&nbsp;<s:property value="#secondClass.name"/></option>
               		</s:iterator>
             </s:iterator>
         	</select>
        </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
       <tr>
        <td align="right" scope="col">
        	<label for="actionForm_dwdepid">签名内容：</label>
        </td>
        <td colspan="3"  align="left" scope="col"> 
        	<textarea name="content" rows="5" cols="50" maxlength="400"><s:property value="#request.content"/>  </textarea>
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
         <input type="hidden" name="libraryId" value="<s:property value='#request.libraryId'/>"/>
         <input type="submit" class="b_tianjia" value="保存" />
         </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>