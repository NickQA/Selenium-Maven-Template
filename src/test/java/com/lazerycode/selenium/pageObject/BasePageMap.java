package com.lazerycode.selenium.pageObject;

import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageMap {
    public WebDriver driver;
    public WebDriverWait wait;

    protected BasePageMap() {
        try {
            driver = DriverBase.getDriver();
            wait = DriverBase.getWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> findElements(By by){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
