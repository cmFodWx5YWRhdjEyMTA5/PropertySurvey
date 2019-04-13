package com.softminesol.survey_framework.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyUsages{

	@SerializedName("PropertyUsage")
	private List<PropertyUsageItem> propertyUsage;

	public void setPropertyUsage(List<PropertyUsageItem> propertyUsage){
		this.propertyUsage = propertyUsage;
	}

	public List<PropertyUsageItem> getPropertyUsage(){
		return propertyUsage;
	}

	@Override
 	public String toString(){
		return 
			"PropertyUsages{" + 
			"propertyUsage = '" + propertyUsage + '\'' + 
			"}";
		}
}