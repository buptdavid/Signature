/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.page;

/**
 * PageUtil类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-3 创建
 *          </p>
 */
public class PageUtil {

	/**
	 * 创建Page对象
	 * 
	 * @param page
	 *            Page实例对象
	 * @param totalRecords
	 *            总记录数
	 * @return Page实例对象
	 */
	public static Page createPage(Page page, int totalRecords) {
		return createPage(page.getEveryPage(), page.getCurrentPage(),
				totalRecords);
	}

	/**
	 * 创建Page对象
	 * 
	 * @param everyPage
	 *            每页的记录数量
	 * @param currentPage
	 *            当前页
	 * @param totalRecords
	 *            总记录数
	 * @return Page实例对象
	 */
	public static Page createPage(int everyPage, int currentPage,
			int totalRecords) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		int totalPage = getTotalPage(everyPage, totalRecords);
		boolean hasNextPage = hasNextPage(currentPage, totalPage);
		boolean hasPrePage = hasPrePage(currentPage);

		return new Page(hasPrePage, hasNextPage, everyPage, totalPage,
				currentPage, beginIndex, totalRecords);
	}

	/**
	 * 返回每页显示数目
	 * 
	 * @param everyPage
	 *            每页的数量
	 * @return 每页显示的数量
	 */
	private static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	/**
	 * 返回当前页
	 * 
	 * @param currentPage
	 *            当前页
	 * @return 当前页
	 */
	private static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * 返回开始的索引
	 * 
	 * @param everyPage
	 *            每页的数量
	 * @param currentPage
	 *            当前页
	 * @return 开始的索引
	 */
	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	/**
	 * 返回总页数
	 * 
	 * @param everyPage
	 *            每页的数量
	 * @param totalRecords
	 *            总记录数
	 * @return 总页数
	 */
	private static int getTotalPage(int everyPage, int totalRecords) {
		int totalPage = 0;

		if (totalRecords % everyPage == 0)
			totalPage = totalRecords / everyPage;
		else
			totalPage = totalRecords / everyPage + 1;

		return totalPage;
	}

	/**
	 * 返回是否有上一页。false：没有；true：有
	 * 
	 * @param currentPage
	 *            当前页
	 * @return 是否有上一页
	 */
	private static boolean hasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	/**
	 * 返回是否有下一页。false：没有；true：有
	 * 
	 * @param currentPage
	 *            当前页
	 * @param totalPage
	 *            总页数
	 * @return 是否有下一页
	 */
	private static boolean hasNextPage(int currentPage, int totalPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
