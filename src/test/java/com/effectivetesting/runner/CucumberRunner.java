package com.effectivetesting.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.effectivetesting.gluecode", tags = {"@wip"}, plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" })
public class CucumberRunner {

}
