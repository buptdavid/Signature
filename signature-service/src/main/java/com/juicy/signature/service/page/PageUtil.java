/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.page;

/**
 * PageUtil��
 * 
 * @author ·����
 * @version <p>
 *          2011-8-3 ����
 *          </p>
 */
public class PageUtil {

	/**
	 * ����Page����
	 * 
	 * @param page
	 *            Pageʵ������
	 * @param totalRecords
	 *            �ܼ�¼��
	 * @return Pageʵ������
	 */
	public static Page createPage(Page page, int totalRecords) {
		return createPage(page.getEveryPage(), page.getCurrentPage(),
				totalRecords);
	}

	/**
	 * ����Page����
	 * 
	 * @param everyPage
	 *            ÿҳ�ļ�¼����
	 * @param currentPage
	 *            ��ǰҳ
	 * @param totalRecords
	 *            �ܼ�¼��
	 * @return Pageʵ������
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
	 * ����ÿҳ��ʾ��Ŀ
	 * 
	 * @param everyPage
	 *            ÿҳ������
	 * @return ÿҳ��ʾ������
	 */
	private static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	/**
	 * ���ص�ǰҳ
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @return ��ǰҳ
	 */
	private static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * ���ؿ�ʼ������
	 * 
	 * @param everyPage
	 *            ÿҳ������
	 * @param currentPage
	 *            ��ǰҳ
	 * @return ��ʼ������
	 */
	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	/**
	 * ������ҳ��
	 * 
	 * @param everyPage
	 *            ÿҳ������
	 * @param totalRecords
	 *            �ܼ�¼��
	 * @return ��ҳ��
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
	 * �����Ƿ�����һҳ��false��û�У�true����
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @return �Ƿ�����һҳ
	 */
	private static boolean hasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	/**
	 * �����Ƿ�����һҳ��false��û�У�true����
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param totalPage
	 *            ��ҳ��
	 * @return �Ƿ�����һҳ
	 */
	private static boolean hasNextPage(int currentPage, int totalPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
