package com.softminesol.survey_framework.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

public class PropertyUsageItem{

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
			"PropertyUsageItem{" + 
			"property_usage_id = '" + propertyUsageId + '\'' + 
			",property_usage = '" + propertyUsage + '\'' + 
			"}";
		}
}