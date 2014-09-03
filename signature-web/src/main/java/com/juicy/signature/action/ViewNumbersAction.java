/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 显示某用户个性化签名的所有接收主叫号码Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-29 创建
 *          </p>
 */
public class ViewNumbersAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = -6358990853379198795L;

	/** request的电话号码numbers */
	private String numbers;

	private List<String> numberList;

	/**
	 * 显示某用户个性化签名的所有接收主叫号码方法，主要将numbers字符串解析为List对象
	 * 
	 * @return 结果字符串
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
