/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.IndexBaseAction;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.result.Result;

/**
 * ��ҳ��ʾAction
 *
 * @author ·����
 * @version <p>Nov 1, 2011 ����</p>
 */
public class IndexAction extends IndexBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -1449428856947247983L;
	// ��ҳ�
	private List<Activity> activityList;
	//����ǩ��_1��ǩ���У�
	private List<Recommend> wonderfulList_1;
	//����ǩ��_2��ǩ���У�
	private List<Recommend> wonderfulList_2;
	//�龰ǩ���Ƽ�
	private List<Recommend> originalList;
	//���Ż���
	private List<SignatureClass> classList;
	//�Ƽ�ǩ����
	private List<SignatureLibrary> libraryList;
	//�������а�
	List<SignatureOriginal> originalRankList;
	//�����ύǩ��
	List<SignatureOriginal> newOriginalList;

	@Override
	public String execute() throws Exception {
		
		Result result = indexService.view();
		
		if(result.isSuccess()){
			activityList = (List<Activity>)result.getModel().get("activityList");
			wonderfulList_1 = (List<Recommend>)result.getModel().get("wonderfulList_1");
			wonderfulList_2 = (List<Recommend>)result.getModel().get("wonderfulList_2");
			originalList = (List<Recommend>)result.getModel().get("originalList");
			classList = (List<SignatureClass>)result.getModel().get("classList");
			libraryList = (List<SignatureLibrary>)result.getModel().get("libraryList");
			originalRankList = (List<SignatureOriginal>)result.getModel().get("originalRankList");
			newOriginalList = (List<SignatureOriginal>)result.getModel().get("newOriginalList");
		}
		
		return SUCCESS;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public List<Recommend> getWonderfulList_1() {
		return wonderfulList_1;
	}

	public void setWonderfulList_1(List<Recommend> wonderfulList_1) {
		this.wonderfulList_1 = wonderfulList_1;
	}

	public List<Recommend> getWonderfulList_2() {
		return wonderfulList_2;
	}

	public void setWonderfulList_2(List<Recommend> wonderfulList_2) {
		this.wonderfulList_2 = wonderfulList_2;
	}

	public List<Recommend> getOriginalList() {
		return originalList;
	}

	public void setOriginalList(List<Recommend> originalList) {
		this.originalList = originalList;
	}

	public List<SignatureClass> getClassList() {
		return classList;
	}

	public void setClassList(List<SignatureClass> classList) {
		this.classList = classList;
	}

	public List<SignatureLibrary> getLibraryList() {
		return libraryList;
	}

	public void setLibraryList(List<SignatureLibrary> libraryList) {
		this.libraryList = libraryList;
	}

	public List<SignatureOriginal> getOriginalRankList() {
		return originalRankList;
	}

	public void setOriginalRankList(List<SignatureOriginal> originalRankList) {
		this.originalRankList = originalRankList;
	}

	public List<SignatureOriginal> getNewOriginalList() {
		return newOriginalList;
	}

	public void setNewOriginalList(List<SignatureOriginal> newOriginalList) {
		this.newOriginalList = newOriginalList;
	}
	
	

}
