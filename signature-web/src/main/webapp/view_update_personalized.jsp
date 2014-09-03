<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">

function checkDate(){
    var start = document.getElementById("startTime").value;
    var end = document.getElementById("endTime").value;
    if(start !='' && end !=''){
        if(start>=end){
            document.getElementById("endTimeTip").innerHTML = '结束时间不能小于开始时间';
        }else{
            document.getElementById("endTimeTip").innerHTML ='';
        }
    }else{
       document.getElementById("endTimeTip").innerHTML ='';
    } 
}

function openColtFrame(){
   sAlert('collections0.html?selectWindow=true',700, 550, "彩印收藏管理", 5, 15);
}
function openSignSetFrame(){
   sAlert('signSetHistory0.html',700, 650, "彩印设置历史", 5, -100);
}
function openTalkFrame(){
   sAlert('toTalkList.html',700, 550, "139说客列表", 5, 15);
}
function lookDetail() {
    var id=document.getElementById('packageId').value;
    if(id.indexOf("U")!=0){
    sAlert('viewSignPackage.html?signPackage.id='+id,700, 550, '彩印盒详情',5,15);
    }else{
    sAlert('detailUserPackage.html?upackage.id='+id,700, 550, '用户自定义彩印盒详情',5,15);
    }  
}

function openUserPackageFrame(){
    sAlert('listUserPackage.html?actionResult=alert',700, 550, "我的原创彩印盒", 5, 15);
}
function openMyCsFrame(){
   sAlert('mySignatures.html?showDefaultMySigns=true&actionResult=alert&paging.pageSize=6',700, 550, "我的原创彩印", 5, 15); 
}
function openSignPackageDetail(){
	var id = document.getElementById("packageId").value;
	if (id == '') {
		alert("请选择签名盒！");
		return;
	}
	
	sAlert('view_library_signature.html?library.id=' + id, 700, 580,
			'签名盒详情', 5, 15);
}
function setSignPackage(objValue1, objValue2) {
	document.getElementById("packageName").value = objValue2;
	document.getElementById("packageId").value = objValue1;
	
	//插入签名盒时，清空先前插入的签名
	document.getElementById("signatureId").value = "";
	document.getElementById("libraryContent").value = "";
	
	window.pRemoveAlertBase();
} 

function autoSet(objVlaue0,objValue1) {
    document.getElementById("sign_set").value=objVlaue0;
    if(objValue1 != null){
		document.getElementById("originalId").value = objValue1;
	}    
    window.pRemoveAlertBase();
} 

function setSendAsAllTimes(){
    $("startTime").value="00:00:00";
    $("startTime").readOnly=true;
    
    $("endTime").value="23:59:59";
    $("endTime").readOnly=true;
}
function setSendAsCustomer(){
    $("startTime").value="";
    $("startTime").readOnly=false;
    $("endTime").value="";
    $("endTime").readOnly=false;
}
function setTimeFlag(type){
    if(type==1){
      document.getElementById("weekBlock").style.display='none';
      document.getElementById("dayBlock1").style.display='';
      document.getElementById("dayBlock2").style.display='';
    }else{
      document.getElementById("weekBlock").style.display='';
      document.getElementById("dayBlock1").style.display='none';
      document.getElementById("dayBlock2").style.display='none';
    }
}
function radioReset(){
  var obj=document.getElementsByName("rule.cctTimeFlag");
  if(obj){
   if(obj[0].checked ){
    setTimeFlag(1);
   }
     if(obj[1].checked ){
    setTimeFlag(2);
   }
   }
}

function submitRuleForm(){
var obj = document.getElementsByName("rule.cctTimeFlag");
 if(obj[0].checked ){
   if($('startTime').value.length==0){
        alert("请设置开始时间！");
        return ;
   }
   if($('endTime').value.length==0){
        alert("请设置结束时间！");
        return ;
   }
   if($('startTime').value>$('endTime').value){
    alert("您设置的开始时间不能大于结束时间！");
        return ;
   }
 	
   //设置时间格式，并赋值
   var startTime = $('startTime').value;
   var endTime = $('endTime').value;
   startTime = startTime.substring(0,5);
   endTime = endTime.substring(0,5);   
   var periodTime = startTime +"-" + endTime;
   $('periodTime').value = periodTime;
   
   
 }else if(obj[1].checked ){
    var weekDayValue="";
    for(var i=0;i<7;i++){
        obj=document.ruleForm.week[i];
        weekDayValue=weekDayValue+(obj.checked?"1":"0");
    }
    if(weekDayValue=="0000000"){
        alert("请选择发送时间！");
        return;
    }
    $('cctWeekValue').value=weekDayValue;
  }else{
    alert("请选择设置类型");
    return ;
  }
   
  //判断签名内容来源
  if($("contentType").value == "1"){
	 // 来源于签名宝库
	 if($("packageId").value.length==0){
		alert("签名盒不能为空！");
		return;
		}
      
     //if($("signatureId").value.length == 0){
		//alert("签名内容不能为空,请插入签名!");
		//return;
		//}
  }else{
	  if($('sign_set').value.trim().length==0){
  		alert('签名内容不能为空');
          return ;
  		}
  }
  
   document.ruleForm.action = "update_personalized.html";
   document.ruleForm.submit();
}

