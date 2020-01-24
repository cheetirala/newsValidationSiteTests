package com.test.auto.pages;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.theguardian.com/tone/news")
public class HomePage extends PageObject {

    @FindBy(css = ".js-first-pv-consent-agree")
    private WebElementFacade acceptCookies;

    private GooglePage googlePage;
    private YahooPage yahooPage;

    public void validateFirstNews() {
        if (acceptCookies.isCurrentlyVisible()) {
            acceptCookies.click();
        }
        List<WebElementFacade> newsElements = findAll(By.cssSelector("[data-test-id='facia-card']"));
        String firstNews = getFirstNewsArticle(newsElements);
        Serenity.setSessionVariable("firstNewsArticle").to(firstNews);
    }

    public boolean validateNewsFromDifferentSources() {
        boolean googleResult = googlePage.validateNewsOnGoogle();

        boolean yahooResult = yahooPage.validateNewsOnYahoo();

        if (googleResult && yahooResult) {
            return true;
        }
        return false;
    }

    private String getFirstNewsArticle(List<WebElementFacade> newsElements) {
        return newsElements.get(0).findElement(By.cssSelector("[data-link-name='article']")).getText().replaceAll("Live", "")
            .replaceAll("– live news", "").replaceAll("– live!", "").trim();
    }
}



