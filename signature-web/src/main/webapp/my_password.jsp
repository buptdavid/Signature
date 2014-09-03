<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/checkpwd.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js-i18n.js" type="text/javascript"></script> 

<title>修改密码</title>
<script type="text/javascript" >
function changPsw() {
    var npwd = document.getElementById("npwd").value;
    var rnpwd = document.getElementById("rnpwd").value;    
    if(npwd == "") {
        alert("新密码不能为空");  
        return;    
    }
    if(rnpwd == "") {
        alert("确认密码不能为空");    
        return;   
    }
    if(npwd.length < 6) {
        alert("新密码长度应在6-20位以内");    
        return;   
    }
    if(!(/^\S+$/.test(npwd))) {
        alert("新密码不能包含空格");   
        return;    
    }
    if(npwd != rnpwd) {
        alert("两次密码输入不一致");  
        return;     
    }    
   
    //if(pwdRank == 0) {
        //alert("您设置的密码过于简单，系统将不允许修改，请至少包含字母、数字和特殊符号中的两种！");   
        //return;    
   // }
    document.passwordForm.submit();
}
</script>
<style type="text/css">
#pwdpower {
width:125px;
border:0px none;
background-color:#f1f1f1
}
#pwdpower td {
text-align:center;
vertical-align:middle;
padding:1px;
color:#adadac;
}
#pwdpower #pweak{
border-right:1px solid #dedede;
}
#pwdpower #pmedium{
border-right:1px solid #dedede;
}
#pwdpower #pstrong{

}
</style>
</head>

<body>
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">修改密码</span></div>

<div id="RightMain_end">

<form action="update_password.html"  name="passwordForm" method="post" >
  <div class="mycmccqm_right2">
    <div class="rightsub1_5" style=" padding-left:15px; width:690px;">
    <%  //判断是否需要提示修改密码（即通过短信随机码登录）
    	Boolean isPassword = (Boolean)session.getAttribute("isPassword"); 
       if(isPassword != null && isPassword.equals(true)){ %>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">温馨提示： </div>
      <div class="spaceaccountright5"><span style="color:red">请先修改您的密码！ </span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <% 	   
       }
    %>
    
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">手机号码： </div>
      <div class="spaceaccountright5"><span class="color14F29400">${user.loginName } </span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2" style="height:30px;">新密码：</div>
      <div class="spaceaccountright5">
        <input onchange="javascript:EvalPwd(this.value);" onkeyup="javascript:EvalPwd(this.value);" id="npwd" name="password" type="password" maxlength="20" />
        &nbsp;&nbsp;<span class="color14F29400_2">*</span><span class="colora3a3a3"> 密码长度应在6-20位以内，不能包含空格</span></div>
      <div class="spaceaccountright5">
	  <div id="pweak" class="contpw01" style="background-color:#F1F1F1;color:#adadad">弱</div>
	  <div id="pmedium" class="contpw01" style="background-color:#F1F1F1;color:#adadad">中</div>
      <div id="pstrong" class="contpw01" style="background-color:#F1F1F1;color:#adadad">强</div>
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">确认新密码：</div>
      <div class="spaceaccountright5">
        <input id="rnpwd" type="password" maxlength="20" />
        &nbsp;&nbsp;<span class="color14F29400_2">*</span> <span class="colora3a3a3">请再次输入前面的新密码</span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:changPsw()" class="link000">提 交</a></div>
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:document.passwordForm.reset()" class="link000">重 置</a></div>
    </div>
  </div>
</div>
</form>
</div>

</div>

</body>
</html>