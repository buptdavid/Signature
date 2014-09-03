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
function cancelIndex(id){
	if(confirm('您确认取消首页显示吗？')){
		 window.location.href="cancel_index.html?activityId="+id; 
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
您的位置：首页管理 -&gt; 精彩活动管理 -&gt; 精彩活动
</div>
<form action="#" method="post" name="listform" id="listform">

<div class="content">
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable" >
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">精彩活动</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">活动序号</th>
        <th width="20%">活动名称</th>
        <th width="45%">活动主题</th>
        <th width="15%">起止时间</th>
        <th width="10%"> 操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="activities" id="activity">
       <tr>
        <td align="center"><s:property value="#activity.id"/></td>
        <td align="left"><s:property value="#activity.name"/></td>
        <td align="left"><s:property value="#activity.theme"/></td>
        <td align="center"><s:date name="#activity.startTime" format="yyyy-MM-dd"/> -- <s:date name="#activity.endTime" format="yyyy-MM-dd"/></td>
        <td class="list_aselect"><a href="javascript:cancelIndex(<s:property value='#activity.id'/>);">取消首页显示</a></td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="5">      
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
