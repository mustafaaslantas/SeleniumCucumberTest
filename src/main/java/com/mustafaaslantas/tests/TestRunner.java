package com.mustafaaslantas.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "com.mustafaaslantas.stepDefinitions",
        plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json" },
        monochrome = true
)


public class TestRunner {
}
