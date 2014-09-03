<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>

<title>设置个性化签名</title>
<script type="text/javascript">
function searchSubmit(){
  document.ruleList.submit();
}

//删除个性化签名
function batchdelete() {
	//document.get
    var ids=commonBatchDel(document.ruleList.cb);    
    if(ids != ""){
    	document.ruleList.action="delete_personalized.html";
    	document.ruleList.submit();
    }   
    
}

</script>
</head>

<body>
<div id="RightMain_top"><span class="margin_left">设置个性化签名</span></div>


<div id="RightMain_end">

<form action="delete_personalized.html" name="ruleList" id="ruleList">
  <div class="mycmccqm_right2">
  	<div class="rightsub2_0">
  	设置规则：同一个接收号码要么按周设置要么按周设置不能冲突;同一个接收号码按天设置时间段不能重叠;同一个接收号码按周设置不能设置一周的同一天。
	</div>
		
    <div class="rightsub2_0"><strong>系统提示：</strong>系统允许用户最多可创建 20 条签名发送规则。</div> 
    
    <!-- 用于删除或创建后的跳转信息 -->
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/> </div>
	   
	<div class="rightsub2_5" style="margin-bottom:5px;">
	   
	  <table width="100%" border="0" cellspacing="1" cellpadding="0">
	  <tr>
		<th width="4%" height="29" align="center" bgcolor="#CCEBFA"><input type="checkbox" name="checkbox3" onclick="selectAll(this.checked);" value="checkbox" /></th>
		<th width="15%" align="center" bgcolor="#CCEBFA">接收号码</th>
		<th width="40%" align="center" bgcolor="#CCEBFA">签名内容</th>		
        <th width="9%" align="center" bgcolor="#CCEBFA">设置方式</th>
		<th width="11%" align="center" bgcolor="#CCEBFA">发送时间</th>
		<th width="10%" align="center" bgcolor="#CCEBFA">操作</th>
	  </tr>
		  <s:iterator value="personalizes" id="personalize">
		  <tr bgcolor="#f8f8f8">
			<td height="30px;" align="center"><input type="checkbox" name="cb" value="<s:property value='#personalize.id' />" /></td>
			<td align="center">
				<s:if test='%{#personalize.callingNumbers=="*"}'>所有号码</s:if>
				<s:else>
			 	<!-- 只显示2个手机号 -->
			 	<s:set name="numbers" value="#personalize.callingNumbers"></s:set>  
				<s:if test="#numbers.length() > 23">  
					<s:property value="#numbers.substring(0,11)" /><br />
					<s:property value="#numbers.substring(12,23)" /><br />
					<a href="javascript:sAlert('view_numbers.html?numbers=<s:property value="#personalize.callingNumbers" />', 700, 550, '所有手机号码', 5, 10);">......更多</a>  
				</s:if>  
				<s:else>  
					<s:property value="#numbers.substring(0,11)" /><br />
					<s:if test="#numbers.length() > 11">
					<s:property value="#numbers.substring(12,23)" /><br />
					</s:if>
				</s:else>
				</s:else>
			</td>
			<td>
				<s:if test="#personalize.diyInfo.flag == 0">
					<s:property value="#personalize.diyInfo.diyInfoContent" />
				</s:if>
				<s:else>
					<b>[签名盒]</b>
					<a title="点击查看签名盒详情" class="linkblue02" href="javascript:sAlert('view_library_signature.html?library.id=' + <s:property value='#personalize.diyInfo.libraryClassId' /> , 700, 580,'签名盒详情', 5, 15);"> 
	    		    [<s:property value="#personalize.diyInfo.libraryClassId" />]&nbsp; <s:property value="#personalize.diyInfo.libraryClassName" />
	    		    </a>
				</s:else>	               
			</td>			
            <td height="30px;" align="center">
            	<s:property value="#personalize.sendruleName" />
            </td>
            
			<td height="30px;" align="center">
				<s:property value="#personalize.weeksShow" />
				<s:property value="#personalize.sendruleSendperiodtime" />				
			</td>
			
			<td align="center">			
				<a href="view_update_personalized.html?id=<s:property value='#personalize.id' />">
		      <img src="images/edit.gif" width="16" height="16" title="修改此签名发送规则" border="0"/></a>
			</td>
		  </tr>
		  </s:iterator>
		  
	</table>
	</div>
    <div class="rightsub715" style=" margin-bottom:0px;">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:location.href='view_personalized.html'" class="link000"  >新 增</a></div>
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:batchdelete()" class="link000"   >删 除</a></div>
    </div>
    <div class="rightsub_fy" >
    	<!-- 分页 -->
    	<s:include value="page.jsp">
			<s:param name="pageUrl" value="'list_personalized.html?'"></s:param>
		</s:include>
	</div>
  </div>
  </form>
</div>

<div>

</div>

</body>
</html>