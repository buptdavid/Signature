<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导航</title>
<link href="./css/leftnav.css" rel="stylesheet" type="text/css" />
<link href="./css/dtree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/dtree.js"></script>

<script type="text/JavaScript">
<!--
 function disobjone(id)
 {
   var pid=eval(id);
   var num=document.all.objectNum.value;
   var num1=eval(num);
   for(var i=0;i<num1;i++)
   {
       if(pid!=i)
       { 
          var pointId=document.getElementById("ssdx_"+i);
          pointId.style.display="none";
       }
       else
       { 
           var pnum="document.all.pointNum"+pid;
           var pointNum=eval(pnum);
           var pointValue=pointNum.value;
           var pId=document.getElementById("ssdx_"+pid);
           if(eval(pointValue)==0)
           {
               pId.style.display="none";
           }
           else
           {
             pId.style.display="";
           }
       }
   }
}
function disAll()
{
   var num=document.all.objectNum.value;
   var num1=eval(num);
   for(var i=0;i<num1;i++)
   {
      var pointId=document.getElementById("ssdx_"+num1);
      pointId.style.display="none";
   }
}
function Menushow(str){
//alert("menu_"+str)
 var menubox=document.getElementById("menu_"+str);
 if(menubox.style.display==""){
     menubox.style.display="none";
 }else{
  menubox.style.display="";
 }
}
-->
</script>
</head>
<body>
<div class="contentbox">
	<div class="M_Yygl"><a href="javascript:Menushow(1);">活动管理</a></div>
	<div class="menubox" id="menu_1">
	<script type="text/javascript">
		f1 = new dTree('f1');
		f1.add(0,-1,'活动管理','','','mainFrame');
		f1.add(11,0,'所有活动','view_all_activity.html','','mainFrame');
		f1.add(12,0,'添加活动','view_add_activity.html','','mainFrame');
		document.write(f1);
	 </script>
	</div>

   <div class="M_Yygl"><a href="javascript:Menushow(2);">回收站管理</a></div>
   <div class="menubox" id="menu_2"  style="display:none;">
   <script type="text/javascript">
		f2 = new dTree('f2');
		f2.add(0,-1,'回收站管理','','','mainFrame');
		f2.add(21,0,'已删活动','view_deleted_activity.html','','mainFrame');
		document.write(f2);
   </script>
   </div> 
	
  
</div>
</body>
</html>

