package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.pageObject.google.GooglePage;

import org.testng.annotations.Test;

/**
 * Created by Nick Chursin on 9/22/2016.
 */
public class GoogleExamplePoIT extends DriverBase {
    @Test
    public void googleCheeseExample() throws Exception {
        GooglePage googlePage = new GooglePage();
        googlePage.open();
        System.out.println("Page title is: " + googlePage.getTitle());
        googlePage.performSearch("Cheese!");
        System.out.println("Page title is: " + googlePage.getTitle());
    }
}
