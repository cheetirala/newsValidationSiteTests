package com.test.auto.steps.serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.test.auto.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class EndUserSteps {

    HomePage homePage;

    @Step
    public void validate_first_news() {
        homePage.validateFirstNews();
    }

    @Step
    public void validate_news_from_different_sources() {
        assertThat(homePage.validateNewsFromDifferentSources(), is(true));
    }

    @Step
    public void is_the_home_page() {
        homePage.open();
    }
}
