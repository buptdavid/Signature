<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="js/shareJs.js" type="text/javascript"></script>

<title>拒绝签名</title>
<script type="text/javascript"> 
//添加拒签名单
function addSpn(){
    var phone = document.getElementById('phone').value; 
    if(phone==''){
        alert('请输入手机号码！');
        return ;
    }
    if(phone=='${user.loginName}'){
        alert('对不起，您不能拒接您自己的手机号码，请重新输入手机号码');
        return ;
    }
    var re = new RegExp("[1-9][0-9]{10}");
    if(!re.test(phone)){
       alert('手机号码格式不正确！'); 
       return;
    }
    else{
       if(confirm('您确认添加吗？')) {
           document.myForm.action = 'create_refuse.html';
           document.myForm.submit(); 
       }
    }
}

//恢复拒绝签名号码
function deleteSpn(id){
    if(confirm('您确认恢复接收此手机号码的签名吗？')) {
        document.location.href= 'delete_refuse.html?cb='+id; 
    }
}

//批量删除
function batchdelete() {
    var ids=commonBatchDel(document.recordList.cb);
    if(ids!=""){
    	document.recordList.action="delete_refuse.html";
    	document.recordList.submit();
    }        
}

</script> 
</head>

<body>
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">拒接签名设置</span></div>

<div id="RightMain_end">


<div class="mycmccqm_right2">
    <!-- 用于显示操作后的信息 -->
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
	
    <form name="recordList" action="" method="post">
    <div class="rightsub2_5">
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
      <tr>
        <th width="4%" align="center" bgcolor="#CCEBFA"><input type="checkbox" name="checkbox3" onclick="selectAll(this.checked);" value="checkbox" /></th>
        <th width="35%" align="center" bgcolor="#CCEBFA">拒接手机号码</th>
        <th width="36%" height="29" align="center" bgcolor="#CCEBFA">备注</th>
        <th width="29%" align="center" bgcolor="#CCEBFA">操作</th>
      </tr>
      <s:iterator  value="specialNumbers" id="specialNumber">
      <tr>
        <td  align="center" bgcolor="#f8f8f8"><input type="checkbox" name="cb" value="<s:property value='#specialNumber.id' />" /></td>
      <td align="center" bgcolor="#f8f8f8"><s:property value="#specialNumber.customerName"/></td>
        <td height="30" align="center" bgcolor="#f8f8f8"><s:property value="#specialNumber.remark"/> </td>
        <td align="center" bgcolor="#f8f8f8"><a href="javascript:deleteSpn('<s:property value="#specialNumber.id"/>')"  class="linkblue02">恢复</a></td>
      </tr>
     </s:iterator>
    </table>
    </div>
    </form>
    
    <div class="rightsub715" style=" margin-bottom:0px;">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除</a></div>
    </div>
    
    <div class="rightsub_fy" >
    	<!-- 分页 -->
    	<s:include value="page.jsp">
			<s:param name="pageUrl" value="'manage_refuse.html?'"></s:param>
		</s:include>
    </div>
    
    <form  name="myForm" id="myForm">
    <div class="rightsub2_0">
      <div class="rightsub2_2">手机号码：
        <input id="phone" name="specialNumber.specialNumber" type="text" class="rightsub2_1" value="" maxlength="11"/>
      </div>
      <div class="rightsub2_2">备注：
        <input name="specialNumber.remark" type="text" class="rightsub2_1"  value="" maxlength="20"/>
      </div>
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
      <a href="javascript:addSpn()"  class="link000">添加拒接手机号码</a></div>
    </div>
    </form>
    
</div>
</div>


</div>


</body>
</html>