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
   <div class="M_Yygl"><a href="javascript:Menushow(1);">精彩活动管理</a></div>
   <div class="menubox" id="menu_1"  >
   <script type="text/javascript">
		f1 = new dTree('f1');
		f1.add(0,-1,'精彩活动管理','','','mainFrame');
		f1.add(11,0,'精彩活动','view_activity.html','','mainFrame');
		document.write(f1);
   </script>
   </div> 
	
  <div class="M_Yygl"><a href="javascript:Menushow(2);">精彩签名推荐管理</a></div>
  <div class="menubox" id="menu_2" style="display:none;">
  <script type="text/javascript">
		f2 = new dTree('f2');
		f2.add(0,-1,'精彩签名推荐管理','','','mainFrame');
		f2.add(21,0,'精彩签名推荐','view_wonderful.html','','mainFrame');
		document.write(f2);
  </script>
  </div>
  
  <div class="M_Yygl"><a href="javascript:Menushow(3);">热门话题管理</a></div>
  <div class="menubox" id="menu_3" style="display:none;">
  <script type="text/javascript">
		f3 = new dTree('f3');
		f3.add(0,-1,'热门话题管理','','','mainFrame');
		f3.add(31,0,'热门话题','view_hot_topic.html','','mainFrame');
		document.write(f3);
  </script>
  </div>
  
  <div class="M_Yygl"><a href="javascript:Menushow(4);">情景签名推荐管理</a></div>
  <div class="menubox" id="menu_4" style="display:none;">
  <script type="text/javascript">
		f4 = new dTree('f4');
		f4.add(0,-1,'情景签名推荐管理','','','mainFrame');
		f4.add(41,0,'情景签名推荐','view_scene.html','','mainFrame');
		document.write(f4);
  </script>
  </div>
	
  <div class="M_Yygl"><a href="javascript:Menushow(5);">签名盒推荐管理</a></div>
  <div class="menubox" id="menu_5" style="display:none;">
  <script type="text/javascript">
		f5 = new dTree('f5');
		f5.add(0,-1,'签名盒推荐管理','','','mainFrame');
		f5.add(51,0,'签名盒推荐','view_library_recommend.html','','mainFrame');
		document.write(f5);
  </script>
  </div>  
  
  <div class="M_Yygl"><a href="javascript:Menushow(6);">排行榜管理</a></div>
  <div class="menubox" id="menu_6" style="display:none;">
  <script type="text/javascript">
		f6 = new dTree('f6');
		f6.add(0,-1,'排行榜管理','','','mainFrame');
		f6.add(61,0,'排行榜','view_rank.html','','mainFrame');
		document.write(f6);
  </script>
  </div> 
</div>
</body>
</html>

