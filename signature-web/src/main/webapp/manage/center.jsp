<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>框架控制</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<script>
<!--
var pic=new Array("./images/tolefto.gif","./images/tolefto2.gif","./images/torightt.gif","./images/torightt2.gif")
var leftorright='left';
function changeSize(){
top.btmframe.cols=(top.btmframe.cols=="190,10,*")?"0,10,*":"190,10,*";
if (leftorright=='left'){
document.all.a1.innerHTML="<img src=\"./images/torightt.gif\" onmouseover=\"this.src=pic[3]\" onmouseout=\"this.src=pic[2]\" onclick=\"changeSize()\"style=\"cursor:hand\" alt=\"显示列表\">";
leftorright='right';
}
else
{
document.all.a1.innerHTML="<img src=\"./images/tolefto.gif\" onmouseover=\"this.src=pic[1]\" onmouseout=\"this.src=pic[0]\" onclick=\"changeSize()\"style=\"cursor:hand\" alt=\"隐藏列表\">";
leftorright='left';
}
}
document.oncontextmenu="return false";
document.onselectstart="return false";
if (self == top)
location="index.asp";
//-->
</script>
<style type="text/css">
*{ padding:0px; margin:0px;}
html,body{ height:100%;}

</style>
</head>
<body  >
<div style="background:url(./images/dxtop_10.jpg) top left repeat-x; height:100%;">
<table cellpadding=0 cellspacing=0 width=9 height=100%  >
<tr>
<td id=a1>
<img src="./images/tolefto.gif" alt="隐藏列表" width="10" height="50" style="cursor:hand" onClick="changeSize()" onMouseOver="this.src='./images/tolefto2.gif'" onMouseOut="this.src='./images/tolefto.gif'"></td>
</tr>
</table>
</div>
</body>
</html>