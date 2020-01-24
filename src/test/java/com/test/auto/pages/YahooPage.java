package com.test.auto.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class YahooPage extends PageObject {

    @FindBy(id = "yschsp")
    private WebElementFacade yahooSearchField;

    @FindBy(id = "results")
    private WebElementFacade yahooSearchResult;

    @FindBy(name = "agree")
    private WebElementFacade acceptYahooTerms;

    String yahooUrl = "https://uk.search.yahoo.com/";

    public boolean validateNewsOnYahoo() {
        getDriver().navigate().to(yahooUrl);
        if (acceptYahooTerms.isCurrentlyVisible()) {
            acceptYahooTerms.click();
        }
        String newsArticle = Serenity.sessionVariableCalled("firstNewsArticle");
        yahooSearchField.typeAndEnter(newsArticle);
        return StringUtils.containsIgnoreCase(yahooSearchResult.getText(), newsArticle);
    }

}
