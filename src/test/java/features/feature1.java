package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.RestSteps;

@RunWith(SerenityRunner.class)
public class feature1 {

    @Steps
    RestSteps rest;

    @Test
    @WithTag("BLKNL_DESKTOP")
    public void test1() throws Exception {

    }
}