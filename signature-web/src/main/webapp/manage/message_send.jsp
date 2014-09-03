<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="javascript">

//保存
function save(){
	var re = /^[1-9]\d*$/;
	
	var flowControl = document.getElementById("flowControl");
	if(flowControl.value == null || flowControl.value == ""){				
		alert("请输入--被叫日推送总量！");
		flowControl.focus();
		return false;
	}else if(!re.test(flowControl.value)){
		alert("必须为正整数--被叫日推送总量！");
		flowControl.focus();
		return false;
	}
	
	var smInterval = document.getElementById("smInterval");
	if(smInterval.value == null || smInterval.value == ""){
		alert("请输入--主叫接收信息间隔时间！");
		smInterval.focus();
		return false;
	}else if(!re.test(smInterval.value)){
		alert("必须为正整数--主叫接收信息间隔时间！");
		smInterval.focus();
		return false;
	}
	
	var controlNum = document.getElementById("controlNum");
	if(controlNum.value == null || controlNum.value == ""){
		alert("请输入--主叫日接收信息总量！");
		controlNum.focus();
		return false;
	}else if(!re.test(controlNum.value)){
		alert("必须为正整数--主叫日接收信息总量！");
		controlNum.focus();
		return false;
	}
	
	var comboMsgNumber = document.getElementById("comboMsgNumber");
	if(comboMsgNumber.value == null || comboMsgNumber.value == ""){
		alert("请输入--被叫月推送信息总量！");
		comboMsgNumber.focus();
		return false;
	}else if(!re.test(comboMsgNumber.value)){
		alert("必须为正整数--被叫月推送信息总量！");
		comboMsgNumber.focus();
		return false;
	}
		
	//提交
	document.getElementById("saveform").submit();
}


</script>
</head>
<body>
<div id="postion_nav">
您的位置：系统管理 -&gt; 系统参数管理 -&gt; 推送参数管理
</div>
<form id="saveform" action="save_message_send.html" method="post" >
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
   	推送参数
    </caption>
    <tbody>
      <tr>
        <td align="right">被叫日推送总量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="flowControl" name="messageSend.flowControl" value="<s:property value='messageSend.flowControl' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">主叫接收信息间隔时间：</td>
        <td colspan="3" align="left">
        	<input type="text" id="smInterval" name="messageSend.smInterval" value="<s:property value='messageSend.smInterval' />" />秒
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">主叫日接收信息总量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="controlNum" name="messageSend.controlNum" value="<s:property value='messageSend.controlNum' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">被叫月推送信息总量：</td>
        <td colspan="3" align="left">
        	<input type="text" id="comboMsgNumber" name="hgComboDetail.comboMsgNumber" value="<s:property value='hgComboDetail.comboMsgNumber' />" />
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">被叫月推送总量超后的策略:</td>
        <td colspan="3" align="left">
        	<s:set value="hgFirmParameter.firmParameterValue" name="firmParameterValue"></s:set>
        	<input type="radio" name="hgFirmParameter.firmParameterValue"  value="1"/ <s:if test="#firmParameterValue == 1"> checked </s:if> />继续发送&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="hgFirmParameter.firmParameterValue"  value="2"  <s:if test="#firmParameterValue == null || #firmParameterValue == 2"> checked </s:if> />停止发送
        </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input id="messageSendId" type="hidden" name="messageSend.id" value="<s:property value='messageSend.id' />" />
        	<input id="hgComboDetailId" type="hidden" name="hgComboDetail.id" value="<s:property value='hgComboDetail.id' />" />
        	<input id="hgFirmParameterId" type="hidden" name="hgFirmParameter.id" value="<s:property value='hgFirmParameter.id' />" />
        	<input type="button" class="b_tianjia" value="保存" onClick="save()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>