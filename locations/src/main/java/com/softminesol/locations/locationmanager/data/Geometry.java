package com.softminesol.locations.locationmanager.data;

public class Geometry{
	private Viewport viewport;
	private Location location;
	private String locationType;

	public void setViewport(Viewport viewport){
		this.viewport = viewport;
	}

	public Viewport getViewport(){
		return viewport;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

	@Override
 	public String toString(){
		return 
			"Geometry{" + 
			"viewport = '" + viewport + '\'' + 
			",location = '" + location + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}
