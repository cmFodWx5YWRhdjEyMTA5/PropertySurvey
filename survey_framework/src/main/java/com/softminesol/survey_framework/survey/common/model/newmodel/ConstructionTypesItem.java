package com.softminesol.survey_framework.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class ConstructionTypesItem extends CustomAdapterModel {

	@SerializedName("construction_type")
	private String constructionType;

	@SerializedName("construction_type_id")
	private int constructionTypeId;

	public void setConstructionType(String constructionType){
		this.constructionType = constructionType;
	}

	public String getConstructionType(){
		return constructionType;
	}

	public void setConstructionTypeId(int constructionTypeId){
		this.constructionTypeId = constructionTypeId;
	}

	public int getConstructionTypeId(){
		return constructionTypeId;
	}

	@Override
 	public String toString(){
		return
				constructionType;
		}

	@Override
	public String getText() {
		return constructionType;
	}
}