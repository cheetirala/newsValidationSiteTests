package com.test.auto.steps;

import com.test.auto.steps.serenity.EndUserSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class NewsValidationSteps {

    @Steps
    EndUserSteps user;

    @Given("^the user is on the guardian home page$")
    public void theUserIsOnTheGuardianHomePage() {
        user.is_the_home_page();
    }

    @When("^the user want to validate the first news article$")
    public void theUserWantToValidateFirstNews() {
        user.validate_first_news();
    }

    @Then("^the user validated news from different sources$")
    public void userValidatedNewsFromDifferentSources() {
        user.validate_news_from_different_sources();
    }
}
