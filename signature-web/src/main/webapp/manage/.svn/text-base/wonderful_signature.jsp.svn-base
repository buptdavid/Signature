<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精彩签名</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//删除
function deleteWonderful(id){
	if(confirm('您确认取消推荐吗？')){
		 window.location.href="delete_wonderful.html?libraryId="+id; 
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
您的位置：首页管理 -&gt; 精彩签名管理 -&gt; 精彩签名
</div>
<form action="#" method="post" name="listform" id="listform">

<div class="content">
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable" >
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">精彩签名</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">推荐编号</th>
        <th width="50%">签名内容</th>
        <th width="10%">所属一级类别</th>
        <th width="10%">所属二级类别</th>
        <th width="10%"> 推荐时间</th>
        <th width="10%"> 操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="libraries" id="library">
       <tr>
        <td align="center"><s:property value="#library.id"/></td>
        <td align="left"><s:property value="#library.content"/></td>
        <td align="left"><s:property value="#library.parentName"/></td>
        <td align="center"><s:property value="#library.className"/></td>
        <td align="center"><s:date name="#library.time" format="yyyy-MM-dd HH:mm"/></td>
        <td class="list_aselect"><a href="javascript:deleteWonderful(<s:property value='#library.id'/>);">取消推荐</a></td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="6">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_wonderful.html?'"></s:param>
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
