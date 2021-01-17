package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_Place;
import pojo.location;

public class TestDataBuild {

	public Add_Place addPlacePayload(String name, String language, String address) {
		Add_Place add_Place = new Add_Place();
		
		location Location = new location();
		Location.setLat(-38.383494);
		Location.setLng(33.427362);
		
		List<String> myList = new ArrayList<String>();
		myList.add("Park");
		myList.add("Garden");
		myList.add("Bageecha");
		
		add_Place.setAccuracy(50);
		add_Place.setAddress(address);
		add_Place.setLanguage(language);
		add_Place.setLocation(Location);
		add_Place.setName(name);
		add_Place.setPhone_number("+91 9902545812");
		add_Place.setTypes(myList);
		add_Place.setWebsite("www.cool.com");
		add_Place.setLocation(Location);
		
		return add_Place;
	}
	
	public String delete_Place(String place_Id) {
		return "{\\r\\n\\t\\\"place_id\\\":\\\""+place_Id+"\\\"\\r\\n}";
	}
}
