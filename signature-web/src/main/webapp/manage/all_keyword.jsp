<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有关键字</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//删除
function deleteKeyword(id,content){
	if(confirm('您确认删除吗？')){
		 window.location.href="delete_keyword.html?keyword.id="+id+"&keyword.keyWordContent="+content; 
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
您的位置：内容审核管理 -&gt; 敏感词管理 -&gt; 所有敏感词
</div>
<form action="view_all_library.html" name="listform">
<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">所有敏感词</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="25%">敏感词类型</th>
        <th width="25%">敏感词内容</th>
        <th width="15%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="keywords" id="keyword">
       <tr>
        <td align="center"><s:property value="#keyword.id"/></td>
        <td align="center"><s:property value="#keyword.keyWordName"/></td>
        <td align="center"><s:property value="#keyword.keyWordContent"/></td>
        <td class="list_aselect">
        	<a href="view_update_keyword.html?keyword.id=<s:property value='#keyword.id'/>&keyword.keyWordName=<s:property value='#keyword.keyWordName'/>&keyword.keyWordContent=<s:property value='#keyword.keyWordContent'/>"  >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:deleteKeyword(<s:property value='#keyword.id'/>,'<s:property value="#keyword.keyWordContent"/>');"  >删除</a> 
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_all_keyword.html?'"></s:param>
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
