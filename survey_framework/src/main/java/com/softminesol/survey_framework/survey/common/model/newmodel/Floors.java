package com.softminesol.survey_framework.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Floors{

	@SerializedName("Floors")
	private List<FloorsItem> floors;

	public void setFloors(List<FloorsItem> floors){
		this.floors = floors;
	}

	public List<FloorsItem> getFloors(){
		return floors;
	}

	@Override
 	public String toString(){
		return 
			"Floors{" + 
			"floors = '" + floors + '\'' + 
			"}";
		}
}