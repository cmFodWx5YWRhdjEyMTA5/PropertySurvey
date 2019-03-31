package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class FloorsItem extends CustomAdapterModel {

	@SerializedName("floor_id")
	private int floorId;

	@SerializedName("floor")
	private String floor;

	public void setFloorId(int floorId){
		this.floorId = floorId;
	}

	public int getFloorId(){
		return floorId;
	}

	public void setFloor(String floor){
		this.floor = floor;
	}

	public String getFloor(){
		return floor;
	}

	@Override
 	public String toString(){
		return 
			floor;
		}

	@Override
	public String getText() {
		return floor;
	}
}