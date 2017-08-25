package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class GooglePage extends BasePage<GoogleMap, GoogleValidator> {

    public GooglePage() {
        super(new GoogleMap(), new GoogleValidator());
    }

    @Step("Type {query} into google search field")
    public GooglePage performSearch(String query) {
        WebElement searchField = getMap().getSearchField();
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();
        return this;

    }

    @Step("Waiting until title contains {query}")
    public GooglePage waitUntilResultsLoaded(final String query) {
        getMap().wait.until(d -> d.getTitle().toLowerCase().startsWith(query.toLowerCase()));
        return this;
    }
}
