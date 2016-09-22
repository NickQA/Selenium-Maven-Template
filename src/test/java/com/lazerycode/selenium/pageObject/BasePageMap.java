package com.lazerycode.selenium.pageObject;

import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nick Chursin on 9/22/2016.
 */
public class BasePageMap {
    protected WebDriver driver;
    public WebDriverWait wait;

    protected BasePageMap() {
        try {
            driver = DriverBase.getDriver();
            wait = new WebDriverWait(driver, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
