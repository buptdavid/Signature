<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
</head>
<body onload="loadTxLisnter('signContext');">
<div id="postion_nav">
您的位置：签名盒管理 -&gt; 签名管理 -&gt; 添加签名
</div>
<form id="saveform" action="add_library.html" method="post">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    添加签名
    </caption>
    <tbody>
    <div style="color:red;font-size:14px" align="center"> <s:property value="message"/> </div>
       <tr>
        <td align="right" scope="col"><label>选择分类：</label></td>
        <td colspan="3"  align="left" scope="col"> 
       		<select name="classId">
        	<s:iterator  value="classes" id="firstClass">
            	 <option value="<s:property value='#firstClass.id'/>" >&nbsp;<s:property value="#firstClass.name"/></option>
                	<s:iterator value="#firstClass.secondClasses" id="secondClass">
                		<option value="<s:property value='#secondClass.id'/>" >&nbsp;&nbsp;|---&nbsp;<s:property value="#secondClass.name"/></option>
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
        	<textarea id="signContext" name="content" rows="5" cols="40" maxlength="70" ></textarea>
        	 <span class="color14F29400_2"> *</span>        &nbsp;<span id="cur_num">0</span> / <span id="max_num">70</span>
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
         <input type="submit" class="b_tianjia" value="保存" />
         </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>