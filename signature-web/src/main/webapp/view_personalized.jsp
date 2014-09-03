<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">

//检查时间
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

//检查手机号码格式
function checkPhone(){ 
    var phones = document.getElementById("phones").value; 
    var re= new RegExp("^((1\\d{10})(\\r?\\n(1\\d{10})){0,})$");
    if(phones.trim()!=''&&!re.test(phones)){
                 document.getElementById("phonesTip").innerHTML ='手机号码格式不正确：只能是11位手机号码，不能有空行，一行只能输入一个手机号码！';
                 return;
           }else{
                document.getElementById("phonesTip").innerHTML ='';
           }
           
    if (phones != ''){
        var arrPhone = phones.split(/\r?\n/);
        var size=20;
        if(arrPhone.length>size){
            document.getElementById("phonesTip").innerHTML="您最多只可以添加"+size+"个手机号码";            
        }
    } 
}

function setSignPackage(objValue1, objValue2) {
	document.getElementById("packageName").value = objValue2;
	document.getElementById("packageId").value = objValue1;
	
	//插入签名盒时，清空先前插入的签名
	document.getElementById("signatureId").value = "";
	document.getElementById("libraryContent").value = "";
	
	window.pRemoveAlertBase();
	
} 

function setStyle(model){
   if(model=='0'){
      document.getElementById("signPackage").style.display='';
      document.getElementById("signContent").style.display='none';
      //document.getElementById("signContentTable").style.display='none';
   }else if (model =='1'){
      document.getElementById("signContent").style.display='';
      //document.getElementById("signContentTable").style.display='';
      document.getElementById("signPackage").style.display='none';
   }
}

function setMobileStyle(flag){
    if(flag=='0'){
      document.getElementById("MobileBlock0").style.display='';
      document.getElementById("MobileBlock1").style.display='none';
   }else if (flag =='1'){
      document.getElementById("MobileBlock1").style.display='';
      document.getElementById("MobileBlock0").style.display='none';
   }
}

function autoSet(objVlaue0,objValue1) {
    document.getElementById("sign_set").value=objVlaue0;
    if(objValue1 != null){
		document.getElementById("originalId").value = objValue1;
	}
    window.pRemoveAlertBase();
} 

//插入签名
function openSignPackageDetail(){
	var id = document.getElementById("packageId").value;
	if (id == '') {
		alert("请选择签名盒！");
		return;
	}
	
	sAlert('view_library_signature.html?library.id=' + id, 700, 580,
			'签名盒详情', 5, 15);
	
}


//提交
function submitPhones(){
    var obj = document.getElementsByName("cctTimeFlag");
 if(obj[0].checked ){
   if($('startTime').value.length==0){
        alert("请设置开始时间！");
        return ;
   }else if($('endTime').value.length==0){
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
   
   obj = document.getElementsByName("selectMobile");
   //自定义手机号码
   if(obj[0].checked&&$('phones').value.trim().length==0){
        alert("请输入手机号码！");
        return;
   }
   if(obj[0].checked ){
       checkPhone();
       if($("phonesTip")&&$("phonesTip").innerHTML!=''){
        alert($("phonesTip").innerHTML);
        //只能是11位手机号码，不能有空行，一行只能输入一个手机号码！");
        return ;
       }
        $('allphones').value='';
        $('callingNumbers').value = $('phones').value;
   }
   
     if(obj[1].checked ){
     $('allphones').value='*';
     $('phones').value='';
     $('callingNumbers').value = '*';
   }
        
       var obj = document.getElementsByName("signModel");
       if(obj[0].checked){
    	   if($("packageId").value.length==0){
				alert("签名盒不能为空！");
				return;
			}
            
            //if($("signatureId").value.length == 0){
				//alert("签名内容不能为空,请插入签名!");
				//return;
			//}
            
            //提交
            document.ruleForm.action="create_personalized_library.html";
            document.ruleForm.submit();            
       }
     
     	  if(obj[1].checked){
        	if($('sign_set').value.trim().length==0){
        		alert('签名内容不能为空');
                return ;
        	}
        	
        	//提交
            document.ruleForm.action="create_personalized.html";
            document.ruleForm.submit();        	
       }
  
 
}

//全天发送设置
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
      document.getElementById("dayBlock3").style.display='';
    }else{
      document.getElementById("weekBlock").style.display='';
      document.getElementById("dayBlock1").style.display='none';
      document.getElementById("dayBlock2").style.display='none';
      document.getElementById("dayBlock3").style.display='none';
    }
}

