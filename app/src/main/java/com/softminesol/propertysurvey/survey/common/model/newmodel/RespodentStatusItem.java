package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class RespodentStatusItem extends CustomAdapterModel {

	@SerializedName("respodent")
	private String respodent;

	@SerializedName("respodent_id")
	private int respodentId;

	public void setRespodent(String respodent){
		this.respodent = respodent;
	}

	public String getRespodent(){
		return respodent;
	}

	public void setRespodentId(int respodentId){
		this.respodentId = respodentId;
	}

	public int getRespodentId(){
		return respodentId;
	}

	@Override
 	public String toString(){
		return 
			getText();
		}

	@Override
	public String getText() {
		return respodent;
	}
}