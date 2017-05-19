package steps;

import helpers.WireMockHelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.when;

public class RestSteps {

	@Steps
	WireMockHelper mock;

	public static final String MOCK_SERVICE = "http://localhost:9080/";

	@Step
	public void callService(String animal) {

		mock.setMockMapping(animal);

		when().
				get(MOCK_SERVICE + animal).
				then().statusCode(200);

		mock.resetMockMappings();
	}
}
