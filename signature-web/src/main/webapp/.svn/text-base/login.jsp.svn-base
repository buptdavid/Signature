<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link
	href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<style>
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shareJs.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-i18n.js"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<script type="text/javascript">
	//自定义jQuery的快捷方式，以避免与其它库的冲突
var $j = jQuery.noConflict();

function onfoucs(objId){
    document.getElementById(objId).focus();
}

window.onload = function () { 
    onfoucs("userId"); 
} 

function modelChange(){
  var modelType = document.getElementById('model').value; 
  if(modelType==1){
      document.getElementById('sendRand').style.display=''; 
      document.getElementById("passLabel").innerHTML="随机短信";
  }else{
      document.getElementById('sendRand').style.display='none'; 
      document.getElementById("passLabel").innerHTML="用户密码";
  }
} 

function changeLoginType(modelType){
   if(modelType==1){
      document.getElementById('sendRand').style.display='';       
      document.getElementById("passLabel").innerHTML="随机短信";
  }else{
      document.getElementById('sendRand').style.display='none'; 
      document.getElementById("passLabel").innerHTML="用户密码";
  }
}

//发送手机随机短信
function sendCode(){
   var userId = document.getElementById('userId').value; 
   if(userId == null || userId == ''){
      alert('请您输入手机号码！');
      return false;
   }else{ 
	 	//jQuery AJAX请求
	 	var url = "send_code.html";
       $j.post(url,{
      	 loginName:userId
       },function(data,textStatus){
      	 if(textStatus == "success"){
      		 var success = data.success;
          	 var message = data.message;
          	 //无论是否发送成功都提示信息
          	 alert(message);
      	 }
      	 
       },"json");
	   
	   
   }
}

function hiddenImg2(){
    //if(objId !='checkcode'){
    if(document.getElementById('_rndImageDIV2')){
         document.getElementById('_rndImageDIV2').style.display='none';
         }
    //}
}
function showImg2(){
    document.getElementById('_rndImageDIV2').style.display='';
}
/*0.刷新随机码*/
function refreshCheckCodeImageImage2() {
    var checkCodeImage2 = document.getElementById('checkCodeImage');
    if (! checkCodeImage2) return;
    checkCodeImage2.src = "image.jsp?random=" + Math.random();
}

/*1.看不清时使用*/
function reLoadFreshCheckCode(){
    refreshCheckCodeImageImage2();
    //设置已经刷新过随机码
    reloadFreshCount=reloadFreshCount+1;
    needRefreshRandCode=false;
    runRandCodeCounter(1);//执行定时器
    $("checkcode").value='';
}

/*2.点击输入框时调用，如果needReloadRandCode为true表示验证码超时，需要重新获取验证才能登录*/
function checkCodeShow() { 
    if(needRefreshRandCode){
        refreshCheckCodeImageImage2();
        haveRefreshRandCode=false;
        needRefreshRandCode=false;
        runRandCodeCounter(2);
        $("checkcode").value='';
    }
} 

/*3.计时器，在下个周期修改状态，再次点击按扭，需要刷新随机码*/
function runRandCodeCounter(type)
{
    if(type==1){//表示点了看不清
        setTimeout("setNeedReloadRandCode1()",60000);
    }else{
        setTimeout("setNeedReloadRandCode2()",60000);
    }
}

/*4.重置刷新状态为需要刷新*/
function setNeedReloadRandCode1(){
    if(reloadFreshCount==0){return ;}
    reloadFreshCount=reloadFreshCount-1;
    if(reloadFreshCount==0){
        needRefreshRandCode=true
    }
}

/*5.重置刷新状态为需要刷新*/
function setNeedReloadRandCode2(){
    if(reloadFreshCount==0){//没有点击看不清按扭
        needRefreshRandCode=true;
    }
}

function getLoginType(){
       var obj = document.getElementsByName("model");
       //密码登录
       if(obj[0].checked ){
        return '0';
       }
       //短信随机码登录
        if(obj[1].checked ){
        return '1';
       }
}

