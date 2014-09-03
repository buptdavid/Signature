<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/shareJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js-i18n.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js"></script>
<title>默认签名</title>
<script type="text/javascript">
	
	//自定义jQuery的快捷方式，以避免与其它库的冲突
	var $j = jQuery.noConflict();

	function commonSet() {
		
		var obj = document.getElementsByName("signModel");
		if (obj[0].checked) {
			if(document.getElementById("packageId").value == ''){
				alert("签名盒不能为空！");
				return;
			}
			//if(document.getElementById("signatureId").value == ''){
				//alert("签名内容不能为空,请插入签名!");
				//return;
			//}	
			
			
		}
		
		
		if (obj[1].checked) {
			if(document.getElementById("sign_set").value == '' || $('sign_set').value.trim() == ''){
				alert('签名内容不能为空！');
				return;
			}			
			
		}
		
		
		if (obj[0].checked) {			
			if(document.getElementById("signatureId").value == ''){
				if (confirm('您确定使用此签名盒吗？(随机发送签名盒中签名)')) {
					checkDumpClick();
					document.forms[0].action = "create_default_library.html";
					document.forms[0].submit();
				}
			}else{
				if (confirm('您确定使用此签名盒中的此签名吗？')) {
					checkDumpClick();
					document.forms[0].action = "create_default_library.html";
					document.forms[0].submit();
				}
			}	
			
			
		} else {
			if (confirm('确认设置为默认签名吗？')) {				
				//是否重复提交
				checkDumpClick();
				document.forms[0].action = "create_default.html";
				document.forms[0].submit();
			}
		}

	}
	
	//设置为默认签名
	function setDefault(content){
		if(content == ''){
			alert('签名内容不能为空！');
			return;
		}
		
		if (confirm('您确定使用此签名吗？')) {
			//访问url
			var url = "set_default.html";
			
			 //jQuery AJAX请求
	        $j.post(url,{
	       	 content:content
	        },function(data,textStatus){
	       	 if(textStatus == "success"){
	       		 var success = data.success;
	           	 var message = data.message;
	           	 //无论成功与否,均弹出信息
	           	 alert(message);
	           	 
	           	 //自动刷新本子页面
	           	 window.location.reload();
	       	 }
	       	 
	        },"json");
		}
		
		
	}
	
	//显示签名盒中的签名
	function openSignPackageDetail() {
		var id = document.getElementById("packageId").value;
		if (id == '') {
			alert("请选择签名盒！");
			return;
		}
		
		sAlert('view_library_signature.html?library.id=' + id, 700, 580,'签名盒详情', 5, 15);
		return;
	}
	
	//插入
	function autoSet(objVlaue0,objValue1) {
		document.getElementById("sign_set").value = objVlaue0;
		
		if(objValue1 != null){
			document.getElementById("originalId").value = objValue1;
		}
		
		window.pRemoveAlertBase();
	}
	
	//签名宝库
	function setSignPackage(objValue1, objValue2, startTime, endTime) {
		document.getElementById("packageName").value = objValue2;
		document.getElementById("packageId").value = objValue1;
		
		//插入签名盒时，清空先前插入的签名
		document.getElementById("signatureId").value = "";
		document.getElementById("libraryContent").value = "";
		
		window.pRemoveAlertBase();
	}
	
	//设置插入签名
	function setInsertSig(objValue1,objValue2){
		document.getElementById("signatureId").value = objValue1;
		document.getElementById("libraryContent").value = objValue2;
		window.pRemoveAlertBase();
	}
	
	function setStyle(model) {
		var obj = document.getElementsByName("signModel");
		if (!obj[model].checked) {
			obj[model].checked = true;
		}
		if (model == '0') {
			document.getElementById("signPackage").style.display = '';
			document.getElementById("signContent").style.display = 'none';
		} else if (model == '1') {
			document.getElementById("signContent").style.display = '';
			document.getElementById("signPackage").style.display = 'none';
		}
	}

	function radioReset() {
		var obj = document.getElementsByName("signModel");
		if (obj[0].checked) {
			setStyle(0);
		}
		if (obj[1].checked) {
			setStyle(1);
		}
	}

	var isclicked = false;

	function checkDumpClick() {
		if (!isclicked) {
			isclicked = true;
		} else {
			alert("您的请求已经提交！");
			return;
		}

	}
