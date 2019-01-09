package com.softminesol.propertysurvey.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PropertyUsage{

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
			"PropertyUsage{" + 
			"propertyUsage = '" + propertyUsage + '\'' + 
			"}";
		}
}