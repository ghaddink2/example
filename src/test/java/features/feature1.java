package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.RestSteps;

@RunWith(SerenityRunner.class)
public class feature1 {

    @Steps
    RestSteps rest;

    @Test
    public void test1() throws Exception {
		rest.callService();
    }
}