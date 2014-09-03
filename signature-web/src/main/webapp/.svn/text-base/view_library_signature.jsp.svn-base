<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>签名盒详情</title>
<link href="<%=request.getContextPath()%>/css/p_window.css" rel="stylesheet" type="text/css" />

<style>
html { overflow-x:hidden; }
</style>
<script src="<%=request.getContextPath()%>/js/js-i18n.js" type="text/javascript"></script> 
<style>

<!--
html { overflow-x:hidden; }

.fc {
    float:left;
    height:32px;
}
.fc1 {
    float:left;
    height:26px;
    background-image:url(/cy/gd//images/login_bg_fd_2.gif);
}
.fc1_1 {
    float:left;
    padding:4px 0 0 0;
    font-size:12px;
    font-weight:bold;
    color:#fff;
}
.fc1_2 {
    float:left;
    padding-top: 5px;
}
.fc2 {
    float:left;
    border:solid 1px #8fdcf7;
    border-top:none;
    padding-bottom:15px;
    background-color:#fff;
    padding: 2px;
}
.fc3 {
    margin:auto;
    width:85%;
    font-size:12px;
    padding-top:8px;
}
.fc3_2 {
    margin:auto;
    padding:5px;
    font-size:12px;
    line-height:24px;
    color:#4B5661;
}
.fc3_3 {
    margin:auto;
    padding-top:10px;
    text-align:center;
}
.fc4 {
    padding-top:8px;
}

-->
</style>
</head>
<script type="text/javascript">
	function insertSig(obj) {
    	var param0=obj.param0;
    	var param1=obj.param1;
    	if(typeof param0 =='undefined'){
            param0=obj.getAttribute("param0");
            param1=obj.getAttribute("param1");
   	 }
     parent.setInsertSig(param0, param1);
	}
</script>
<body>

<div >
	
	<div >
	 <div class="fwindows3_2" id="page_div">  
	 <strong>签名盒信息</strong></div>
	 <div class="fwindows3_3"> 
	 签名盒名称： <span class="color0167B2"><s:property value="library.name"/> </span>&nbsp;&nbsp;&nbsp;<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong>
	 签名盒编号：<span class="color0167B2"> <s:property value="library.id"/> </span><br />
	 签名盒分类： <span class="color0167B2"><s:property value="library.firstClass.name"/></span><br />
	 </div>
	 <div class="fwindows3_2">  
	 <strong>签名列表</strong></div>
	  <div class="fwindows3_0">
        <table width="100%" border="0" cellspacing="1" cellpadding="0">        
          <tr>
            <td width="12%" height="29" align="center" bgcolor="#CCEBFA">序号</td>
            <td width="75%" align="center" bgcolor="#CCEBFA">内容</td>
            <td width="8%" align="center" bgcolor="#CCEBFA">选择</td>
          </tr>
          <s:iterator value="signatures" id="signature" status="st">           
          <tr  bgcolor="#f8f8f8">
            <td width="12%" height="25" align="center"><s:property value="#st.count"/> </td>
            <td width="75%" align="left" id="spSign_0"><s:property value="#signature.content"/> </td>
            <td width="8%" align="center">
                <a title="插入该签名" href="javascript:void(0)" onclick="insertSig(this)"
                	 param0="<s:property value='#signature.id'/>"  
                 	 param1="<s:property value='#signature.content'/>"
                >
                <img src="images/qmjh-wyy.gif"  width="16" height="16" border="0" /></a>&nbsp;&nbsp;
            </td>
          </tr>
          </s:iterator>         
        </table>
        <div style="margin-right:15px;">
      		<!-- 分页 -->
			<s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_library_signature.html?library.id='+#request[library.id]+'&'"></s:param>
			</s:include> 
		</div>
      </div>
    <div style="width:150px; margin:auto;">
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:parent.pRemoveAlertBase();" class="link000"  >关闭弹出框</a></div>
    </div>
  </div>	
</div>



</body>
</html> 
