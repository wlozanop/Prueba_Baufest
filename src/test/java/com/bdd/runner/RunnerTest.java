package com.bdd.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/build/cucumber-html-report",
                           "pretty:target/build/cucumber-pretty.txt",
                           "json:target/build/cucumber.json"},
        features = {"src/test/resources"},
        glue = {"com.bdd.stepdefinition",
                "com.bdd.Api.StepDefinition"},
        tags = {"@BLAZE2"}
)
public class RunnerTest {

}
