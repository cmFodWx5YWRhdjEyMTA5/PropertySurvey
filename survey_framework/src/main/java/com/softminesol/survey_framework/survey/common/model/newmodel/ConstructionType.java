package com.softminesol.survey_framework.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ConstructionType{

	@SerializedName("ConstructionTypes")
	private List<ConstructionTypesItem> constructionTypes;

	public void setConstructionTypes(List<ConstructionTypesItem> constructionTypes){
		this.constructionTypes = constructionTypes;
	}

	public List<ConstructionTypesItem> getConstructionTypes(){
		return constructionTypes;
	}

	@Override
 	public String toString(){
		return 
			"ConstructionType{" + 
			"constructionTypes = '" + constructionTypes + '\'' + 
			"}";
		}
}