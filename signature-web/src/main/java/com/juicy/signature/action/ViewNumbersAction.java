/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ʾĳ�û����Ի�ǩ�������н������к���Action
 * 
 * @author ·����
 * @version <p>
 *          2011-8-29 ����
 *          </p>
 */
public class ViewNumbersAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = -6358990853379198795L;

	/** request�ĵ绰����numbers */
	private String numbers;

	private List<String> numberList;

	/**
	 * ��ʾĳ�û����Ի�ǩ�������н������к��뷽������Ҫ��numbers�ַ�������ΪList����
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {

		if (numbers != null && numbers.length() > 0) {
			String[] numbersArray = numbers.split(",");
			numberList = new ArrayList<String>();
			for(String number:numbersArray){
				numberList.add(number);
			}
		}

		return SUCCESS;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public List<String> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<String> numberList) {
		this.numberList = numberList;
	}

}
