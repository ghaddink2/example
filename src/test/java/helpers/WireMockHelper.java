package helpers;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;

public class WireMockHelper {

	@Steps
	HandlebarsHelper handlebars;

	private String MIRAKL_MOCK_MAPPINGS_URL = "http://localhost:9080/__admin/mappings";
	private String MOCK_UUID = "mock_uuid";

	@Step
	public void setMockMapping(String resourceName) {

		String messageBody = loadMappingFile(resourceName);
		sendMappingToMock(messageBody);
	}

	private void sendMappingToMock(String messageBody) {
		String uuid = given().log().all().
				request().body(messageBody).with().contentType("application/json").
				when().post(MIRAKL_MOCK_MAPPINGS_URL).
				then().statusCode(201).
				extract().path("uuid");

		Serenity.setSessionVariable(MOCK_UUID).to(uuid);
	}

	private String loadMappingFile(String resourceName) {
		File wireMockConfig = new File("src/test/resources/" + resourceName + ".json");
		String messageBody = "";

		//A new version of Rest Assured should be able to get the file directly
		try (FileInputStream fis = new FileInputStream(wireMockConfig)) {
			int content;

			while ((content = fis.read()) != -1) {
				messageBody = messageBody + (char) content;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return messageBody;
	}

	@Step
	public void resetMockMappings() {

		String uuid = Serenity.sessionVariableCalled(MOCK_UUID);

		given().
				when().delete(MIRAKL_MOCK_MAPPINGS_URL + "/" + uuid).
				then().statusCode(200);
	}

	@Step
	public void setDynamicMockMapping(String resourceName) {
		String messageBody = loadMappingFile(resourceName);
		String dynamicMessageBody = handlebars.handlebarsify(resourceName, messageBody);
		sendMappingToMock(dynamicMessageBody);
	}

}
