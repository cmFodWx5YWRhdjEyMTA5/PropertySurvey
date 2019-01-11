package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class BuildingOfAgeItem extends CustomAdapterModel {

	@SerializedName("building_age")
	private String buildingAge;

	@SerializedName("building_age_id")
	private int buildingAgeId;

	public void setBuildingAge(String buildingAge){
		this.buildingAge = buildingAge;
	}

	public String getBuildingAge(){
		return buildingAge;
	}

	public void setBuildingAgeId(int buildingAgeId){
		this.buildingAgeId = buildingAgeId;
	}

	public int getBuildingAgeId(){
		return buildingAgeId;
	}

	@Override
 	public String toString(){
		return
				buildingAge;
		}

	@Override
	public String getText() {
		return buildingAge;
	}
}