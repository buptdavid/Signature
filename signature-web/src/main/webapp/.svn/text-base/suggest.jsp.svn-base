<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>

<title>意见</title>

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
</head>
<body  onload="loadTxLisnter('content');">
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">我的建议和意见</span></div>

<div id="RightMain_end">
  <form id="sug_form" method="post" action="submit_suggest.html">
  <div class="mycmccqm_right2" >
  <div class="rightsub1_5" style=" padding-left:15px; width:690px;">
  <input type="hidden" name="suggest.loginName" value="<s:property value='stUser.loginName'/>"/>
  <s:property value=''/>
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">姓名：</div>
      <div class="spaceaccountright5">
        <input type="text" size="20" maxlength="20" name="suggest.name"  value="<s:property value='stUser.name'/>"/>
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">手机号码：</div>
      <div class="spaceaccountright5">
        <input type="text" size="20" maxlength="11" id="phone" name="suggest.mobile" value="<s:property value='stUser.loginName'/>"/>
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">邮箱地址：</div>
      <div class="spaceaccountright5">
        <input type="text" size="30" id="email" maxlength="50" name="suggest.email" value="<s:property value='stUser.email'/>"/>
      </div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">标题：</div>
      <div class="spaceaccountright5">
        <input type="text"  size="40" maxlength="100" name="suggest.title" id="title"/>
        &nbsp;&nbsp;&nbsp;<span class="color14F29400_2">*</span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="spaceaccountright5_0">
      <div class="spaceaccountright5_2">内容：</div>
      <div class="spaceaccountright5">
        <textarea cols="40" rows="5" maxlength="200" name="suggest.content" id="content"></textarea>
        &nbsp;<span id="cur_num">0</span> / <span id="max_num">200</span> <span class="color14F29400_2">*</span></div>
      <div class="spaceaccountright5_1"></div>
      <div class="spaceaccountright5_1"></div>
    </div>
    
    <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:if(suggestion.doSubmit())$('sug_form').submit()" class="link000">提 交</a></div>
      
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:$('sug_form').reset();txChange('content');" class="link000">重 置</a></div>
       
    </div>
    
  </div>
</div>
</form>

<script type="text/javascript">
var suggestion = {
  doSubmit : function() {
    var title = $("title").value.trim();
    if((/^\s*$/).test(title)) {
        alert('您输入的标题不能为空！');
        return false;
    } 
    if(!checkPhone($('phone').value)){
        alert('您输入的手机号码格式错误，请输入11位正确的手机号码！');
            return false;
    }
    var content = $("content").value.trim();
    if((/^\s*$/).test(content)) {
        alert('您输入的内容不能为空！');
        return false;
    }
    var email = $("email").value.trim();
    var re =/[\u4E00-\u9FA5]{1,}/ig; 
    if(email.match(re)){
        alert('请您输入正确的Email，不能包含中文字符！');
        return false;
    }
    
    if(!((/^\s*$/).test(email)) && !((/^\S+@\S+\.\S+$/).test(email))) {
        alert('请您输入正确的Email！');
        return false;
    } 
    if(confirm('您是否确认提交？')) {
        return true;
    } 
    return false;
  } 
};
</script> 

</div></div>
</body>
</html>