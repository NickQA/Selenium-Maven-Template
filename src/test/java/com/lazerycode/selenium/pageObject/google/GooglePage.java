package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by Nick Chursin on 9/22/2016.
 */
public class GooglePage extends BasePage<GoogleMap, GoogleValidator> {
    public GooglePage() {
        super(() -> new GoogleMap(), () -> new GoogleValidator());
    }

    public GooglePage performSearch(String query) {
        WebElement searchField = getMap().getSearchField();
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();
        waitUntilLoaded();
        return this;
    }

    private GooglePage waitUntilLoaded() {
        getMap().wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        return this;
    }
}
