<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript">
function changeClass(model){
   if(model=='0'){
      document.getElementById("selectFirst").style.display='none';
	 }else if (model =='1'){
	   document.getElementById("selectFirst").style.display='';
	}
}

</script>
</head>
<body>
<div id="postion_nav">
您的位置：<s:if test="#request['basis'] == 1">情景签名管理</s:if><s:else>签名盒管理</s:else> -&gt; 分类管理 -&gt; 添加分类
</div>
<form id="saveform" action="add_class.html" method="post">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    添加分类<s:if test="#request['basis'] == 2"><span style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;注：二级分类为签名盒</span></s:if>
    </caption>
    <tbody>
    <div style="color:red;font-size:14px" align="center"> <s:property value="message"/> </div>
      <tr>
        <td align="right" scope="col"><label>选择分类级别：</label></td>
        <td colspan="3"  align="left" scope="col"> 
        <input  type="radio" name="classType" value="0" checked onclick="changeClass(0)" />一级分类&nbsp;&nbsp;&nbsp;&nbsp;
        <input  type="radio" name="classType" value="1" onclick="changeClass(1)" />二级分类
        
        </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
      <tr>
        <td align="right" scope="col"><label>选择一级分类：</label></td>
        <td colspan="3"  align="left" scope="col">
        	<span id="selectFirst" style="display:none;">
        	<select id="parentId" name="parentId" >
        		<s:iterator  value="signatureClasses" id="signatureClass">
                	<option value="<s:property value='#signatureClass.id'/>"><s:property value="#signatureClass.name"/></option>
                </s:iterator>
        	</select>
        	</span>
        </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
       <tr>
        <td align="right" scope="col"><label for="actionForm_dwdepid">分类名称：</label></td>
        <td colspan="3"  align="left" scope="col"> 
        	<input type="text" id="className" name="className" style="width;50px;" maxlength="30" />
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
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