//登录
function divLogin(){
	  $('logintipsDiv').innerHTML='';
      var userId = document.getElementById('userId').value;
      var password =  document.getElementById('password').value;
      var modelType = getLoginType();
      var checkcode;
      if(document.getElementById('checkcode')){
         checkcode = document.getElementById('checkcode').value;
      }else{
         checkcode= "";
      }
      if(!checkPhone(userId)){
          $('logintipsDiv').innerHTML='请输入11位手机号码！';
          document.getElementById('userId').focus();
         return false;
      }

    if(password==''){
         if(modelType=='0'){
           $('logintipsDiv').innerHTML='请输入您的用户密码！';
          }else{
           $('logintipsDiv').innerHTML='请输入随机短信密码！';
          }
         
         document.getElementById('password').focus();
          return false;
      }else{
         if($('_rndImageDIV2')&&$("checkcode").value.trim().length==0){
            $('logintipsDiv').innerHTML='请输入验证码！';
            document.getElementById('checkcode').focus();
            return false;
         }
      
         // 用户登录url
         var url;
         if(modelType == 0){
        	 //密码登录
        	 url = "login_password.html" 
         }else{
        	 //短信随家码登录
        	 url = "login_code.html";
        	 //设置Cookie中requestUrl的值，用于跳转到让用户登录的页面
        	 setCookie("requestUrl","mine.html?frameUrl=my_password.html&menuId=9");
         }
            
         //jQuery AJAX请求
         $j.post(url,{
        	 loginName:userId,
        	 password:password,
        	 checkCode:checkcode
         },function(data,textStatus){
        	 if(textStatus == "success"){
        		 var success = data.success;
            	 var message = data.message;
            	 if(success == true){
            		 //关闭登录对话框
            		 	//userId放入Cookie中
            		 	setCookie("userId",userId);
            			 //登录后的相应操作
            			 parent.removeLoginDialogAfterLogon(message);
            				
            	 }else{
            		 //转向首页
            		 alert(message);
            	 }
        	 }else{
        		// 
        	 }
        	 
         },"json");
         
         return false;
      }
}

//载入手机号码
function loadUser(){
	var uid = getCookie("userId");;
	if(uid && uid.length==11){
	$('userId').value=uid;
	}
}

</script>
</head>

<body class="bodymycenter" onload="loadUser();onfoucs('userId')">
	<form name="loginForm" method="post" >
		<input type="hidden" name="randCodeFlag" value="3" />
		<div class="fc" style="width: 300px; height: 300px;">
			<div class="fc1" style="width: 100%; height: 26px;">
				<div class="fc1_1" style="width: 85%; padding-left: 10px; padding-top: 7px;">用户登录</div>
				<div class="fc1_2">
					<a href="javascript:void(0)"> 
					<img title="关闭登录对话框" src="images/close.gif" border="0"
						onclick="javascript:parent.removeLoginDialog();" />
					</a>
				</div>
			</div>

			<div class="fc2" style="width: 294px; height: 268px;">

				<div class="fc3">
					<span style="color:red">提示：首次登录或忘记密码，请采用 [随机短信] 登录模式登录！</span> <br /> 
					<span class="color14F29400_2" id="logintipsDiv"></span>
				</div>

				<div class="fc3" style="height: 30px; line-height: 30px;">
					手机号码： 
					<input type="text" id="userId" name="loginName" class="banner03_2_2inpt" maxlength="11"
						onmouseover="onfoucs('userId')" align="absmiddle" />
				</div>

				<div class="fc3">
					<span style="">登录模式：</span> 
					<input type="radio" name="model" value="0" onclick="changeLoginType(0)" checked /> 用户密码 
					<input type="radio" name="model" value="1" onclick="changeLoginType(1)" /> 随机短信
				</div>

				<div class="fc3">
					<span id="passLabel" style="">用户密码</span>： 
					<input class="banner03_2_2inpt2" type="password" id="password" title=""
						name="password" maxlength="20" onmouseover="onfoucs('password');"/>
					<label id="sendRand" style="display: none">
					<a class="linkblue02" href="javascript:void(0)" onclick="sendCode();return false;">点击获取</a>
					</label>
				</div>

				<div class="fc3">
					<span style="">验证码：</span> 
					<input style="margin-left: 12px;" type="text" class="banner03_2_2inpt2" id="checkcode" maxlength="4"
						name="checkCode" length="4" autocomplete="off" size="5"
						onmouseover="onfoucs('checkcode');"
						onfocus="checkCodeShow();showImg2()" /> 
				</div>
				<div id="_rndImageDIV2" style="margin-top: -24px; margin-left: 175px; border: solid 1px #545454; display: none; height: 21px !important; height: 21px; overflow: hidden;">
					<div style="float: left;">
						<img id="checkCodeImage" src="image.jsp" style="cursor: pointer; margin-bottom: 5px" width="65" height="20" />
					</div>
					<div style="float: left; margin-top: 5px;">
						<span title="点击更换" onclick="$('checkcode').focus();reLoadFreshCheckCode();" style="cursor: pointer;">看不清？</span>
					</div>
				</div>

				<div class="fc4" style="padding-left: 81px;">
					<input width="70"  height="28" style="cursor:pointer;" name="queryButton2" type="button" class="btn_style_login" id="queryButton2" onclick="divLogin()"  value="" />
				</div>
			</div>
		</div>



	</form>


</body>
</html>