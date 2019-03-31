package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class PropertyUsageItem extends CustomAdapterModel {

	@SerializedName("property_usage_id")
	private int propertyUsageId;

	@SerializedName("property_usage")
	private String propertyUsage;

	public void setPropertyUsageId(int propertyUsageId){
		this.propertyUsageId = propertyUsageId;
	}

	public int getPropertyUsageId(){
		return propertyUsageId;
	}

	public void setPropertyUsage(String propertyUsage){
		this.propertyUsage = propertyUsage;
	}

	public String getPropertyUsage(){
		return propertyUsage;
	}

	@Override
 	public String toString(){
		return 
			getText();
		}

	@Override
	public String getText() {
		return propertyUsage;
	}
}