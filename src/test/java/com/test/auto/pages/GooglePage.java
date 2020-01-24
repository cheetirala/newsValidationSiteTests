package com.test.auto.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class GooglePage extends PageObject{

    @FindBy(name = "q")
    private WebElementFacade googleSearchField;

    @FindBy(id = "search")
    private WebElementFacade googleSearchResult;

    String googleUrl = "http://www.google.com";

    public boolean validateNewsOnGoogle() {
        getDriver().navigate().to(googleUrl);
        String newsArticle = Serenity.sessionVariableCalled("firstNewsArticle");
        googleSearchField.typeAndEnter(newsArticle);
        return StringUtils.containsIgnoreCase(googleSearchResult.getText(), newsArticle);
    }
}