</script>
</head>

<body onload="radioReset();loadTxLisnter('sign_set');">
	<div id="RightMain">
		<div id="RightMain_top">
			<span class="margin_left">修改默认签名</span>
		</div>
		<div id="RightMain_end">
			<div class="mycmccqm_right2">
			
				<!-- 显示当前签名内容 -->
				<div class="rightsub1_1">  
				<strong>您当前设置的默认签名为：</strong><br />
					<span class="color14F29400_2 fontsize14"><s:property value="currentDiyInfo.diyInfoContent"/> </span>             		
				</div>
				             	
				<form id="form.id" action="create_default.html" name="form1" >
					<!-- 签名盒ID -->					
					<input id="packageId" name="classId" type="hidden" value="<s:if test="currentDiyInfo.libraryClassId != null"><s:property value='currentDiyInfo.libraryClassId'/></s:if><s:elseif test='currentDiyInfo.library.signatureClass.id!=null'><s:property value='currentDiyInfo.library.signatureClass.id'/></s:elseif>" />
					<!-- 具体签名盒中的签名 -->
					<input id="signatureId" name="libraryId" type="hidden" value="<s:property value='currentDiyInfo.library.id'/>" />	
					<!-- 原创签名ID -->				
					<input id="originalId" name="originalId" type="hidden" />
					
					
					<div class="rightsub1_4">
						<strong>选择使用方式：</strong> 
							<input type="radio" name="signModel" value="0" onclick="setStyle(0)" <s:if test="currentDiyInfo.library != null || currentDiyInfo.libraryClassId != null">checked</s:if> />签名盒 &nbsp;&nbsp; 
							<input type="radio" name="signModel" value="1" onclick="setStyle(1)" <s:if test="currentDiyInfo.library == null && currentDiyInfo.libraryClassId == null">checked</s:if>/>签名内容<br />						
					</div>
					<div class="rightsub1_5">

						<div id="signPackage" class="rightsub1_5_1">
							<strong>签名盒：</strong><br />
							<s:if test="currentDiyInfo.library == null && currentDiyInfo.libraryClassId == null">
								<s:set value="'请选择签名盒'" name="className">
								</s:set> 
							</s:if>
							<s:else>
								<s:if test="currentDiyInfo.library.signatureClass.name != null">
									<s:set value="#request['currentDiyInfo.library.signatureClass.name']" name="className">
									</s:set>
								</s:if>
								<s:else>
									<s:set value="#request['currentDiyInfo.libraryClassName']" name="className">
									</s:set>
								</s:else>
								 
							</s:else>
							
							<input type="text"	class="rightsub1_2" id="packageName" readonly value="${className }" /> 
							<input type="hidden" id="sp.startTime" /> 
							<input type="hidden" id="sp.endTime" /> 							
							<br /> 
							<a href="javascript:sAlert('view_library.html',700, 550, '签名盒列表', 5, 15);" class="linkblue02">选择签名盒</a> &nbsp;|&nbsp; 
							<a href="javascript:sAlert('view_collect_library.html', 700, 550, '签名盒收藏', 5, 15);" class="linkblue02">从收藏选择</a> 
							<br />
							<br />
							<strong>签名内容：</strong>
							<a href="javascript:openSignPackageDetail();" class="linkblue02">插入签名</a>
							<br />
							<textarea class="rightsub1_3" id="libraryContent" name="libraryContent" readonly><s:property value="currentDiyInfo.library.content"/></textarea>
						</div>

						<div id="signContent" style="display: none;" class="rightsub1_5_1">
							<strong>签名内容：</strong><br />	
							<!-- 此处不能用标签 -->
							<textarea class="rightsub1_3" id="sign_set" name="content" ><s:property value="currentDiyInfo.diyInfoContent"/></textarea>&nbsp;&nbsp;*
							<span id="cur_num">0</span>/<span id="max_num">70</span>
							<br />
							<a href="javascript:sAlert('view_collect.html', 700, 550, '签名收藏管理', 5, 15);" class="linkblue02">从收藏选择</a>&nbsp;|&nbsp;
							<a href="javascript:sAlert('view_original.html?auditStatus=1', 700, 550, '我的原创签名', 5, 15);" class="linkblue02">我的原创签名列表</a>
						</div>

						<div class="rightsub1_5_1">
							<div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
								<a href="javascript:commonSet()" class="link000"  >提 交</a>
							</div>
							<!--  
							<div class="botton_bg" onmouseover="this.className='botton_bg_over'" onmouseout="this.className='botton_bg'">
								<a href="javascript:document.form1.reset();txChange('sign_set');" class="link000">重 置</a>
							</div>
							-->
						</div>
					</div>
				</form>

				<div class="rightsub1_6">提示：每天最多可设置 <s:property value="maxDefaultCount"/> 个默认签名。请勿传送非法信息，违者将自负相应法律责任。
				</div>


				<div class="rightsub2_0">
					<div style="width: 50%; float: left;">
						<strong>默认签名设置记录</strong>
					</div>
				</div>
				<div class="rightsub2_5" style="margin-bottom: 5px;">
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th width="10%" height="29" align="center" bgcolor="#CCEBFA">接收号码</th>
							<th width="47%" align="center" bgcolor="#CCEBFA">设置内容</th>
							<th width="13%" align="center" bgcolor="#CCEBFA">发送时间</th>
							<th width="19%" align="center" bgcolor="#CCEBFA">设置时间</th>
							<th width="12%" align="center" bgcolor="#CCEBFA">操作</th>
						</tr>
						<s:iterator value="defaultRules" id="defaultRule">
							<tr bgcolor="#f8f8f8">
								<td align="center">所有号码</td>
								<td align="center">
								<s:if test="#defaultRule.diyInfo.flag == 0">
									<s:property value="#defaultRule.diyInfo.diyInfoContent" />
								</s:if>
								<s:else>
								<b>[签名盒]</b>
								<a title="点击查看签名盒详情" class="linkblue02" href="javascript:sAlert('view_library_signature.html?library.id=' + <s:property value='#defaultRule.diyInfo.libraryClassId' /> , 700, 580,'签名盒详情', 5, 15);"> 
    		                   [<s:property value="#defaultRule.diyInfo.libraryClassId" />]&nbsp;<s:property value="#defaultRule.diyInfo.libraryClassName" />
    		           			</a>
								</s:else>	
									
								</td>
								<td height="30" align="center">
									<s:property value="#defaultRule.sendruleSendperiodtime" />
								</td>
								<td align="center"><s:date name="#defaultRule.diyInfo.diyInfoCreatetime" format="yyyy-MM-dd HH:mm"/></td>
								<td align="center">
									<!-- 设置URL -->
			      					<a href="javascript:toUrl('view_personalized.html?content=','<s:property value="#defaultRule.diyInfo.diyInfoContent" />');">
			      						<img src="images/qm-02.gif" width="18" height="18" title="设置为个性化签名" border="0"/>
			      					</a>
			      					<a href="javascript:void(0)" onclick="return setDefault('<s:property value="#defaultRule.diyInfo.diyInfoContent" />');">
			      						<img src="images/qm-03.gif" width="18" height="18" title="设置为默认签名" border="0"/>
			      					</a>								
								</td>
							</tr>
						</s:iterator>
					</table>
					
					<!-- 分页 -->
				<div class="rightsub_fy">
					<s:include value="page.jsp">
						<s:param name="pageUrl" value="'list_default.html?'"></s:param>
					</s:include>
				</div>
				</div>
				
							
				
			</div>

		</div>

	</div>

</body>

</html>

