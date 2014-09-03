/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * �û�ͳ��Action
 * 
 * @author ·����
 * @version <p>
 *          Nov 24, 2011 ����
 *          </p>
 */
public class CustomerStatisticsAction extends CustomerStatisticsBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** ��ʼʱ�� */
	private Date startTime;

	/** ����ʱ�� */
	private Date endTime;

	/** ҵ��״̬ */
	private Integer customerStat;

	/** �û�HgCustomer */
	private List<HgCustomer> customers;

	/** �û���¼�˺ŵ绰 */
	private String loginName;

	/** StUsers���� */
	private StUsers user;

	/** ��ҳ������Ϣ */
	private Page page;
	
	/** ���б�� */
	private String city;

	/** �û��ֳ������򶩹�״̬ͳ�� */
	private List<Map<Integer, Integer>> statisticsList;
	
	/** ��������  */
	private List<City> cityList;

	/** ��ҳ����URL�����null������ҳ����ʾ����null�ַ��������µ��쳣 */
	private String pageUrl;
	
	/**
	 * ��ʾ�����û�����״̬
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
		}

		page.setEveryPage(15);

		// ���Ϊ0����ʾȫѡ�����ÿ�
		if (customerStat != null && 0 == customerStat) {
			customerStat = null;
		}

		//���loginNameΪ���ַ��������ÿ�
		if(loginName != null && loginName.trim().length() == 0){
			loginName = null;
		}
		
		if(city == null || city.equals("0")){
			city = null;
		}
		
		Result result = statisticsManage.handleViewAllCustomer(startTime, endTime,
				customerStat, loginName, city, page);

		// �γɷ�ҳURL����
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
	 * ��ʾ�û���¼���
	 * 
	 * @return ����ַ���
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
	 * �ֳ���������ʾ�û�ͳ��
	 * 
	 * @return ����ַ���
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
	 * �����û�ҵ��״̬��������������������״̬���ã�
	 * 
	 * @return ����ַ���
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
