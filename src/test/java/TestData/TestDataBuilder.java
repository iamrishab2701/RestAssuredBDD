package TestData;

import Pojo.AddPlacePojo.AddPlacePayload;
import Pojo.AddPlacePojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public AddPlacePayload addPlaceLoad(String name, String language, String address)
    {
        AddPlacePayload addPlacePayload = new AddPlacePayload();
        Location location = new Location();
        addPlacePayload.setAccuracy(50);
        addPlacePayload.setName(name);
        addPlacePayload.setPhone_number("(+91) 4383638561");
        addPlacePayload.setAddress(address);
        addPlacePayload.setWebsite("https://rahulshettyacademy.com");
        addPlacePayload.setLanguage(language);

        List<String> locationItems = new ArrayList<>();
        locationItems.add("shoe park");
        locationItems.add("shop");
        addPlacePayload.setTypes(locationItems);

        location.setLat(-39.897);
        location.setLng(32.876);
        addPlacePayload.setLocation(location);
        return addPlacePayload;
    }
}
