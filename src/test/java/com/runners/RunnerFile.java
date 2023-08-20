package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/First.Features.feature",
glue="com.step",
plugin= {"pretty","json:target/report/report.json"})

public class RunnerFile extends AbstractTestNGCucumberTests{
	

}
