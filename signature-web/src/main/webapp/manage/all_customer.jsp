<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有用户</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="javascript">

//删除
function setStat(customerName,stat){
	if(confirm('您确认置状态吗？')){
		 window.location.href="set_customer_stat.html?loginName="+customerName+"&customerStat="+stat; 
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
您的位置：统计管理 -&gt; 用户管理 -&gt; 所有用户
</div>
<form id="saveform" action="view_all_customer.html" method="post">
<div class="content">
	 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
	 <thead>
	    </thead>
	<tbody>
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">筛选</td>
		  <td align="left" class="list_aselect"><label for="select"></label>
		  开始时间：<input type="text" name="startTime" value="<s:date name='#request.startTime' format='yyyy-MM-dd'/>" onClick="WdatePicker()" readOnly />&nbsp;&nbsp;
		  结束时间：<input type="text" name="endTime" value="<s:date name='#request.endTime' format='yyyy-MM-dd'/>" onClick="WdatePicker()" readOnly />&nbsp;&nbsp;
		  所属城市：<select name="city">
		  				<s:set value="#request.city" name="city"></s:set>
		  				<option value="0" >&nbsp;&nbsp;所有&nbsp;&nbsp;</option>
            	 		<option value="0290" <s:if test="#city == '0290'">selected</s:if> >&nbsp;&nbsp;西安&nbsp;&nbsp;</option>
            	 		<option value="U029" <s:if test="#city == 'U029'">selected</s:if> >&nbsp;&nbsp;咸阳&nbsp;&nbsp;</option>
            	 		<option value="0911" <s:if test="#city == '0911'">selected</s:if> >&nbsp;&nbsp;延安&nbsp;&nbsp;</option>
            	 		<option value="0912" <s:if test="#city == '0912'">selected</s:if> >&nbsp;&nbsp;榆林&nbsp;&nbsp;</option>
            	 		<option value="0913" <s:if test="#city == '0913'">selected</s:if> >&nbsp;&nbsp;渭南&nbsp;&nbsp;</option>
            	 		<option value="0914" <s:if test="#city == '0914'">selected</s:if> >&nbsp;&nbsp;商洛&nbsp;&nbsp;</option>
            	 		<option value="0915" <s:if test="#city == '0915'">selected</s:if> >&nbsp;&nbsp;安康&nbsp;&nbsp;</option>
            	 		<option value="0916" <s:if test="#city == '0916'">selected</s:if> >&nbsp;&nbsp;汉中&nbsp;&nbsp;</option>
            	 		<option value="0917" <s:if test="#city == '0917'">selected</s:if> >&nbsp;&nbsp;宝鸡&nbsp;&nbsp;</option>
            	 		<option value="0919" <s:if test="#city == '0919'">selected</s:if> >&nbsp;&nbsp;铜川&nbsp;&nbsp;</option>
         			</select>
		   &nbsp;&nbsp;
		  业务状态：<select name="customerStat">
		  				<s:set value="#request.customerStat" name="cStat"></s:set>
		  				<option value="0" >&nbsp;所有</option>
            	 		<option value="1" <s:if test="#cStat == 1">selected</s:if> >&nbsp;业务订购</option>
            	 		<option value="2" <s:if test="#cStat == 2">selected</s:if> >&nbsp;业务退订</option>
            	 		<option value="3" <s:if test="#cStat == 3">selected</s:if> >&nbsp;业务暂停</option>
            	 		<option value="4" <s:if test="#cStat == 4">selected</s:if> >&nbsp;业务有效期已过</option>
            	 		<option value="6" <s:if test="#cStat == 6">selected</s:if> >&nbsp;业务免费体验</option>
            	 		<option value="7" <s:if test="#cStat == 7">selected</s:if> >&nbsp;业务体验结束</option>
         			</select>
		   &nbsp;&nbsp;
		   用户号码：<input type="text" name="loginName" value="<s:property value="#request.loginName"/>" />&nbsp;&nbsp;
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
    <a class="TitleStype">所有用户</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="15%">用户号码</th>
        <th width="15%">所属城市</th>
        <th width="15%">业务状态</th>
        <th width="15%">业务状态更改时间</th>
        <th width="10%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="customers" id="customer">
       <tr>
        <td align="center"><s:property value="#customer.id"/></td>
        <td align="center"><s:property value="#customer.customerName"/></td>
        <td align="center"><s:property value="#customer.cityName"/></td>
        <s:set value="#customer.customerStat" name="stat" ></s:set>
        <td align="center">
        <s:if test="#stat == 1">业务订购</s:if>
        <s:elseif test="#stat == 2">业务退订</s:elseif>
        <s:elseif test="#stat == 3">业务暂停</s:elseif>
        <s:elseif test="#stat == 4">业务有效期已过</s:elseif>
        <s:elseif test="#stat == 5">业务改号</s:elseif>
        <s:elseif test="#stat == 6">业务免费体验</s:elseif>
        <s:elseif test="#stat == 7">业务体验结束</s:elseif>
        <s:else>未知状态</s:else>
        </td>
        <td align="center"><s:date name="#customer.updateTime" format="yyyy-MM-dd HH:mm"/></td>
        <td class="list_aselect">
        	<a href="view_user_login.html?loginName=<s:property value='#customer.customerName'/>"  >查看登录情况</a>&nbsp;&nbsp;
        	
        	<s:if test="#stat == 6">
        	<a href="javascript:setStat('<s:property value="#customer.customerName"/>',7);"  >置体验结束</a>
        	</s:if>
        	<s:elseif test="#stat == 7">
        	<a href="javascript:setStat('<s:property value="#customer.customerName"/>',6);"  >置免费体验</a>
        	</s:elseif>
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_all_customer.html?'+#request.pageUrl"></s:param>
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
