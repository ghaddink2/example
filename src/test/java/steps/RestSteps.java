package steps;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.when;

public class RestSteps {
	@Step
	public void callService() {
				when().
				get("http://localhost:9080/aap/123").
				then().statusCode(200);
	}
}
