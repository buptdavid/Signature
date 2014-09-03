<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>

<script type="text/javascript">

//提交签名
function addCsSign(){
   
    var content = $("signContext").value;
    
    if(/^\s*$/.test(content)){
       alert("请输入签名内容！");
       return ;
    } 
        
    
    document.forms[0].submit();
}

</script> 
<title>创建原创签名</title>
</head>

<body onload="loadTxLisnter('signContext');">
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">创建签名</span></div>

<div id="RightMain_end">
 	
  <form action="create_original.html" id="cmc_fm" method="post">

      <div class="rightsub1_4" style="padding:5px 0px 5px 10px; margin-top:15px; width:705px;">提交新签名<br />
      </div>
      
     <div class="rightsub2_0">
       <div style="float:left; width:670px; margin-bottom:10px;" >
            <b>温馨提示</b>：如果您在 [提交] 时选择了 [公开此签名] ，提交成功之后，签名审核通过后将显示在门户签名库中。<br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每天最多可创建 <s:property value="maxCountOriginal"/> 条原创签名
        </div>
    </div>
    

<div class="rightsub1_5_2 color14F29400" id="servertips">
</div>
    
      <div class="rightsub1_5" style=" padding-left:15px; width:690px;">
        <div class="spaceaccountright5_0">
            
          <div class="spaceaccountright5_2">签名分类：</div>
          <div class="spaceaccountright5" >
                <select id="signGroupId" name="original.signatureClass.id">
                		<s:iterator  value="classes" id="firstClass">
                		 <option value="<s:property value='#firstClass.id'/>" realtext="<s:property value='#firstClass.name'/>">&nbsp;<s:property value="#firstClass.name"/></option>
                		 	<s:iterator value="#firstClass.secondClasses" id="secondClass">
                		 	<option value="<s:property value='#secondClass.id'/>" realtext="<s:property value='#secondClass.name'/>" parentId="<s:property value='#firstClass.id'/>">&nbsp;&nbsp;|---&nbsp;<s:property value="#secondClass.name"/></option>
               				</s:iterator>
                        </s:iterator>
                </select>
                
                <span class="color14F29400_2">* </span>公开此签名
                <input type="checkbox" id="openSign" name="original.publish" checked value="true"/>
          </div>
          
          <div class="spaceaccountright5_1"></div>
          <div class="spaceaccountright5_1"></div>
        </div>
       

        <div class="spaceaccountright5_0" id="actionCheckCodeDiv" style="display:none;" >
          <div class="spaceaccountright5_2">校验码：</div>
          <div class="spaceaccountright5">
            <input type="text" id="actionCheckCode"  style="width;50px;" maxlength="4" />
            <img id="SigncreateCheckCodeImage" style="cursor:pointer;margin-bottom:5px"  
            src="csp.CheckCode?random=20110812144450" 
            onclick="this.src='csp.CheckCode?random='+ Math.random();"
             width="65" height="20" />
             <span class="color14F29400_2"> *</span></div>
          <div class="spaceaccountright5_1"></div>
          <div class="spaceaccountright5_1"></div>
        </div>
       
        <div class="spaceaccountright5_0">
          <div class="spaceaccountright5_2">签名内容：</div>
          <div class="spaceaccountright5">
            <textarea name="original.content" id="signContext" cols="40" rows="5"></textarea>
            <span class="color14F29400_2"> *</span>        &nbsp;<span id="cur_num">0</span> / <span id="max_num">70</span> </div>
          <div class="spaceaccountright5_1"></div>
          <div class="spaceaccountright5_1"></div>
        </div>
        <div class="rightsub1_5_1"  style="margin-top:15px; padding-left:110px; width:400px;">
          <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:addCsSign();" class="link000">提 交</a></div>
          <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:$('cmc_fm').reset();txChange('signContext');" class="link000">重 置</a></div>
          
          <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="my_original.html" class="link000">返回原创列表界面</a></div>
        </div>
      </div>

  </form>

</div></div>


</body>
</html>