//插入签名
function setInsertSig(objValue1,objValue2){
	document.getElementById("signatureId").value = objValue1;
	document.getElementById("libraryContent").value = objValue2;
	window.pRemoveAlertBase();
}
</script>
<title>修改个性化签名规则</title>

</head>

<body onload="loadTxLisnter('sign_set');">
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">修改签名高级设置</span></div>

<div id="RightMain_end">



<form action="update_personalized.html" name="ruleForm"  method="post">
	<!-- 要修改的个性化签名ID -->
  	<input name="personalize.id" value="<s:property value='personalize.id'/>" type="hidden" />  	
  	<!-- 签名盒ID -->	
	<input id="packageId" name="classId" type="hidden"  value="<s:if test="personalize.diyInfo.libraryClassId != null"><s:property value='personalize.diyInfo.libraryClassId'/></s:if><s:elseif test='personalize.diyInfo.library.signatureClass.id!=null'><s:property value='personalize.diyInfo.library.signatureClass.id'/></s:elseif>" />
  	<!-- 具体签名盒中的签名 -->
	<input id="signatureId" name="libraryId" type="hidden" value="<s:property value='personalize.diyInfo.library.id'/>" />
	<!-- 原创签名ID -->				
	<input id="originalId" name="originalId" type="hidden" />
  	
  <div class="mycmccqm_right2">
    <div class="rightsub1_5" style=" padding-left:15px; width:690px; border:none;">
    <div class="rightsub1_5_1">
      <div class="spaceaccountright5_2">接收号码：</div>
      <span class="spaceaccountright5"><span class="color14F29400"> <% String callingNumbers = (String)request.getAttribute("personalize.callingNumbers"); if(callingNumbers.equals("*")){ %>所有号码<% } else{ %> <s:property value="personalize.callingNumbers"/><%} %>  </span></span>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="rightsub1_5_1">
      <div class="spaceaccountright5_2">设置类型：</div>
      <div class="spaceaccountright5">
      	   <input name="setTime" type="hidden" value="<s:property value='setTime'/>" />
           <input  type="radio" name="rule.cctTimeFlag"  <s:if test="#request['setTime'] == 1">checked</s:if>  value="1" onclick="setTimeFlag(1)" />按天设置
           <input  type="radio" name="rule.cctTimeFlag" <s:if test="#request['setTime'] == 2">checked</s:if>   value="2" onclick="setTimeFlag(2)" />按周设置
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="rightsub1_5_1" id="weekBlock" <s:if test="#request['setTime'] == 1">style="display:none;"</s:if> >
      <div class="spaceaccountright5_2">发送时间：</div>
      <div class="spaceaccountright5">
      	   <% Object weeksObject = request.getAttribute("weeks");
      	 	  String[] weeks = new String[7];
      	   	  if(weeksObject != null){
      	   		weeks = (String[])weeksObject;
      	   	  }%>
      	   <input  type="checkbox" name="week" <% if(weeks[0] != null){ if(weeks[0].equals("1")){ %> checked <% } } %> />星期日
           <input  type="checkbox" name="week" <% if(weeks[1] != null){ if(weeks[1].equals("1")){ %> checked <% } }%> />星期一
           <input  type="checkbox" name="week" <% if(weeks[2] != null){ if(weeks[2].equals("1")){ %> checked <% } }%> />星期二
           <input  type="checkbox" name="week" <% if(weeks[3] != null){ if(weeks[3].equals("1")){ %> checked <% } }%> />星期三
           <input  type="checkbox" name="week" <% if(weeks[4] != null){ if(weeks[4].equals("1")){ %> checked <% } }%> />星期四
           <input  type="checkbox" name="week" <% if(weeks[5] != null){ if(weeks[5].equals("1")){ %> checked <% } }%> />星期五
           <input  type="checkbox" name="week" <% if(weeks[6] != null){ if(weeks[6].equals("1")){ %> checked <% } }%> />星期六
          
           <input type="hidden"  name="personalize.sendruleWeeks" id="cctWeekValue" />
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="dayBlock1" <s:if test="#request['setTime'] == 2">style="display:none;"</s:if> >
      <div class="spaceaccountright5_2">时间范围：</div>
      <div class="spaceaccountright5">
      		 <% Byte allDayOrSelf = (Byte)request.getAttribute("allDayOrSelf");%>
           <input  type="radio" name="timeType" <%if(allDayOrSelf != null && allDayOrSelf == 1){ %> checked <%} %>  onclick="setSendAsAllTimes()" />
           按全天发送
           <input  type="radio" name="timeType" <%if(allDayOrSelf == null || allDayOrSelf == 2){ %> checked <%} %>  onclick="setSendAsCustomer()" />自定义发送时间
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="rightsub1_5_1" id="dayBlock2" <s:if test="#request['setTime'] == 2">style="display:none;"</s:if>>
      <div class="spaceaccountright5_2"> 时间段：</div>
      <!-- 发送时间段 -->
    <input id="periodTime" type="hidden" name="personalize.sendruleSendperiodtime"></input>
      <div class="spaceaccountright5">
        <input type="text" name="rule.startTime"  id="startTime" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" value="<s:property value='startTime'/>" class="Wdate" style="width:140px" readOnly/>
        &nbsp;— 
        <input type="text"  name="rule.endTime"   id="endTime" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" value="<s:property value='endTime'/>" class="Wdate" style="width:140px" readOnly/>
        <span class="color14F29400_2">*</span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
	<input id="contentType" type="hidden" name="contentType" value="<s:property value='contentType'/>" />
	<s:if test="#request['contentType'] == 1">
	    <div class="rightsub1_5_1" id="signPackage" > 
	      <div class="spaceaccountright5_2" >签名盒：</div>

			<s:if test="personalize.diyInfo.library == null && personalize.diyInfo.libraryClassId == null">
				<s:set value="'请选择签名盒'" name="className">
				</s:set> 
			</s:if>
			<s:else>
				<s:if test="personalize.diyInfo.library.signatureClass.name != null">
					<s:set value="#request['personalize.diyInfo.library.signatureClass.name']" name="className">
					</s:set>
				</s:if>
				<s:else>
					<s:set value="#request['personalize.diyInfo.libraryClassName']" name="className">
					</s:set>
				</s:else>
			</s:else>
	      
	      
	      <div class="spaceaccountright5">
	        <input id="packageName" type="text" value="<s:property value='#className'/>"   size="40" class="address_input1" readonly/>
	      
	        <br />
	        <a href="javascript:sAlert('view_library.html', 700, 550, '签名盒列表', 5, 15);" class="linkblue02">选择签名盒</a>&nbsp;|&nbsp; 
	        <a href="javascript:sAlert('view_collect_library.html', 700, 550, '签名盒收藏', 5, 15);" class="linkblue02">从收藏选择</a>
	        <br />
			<br />
			<strong>签名内容：</strong>
			<a href="javascript:openSignPackageDetail();" class="linkblue02">插入签名</a>
			<br />
			<textarea class="rightsub1_3" id="libraryContent" name="personalize.diyInfo.diyInfoContent" readonly><s:property value="personalize.diyInfo.diyInfoContent"/> </textarea>
	      </div>
	      <div class="spaceaccountright5_1"></div>
	      <div class="spaceaccountright5_1"></div>
	    </div>
    </s:if>
    <s:elseif test="#request['contentType'] == 2">
    <div class="rightsub1_5_1" id="signContent"  >
      <div class="spaceaccountright5_2">签名内容：</div>
      <div class="spaceaccountright5">
        <textarea id="sign_set" name="personalize.diyInfo.diyInfoContent" cols="40" rows="5"><s:property value="personalize.diyInfo.diyInfoContent"/></textarea>
         <span id="cur_num">0</span>/<span id="max_num">70</span><br />
 			<a href="javascript:sAlert('view_collect.html', 700, 550, '签名收藏管理', 5, 15);" class="linkblue02">从收藏选择</a>&nbsp;|&nbsp;
	        <a href="javascript:sAlert('view_original.html?auditStatus=1', 700, 550, '我的原创签名', 5, 15);" class="linkblue02">我的原创签名列表</a>  
        </div>
   	</div>
   </s:elseif>
   
    
    <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:submitRuleForm();" class="link000">提 交</a></div>
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:document.ruleForm.reset();txChange('sign_set');" class="link000">重 置</a></div>
    </div>
  </div>
</div>


</form>

  </div> 
</div> 

</body>
</html>
