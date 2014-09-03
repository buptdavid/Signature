/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.juicy.signature.action.base.ActivityManageBaseAction;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 活动管理Action
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 21, 2011 创建
 *          </p>
 */
public class ActivityManageAction extends ActivityManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 活动对象 */
	private Activity activity;

	/** 活动图片存放地址 */
	private String savePath;

	/** 上传活动图片文件域 */
	private File upload;

	/** 上传活动图片文件类型 */
	private String uploadContentType;

	/** 上传活动图片文件名 */
	private String uploadFileName;

	/** 上传首页活动图片文件域 */
	private File indexUpload;

	/** 上传首页活动图片文件类型 */
	private String indexUploadContentType;

	/** 上传首页活动图片文件名 */
	private String indexUploadFileName;

	/** 活动对象List */
	private List<Activity> activities;

	/** 分页对象 */
	private Page page;

	/** 要操作的活动ID */
	private Integer activityId;

	/** 是否首页显示 */
	private Byte isIndex;

	/** 结果提示信息 */
	private String message;

	/**
	 * 显示所有活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
		}

		Result result = activityManage.viewActivity(null, null, false, page);

		if (result.isSuccess()) {
			activities = (List<Activity>) result.getModel().get("activities");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * 显示添加活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewAdd() throws Exception {

		return SUCCESS;
	}

	/**
	 * 添加活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String add() throws Exception {
		// 上传图片
		this.uploadImage();

		// 设置管理员ID
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();
		 
		 HgCustomer customer = new HgCustomer();
		 customer.setId(customerId);

		activity.setCustomer(customer);

		// 保存图片
		Result result = activityManage.createActivity(activity);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.addActivity.success"));
		} else {
			this.setMessage(getText("manage.addActivity.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 显示修改活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewUpdate() throws Exception {

		Result result = activityManage.viewModify(activityId);

		if (result.isSuccess()) {
			activity = (Activity) result.getModel().get("activity");
		}
		
		return SUCCESS;
	}

	/**
	 * 修改活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String update() throws Exception {
		// 更新图片
		this.updateImage();

		// 设置管理员ID
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();

		HgCustomer customer = new HgCustomer();
		customer.setId(customerId);

		activity.setCustomer(customer);

		// 更新图片
		Result result = activityManage.modifyActivity(activity);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.updateActivity.success"));
		} else {
			this.setMessage(getText("manage.updateActivity.fail"));
		}

		return SUCCESS;

	}

	/**
	 * 删除活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {
		List<Integer> activityIds = new ArrayList<Integer>();
		activityIds.add(activityId);

		Result result = activityManage.deleteActivity(activityIds);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.deleteActivity.success"));
		} else {
			this.setMessage(getText("manage.deleteActivity.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 取消删除活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String undelete() throws Exception {
		List<Integer> activityIds = new ArrayList<Integer>();
		activityIds.add(activityId);

		Result result = activityManage.undeleteActivity(activityIds);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.undeleteActivity.success"));
		} else {
			this.setMessage(getText("manage.undeleteActivity.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 显示设置首页显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewSetIndex() throws Exception {
		Result result = activityManage.viewModify(activityId);

		if (result.isSuccess()) {
			activity = (Activity) result.getModel().get("activity");
		}

		return SUCCESS;
	}

	/**
	 * 设置为首页显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String setIndex() throws Exception {
		// 设置首页显示图片
		this.setIndexImage();

		// 设置管理员ID
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();

		HgCustomer customer = new HgCustomer();
		customer.setId(customerId);

		activity.setCustomer(customer);

		Result result = activityManage.setIndex(activity);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.setIndexActivity.success"));
		} else {
			this.setMessage(getText("manage.setIndexActivity.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 取消首页显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String cancelIndex() throws Exception {
		Activity cancelActivity = new Activity();
		cancelActivity.setId(activityId);
		// 设置管理员ID
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();

		HgCustomer customer = new HgCustomer();
		customer.setId(customerId);

		cancelActivity.setCustomer(customer);

		Result result = activityManage.cancelIndex(cancelActivity);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.cancelIndexActivity.success"));
		} else {
			this.setMessage(getText("manage.cancelIndexActivity.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 显示删除的活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewDeleted() throws Exception {
		if (page == null) {
			page = new Page();
		}

		Result result = activityManage.viewActivity(null, null, true, page);
		if (result.isSuccess()) {
			activities = (List<Activity>) result.getModel().get("activities");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * 保存图片
	 * 
	 * @throws IOException
	 */
	private void uploadImage() throws IOException {
		// 上传活动图片
		if (upload != null) {
			// 在该实际路径下实例化一个文件
			String imageName = getUploadFileName();
			File saveFile = new File(new File(getSavePath()), imageName);
			// 判断父目录是否存在
			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			// 执行文件上传
			FileUtils.copyFile(upload, saveFile);

			// 保存图片地址
			activity.setImage(this.savePath + "/" + imageName);
		}

		// 如果首页显示活动，则上传首页活动图片
		if (isIndex == 1) {
			// 在该实际路径下实例化一个文件
			String indexImageName = getIndexUploadFileName();
			File saveIndexFile = new File(new File(getSavePath()),
					indexImageName);

			// 判断父目录是否存在
			if (!saveIndexFile.getParentFile().exists()) {
				saveIndexFile.getParentFile().mkdirs();
			}

			// 执行文件上传
			FileUtils.copyFile(indexUpload, saveIndexFile);

			// 保存文件名称
			activity.setIndexImage(this.savePath + "/" + indexImageName);
			activity.setIsIndex(true);
		} else {
			activity.setIsIndex(false);
		}
	}

	/**
	 * 更新图片
	 * 
	 * @throws IOException
	 */
	private void updateImage() throws IOException {
		// 如果更新了活动图片，则上传更新活动图片
		if (upload != null) {
			// 在该实际路径下实例化一个文件
			String imageName = getUploadFileName();
			File saveFile = new File(new File(getSavePath()), imageName);
			// 判断父目录是否存在
			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			// 执行文件上传
			FileUtils.copyFile(upload, saveFile);

			// 保存图片地址
			activity.setImage(this.savePath + "/" + imageName);
		}

//		// 如果首页显示活动且更新了首页活动图片，则上传更新首页活动图片
//		if (isIndex == 1) {
//			if (indexUpload != null) {
//				// 在该实际路径下实例化一个文件
//				String indexImageName = getIndexUploadFileName();
//				File saveIndexFile = new File(new File(getSavePath()),
//						indexImageName);
//
//				// 判断父目录是否存在
//				if (!saveIndexFile.getParentFile().exists()) {
//					saveIndexFile.getParentFile().mkdirs();
//				}
//
//				// 执行文件上传
//				FileUtils.copyFile(indexUpload, saveIndexFile);
//
//				// 保存文件名称
//				activity.setIndexImage(this.savePath + "/" + indexImageName);
//				activity.setIsIndex(true);
//			}
//
//		} else {
//			activity.setIsIndex(false);
//		}
	}

	/**
	 * 设置首页显示图片
	 * 
	 * @throws IOException
	 */
	private void setIndexImage() throws IOException {
		// 在该实际路径下实例化一个文件
		String indexImageName = getIndexUploadFileName();
		File saveIndexFile = new File(new File(getSavePath()), indexImageName);

		// 判断父目录是否存在
		if (!saveIndexFile.getParentFile().exists()) {
			saveIndexFile.getParentFile().mkdirs();
		}

		// 执行文件上传
		FileUtils.copyFile(indexUpload, saveIndexFile);

		// 保存文件名称
		activity.setIndexImage(this.savePath + "/" + indexImageName);
		activity.setIsIndex(true);

	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 返回活动图片保存的路径
	 * 
	 * @return
	 */
	public String getSavePath() {
		//根据操作系统的不同返回不同的路径
		 if (System.getProperty("os.name").equals("Linux")) {
			 return ServletActionContext.getServletContext().getRealPath("/") + "/" + savePath;
		 }else{
			 return ServletActionContext.getServletContext().getRealPath("/") + "\\" + savePath;
		 }
		
	}

	/**
	 * 根据配置文件中的参数设置
	 * 
	 * @param value
	 *            配置文件中的参数值
	 */
	public void setSavePath(String value) {
		this.savePath = value;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 随机生成图片名字
	 * 
	 * @return
	 */
	public String getUploadFileName() {
		String[] name = uploadFileName.split("\\.");

		return UUID.randomUUID().toString() + "." + name[1];
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getIndexUpload() {
		return indexUpload;
	}

	public void setIndexUpload(File indexUpload) {
		this.indexUpload = indexUpload;
	}

	public String getIndexUploadContentType() {
		return indexUploadContentType;
	}

	public void setIndexUploadContentType(String indexUploadContentType) {
		this.indexUploadContentType = indexUploadContentType;
	}

	/**
	 * 随机生成首页图片名称
	 * 
	 * @return
	 */
	public String getIndexUploadFileName() {
		String[] name = indexUploadFileName.split("\\.");

		return UUID.randomUUID().toString() + "." + name[1];
	}

	public void setIndexUploadFileName(String indexUploadFileName) {
		this.indexUploadFileName = indexUploadFileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Byte getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(Byte isIndex) {
		this.isIndex = isIndex;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}
