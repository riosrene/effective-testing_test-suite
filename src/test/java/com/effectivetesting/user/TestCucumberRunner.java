package com.effectivetesting.user;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.effectivetesting.user", plugin = {"json:target/cucumber.json" })
public class TestCucumberRunner {

}
