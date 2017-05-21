package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.RestSteps;

@RunWith(SerenityRunner.class)
public class Mocking {

	@Steps
	RestSteps rest;

	@Test
	public void setMockingBasedOnStaticFile() throws Exception {
		rest.callService("monkey");
	}

	@Test
	public void setMockingBasedOnDynamicFileWithSingleVariable() throws Exception {
    	rest.callDynamicService("hippo");
	}

}