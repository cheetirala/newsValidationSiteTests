package com.test.auto.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.theguardian.com/tone/news")
public class HomePage extends PageObject {

    @FindBy(css = ".js-first-pv-consent-agree")
    private WebElementFacade acceptCookies;

    @FindBy(name = "q")
    private WebElementFacade googleSearchField;

    @FindBy(id = "yschsp")
    private WebElementFacade yahooSearchField;

    @FindBy(id = "search")
    private WebElementFacade googleSearchResult;

    @FindBy(id = "results")
    private WebElementFacade yahooSearchResult;

    @FindBy(name = "agree")
    private WebElementFacade acceptYahooTerms;

    String firstNewsArticle;

    String googleUrl = "http://www.google.com";
    String yahooUrl = "https://uk.search.yahoo.com/";

    public void validateFirstNews() {
        if (acceptCookies.isCurrentlyVisible()) {
            acceptCookies.click();
        }
        List<WebElementFacade> newsElements = findAll(By.cssSelector("[data-test-id='facia-card']"));
        firstNewsArticle = getFirstNewsArticle(newsElements);
    }

    public boolean validateNewsFromDifferentSources() {
        boolean googleResult = validateNewsOnGoogle();

        boolean yahooResult = validateNewsOnYahoo();

        if (googleResult && yahooResult) {
            return true;
        }
        return false;
    }

    private boolean validateNewsOnYahoo() {
        getDriver().navigate().to(yahooUrl);
        if (acceptYahooTerms.isCurrentlyVisible()) {
            acceptYahooTerms.click();
        }
        yahooSearchField.typeAndEnter(firstNewsArticle);
        return StringUtils.containsIgnoreCase(yahooSearchResult.getText(), firstNewsArticle);
    }

    private boolean validateNewsOnGoogle() {
        getDriver().navigate().to(googleUrl);
        googleSearchField.typeAndEnter(firstNewsArticle);
        return StringUtils.containsIgnoreCase(googleSearchResult.getText(), firstNewsArticle);
    }

    private String getFirstNewsArticle(List<WebElementFacade> newsElements) {
        return newsElements.get(0).findElement(By.cssSelector("[data-link-name='article']")).getText().replaceAll("Live", "")
            .replaceAll("– live news", "").replaceAll("– live!", "").trim();
    }
}



