package com.softminesol.survey_framework.survey.common.model.newmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NonResidentalCategory{

	@SerializedName("NonResidentalCategory")
	private List<NonResidentalCategoryItem> nonResidentalCategory;

	public void setNonResidentalCategory(List<NonResidentalCategoryItem> nonResidentalCategory){
		this.nonResidentalCategory = nonResidentalCategory;
	}

	public List<NonResidentalCategoryItem> getNonResidentalCategory(){
		return nonResidentalCategory;
	}

	@Override
 	public String toString(){
		return 
			"NonResidentalCategory{" + 
			"nonResidentalCategory = '" + nonResidentalCategory + '\'' + 
			"}";
		}
}