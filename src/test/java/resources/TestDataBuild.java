package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.BodyForSerialization;
import pojo.Location;

public class TestDataBuild {
	
	public BodyForSerialization addPlacePayload(String name, String phone_number, String address, String website, String language) {
		BodyForSerialization serialize = new BodyForSerialization();
		serialize.setAccuracy(50);
		serialize.setAddress(address);
		serialize.setLanguage(language);
		serialize.setPhone_number(phone_number);
		serialize.setWebsite(website);
		serialize.setName(name);
		serialize.setTypes(null);
		List<String> myList = new ArrayList<String>();
		myList.add("Shoe Park0");
		myList.add("Shop");
		serialize.setTypes(myList);
		Location l = new Location();
		serialize.setLocation(l);
		l.setLat(-57.87885);
		l.setLng(45.582555);
		return serialize;
	}
	public String deletePlacePayload(String placeId) {
		return "{\r\n  \"place_id\":\""+placeId+"\"\r\n}";
		
	}

}
