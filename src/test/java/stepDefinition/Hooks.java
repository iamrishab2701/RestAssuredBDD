package stepDefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {


    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        addPlaceStep addplacestep = new addPlaceStep();
        if(addPlaceStep.place_id == null )
        {
            addplacestep.addAddPlacePayloadWithAnd("Rishabh","French","Asia");
            addplacestep.userCallsWithHttpRequest("AddPlaceAPI", "POST");
            addplacestep.verifyPlace_IdCreatedMapsToUsing("Rishabh", "getPlaceAPI");
        }
    }
}