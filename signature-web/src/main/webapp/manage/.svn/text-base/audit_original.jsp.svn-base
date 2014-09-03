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
//删除
function deleteKeyword(id){
	if(confirm('您确认删除吗？')){
		 window.location.href="delete_keyword.html?keyword.id="+id; 
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
<s:set value="#request.auditStatus" name="auditStatus"></s:set>
您的位置：内容审核管理 -&gt; 审核管理 -&gt; <s:if test="#auditStatus == 0">未审核</s:if><s:elseif test="#auditStatus == 1">审核通过</s:elseif><s:else>审核未通过</s:else>
</div>
<form action="view_all_library.html" name="listform">
<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">审核签名</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="40%">签名内容</th>
        <th width="10%">作者</th>
        <th width="8%">是否公开</th>
        <th width="8%">审核状态</th>
        <th width="15%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="originals" id="original">
       <tr>
        <td align="center"><s:property value="#original.id"/></td>
        <td align="left"><s:property value="#original.content"/></td>
        <td align="center"><s:property value="#original.customer.customerName"/></td>
        <td align="center"><s:if test="#original.isPublish == true">是</s:if><s:else>否</s:else> </td>
        <td align="center">
        	<s:if test="#original.auditStatus == 0">未审核</s:if><s:elseif test="#original.auditStatus == 1">审核通过</s:elseif><s:else>审核未通过</s:else>
        </td>
        <td class="list_aselect">
        	<s:if test="#original.auditStatus == 0">
        	<a href="set_audit_status.html?originalId=<s:property value='#original.id'/>&auditStatus=1" >设置通过</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="set_audit_status.html?originalId=<s:property value='#original.id'/>&auditStatus=2" >设置未通过</a>
        	</s:if>
        	<s:elseif test="#original.auditStatus == 1">
        	<a href="set_audit_status.html?originalId=<s:property value='#original.id'/>&auditStatus=2" >设置未通过</a>
        	</s:elseif>
        	<s:else>
        		<a href="set_audit_status.html?originalId=<s:property value='#original.id'/>&auditStatus=1" >设置通过</a>
        	</s:else>
        	
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_audit_original.html?auditStatus='+#auditStatus+'&'"></s:param>
		 </s:include>
        
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
