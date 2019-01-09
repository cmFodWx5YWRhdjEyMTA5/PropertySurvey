package com.softminesol.propertysurvey.survey.common.model.newmodel;

import java.util.List;

public class SourceWater{
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