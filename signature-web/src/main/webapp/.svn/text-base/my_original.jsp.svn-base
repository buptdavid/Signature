<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="js/shareJs.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<title>我的原创签名</title>
</head>
<body>
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">我的原创签名</span></div>

<div id="RightMain_end">

<div class="mycmccqm_right2" id>
    <form id="myForm" name="myForm"  method="post"   action="my_original.html"> 
	<div class="rightsub2_0">
    	
        <div class="rightsub2_2">签名内容：
	       <input name="keyWord"  type="text" class="rightsub2_1" value="<s:property value='keyWord' />" />
	    </div>
    	<div class="rightsub2_3">
    	  <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="javascript:document.getElementById('myForm').submit();" class="link000">查 询</a></div>
        </div>
        
       <div style="float:left; width:670px; margin-bottom:10px;" >
            <b>温馨提示</b>：<br/>
            1、如果只需要编辑签名设为自己的当前签名，可直接在 [修改默认签名] 中进行设置；<br/>
            2、在此界面您[创建签名]时：默认被公开，当审核通过后可以在门户上显示；如果选择不公开，将只在[我的原创签名]中显示。
        </div>
	</div>
	</form>
	
	<!-- 用于删除或创建后的跳转信息 -->
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/> </div>
	
	<div class="rightsub715" style="margin-bottom:5px;">
	  <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'"><a href="view_create_original.html" class="link000"> 创建签名 </a></div>
	          <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除原创</a>        
        </div>
               
    </div>
    
    <div id="mysignListPortlet">

<form name="signform" id="signform" action="delete_original.html"> 
    <div class="rightsub2_5">
      <table width="100%" border="0" cellspacing="1" cellpadding="0">
      <tr>
        <th width="5%" align="center" bgcolor="#CCEBFA"><input type="checkbox" name="checkbox3" onclick="selectAll(this.checked);" value="checkbox" /></th>
        <th width="8%" height="29" align="center" bgcolor="#CCEBFA">序号</th>
        <th width="29%" align="center" bgcolor="#CCEBFA">签名内容</th>
        <th width="13%" align="center" bgcolor="#CCEBFA">签名分类</th>
        <th width="13%" align="center" bgcolor="#CCEBFA">签名状态</th>
        <th width="21%" align="center" bgcolor="#CCEBFA">提交时间</th>
        <th width="11%" align="center" bgcolor="#CCEBFA">操作</th>
      </tr>
      <s:iterator value="originals" id="original" status="st">
      <tr >
        <td  align="center" bgcolor="#f8f8f8">
           <input type="checkbox" name="cb" value="<s:property value='#original.id' />" />
        </td>
        <td height="33" align="center" bgcolor="#f8f8f8"><s:property value="#st.count"/> </td>
        <td align="center" bgcolor="#f8f8f8"> <span id="mycs_0"><s:property value="#original.content" /> </span> </td>
        <td align="center" bgcolor="#f8f8f8"><s:property value="#original.signatureClass.name" /></td>
        <td align="center" bgcolor="#f8f8f8">
           <s:if test="#original.auditStatus == 0">
           		正在审核
           </s:if>
           <s:elseif test="#original.auditStatus == 1">
           		审核通过
           </s:elseif>
           <s:elseif test="#original.auditStatus == 2">
           		审核未通过
           </s:elseif>           
        </td>
        <td align="center" bgcolor="#f8f8f8"><s:date name="#original.gmtTime" format="yyyy-MM-dd HH:mm"/></td>
        <td align="center" bgcolor="#f8f8f8">
           <!-- 只有通过审核的才能操作 -->
           <s:if test="#original.auditStatus == 1">
            <a href="javascript:toUrl('view_personalized.html?content=','<s:property value="#original.content" />');">
            	<img src="images/qm-02.gif" border="0" width="18" height="18" title="设置个性化签名" />
            </a>
            <a href="javascript:void(0)" onclick="return setDefault('<s:property value="#original.id" />','<s:property value="#original.content" />');"  >
            	<img src="images/qm-03.gif" border="0" width="18" height="18" title="设置为默认签名" />
            </a>
           </s:if>
           <s:elseif test="#original.auditStatus == 2">
           <img  title="删除没有通过审核的签名" src="images/delete_16x16.gif" style="cursor:hand;" type="submit"
             onclick="if(window.confirm('您确定要删除签名？')){toUrl('delete_original.html?cb=<s:property value="#original.id" />','');}"/>
           </s:elseif>
         </td>

      </tr>
     </s:iterator>
    </table>
    </div>
    
        
    <div class="rightsub715" style=" margin-bottom:0px;">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除原创</a></div>
    </div>

</form>
    
    <div class="rightsub_fy" >
    	<!-- 分页 -->
    	<s:include value="page.jsp">
			<s:param name="pageUrl" value="'my_original.html?'"></s:param>
		</s:include>
    </div>    
    </div>
</div>
  
<script type="text/javascript">
	//自定义jQuery的快捷方式，以避免与其它库的冲突
	var $j = jQuery.noConflict();
 //批量删除      
function batchdelete() {
    var ids=commonBatchDel(document.signform.cb);    
    if(ids != ""){
    	document.signform.action="delete_original.html";
    	document.signform.submit();
    }   
    
}

//设置为默认签名
function setDefault(originalId,content){
	if(content == ''){
		alert('签名内容不能为空！');
		return;
	}
	
	if (confirm('您确定使用此签名吗？')) {
		//访问url
		var url = "set_default.html";
		
		 //jQuery AJAX请求
        $j.post(url,{
         originalId:originalId,
       	 content:content
        },function(data,textStatus){
       	 if(textStatus == "success"){
       		 var success = data.success;
           	 var message = data.message;
           	 //无论成功与否,均弹出信息
           	 alert(message);
           	 
       	 }else{
       		// 无操作
       	 }
       	 
        },"json");
	}
	
	
}

</script>

</div>
</div>

</body>
</html>
