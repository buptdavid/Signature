<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户意见</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">

//删除
function deleteSuggest(id){
	if(confirm('您确认删除吗？')){
		 window.location.href="delete_user_suggest.html?suggest.id="+id; 
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
您的位置：系统管理 -&gt; 系统反馈管理 -&gt; 用户意见管理
</div>

<form name="form" id="form" action="view_user_suggest.html" method="post">
<div class="content">
	 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
	 <thead>
	    </thead>
	<tbody>
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">筛选</td>
		  <td align="left" class="list_aselect">
		   意见标题：<input type="text" name="suggest.title" value="<s:property value="#suggest.title"/>" />&nbsp;&nbsp;
		   <input name="Submit2" type="submit" class="b_chaxun" value="查询" />&nbsp;&nbsp;
		   </td>
		 </tr>
		
	  </tbody>
	  <tfoot>
	    </tfoot>
	</table>
</div>
</form>

<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">用户意见</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="10%">意见标题</th>
        <th width="30%">意见内容</th>
        <th width="10%">用户手机</th>
        <th width="10%">意见时间</th>
        <th width="10%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="suggests" id="s">
       <tr>
        <td align="center"><s:property value="#s.id"/></td>
        <td align="center"><s:property value="#s.title"/></td>
        <td align="center"><s:property value="#s.content"/></td>
        <td align="center"><s:property value="#s.loginName"/></td>
        <td align="center"><s:date name="#s.time" format="yyyy-MM-dd HH:mm"/></td>
        <td class="list_aselect">
        	<a href="javascript:deleteSuggest(<s:property value='#s.id'/>);" >删除</a>
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_user_suggest.html?suggest.title='+#request.title+'&'"></s:param>
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
