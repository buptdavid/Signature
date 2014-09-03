<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.List" %>
<%@ page import="com.juicy.signature.persist.po.Activity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>优惠活动</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<link href="<%=request.getContextPath()%>/css/qmstyle.css"
	rel="stylesheet" type="text/css" />
<LINK rel=stylesheet type=text/css
	href="<%=request.getContextPath()%>/css/city_new.css">
<SCRIPT type=text/javascript
	src="<%=request.getContextPath()%>/js/front-arale.js"></SCRIPT>
<SCRIPT type=text/javascript
	src="<%=request.getContextPath()%>/js/front-index.js"></SCRIPT>

<SCRIPT type=text/javascript>
	E.onDOMReady(function() {
		slide.init({
			box : D.get("J-slide"),
			delayTime : 3
		});
	});
</SCRIPT>
<META name=GENERATOR content="MSHTML 8.00.6001.18702">
</HEAD>
<BODY class=bodymain>

	<div class="body960center">
		<!-- 顶部页面 -->
		<jsp:include page="header.jsp">
    	<jsp:param value="5" name="index"/>
    </jsp:include>

		<DIV class=sub01>
			<!--左侧栏开始-->
			<DIV class=left710px>
				<DIV class=city_banner>
				 <div class="yhhd_left">
				 </div>
					<DIV style=" float:right;BACKGROUND-COLOR: #fff; MARGIN-TOP: 0px; WIDTH: 510px; HEIGHT: 200px;" id=J-slide class=m-slide>
						<DIV class=content>
							<% List<Activity> showList = (List<Activity>)request.getAttribute("showList");
							   int num = 0;
							   if(showList != null){
								 	num = showList.size();
								 }
							for(int i=0;i<num;i++){ 
							%>
							
							<A class=list target="_black" href="view_activity_detail.html?activityId=<%=showList.get(i).getId() %>">
								<img border=0 src="<%=request.getContextPath()%>/<%=showList.get(i).getIndexImage() %>" />
								<H4>
									<SPAN style="COLOR: #fff"></SPAN>
								</H4>
							</A>
							<% } %>
							<%for(int i=num;i<3;i++){%>
							<A class=list href="">
								<img border=0 src="images/city_banner2.jpg" />
								<H4>
									<SPAN style="COLOR: #fff"></SPAN>
								</H4>
							</A>
							<% } %>
						</DIV>
					</DIV>
				</DIV>
				<DIV class=city_qj01>
					<DIV class=city_qj01_1>热门活动推荐</DIV>
					<DIV class=city_qj01_2></DIV>
					<!--      <div class="city_qj01_3"><a href="#" class="link000">更多...</a></div>-->
				</DIV>
				<DIV class=city_qj02>
					<s:iterator value="recommendList" id="activity">
					<DIV class=city_list1>
						<DIV class=city_list1_1>
							<a target="_black" href="view_activity_detail.html?activityId=<s:property value='#activity.id' />">
							<IMG border=0 <s:if test="#activity.image != null">src="<%=request.getContextPath()%>/<s:property value='#activity.image' />"</s:if><s:else>src="images/hot_1.jpg"</s:else>  width=160 height=120>
							</a>
						</DIV>
						<DIV class=city_list1_2>
							<A class=link0167B2 target="_black" href="view_activity_detail.html?activityId=<s:property value='#activity.id' />">
								<s:property value="#activity.name" /> 
							</A>
						</DIV>
						<DIV class=city_list1_3><s:date name="#activity.startTime" format="MM月dd日"/>-<s:date name="#activity.endTime" format="MM月dd日"/> </DIV>
						<DIV class=city_list1_3>
							<A target="_black" href="view_activity_detail.html?activityId=<s:property value='#activity.id' />">
								<IMG border=0 src="images/city_btn.gif" width=94 height=32>
							</A>
						</DIV>
					</DIV>
					</s:iterator>
						</DIV>
				<DIV class=city_qj03></DIV>
			</DIV>
			<!--左侧栏结束-->
			<!--右侧栏开始-->
			<DIV class=qmbox00>
				<DIV class=city_rightside>
					<DIV class=city_rightside1>
						<A href="">精彩活动</A>
					</DIV>
					<DIV style="HEIGHT: 166px" class=city_rightside2>
						<UL>
							<s:iterator value="wonderfulActivityList" id="activity">
							<LI><A class=linkbcb target="_black" href="view_activity_detail.html?activityId=<s:property value='#activity.id' />"
								target=#><s:property value="#activity.name" /></A> <SPAN class=fontcity10><s:date name="#activity.startTime" format="MM-dd"/></SPAN>
							</LI>
							</s:iterator>
						</UL>
					</DIV>
					<!-- 
					<DIV class=city_rightside1_2>地市网点</DIV>
					<DIV
						style="PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; WIDTH: 238px; PADDING-RIGHT: 0px; HEIGHT: 238px; PADDING-TOP: 0px"
						class=city_rightside2>
					</DIV>
					 -->
					<DIV class=city_rightside1_2>获奖公告</DIV>
					<DIV class=city_rightside2>
						<UL>
							<LI><A class=linkbcb href="">敬请期待......
								</A><SPAN class=fontcity10>2011</SPAN>
							</LI>
						</UL>
					</DIV>
				</DIV>
			</DIV>
			<!--右侧栏结束-->
		</DIV>
		<!-- 页面尾部 -->
		<%@include file="footer.jsp"%>

		<BR>&nbsp;<BR>
	</DIV>
</BODY>
</HTML>