<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <META name=Keywords content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
 <META name=description content=签名门户,联通签名,签名业务,签名增值业务,联通签名门户,签名盒,联通签名盒,签名,联通签名盒,中国联通签名业务>
 <title>签名门户-陕西联通</title>
 <link href="<%=request.getContextPath()%>/css/qmstyle.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/shareJs.js" charset="utf-8"></script>
  <!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
	//自定义jQuery的快捷方式，以避免与其它库的冲突
	var $j = jQuery.noConflict(); 
	//判断是否登录
	function checkSession(){
			 var url = "check_session.html";
			 $j.post(url,{},function(data,textStatus){
	        	 if(textStatus == "success"){
	        		 var success = data.success;
	            	 if(success == true){
	            		 window.top.location.href = "mine.html";	            		 	            			 
	            	 }else{
	            		 //登录
	            		 login.show("mine.html");
	            	 }
	        	 }else{
	        		 
	        	 }
	        	 
	         },"json");
			 
	}
 </script>

 </head>
 <body  class=bodymain >
<!--顶部代码开始-->
   <DIV class=top_main>
    <DIV class=logo_top>
       <DIV class=logo_top1>
       <A href="index.html">
       	<IMG border=0 alt="" src="images/qm-gmcc.gif">
       	</A>
       	</DIV>
       <DIV class=logo_top3>
       <A class=linkfff href="http://www.chinaunicom.com.cn/" target=_blank>集团总部</A> | 
       <A class=linkfff href="http://www.10010.com/" target=_blank>网上营业厅</A> | 
       <A class=linkfff href="http://www.chinaunicom.com.cn/brand/index.html" target=_blank>品牌产品</A> | 
       <A class=linkfff href="http://upay.10010.com/web/Layout/welcome" target=_blank>充值缴费</A> | 
       <A class=linkfff href="http://www.chinaunicom.com.cn/city/shanx/index.html" target=_blank>陕西联通</A> | 
       <A class=linkfff href="http://www.chinaunicom.com.cn/news/index.html" target=_blank>新闻中心</A>
       </DIV>
       <FORM id=mysearchform method=post name=search action=nsearch.html>
        <INPUT value=2 type=hidden name=form.sortSubmitTime>
        <INPUT value=0 type=hidden name=form.groupId>
        <INPUT id=mysearchText type=hidden name=form.content>
      </FORM>
       <DIV class=logo_top2>
        <DIV class=logo_top2_1>
           <DIV class=searchspacepage>
             <FORM id=search_form method=post name=search action=search.html>
             	<% String keyWord = request.getParameter("keyWord"); %>
                <INPUT value="1" type="hidden" name="searchFlag">
                <INPUT onblur="if(this.value=='' || this.value.trim()=='请输入关键字搜索签名与签名盒'){this.value='请输入关键字搜索签名与签名盒';this.style.color='#999999';}" 
						style="COLOR: #999999" id=topSearchKey class=txtSearch 
						onclick="onfoucs('topSearchKey');if(this.value=='请输入关键字搜索签名与签名盒'){this.value='';this.style.color='#000000';}" 
						value="<%if(keyWord != null){ %> <%=keyWord %> <%} else { %>请输入关键字搜索签名与签名盒<% } %>" maxLength=50 name=keyWord>
                <DIV class=searchbotton>
                <A href="javascript:$('search_form').submit()">
                	<IMG border=0 alt="" src="images/search_btn.gif" width=68 height=25>
                </A>
                </DIV>
               
              </FORM>
          </DIV>
         </DIV>
      </DIV>
     </DIV>
    <DIV id=page_div class=lpzdtab>
       <UL id="Menu_Top">           
        <LI class=" ${param.index == '1'?'lpzdtab01':'lpzdtab02'}" id="menu1">
        	<A href="index.html"  ><SPAN><s:property value="param.index"/> 首页</SPAN></A> 
        </LI>
        <LI  class="${param.index == '2'?'lpzdtab01':'lpzdtab02'}" id="menu2">
        	<A href="javascript:checkSession();"  target="_self" ><SPAN>我的签名</SPAN></A> 
        </LI>
        <LI class="${param.index == '3'?'lpzdtab01':'lpzdtab02'}" id="menu3" >
        	<A href="original.html" target="_self" ><SPAN>情景签名</SPAN></A> 
        </LI>
        <LI  class="${param.index == '4'?'lpzdtab01':'lpzdtab02'}" id="menu4">
        	<A href="library.html"><SPAN>签名地带</SPAN></A> 
        </LI>
        <LI  class="${param.index == '5'?'lpzdtab01':'lpzdtab02'}" id="menu5">
        	<A href="activity.html"  ><SPAN>优惠活动</SPAN></A> 
        </LI>
        <LI  class="${param.index == '6'?'lpzdtab01':'lpzdtab02'}" id="menu6">
        	<A href="help.html"  ><SPAN>帮助中心</SPAN></A>
        </LI>
      </UL>
     </DIV>
     
  </DIV>

</body>
</html>