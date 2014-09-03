<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有活动</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//删除
function deleteActivity(id){
	if(confirm('您确认删除到回收站吗？')){
		 window.location.href="delete_activity.html?activityId="+id; 
	}else{
		return;
	}
}

//取消首页显示
function cancelIndex(id){
	if(confirm('您确认取消首页显示吗？')){
		 window.location.href="cancel_index_activity.html?activityId="+id; 
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
您的位置：优惠活动管理 -&gt; 活动管理 -&gt; 所有活动
</div>
<form action="view_all_library.html" name="listform">
<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">所有活动</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="15%">活动名称</th>
        <th width="8%">活动开始时间</th>
        <th width="8%">活动结束时间</th>
        <th width="40%">活动主题</th>
        <th width="8%">首页显示</th>
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
        <s:if test="#activity.isIndex == true"><a title="取消首页显示" href="javascript:cancelIndex(<s:property value='#activity.id'/>);"  >显示 </a> </s:if>
        <s:else><a title="设置首页显示" href="view_set_index_activity.html?activityId=<s:property value='#activity.id'/>"  >不显示</a></s:else> </td>
        <td class="list_aselect">
        	<a href="view_update_activity.html?activityId=<s:property value='#activity.id'/>"  >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="javascript:deleteActivity(<s:property value='#activity.id'/>);"  >放入回收站</a> 
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
