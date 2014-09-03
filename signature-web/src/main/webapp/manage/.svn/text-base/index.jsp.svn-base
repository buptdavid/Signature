<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<link href="./css/login.css" rel="stylesheet" type="text/css" />
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<script type="text/javascript">

//登录
function manageLogin(){
	$("#logintipsDiv").html("");
	var userId = document.getElementById("userId").value;
	var password =  document.getElementById("password").value;
	var checkCode = document.getElementById("checkCode").value;
	//验证手机号码
	if(userId==""){
        $("#logintipsDiv").html("请输入用户名！");
        document.getElementById("userId").focus();
       return false;
    }
	
	if(password==""){
		$("#logintipsDiv").html("请输入密码！"); 
		document.getElementById("password").focus();
        return false;
	}
	
	if(checkCode==""){
		$("#logintipsDiv").html("请输入验证码！"); 
        document.getElementById("checkCode").focus();
        return false;
     }
	
	//管理员登录
	var url = "manage_login.html";
	
	
	//jQuery AJAX请求
    $.post(url,{
   	 loginName:userId,
   	 password:password,
   	 checkCode:checkCode
    },function(data,textStatus){
   	 if(textStatus == "success"){
   		 var success = data.success;
       	 var message = data.message;
       	 if(success == true){
       		 //登录成功
       		window.location.href = "main.html";
       	 }else{
       		 //登录失败
       		$("#logintipsDiv").html(message);
       	 }
   	 }else{
   		// 
   	 }
   	 
    },"json");
    
    return false;
}


/*刷新验证码*/
function reLoadFreshCheckCode(){
    var checkCodeImage = document.getElementById("checkCodeImage");
    checkCodeImage.src = "<%=request.getContextPath()%>/image.jsp?random=" + Math.random();
}

</script>
</head>
<body>
<form name="loginForm"  method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="512" border="0" align="center" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="512" height="113" >&nbsp;</td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="131" height="131"  >&nbsp;</td>
            <td width="241"  >
             <table width="100%" border="0" cellspacing="4" cellpadding="0">	             
              <tr>
              	<div align="center">
						<span class="login_tips_text" id="logintipsDiv"></span>
				 </div>
                <td width="20%" height="25" class="login_text">用户名</td>
                <td width="53%" height="25"><div align="center">
                  <input type="text" name="loginName" class="login_input" id="userId">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25" class="login_text">密&nbsp;&nbsp;码</td>
                <td height="25"><div align="center">
                  <input type="password" name="password" class="login_input" id="password">
                </div></td>
                <td height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25" class="login_text">验证码</td>
                <td height="25">
                <input type="text" class="login_input" id="checkCode"></td>
                <td height="25">
                	<div style="float: left;">
						<img id="checkCodeImage" src="<%=request.getContextPath()%>/image.jsp" style="cursor: pointer; margin-bottom: 5px" width="55" height="23" onclick="reLoadFreshCheckCode();" title="点击更换" />
					</div>
				</td>
              </tr>
            </table></td>
            <td width="140"  >&nbsp;</td>
          </tr>
          <tr>
            <td height="23"  >&nbsp;</td>
            <td height="23" colspan="2"  > 
            	<INPUT type="button" id="map1" name="map1" value="登录"  onClick="manageLogin()" class="btn_login"/> &nbsp;
            	<INPUT type="reset" id="map" name="map" value="重置" onClick="openMap()" class="btn_login"/>
              </td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="213"  >&nbsp;</td>
      </tr>
    </table>
    </form>
    </td>
  </tr>
</table>
</body>
</html>
