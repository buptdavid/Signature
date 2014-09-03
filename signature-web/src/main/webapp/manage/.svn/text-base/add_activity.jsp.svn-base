<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script language="javascript">
//选择是否首页显示
function changeIndex(model){
   if(model=='0'){
      document.getElementById("indexImage").style.display='none';
      document.getElementById("isIndex").value='0';
	 }else if (model =='1'){
	   document.getElementById("indexImage").style.display='';
	   document.getElementById("isIndex").value='1';
	}
}

//保存
function save(){
	var name = document.getElementById("name");
	if(name.value == null || name.value == ""){
		alert("请输入活动名称");
		return false;
	}
	
	var isIndex = document.getElementById("isIndex");		
	if(isIndex.value == '1'){
		var indexUpload = document.getElementById("indexUpload");
		if(indexUpload.value == null || indexUpload.value == ""){
			alert("请选择首页图片");
			return false;
		}
	}
	
	//提交
	document.getElementById("saveform").submit();
}

</script>
</head>
<body>
<div id="postion_nav">
您的位置：优惠活动管理 -&gt; 活动管理 -&gt; 添加活动
</div>
<form id="saveform" action="add_activity.html" method="post" enctype="multipart/form-data">
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable"  style="width:68%; margin:0px auto; ">
    <caption>
    添加活动
    </caption>
    <tbody>
    <div style="color:red;font-size:14px" align="center"> <s:property value="message"/> </div>
       <tr>
        <td align="right">活动名称</td>
        <td align="left">
        	<input id="name" type="text" name="activity.name" maxlength="50" />          
         </td>
        <td colspan="-1" align="right">活动图片</td>
        <td colspan="-1" align="left">
        	<input type="file" id="upload" name="upload"/>
         </td>
      </tr>
      <tr align="right">
        <th colspan="4"></th>
      </tr>
      <tr>
        <td align="right">开始时间</td>
        <td align="left">
        	<input type="text" name="activity.startTime"  value="" id="startTime" onClick="WdatePicker()" class="Wdate" style="width:140px" readOnly/>         
         </td>
        <td colspan="-1" align="right">结束时间</td>
        <td colspan="-1" align="left">
        	<input type="text" name="activity.endTime" value="" id="endTime"  onClick="WdatePicker()" class="Wdate" style="width:140px" readOnly/>
         </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">活动对象</td>
        <td colspan="3" align="left">
        	<textarea name="activity.customers" rows="2" cols="101"  maxlength="500" ></textarea>
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">活动主题</td>
        <td colspan="3" align="left">
        	<textarea name="activity.theme" rows="3" cols="101" maxlength="500" ></textarea>
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">活动规则</td>
        <td colspan="3" align="left">
        	<textarea name="activity.regulation" rows="3" cols="101"  maxlength="500" ></textarea>
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">活动详情</td>
        <td colspan="3" align="left">
        	<textarea name="activity.detail" rows="3" cols="101"  maxlength="500" ></textarea>
        </td>
      </tr>
      <tr align="right">
        <th height="22" colspan="4"></th>
      </tr>
      <tr>
        <td align="right">备注</td>
        <td colspan="3" align="left">
        	<textarea name="activity.remark" rows="2" cols="101"  maxlength="500" ></textarea>
        </td>
      </tr>
       <tr align="right">
        <th colspan="4"></th>
      </tr>
      <tr>
        <td align="right">首页显示</td>
        <td align="left">
        	<input id="change" name="bb" type="radio" value="0" onclick="changeIndex(0)" checked/>否&nbsp;&nbsp;&nbsp;&nbsp;
        	<input id="change" name="bb" type="radio" value="1" onclick="changeIndex(1)" />是          
         </td>
        <td colspan="-1" align="right">首页图片</td>
        <td colspan="-1" align="left">
        	<span id="indexImage" style="display:none;">
        		<input id="indexUpload" name="indexUpload" type="file" />
        	</span>
         </td>
      </tr>
    <tfoot>
      <tr>
        <td colspan="4" align="center">
        	<input id="isIndex" type="hidden" name="isIndex" value="0" />
        	<input type="button" class="b_tianjia" value="保存" onClick="save()" />
        </td>
      </tr>
    </tfoot>
      </tbody>
    
  </table>
</form>
</body>
</html>