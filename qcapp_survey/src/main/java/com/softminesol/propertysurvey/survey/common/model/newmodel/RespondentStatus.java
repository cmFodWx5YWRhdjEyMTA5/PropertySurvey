package com.softminesol.propertysurvey.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RespondentStatus{

	@SerializedName("RespodentStatus")
	private List<RespodentStatusItem> respodentStatus;

	public void setRespodentStatus(List<RespodentStatusItem> respodentStatus){
		this.respodentStatus = respodentStatus;
	}

	public List<RespodentStatusItem> getRespodentStatus(){
		return respodentStatus;
	}

	@Override
 	public String toString(){
		return 
			"RespondentStatus{" + 
			"respodentStatus = '" + respodentStatus + '\'' + 
			"}";
		}
}