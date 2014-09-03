<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>签名盒列表</title>
<link href="<%=request.getContextPath()%>/css/p_window.css" rel="stylesheet" type="text/css" />

<style>
html { overflow-x:hidden; }
</style>
<script src="<%=request.getContextPath()%>/js/js-i18n.js" type="text/javascript"></script> 
</head>
<script type="text/javascript">
function autoSet(obj) {
    var param0=obj.param0;
    var param1=obj.param1;
    var param2=obj.param2;
    var param3=obj.param3;
    if(typeof param0 =='undefined'){
            param0=obj.getAttribute("param0");
            param1=obj.getAttribute("param1");
            param2=obj.getAttribute("param2");
            param3=obj.getAttribute("param3");
    }
    parent.setSignPackage(param0, param1,param2,param3);
}

var sobj = null;
var itm="";
function changeType(obj) {
    var opt = obj.options[obj.selectedIndex]; 
    if(sobj != null) {
        sobj.innerHTML = itm;
    }
    for(var i=0; i<obj.options.length; i++){
        if(obj.options[i].value == opt.getAttribute('parentId')) {
            itm = opt.innerHTML;
            opt.innerHTML = "&nbsp;&nbsp;" + obj.options[i].getAttribute('realtext') + "|" + opt.getAttribute('realtext');
            sobj = opt;
            break;
        }
    }
} 
</script>

<body>
 <form id="myForm" name="myForm"  method="post"   action="view_library.html"> 
    <div class="rightsub2_0">
        <div class="rightsub2_2" style="width:220px;">分类：
        
        <select id="signGroupId" onchange="javascript:changeType(this);" name="firstClassId"> 
        		<option value="">&nbsp;所有分类&nbsp;</option>
        		<s:iterator value="firstClasses" id="firstClass">        		
                <option value="<s:property value='#firstClass.id'/>" <s:if test="#firstClass.id == #request['firstClassId']">selected</s:if>>&nbsp;<s:property value='#firstClass.name'/></option>
                </s:iterator>                
        </select> 
          
        </div>
        <div class="rightsub2_2">关键字：
           <input name="keyWord" type="text" class="rightsub2_1" value="<s:property value='keyWord'/>"/>
        </div>
        <div class="rightsub2_3">
          <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
          <a href="javascript:document.getElementById('myForm').submit();" class="link000">查 询</a></div>
        </div>
    </div>
    </form>
 

<div>   
    <div>
    <div class="fwindows3_0">
      <table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <td width="13%" height="29" align="center" bgcolor="#CCEBFA" >选择</td>          
          <td width="20%" align="center" bgcolor="#CCEBFA" >签名盒ID</td>
          <td width="25%" align="center" bgcolor="#CCEBFA" >签名盒</td>
          <td width="20%" align="center" bgcolor="#CCEBFA" >所属分类</td>
          
       </tr>
       <s:iterator value="secondClasses" id="secondClass">
       <tr bgcolor="#f8f8f8">       	 
          <td align="center" >
          	<input name="ro" type="radio" onclick="autoSet(this)" id="ro" 
          		 param0="<s:property value='#secondClass.id'/>"  
                 param1="<s:property value='#secondClass.name'/>"
                 param2=""
                 param3=""
          	>
          </td>
		  <td align="left" style="padding-left:10px;" height="29">
          	<a class="linkblue02" href=""><s:property value="#secondClass.id"/> </a>
          </td>
          <td align="left" style="padding-left:10px;" height="29">
			<s:property value="#secondClass.name"/>               
		  </td>	
          <td align="left" style="padding-left:10px;" height="29">
          	<s:property value="#secondClass.firstClass.name"/>
          </td>
        </tr>  
        </s:iterator>             
      </table>
    <div style="margin-right:15px;">
      	<!-- 分页 -->
		<s:include value="page.jsp">
			<s:param name="pageUrl" value="'view_library.html?'"></s:param>
		</s:include> 
	</div>
</div>
            
    <div style="align:center;width:150px;padding-left:300px;"> 
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" 
      onmouseout="this.className='botton_bg'"><a href="javascript:parent.pRemoveAlertBase();"
       class="link000"  >关闭弹出框</a></div>
    </div>
    


</body>
</html> 
