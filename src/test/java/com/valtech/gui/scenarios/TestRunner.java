package com.valtech.gui.scenarios;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by olu.ogunbusola on 05/01/2018.
 */
@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        format = {"pretty",
                "html:target/cucumber-html-reports",
                "json:target/cucumber/report.json",
                "junit:target/cucumber/junit.xml"},
        features = "src/test/Resources",
        tags = {"~@ignore"})

public class TestRunner {
}
