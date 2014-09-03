<%@page import="com.juicy.signature.persist.po.City"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户统计</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>

<body>
<div id="body_top_bg">
	<div id="body_right_bg">
	
	
<div id="postion_nav">
您的位置：统计管理 -&gt; 用户管理 -&gt; 用户状态统计
</div>
<form id="saveform" action="view_customer_statistics.html" method="post">
<div class="content">
	 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
	 <thead>
	    </thead>
	<tbody>
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">筛选</td>
		  <td align="left" class="list_aselect"><label for="select"></label>
		  开始时间：<input type="text" name="startTime" value="<s:date name='#request.startTime' format='yyyy-MM-dd'/>" onClick="WdatePicker()" readOnly />&nbsp;&nbsp;
		  结束时间：<input type="text" name="endTime" value="<s:date name='#request.endTime' format='yyyy-MM-dd'/>" onClick="WdatePicker()" readOnly />
		   &nbsp;&nbsp;
		  <input name="Submit2" type="submit" class="b_chaxun" value="查询" />&nbsp;&nbsp;
		  <span style="color:red">注：开始时间和结束时间指的是 用户业务状态的更改时间</span>
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
    <a class="TitleStype">用户状态统计</a>
    </caption>
    
    <thead>
      <tr>
        <th width="10%">城市</th>
        <th width="10%">总用户数</th>
        <th width="10%">业务订购状态数</th>
        <th width="10%">业务退订状态数</th>
        <th width="10%">业务暂停状态数</th>
        <th width="10%">业务有效期已过状态数</th>
        <th width="10%">业务免费体验状态数</th>
        <th width="10%">业务免费体验结束状态数</th>
        <th width="10%">未知状态数</th>
        </tr>
    </thead>
    <tbody>
     <% 
     	List<City> cityList = (List<City>)request.getAttribute("cityList");
     	List<java.util.Map<Integer,Integer>>  statisticsList = (List<Map<Integer,Integer>>)request.getAttribute("statisticsList");
       	Iterator<Map<Integer,Integer>> it = statisticsList.iterator(); 
       	int index = 0;
       	while(it.hasNext()){
       		
       		Map<Integer,Integer> map = it.next();
      %>
       <tr>
       	<td align="center"><%=cityList.get(index).getCityName() %> </td>
        <td align="center"><%=map.get(0) %> </td>
        <td align="center"><%=map.get(1) %> </td>
        <td align="center"><%=map.get(2) %> </td>
        <td align="center"><%=map.get(3) %> </td>
        <td align="center"><%=map.get(4) %> </td>
        <td align="center"><%=map.get(6) %> </td>
        <td align="center"><%=map.get(7) %> </td>
        <td align="center"><%=map.get(-1) %> </td>
       </tr>
        <% 
        index++;
       	} %>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="9" class="list_aselect">     
      	<a href="javascript:history.back()" class="link000">返回</a> 
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
