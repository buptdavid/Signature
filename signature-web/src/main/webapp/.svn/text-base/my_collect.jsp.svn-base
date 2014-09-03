<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<title>我的收藏签名</title>

</head>

<body>
<div id="RightMain">
<div id="RightMain_top"><span class="margin_left">管理我的收藏</span></div>

<div id="RightMain_end">

<div class="mycmccqm_right2" id>
	
	<!-- 用于删除或创建后的跳转信息 -->
	<div style="color:red;font-size:14px" align="center"><s:property value="message"/> </div>
	
	<div class="rightsub715" style="margin-bottom:5px;">
	    <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除收藏</a>        
        </div>
               
    </div>
    
    <div id="mysignListPortlet">

<form name="signform" id="signform" action="delete_collect.html"> 
    <div class="rightsub2_5">
      <table width="100%" border="0" cellspacing="1" cellpadding="0">
      <tr>
        <th width="5%" align="center" bgcolor="#CCEBFA"><input type="checkbox" name="checkbox3" onclick="selectAll(this.checked);" value="checkbox" /></th>
        <th width="8%" height="29" align="center" bgcolor="#CCEBFA">序号</th>
        <th width="23%" align="center" bgcolor="#CCEBFA">签名分类</th>
        <th width="49%" align="center" bgcolor="#CCEBFA">签名内容</th>        
        <th width="11%" align="center" bgcolor="#CCEBFA">操作</th>
      </tr>
      <s:iterator value="collects" id="collect" status="st">
      <tr >
        <td  align="center" bgcolor="#f8f8f8">
           <input type="checkbox" name="cb" value="<s:property value='#collect.id' />" />
        </td>
        <td height="33" align="center" bgcolor="#f8f8f8"><s:property value="#st.count"/> </td>
        <td align="center" bgcolor="#f8f8f8"><s:property value="#collect.className" /></td>
        <td align="center" bgcolor="#f8f8f8"> <span id="mycs_0"><s:property value="#collect.content" /> </span> </td>        
        <td align="center" bgcolor="#f8f8f8">
        	<a href="javascript:toUrl('view_personalized.html?content=','<s:property value="#collect.content" />');">
            	<img src="images/qm-02.gif" border="0" width="18" height="18" title="设置个性化签名" />
            </a>
            <a href="javascript:void(0)" onclick="return setDefault('<s:property value="#collect.libraryId" />','<s:property value="#collect.originalId" />','<s:property value="#collect.content" />');"  >
            	<img src="images/qm-03.gif" border="0" width="18" height="18" title="设置为默认签名" />
            </a>
         </td>

      </tr>
     </s:iterator>
    </table>
    </div>
    
        
    <div class="rightsub715" style=" margin-bottom:0px;">
        <div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
        <a href="javascript:batchdelete()" class="link000"   >删除收藏</a></div>
    </div>

</form>
    
    <div class="rightsub_fy" >
    	<!-- 分页 -->
    	<s:include value="page.jsp">
			<s:param name="pageUrl" value="'my_collect.html?'"></s:param>
		</s:include>
    </div>    
    </div>
</div>
  
<script type="text/javascript">
	//自定义jQuery的快捷方式，以避免与其它库的冲突
	var $j = jQuery.noConflict();
//批量删除        
function batchdelete() {
	//document.get
    var ids=commonBatchDel(document.signform.cb);    
    if(ids != ""){
    	document.signform.action="delete_collect.html";
    	document.signform.submit();
    }   
    
}


//设置为默认签名
function setDefault(libraryId,originalId,content){
	if(content == ''){
		alert('签名内容不能为空！');
		return;
	}
	
	if (confirm('您确定使用此签名吗？')) {
		//访问url
		var url = "set_default.html";
		
		 //jQuery AJAX请求
        $j.post(url,{
         libraryId:libraryId,
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
