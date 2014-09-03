<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

	<!-- 分页 -->	
		<div class="page_number_b">
			<ul class="page_number_a">
				<li><span>&nbsp;&nbsp;</span></li>
				<li><span class="red_a"><s:property value="page.currentPage"/> </span>页/<span class="red_a"><s:property value="page.totalPage"/> </span>页&nbsp;&nbsp;共<span class="red_a"><s:property value="page.totalCount"/> </span> 条记录</li>
				
				<s:if test="page.hasNextPage == false">
				<li>末页</li>
				<li>下一页</li>
				</s:if>
				<s:if test="page.hasNextPage == true">
				<li><a href="${param.pageUrl}page.currentPage=${page.totalPage}">末页</a></li>
				<li><a href="${param.pageUrl}page.currentPage=${page.currentPage + 1}">下一页</a></li>				
				</s:if>
								
				<s:if test="page.hasPrePage == false">
				<li>上一页</li>
				<li>首页</li>
				</s:if>
				
				<s:if test="page.hasPrePage == true">
				<li><a href="${param.pageUrl}page.currentPage=${page.currentPage - 1}">上一页</a></li>
				<li><a href="${param.pageUrl}page.currentPage=1">首页</a></li>
				</s:if>
				
			</ul>
		</div>
