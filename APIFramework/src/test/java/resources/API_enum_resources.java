package resources;

public enum API_enum_resources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	private API_enum_resources(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		
		return resource;
	}
}
