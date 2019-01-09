package com.softminesol.propertysurvey.survey.common.model.newmodel;

public class SourceWaterItem{
	private String waterSource;
	private int waterSourceId;

	public void setWaterSource(String waterSource){
		this.waterSource = waterSource;
	}

	public String getWaterSource(){
		return waterSource;
	}

	public void setWaterSourceId(int waterSourceId){
		this.waterSourceId = waterSourceId;
	}

	public int getWaterSourceId(){
		return waterSourceId;
	}

	@Override
 	public String toString(){
		return 
			"SourceWaterItem{" + 
			"water_source = '" + waterSource + '\'' + 
			",water_source_id = '" + waterSourceId + '\'' + 
			"}";
		}
}
