<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>特殊号码</title>
<link href="./css/dxyljx.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/openwindows.js"></script>
<script language="javascript">
//添加
function saveSepcial(){
	var special = document.getElementById("saveSpecial").value;
	
	if(special == null || special == ""){
		alert("请输入特殊号码！");
		return;		
	}
	
	var re = new RegExp("[1-9][0-9]{10}");
	if(!re.test(special)){
	    alert('手机号码格式不正确！'); 
	    return;
	}

    var saveForm = document.getElementById("saveForm");
	saveForm.submit();
}
	

//删除
function deleteSpecial(id){
	if(confirm('您确认删除吗？')){
		 window.location.href="delete_special_number.html?specialNumber.id="+id; 
	}else{
		return;
	}
}

</script>

</head>

<body>
<div id="body_top_bg">
	<div id="body_right_bg">
	
	
<div id="postion_nav">
您的位置：系统管理 -&gt; 系统反馈管理 -&gt; 特殊号码管理
</div>

<div class="content">
	 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
	 <thead>
	    </thead>
	<tbody>
	<s:set name="special" value="#request.specialNumber" ></s:set>
	<form name="saveForm" id="saveForm" action="save_special_number.html" method="post">
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">添加</td>
		  <td align="left" class="list_aselect">
		   特殊号码：<input id="saveSpecial" type="text" name="specialNumber.sysSpecialNumber" value="" />&nbsp;&nbsp;
		   <!-- 默认黑名单 -->
		   <input type="hidden" name="specialNumber.sysSpecialNumbertype" value="1"/>
		   <input name="Submit2" type="button" class="b_chaxun" onClick="saveSepcial()" value="添加" />
		   </td>
		  </tr>
		</form>
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title"></td>
	      <td align="left" class="list_aselect"></td>
		</tr>
		<form name="form" id="form" action="view_special_number.html" method="post">
		<tr>
	      <td width="3%" align="center" valign="middle" class="td_title">筛选</td>
		  <td align="left" class="list_aselect">
		   特殊号码：<input type="text" name="specialNumber.sysSpecialNumber" value="<s:property value="#special.sysSpecialNumber"/>" />&nbsp;&nbsp;
		   <input name="Submit2" type="submit" class="b_chaxun" value="查询" />&nbsp;&nbsp;
		   </td>
		 </tr>
		</form>
	  </tbody>
	  <tfoot>
	    </tfoot>
	</table>
</div>


<div class="content">
  <div style="color:red;font-size:14px" align="center"><s:property value="message"/></div>
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="listtable">
    <caption style="text-align:left; padding-left:20px; ">
    <a class="TitleStype">所有特殊号码</a>
    </caption>
    
    <thead>
      <tr>
        <th width="5%">编号</th>
        <th width="15%">特殊号码</th>
        <th width="15%">添加时间</th>
        <th width="10%">操作</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="specialNumbers" id="number">
       <tr>
        <td align="center"><s:property value="#number.id"/></td>
        <td align="center"><s:property value="#number.sysSpecialNumber"/></td>
        <s:set value="#number.sysSpecialNumbertype" name="type" ></s:set>
        <td align="center"><s:date name="#number.specialNumberCeratedate" format="yyyy-MM-dd HH:mm"/></td>
        <td class="list_aselect">
        	<a href="javascript:deleteSpecial(<s:property value='#number.id'/>);" >删除</a>
        </td>
        </tr>
     </s:iterator>
    </tbody>
    <tfoot>
       <tr>
      <td colspan="7">      
	     <s:include value="page.jsp">
				<s:param name="pageUrl" value="'view_special_number.html?specialNumber.sysSpecialNumber='+#request.searchNumber+'&'"></s:param>
		 </s:include>
        
        </td>
    </tr>
    </tfoot>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
</div>
</div>
</body>
</html>
