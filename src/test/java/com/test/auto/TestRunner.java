package com.test.auto;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(junit = "--step-notifications", features="src/test/resources/features/validation/validateNews.feature")
public class TestRunner {}
