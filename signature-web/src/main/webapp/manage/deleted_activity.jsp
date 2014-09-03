<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有删除活动</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//取消删除
function undeleteActivity(id){
	if(confirm('您确认还原吗？')){
		 window.location.href="undelete_activity.html?activityId="+id; 
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
您的位置：优惠活动管理 -&gt; 回收站管理 -&gt; 已删活动
</div>
<form action="view_all_library.html" name="listform">
<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">已删活动</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="15%">活动名称</th>
        <th width="8%">活动开始时间</th>
        <th width="8%">活动结束时间</th>
        <th width="40%">活动主题</th>
        <th width="10%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="activities" id="activity">
       <tr>
        <td align="center"><s:property value="#activity.id"/></td>
        <td class="list_aselect" align="left"><a title="活动详情" href="<%=request.getContextPath()%>/view_activity_detail.html?activityId=<s:property value='#activity.id'/>" target="_blank" ><s:property value="#activity.name"/></a></td>
        <td align="center"><s:date name="#activity.startTime" format="yyyy-MM-dd"/></td>
        <td class="list_aselect"><s:date name="#activity.endTime" format="yyyy-MM-dd"/></td>
        <td align="left"><s:property value="#activity.theme"/></td>
        <td class="list_aselect">
        	<a href="javascript:undeleteActivity(<s:property value='#activity.id'/>);"  >还原</a> 
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_all_activity.html?'"></s:param>
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
