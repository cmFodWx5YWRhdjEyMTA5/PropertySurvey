package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SourceWater{

	@SerializedName("SourceWater")
	private List<SourceWaterItem> sourceWater;

	public void setSourceWater(List<SourceWaterItem> sourceWater){
		this.sourceWater = sourceWater;
	}

	public List<SourceWaterItem> getSourceWater(){
		return sourceWater;
	}

	@Override
 	public String toString(){
		return 
			"SourceWater{" + 
			"sourceWater = '" + sourceWater + '\'' + 
			"}";
		}
}