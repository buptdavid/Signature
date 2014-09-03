<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>

<title>我的个人资料</title>

<style type="text/css">
    .preview-image {
      display: block;
      margin: 10px 0;
      border: solid 3px #aaa;
      padding: 1px;
      background: #fff;
    }
  </style>
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">
var isclicked=false;

function checkDumpClick(){
    if(!isclicked){
    isclicked=true;
    }else{
        alert("您的请求已经提交！");
        return ;
    }
    
}

</script></head>

<body  onload="loadTxLisnter('remark');">
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">个人信息维护</span></div>

<div id="RightMain_end">

<form action="update_info.html" name="updateForm" method="POST" >
<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
<div class="mycmccqm_right2">	
  <div class="rightsub1_5" style=" padding-left:15px; width:690px;">
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">手机号码： </div>
      <div class="spaceaccountright5"><span class="color14F29400"><s:property value="stUser.loginName"/> </span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">昵称：</div>
      <div class="spaceaccountright5">
         
        <input name="stUser.name" type="text"  maxlength="8"  value="<s:property value='stUser.name'/>"  size="20" />
        </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">邮箱地址：</div>
      <div class="spaceaccountright5">
        <input name="stUser.email"  type="text" maxlength="30"  value="<s:property value='stUser.email'/>"   size="30" />
        &nbsp;&nbsp;<span class="colora3a3a3">最长30位</span> <span class="colorhot"></span> </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">备注：</div>
      <div class="spaceaccountright5">
        <textarea id="remark" name="stUser.remark" cols="40" rows="5" maxlength="80"><s:property value="stUser.remark"/></textarea>
        <span id="cur_num">0</span>/<span id="max_num">80</span></span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:checkDumpClick();document.updateForm.submit();" class="link000">提 交</a></div>
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:document.updateForm.reset();txChange('remark');" class="link000">重 置</a></div>
    </div>
    </div>
</div>
</form>

</div></div>

</body>
</html>