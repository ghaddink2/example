package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.MountebankSteps;

@RunWith(SerenityRunner.class)
public class Mountebank {
	@Steps
	MountebankSteps mountebank;


	@Test
	public void testMountebackService(){
		mountebank.callService();
	}
}
