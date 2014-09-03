<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>优惠活动</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<link href="<%=request.getContextPath()%>/css/qmstyle.css"
	rel="stylesheet" type="text/css" />
<LINK href="<%=request.getContextPath()%>/css/city.css" rel=stylesheet type=text/css />
</HEAD>
<BODY class=bodymain>

	<div class="body960center">
		<!-- 顶部页面 -->
		<jsp:include page="header.jsp">
    	<jsp:param value="5" name="index"/>
    </jsp:include>

	<DIV style="HEIGHT: 850px" class=sub01>
		<DIV class=left_sider>
			<UL>
				<LI><A href="help.html"
					target=_parent>了解签名</A></LI>
				<LI><A href="help.html"
					target=_parent>开通签名</A></LI>
				<LI><A
					href="original.html"
					target=_parent>情景签名</A></LI>
				<LI><A
					href="library.html"
					target=_parent>签名地带</A></LI>
			</UL>
			<IMG src="images/ktcy.jpg">
		</DIV>
		<DIV class=right_content>
			<DIV class=breadcrumb>
				<IMG src="images/star_03.gif">&nbsp;
				<A href="activity.html">优惠活动</A>&nbsp;>&nbsp;
				<s:property value="activity.name" />
			</DIV>
			<DIV style="HEIGHT: 750px" class=right_box01>
				<DIV class=text>
					<H3><s:property value="activity.name" /></H3>
					<BR>
					<OL>
						<LI><STRONG>活动主题：</STRONG> <BR><s:property value="activity.theme" /></LI>
						<LI><STRONG>活动时间：</STRONG> <BR><s:date name="activity.startTime" format="yyyy年MM月dd日"/>&nbsp;至&nbsp;<s:date name="activity.endTime" format="yyyy年MM月dd日"/></LI>
						
						<LI><STRONG>活动对象：</STRONG> <BR><s:property value="activity.customers" /></LI>
						<LI><STRONG>活动详情：</STRONG> <BR><s:property value="activity.detail" /></LI>
						<LI><STRONG>活动规则：</STRONG> <BR><s:property value="activity.regulation" /></LI>
												
						<LI><STRONG>温馨提示：</STRONG><BR><s:property value="activity.remark" /></LI>
					</OL>
				</DIV>
			</DIV>
		</DIV>
	</DIV>
	
	<!-- 页面尾部 -->
	<%@include file="footer.jsp"%>

		<BR>&nbsp;<BR>
	</DIV>
</BODY>
</HTML>