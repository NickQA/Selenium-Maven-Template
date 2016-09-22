package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePageMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Nick Chursin on 9/22/2016.
 */

public class GoogleMap extends BasePageMap {
    public WebElement getSearchField(){
        return driver.findElement(By.name("q"));
    }
}
