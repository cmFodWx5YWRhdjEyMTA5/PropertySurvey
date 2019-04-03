package com.softminesol.survey_framework.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class BuildingAge{

	@SerializedName("BuildingOfAge")
	private List<BuildingOfAgeItem> buildingOfAge;

	public void setBuildingOfAge(List<BuildingOfAgeItem> buildingOfAge){
		this.buildingOfAge = buildingOfAge;
	}

	public List<BuildingOfAgeItem> getBuildingOfAge(){
		return buildingOfAge;
	}

	@Override
 	public String toString(){
		return 
			"BuildingAge{" + 
			"buildingOfAge = '" + buildingOfAge + '\'' + 
			"}";
		}
}