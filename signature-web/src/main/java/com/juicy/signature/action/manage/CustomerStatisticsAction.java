/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.juicy.signature.action.base.CustomerStatisticsBaseAction;
import com.juicy.signature.persist.po.City;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 用户统计Action
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 24, 2011 创建
 *          </p>
 */
public class CustomerStatisticsAction extends CustomerStatisticsBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 开始时间 */
	private Date startTime;

	/** 结束时间 */
	private Date endTime;

	/** 业务状态 */
	private Integer customerStat;

	/** 用户HgCustomer */
	private List<HgCustomer> customers;

	/** 用户登录账号电话 */
	private String loginName;

	/** StUsers对象 */
	private StUsers user;

	/** 分页基本信息 */
	private Page page;
	
	/** 城市编号 */
	private String city;

	/** 用户分城市区域订购状态统计 */
	private List<Map<Integer, Integer>> statisticsList;
	
	/** 城市区域  */
	private List<City> cityList;

	/** 翻页部分URL，解决null变量在页面显示传递null字符串而导致的异常 */
	private String pageUrl;
	
	/**
	 * 显示所有用户订购状态
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
		}

		page.setEveryPage(15);

		// 如果为0，表示全选，则置空
		if (customerStat != null && 0 == customerStat) {
			customerStat = null;
		}

		//如果loginName为空字符串，则置空
		if(loginName != null && loginName.trim().length() == 0){
			loginName = null;
		}
		
		if(city == null || city.equals("0")){
			city = null;
		}
		
		Result result = statisticsManage.handleViewAllCustomer(startTime, endTime,
				customerStat, loginName, city, page);

		// 形成翻页URL部分
		SimpleDateFormat  sd = new SimpleDateFormat("yyyy-MM-dd");
		pageUrl = "&";
		if (startTime != null) {
			pageUrl += "startTime=" + sd.format(startTime) + "&";
		}
		if (endTime != null) {
			pageUrl += "endTime=" + sd.format(endTime) + "&";
		}
		if (customerStat != null) {
			pageUrl += "customerStat=" + customerStat + "&";
		}
		if(city != null){
			pageUrl += "city=" + city + "&";
		}

		if (result.isSuccess()) {
			customers = (List<HgCustomer>) result.getModel()
					.get("customerList");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * 显示用户登录情况
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewUserLogin() throws Exception {

		Result result = statisticsManage.viewUserLogin(loginName);

		if (result.isSuccess()) {
			user = (StUsers) result.getModel().get("user");
		}

		return SUCCESS;
	}

	/**
	 * 分城市区域显示用户统计
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewCustomerStatistics() throws Exception {

		Result result = statisticsManage.handleViewCustomerStatistics(startTime,endTime);

		if (result.isSuccess()) {
			cityList = (List<City>)result.getModel().get("cityList");
			statisticsList = (List<Map<Integer, Integer>>) result.getModel().get(
					"statisticsList");
		}

		return SUCCESS;
	}
	
	/**
	 * 设置用户业务状态（免费体验和免费体验结束状态互置）
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String setCustomerStat() throws Exception{
		
		Result result = statisticsManage.setCustomerStat(loginName, customerStat);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.setCustomerStat.success"));
		}else{
			this.setMessage(getText("manage.setCustomerStat.fail"));
		}
		
		return SUCCESS;
	}

	public List<HgCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<HgCustomer> customers) {
		this.customers = customers;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public StUsers getUser() {
		return user;
	}

	public void setUser(StUsers user) {
		this.user = user;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCustomerStat() {
		return customerStat;
	}

	public void setCustomerStat(Integer customerStat) {
		this.customerStat = customerStat;
	}

	
	public List<Map<Integer, Integer>> getStatisticsList() {
		return statisticsList;
	}

	public void setStatisticsList(List<Map<Integer, Integer>> statisticsList) {
		this.statisticsList = statisticsList;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	

}
