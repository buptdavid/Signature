<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>原创签名</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//推荐
function recommend(id){
	if(confirm('您确认推荐首页吗？')){
		 window.location.href="recommend_original.html?originalId="+id; 
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
您的位置：情景签名管理 -&gt; 签名管理 -&gt; 原创签名
</div>
<form action="view_all_original.html" name="originalForm">

<div class="content">
	 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
	 <thead>
	    </thead>
	<tbody>
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">筛选</td>
		  <td align="left" class="list_aselect"><label for="select"></label>
		    选择分类：
		    <select name="classId">
		    <s:set value="#request.classId" name="classId_1"></s:set>
		    <option value="0">&nbsp;全部分类</option>
        	<s:iterator  value="classes" id="firstClass">
            	 <option value="<s:property value='#firstClass.id'/>" <s:if test="#firstClass.id == #classId_1">selected</s:if> >&nbsp;<s:property value="#firstClass.name"/></option>
                	<s:iterator value="#firstClass.secondClasses" id="secondClass">
                		<option value="<s:property value='#secondClass.id'/>" <s:if test="#secondClass.id == #classId_1">selected</s:if> >&nbsp;&nbsp;|---&nbsp;<s:property value="#secondClass.name"/></option>
               		</s:iterator>
             </s:iterator>
         	</select>
		    &nbsp;&nbsp;
		    <input name="Submit2" type="submit" class="b_chaxun" value="查询" /></td>
	
		  </tr>
	  </tbody>
	  <tfoot>
	    </tfoot>
	</table>
</div>
</form>
<div class="content">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">原创签名</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="50%">签名内容</th>
        <th width="10%">审核状态</th>
        <th width="10%">类别</th>
        <th width="15%">作者号码</th>
         <th width="10%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="originals" id="original">
       <tr>
        <td align="center"><s:property value="#original.id"/></td>
        <td align="left"><s:property value="#original.content"/></td>
        <td align="left">
        	<s:if test="#original.auditStatus == 0">
           		正在审核
           </s:if>
           <s:elseif test="#original.auditStatus == 1">
           		审核通过
           </s:elseif>
           <s:elseif test="#original.auditStatus == 2">
           		审核未通过
           </s:elseif>      
        </td>
        <td align="center"><s:property value="#original.signatureClass.name"/></td>
        <td class="list_aselect"><s:property value="#original.customer.customerName"/> </td>
         <td class="list_aselect">
         	<s:if test="#original.auditStatus == 1 && #original.recommend == false"> <a href="javascript:recommend(<s:property value='#original.id'/>);"  >推荐首页</a> </s:if> 
         </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="6">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_all_original.html?classId='+#request.classId+'&'"></s:param>
		 </s:include>
        
        </td>
    </tr>
    </tfoot>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>

</div>
</div>
</body>
</html>
