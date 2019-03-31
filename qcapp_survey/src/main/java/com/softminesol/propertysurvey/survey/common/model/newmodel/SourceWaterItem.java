package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class SourceWaterItem extends CustomAdapterModel {

	@SerializedName("water_source")
	private String waterSource;

	@SerializedName("water_source_id")
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
			getText();
		}

	@Override
	public String getText() {
		return waterSource;
	}
}
