package com.softminesol.survey_framework.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OccupancyStatus{

	@SerializedName("OccupancyStatus")
	private List<OccupancyStatusItem> occupancyStatus;

	public void setOccupancyStatus(List<OccupancyStatusItem> occupancyStatus){
		this.occupancyStatus = occupancyStatus;
	}

	public List<OccupancyStatusItem> getOccupancyStatus(){
		return occupancyStatus;
	}

	@Override
 	public String toString(){
		return 
			"OccupancyStatus{" + 
			"occupancyStatus = '" + occupancyStatus + '\'' + 
			"}";
		}
}