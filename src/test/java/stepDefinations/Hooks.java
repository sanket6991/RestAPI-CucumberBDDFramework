package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefination m =new StepDefination();
		if(StepDefination.place_id==null)
		{
		
		m.add_place_payload_with("pretty home", "5425236974", "Opposite to Hospital", "https://rahulshettyacademy.com", "English");
		m.user_calls_with__http_request("AddPlaceAPI", "post");
		m.verify_place_id_created_maps_to_using("pretty home", "getPlaceAPI");
		
	}
	}  
}
