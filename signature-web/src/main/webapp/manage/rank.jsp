<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>排行榜管理</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//删除
function deleteRank(id){
	if(confirm('您确认更新吗？')){
		 window.location.href="delete_rank.html?rankId="+id; 
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
您的位置：首页管理 -&gt; 排行榜管理 -&gt; 排行榜
</div>
<form action="#" method="post" name="listform" id="listform">

<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable" >
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">排行榜</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="50%">签名内容</th>
        <th width="10%">所属一级类别</th>
        <th width="10%">所属二级类别</th>
        <th width="10%"> 操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="originalRanks" id="originalRank">
       <tr>
        <td align="center"><s:property value="#originalRank.id"/></td>
        <td align="left"><s:property value="#originalRank.content"/></td>
        <td align="left"><s:property value="#originalRank.parentName"/></td>
        <td align="center"><s:property value="#originalRank.className"/></td>
        <td class="list_aselect"><a href="javascript:deleteRank(<s:property value='#originalRank.id'/>);"  >更新所有</a></td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="6">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_rank.html?'"></s:param>
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
