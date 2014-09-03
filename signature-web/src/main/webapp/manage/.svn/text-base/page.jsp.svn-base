<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

 <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            
            <td width="88%" align="right" class="page_link">
            <s:if test="page.hasPrePage == true">
				<a href="${param.pageUrl}page.currentPage=1">首页</a>
				<a href="${param.pageUrl}page.currentPage=${page.currentPage - 1}">上一页</a>
			</s:if>
			
			<s:if test="page.hasPrePage == false">
				首页
				上一页
			</s:if>
			
			<s:if test="page.hasNextPage == true">
				<a href="${param.pageUrl}page.currentPage=${page.currentPage + 1}">下一页</a>	
				<a href="${param.pageUrl}page.currentPage=${page.totalPage}">末页</a>		
			</s:if>
			
			<s:if test="page.hasNextPage == false">
				下一页
				末页				
			</s:if>
			
			<s:property value="page.currentPage"/>页/<s:property value="page.totalPage"/>页 共<s:property value="page.totalCount"/>条记录
            
            </td>
          </tr>
 </table>
