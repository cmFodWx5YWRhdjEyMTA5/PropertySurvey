package com.softminesol.propertysurvey.rolebase.model;

import com.google.gson.annotations.SerializedName;

public class RoleData{

	@SerializedName("newProperty")
	private boolean newProperty;

	@SerializedName("updateProperty")
	private boolean updateProperty;

	@SerializedName("distribution")
	private boolean distribution;

	public void setNewProperty(boolean newProperty){
		this.newProperty = newProperty;
	}

	public boolean isNewProperty(){
		return newProperty;
	}

	public void setUpdateProperty(boolean updateProperty){
		this.updateProperty = updateProperty;
	}

	public boolean isUpdateProperty(){
		return updateProperty;
	}

	public void setDistribution(boolean distribution){
		this.distribution = distribution;
	}

	public boolean isDistribution(){
		return distribution;
	}

	@Override
 	public String toString(){
		return 
			"RoleData{" + 
			"newProperty = '" + newProperty + '\'' + 
			",updateProperty = '" + updateProperty + '\'' + 
			",distribution = '" + distribution + '\'' + 
			"}";
		}
}