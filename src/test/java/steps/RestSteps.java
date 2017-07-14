package steps;

import helpers.WireMockHelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.when;

public class RestSteps {

	@Steps
	WireMockHelper mock;

	public static final String MOCK_SERVICE = "http://localhost:8080/";

	@Step
	public void callService(String animal) {

		mock.setMockMapping(animal);
		callMockedService(animal);
		mock.resetMockMappings();
	}

	@Step
	public void callJsonService(String animal) {

		//mock.setMockMapping(animal);
		callMockedService(animal);
		//mock.resetMockMappings();
	}

	private void callMockedService(String animal) {
		when().
				get(MOCK_SERVICE + animal).
				then().statusCode(200);
	}

	@Step
	public void callDynamicService(String animal) {

		mock.setDynamicMockMapping(animal);
		callMockedService(animal);
		mock.resetMockMappings();
	}

	public void callDynamicService(String animal, String name) {
		mock.setDynamicMockMapping(animal, name);
		callMockedService(animal);
		mock.resetMockMappings();
	}
}