//插入签名
function setInsertSig(objValue1,objValue2){
	document.getElementById("signatureId").value = objValue1;
	document.getElementById("libraryContent").value = objValue2;
	window.pRemoveAlertBase();
}
</script>
<title>个性化签名</title>

</head>

<body onload="loadTxLisnter('sign_set');">
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">新增</span>签名高级设置</div>

<div id="RightMain_end">


<form action="create_personalized_library.html" name="ruleForm" method="POST" >
	<!-- 签名盒ID -->	
	<input id="packageId" name="classId" type="hidden"  />
	<!-- 具体签名盒中的签名 -->
	<input id="signatureId" name="libraryId" type="hidden" />	
	<!-- 原创签名ID -->				
	<input id="originalId" name="originalId" type="hidden" />
<div class="mycmccqm_right2">
  <div class="rightsub1_5" style=" padding-left:15px; width:690px; border:none;">
	
	<div class="rightsub1_5_1">
      <div class="spaceaccountright5_2">设置类型：</div>
      <div class="spaceaccountright5">
           <input  type="radio" name="cctTimeFlag" value="1" onclick="setTimeFlag(1)" checked />按天设置
           <input  type="radio" name="cctTimeFlag" value="2" onclick="setTimeFlag(2)" />按周设置
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
	
	<div class="rightsub1_5_1" id="weekBlock" style="display:none;">
      <div class="spaceaccountright5_2">发送时间：</div>
      <div class="spaceaccountright5">
      	   <input  type="checkbox" name="week" />星期日
           <input  type="checkbox" name="week"  />星期一
           <input  type="checkbox" name="week"  />星期二
           <input  type="checkbox" name="week"  />星期三
           <input  type="checkbox" name="week" />星期四
           <input  type="checkbox" name="week"  />星期五
           <input  type="checkbox" name="week" />星期六           
           <input type="hidden"  name="sendrule.sendruleWeeks" id="cctWeekValue" />
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="dayBlock1" >
      <div class="spaceaccountright5_2">时间范围：</div>
      <div class="spaceaccountright5">
           <input  type="radio" name="timeType"  onclick="setSendAsAllTimes()" />
           按全天发送
           <input  type="radio" name="timeType"  onclick="setSendAsCustomer()" checked />自定义发送时间
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <!-- 发送时间段 -->
    <input id="periodTime" type="hidden" name="sendrule.sendruleSendperiodtime"></input>
    <div class="rightsub1_5_1" id="dayBlock2" >
      <div class="spaceaccountright5_2">开始时间：</div>
      <div class="spaceaccountright5">
        <input type="text" name="startTime" value="" id="startTime" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="width:140px" onBlur="checkDate()" readOnly/>
        &nbsp;<span color="red"></div>
      <div class="spaceaccountright5_1"><span id="startTimeTip"></span></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="dayBlock3" >
      <div class="spaceaccountright5_2">结束时间：</div>
      <div class="spaceaccountright5">
        <input type="text" name="endTime" value="" id="endTime"  onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="width:140px" onBlur="checkDate()" readOnly/>
        &nbsp;&nbsp;<span color="red"></div>
      <div class="spaceaccountright5_1"><span id="endTimeTip" style="color:#FF6347"></span></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="rightsub1_5_1">
      <div class="spaceaccountright5_2">手机号码：</div>
      <div class="spaceaccountright5">
            <input type="radio" name="selectMobile" value="0" checked onclick="setMobileStyle(0)" />
            自定义手机号码
            <input type="radio" name="selectMobile" value="1" onclick="setMobileStyle(1)" />
          所有手机号码
        </div>
      
      <!-- 设置的主叫手机号码 -->  
      <input type=hidden id="callingNumbers" name="sendrule.callingNumbers"></input>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="MobileBlock0" >
      <div class="spaceaccountright5_2"></div>
      <div class="spaceaccountright5">
      	*每行输入一个手机号码,您最多可以添加 <s:property value="maxPersonalizeCount"/> 个陕西联通手机号码<br/>
        <textarea id="phones" cols="40" rows="5" onBlur="checkPhone()"></textarea>
        &nbsp;<span class="color14F29400_2" id="phonesTip"></span></div>
      <div class="spaceaccountright5_1">
	      <span class="pause_red">
	           
	      </span>
      </div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
     <div id="MobileBlock1"  >
                <input type="hidden" id="allphones" value="*" />
     </div>
     
    <div class="rightsub1_5_1">
      <div class="spaceaccountright5_2">使用方式：</div>
      <div class="spaceaccountright5">
           <input  type="radio" name="signModel" value="0"  onclick="setStyle(0)" />
          	签名盒
          <input  type="radio" name="signModel" value="1" onclick="setStyle(1)" checked />
          	签名内容
          </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="signPackage" style="display:none"  > 
      <div class="spaceaccountright5_2" >签名盒：</div>
      <div class="spaceaccountright5">
        <input id="packageName" type="text" value="请选择签名盒"   size="40" class="address_input1" readonly/>
      
        <br />
        <a href="javascript:sAlert('view_library.html', 700, 550, '签名盒列表', 5, 15);" class="linkblue02">选择签名盒</a>&nbsp;|&nbsp; 
        <a href="javascript:sAlert('view_collect_library.html', 700, 550, '签名盒收藏', 5, 15);" class="linkblue02">从收藏选择</a>
        <br />
		<br />
		<strong>签名内容：</strong>
		<a href="javascript:openSignPackageDetail();" class="linkblue02">插入签名</a>
		<br />
		<textarea class="rightsub1_3" id="libraryContent" name="libraryContent" readonly>请先选择签名盒，然后插入签名</textarea>
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1" id="signContent"  >
      <div class="spaceaccountright5_2">签名内容：</div>
      <div class="spaceaccountright5">
        <textarea id="sign_set" name="content" cols="40" rows="5"><s:property value="content"/> </textarea>
         <span id="cur_num">0</span>/<span id="max_num">70</span><br>
 			<a href="javascript:sAlert('view_collect.html', 700, 550, '签名收藏管理', 5, 15);" class="linkblue02">从收藏选择</a>&nbsp;|&nbsp;
	        <a href="javascript:sAlert('view_original.html?auditStatus=1', 700, 550, '我的原创签名', 5, 15);" class="linkblue02">我的原创签名列表</a>  
        </div>
   	</div>
    <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:submitPhones();" class="link000">提 交</a></div>
      <!--  
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:document.ruleForm.reset()" class="link000">重 置</a></div>
      -->
    </div>
</div>
</div>

</form>

</div>
</div>
</body>
<script type="text/javascript" language="javascript">
    
/*页面中重置功能相关js*/    
function radioSelect(name)
    {   
    if(name=="signModel"){
       var obj = document.getElementsByName("signModel");
       if(obj[0].checked ){
        setStyle(0);
       }
         if(obj[1].checked ){
        setStyle(1);
       }
   }
  
  if(name=="selectMobile"){
        var  obj = document.getElementsByName("selectMobile");
        if(obj[0].checked ){
            setMobileStyle(0);
        }
       if(obj[1].checked ){
            setMobileStyle(1);
       }
   }
}
/*页面中重置功能相关js*/   
function AttachEvent(target,id)
{
    if(window.attachEvent){//IE
        target[0].attachEvent("onpropertychange",function(){radioSelect(id);});
        target[1].attachEvent("onpropertychange",function(){radioSelect(id);});
    }else{//FF
        target[0].addEventListener("input",function(){radioSelect(id);} ,false);
        target[1].addEventListener("input",function(){radioSelect(id);} ,false);
    }
}

   AttachEvent(document.getElementsByName("signModel"),"signModel");
   AttachEvent(document.getElementsByName("selectMobile"),"selectMobile");

</script>
</html>
