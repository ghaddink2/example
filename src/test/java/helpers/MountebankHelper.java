package helpers;

import net.thucydides.core.annotations.Step;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;

public class MountebankHelper {
	private static final String MOUNTEBANK_MAPPINGS_URL = "localhost:2525/imposters";

	@Step
	public void setMockMapping(String resourceName){
		String messageBody = loadMappingFile(resourceName);
		sendMappingToMock(messageBody);

	}


	private void sendMappingToMock(String messageBody) {
		given().log().all().
				request().body(messageBody).with().contentType("application/json").
				when().post(MOUNTEBANK_MAPPINGS_URL).
				then().statusCode(201);
	}

	//TODO: Refactor to separate helper
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
}
