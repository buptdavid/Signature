<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>黑白名单设置</title>
<link href="<%=request.getContextPath()%>/css/mycmccqm.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/type.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script type="text/javascript"> 
//添加黑名单
function addBlackWhite(){
        var phone = document.getElementById('phone1').value; 
        if(phone==''){
            alert('请在手机号码1输入框中输入手机号码！');
            return ;
        }        
        var re = new RegExp("^(|([0]?[0-9]{2,3}(\-)?)?([0-9]{1}[0-9]{6,7}){1}(\-[0-9]{1,4})?)$");
        
    for(var i=1;i<=5;i++){
        if(document.getElementById('phone'+i)){
            phone=document.getElementById('phone'+i).value;
        	if((phone.trim().length>0&&phone.trim().length<11)||!re.test(phone)){
        	   alert('手机号码'+i+'格式不正确，请重新输入！'); 
        	   return ;
        	}
    	}
	}
	
	if(confirm('您确认添加吗？')) {
           document.forms["blackList"].action = 'create_black_white.html';
           document.forms["blackList"].submit(); 
       }
}

//开启黑白名单
function openBlackWhite(flag){ 
       var msg = '';
       if(flag == '1'){
          msg = '您确定要启用白名单功能吗？';
       }else if(flag == '2'){
          msg = '您确定要启用黑名单功能吗？';
       }
       if(confirm(msg)){
           document.location.href= 'set_black_white.html';
       } 
}
String.prototype.trim = function() { 
    return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 

 //批量删除       
function batchdelete() {
    var ids=commonBatchDel(document.deleteList.cb);
    if(ids!=""){
    	document.deleteList.action="delete_black_white.html";
    	document.deleteList.submit();
    }        
}

</script> 
</head>
<body style="width:100%;height:100%" class="bodymycenter">

<div class="mycmccqm_right1">黑白名单设置</div>

<div class="mycmccqm_right2">
	<div class="rightsub2_0">
	
	<div style="float:left; width:670px; margin-bottom:10px;" >当前启用：
	<span class="color14F29400"><strong><% Integer type = (Integer)request.getAttribute("specialNumberType"); if(type.equals(1)){ %>黑名单 <% }else{ %>白名单<% } %> &nbsp;&nbsp;</strong></span> <span class="colora3a3a3"><% if(type.equals(1)){ %>(与黑名单列表内的用户通话，不推送手机签名。)<% }else{ %> (只有与白名单中的用户通话，才会推送手机签名。)  <% }%>	</span>
	   
	   <br />

	   <br/>
            <b>温馨提示</b>：您最多可以设置<span class="color14F29400"><strong><s:property value="maxNum" />  </strong></span>个黑白名单。您已经设置黑名单<s:property value="blackNum" />个，白名单<s:property value="whiteNum" />个，您还可以设置${maxNum - blackNum - whiteNum}个黑白名单。 <br/>
	</div>
	
	<div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:openBlackWhite(<s:property value='specialNumberType'/> )" class="link000" ><% if(type.equals(1)){ %>启用白名单<% }else{ %>启用黑名单<% } %></a></div>
	</div>

	<!-- 用于显示操作后的信息 -->
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
	<form action="" name="deleteList"  method="post"> 
	<div class="rightsub2_5">	 
	  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
	  <tr>
	    <th width="4%" align="center" bgcolor="#CCEBFA"><input type="checkbox" name="checkbox3" onclick="selectAll(this.checked);" value="checkbox" /></th>
		<th width="36%" height="29" align="center" bgcolor="#CCEBFA">名称</th>
		<th width="45%" align="center" bgcolor="#CCEBFA">手机号码</th>
		<th width="19%" align="center" bgcolor="#CCEBFA">操作</th>
	  </tr>
	  <s:iterator  value="specialNumbers" id="specialNumber">
	  <tr>
	    <td  align="center" bgcolor="#f8f8f8"><input type="checkbox" name="cb" value="<s:property value='#specialNumber.id' />" /></td>
		<td height="30" align="center" bgcolor="#f8f8f8"> <s:property value="#specialNumber.remark"/> </td>
		<td align="center" bgcolor="#f8f8f8"><s:property value="#specialNumber.specialNumber"/></td>
		<td align="center" bgcolor="#f8f8f8">
		<img  title="删除" src="images/delete_16x16.gif" style="cursor:hand;" type="submit"
             onclick="if(window.confirm('您确定要删除该号码？')){toUrl('delete_black_white.html?cb=<s:property value="#specialNumber.id" />','');}"/>
		</td>
	  </tr>
	  </s:iterator>
	</table>
	</div>
	
	 <div class="rightsub715" style=" margin-bottom:0px;">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除</a></div>
    </div>
    
    <div class="rightsub_fy" >
		<!-- 分页 -->
    	<s:include value="page.jsp">
			<s:param name="pageUrl" value="'manage_list.html?'"></s:param>
		</s:include>
	</div>
	</form>
	
   <form action="" name="blackList" method="post">   
    <div class="rightsub2_0">

      <div class="rightsub2_2">用户名称1：
        <input name="specialNumbers[0].remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>
      </div>
      <div class="rightsub2_2">手机号码1：
        <input id="phone1" name="specialNumbers[0].specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
        <b><font style="color:red">*</font></b>
      </div>
      
      <div class="rightsub2_2">用户名称2：
        <input name="specialNumbers[1].remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>
      </div>

      <div class="rightsub2_2">手机号码2：
        <input id="phone2" name="specialNumbers[1].specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
        
      </div>
      
      <div class="rightsub2_2">用户名称3：
        <input name="specialNumbers[2].remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>
      </div>
      <div class="rightsub2_2">手机号码3：
        <input id="phone3" name="specialNumbers[2].specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
        
      </div>
      
      <div class="rightsub2_2">用户名称4：
        <input name="specialNumbers[3].remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>

      </div>
      <div class="rightsub2_2">手机号码4：
        <input id="phone4" name="specialNumbers[3].specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
        
      </div>
      
      <div class="rightsub2_2">用户名称5：
        <input name="specialNumbers[4].remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>
      </div>
      <div class="rightsub2_2">手机号码5：
        <input id="phone5" name="specialNumbers[4].specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
        
      </div>
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:addBlackWhite()"  class="link000">添加</a></div>
      
    </div>
    </form>
</div>

</body>
</html>
