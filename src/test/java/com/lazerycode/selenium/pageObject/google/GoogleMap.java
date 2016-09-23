package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePageMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleMap extends BasePageMap {
    public WebElement getSearchField(){
        return findElement(By.name("q"));
    }
}
