<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>原创签名选择弹出框</title>
<link href="<%=request.getContextPath()%>/css/p_window.css" rel="stylesheet" type="text/css" />

<style>
html { overflow-x:hidden; }
</style>
<script src="js/js-i18n.js" type="text/javascript"></script> 
</head>
<script type="text/javascript">
function autoSet(obj) {
    var param0=obj.param0;
    var param1=obj.param1;
    if(typeof param =='undefined'){
            param0=obj.getAttribute("param0");
            param1=obj.getAttribute("param1");
        }
    parent.autoSet(param0,param1);
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
 <form id="myForm" name="myForm"  method="post"   action="view_original.html"> 
    <div class="rightsub2_0">
     <div class="rightsub2_2">关键词：
           <input name="keyWord"  type="text" class="rightsub2_1"  value="<s:property value='keyWord'/>"/>
     </div>
     <div class="rightsub2_3">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
          <a href="javascript:document.getElementById('myForm').submit();" class="link000">查 询</a></div>
        </div>
    </div>
 </form>
    <div class="fwindows3_0">
      <table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <td width="3%" height="29" align="center" bgcolor="#CCEBFA" >选择</td>
          
          <td width="8%" align="center" bgcolor="#CCEBFA" >签名分类</td>
          <td width="30%" align="center" bgcolor="#CCEBFA" >签名内容</td>
       </tr>
       <s:iterator value="originals" id="original">
       <tr bgcolor="#f8f8f8">
          <td align="center" >
             <input name="ro" type="radio" onclick="autoSet(this)" id="ro" 
                    param0="<s:property value='#original.content'/>"
                    param1="<s:property value='#original.id'/>"
             >
           </td>                  
           <td align="left" style="padding-left:10px;" height="29">
				<s:property value="#original.signatureClass.name"/>
		   </td>
           <td align="left" style="padding-left:10px;" height="29">
				 <s:property value="#original.content"/> 
			</td>
         </tr>
        </s:iterator>      
      </table>
   <div>
      <div style="margin-right:15px;">
		<!--分页--> 
		<s:include value="page.jsp">
			<s:param name="pageUrl" value="'view_original.html?'"></s:param>
		</s:include> 
      </div>
    </div>  
</div>
            
    <div style="align:center;width:150px;padding-left:300px;"> 
      <div class="botton_bg" onmouseover="this.className='botton_bg_over'" 
      onmouseout="this.className='botton_bg'"><a href="javascript:parent.pRemoveAlertBase();"
       class="link000"  >关闭弹出框</a></div>
    </div>
    


</body>
</html> 
