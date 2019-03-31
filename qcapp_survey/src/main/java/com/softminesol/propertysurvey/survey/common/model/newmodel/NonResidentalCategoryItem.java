package com.softminesol.propertysurvey.survey.common.model.newmodel;

import com.google.gson.annotations.SerializedName;

import frameworks.customadapter.CustomAdapterModel;

public class NonResidentalCategoryItem extends CustomAdapterModel {

	@SerializedName("code")
	private String code;

	@SerializedName("category_id")
	private int categoryId;

	@SerializedName("category")
	private String category;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return
				category;
		}

	@Override
	public String getText() {
		return category;
	}
}