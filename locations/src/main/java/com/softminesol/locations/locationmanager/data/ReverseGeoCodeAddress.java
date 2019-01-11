package com.softminesol.locations.locationmanager.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReverseGeoCodeAddress{
	private String formattedAddress;

	private List<String> types;
	private Geometry geometry;
	@SerializedName("address_components")
	private List<AddressComponentsItem> addressComponents;
	private String placeId;

	public void setFormattedAddress(String formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress(){
		return formattedAddress;
	}

	public void setTypes(List<String> types){
		this.types = types;
	}

	public List<String> getTypes(){
		return types;
	}

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public void setAddressComponents(List<AddressComponentsItem> addressComponents){
		this.addressComponents = addressComponents;
	}

	public List<AddressComponentsItem> getAddressComponents(){
		return addressComponents;
	}

	public void setPlaceId(String placeId){
		this.placeId = placeId;
	}

	public String getPlaceId(){
		return placeId;
	}

	@Override
 	public String toString(){
		return 
			"ReverseGeoCodeAddress{" + 
			"formatted_address = '" + formattedAddress + '\'' + 
			",types = '" + types + '\'' + 
			",geometry = '" + geometry + '\'' + 
			",address_components = '" + addressComponents + '\'' + 
			",place_id = '" + placeId + '\'' + 
			"}";
		}
}