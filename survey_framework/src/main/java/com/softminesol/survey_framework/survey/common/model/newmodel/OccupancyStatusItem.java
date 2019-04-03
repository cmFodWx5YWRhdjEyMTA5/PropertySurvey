package com.softminesol.survey_framework.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class OccupancyStatusItem extends CustomAdapterModel {

	@SerializedName("occupency")
	private String occupency;

	@SerializedName("occupency_id")
	private int occupencyId;

	public void setOccupency(String occupency){
		this.occupency = occupency;
	}

	public String getOccupency(){
		return occupency;
	}

	public void setOccupencyId(int occupencyId){
		this.occupencyId = occupencyId;
	}

	public int getOccupencyId(){
		return occupencyId;
	}

	@Override
 	public String toString(){
		return 
			getText();
		}

	@Override
	public String getText() {
		return occupency;
	}
}