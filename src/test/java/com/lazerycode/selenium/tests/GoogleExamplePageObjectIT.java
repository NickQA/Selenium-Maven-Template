package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.pageObject.google.GooglePage;

import org.testng.annotations.Test;

public class GoogleExamplePageObjectIT extends DriverBase {
    @Test
    public void googleCheeseExample() throws Exception {
        //Create an instance of GooglePage class
        GooglePage googlePage = new GooglePage();
        //Open url definced in page class
        googlePage.navigate();
        // Check the title of the page
        System.out.println("Page title is: " + googlePage.getTitle());
        // Enter something to search for
        googlePage.performSearch("Cheese!");
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout defined in DriverFactory
        googlePage.waitUntilResultsLoaded("Cheese");
        // Check the title of the page
        System.out.println("Page title is: " + googlePage.getTitle());
        // Verify that title contains using Validator class
        googlePage.getValidator().assertThatTitleContains("Cheese");
    }

    @Test
    public void googleMilkExample() throws Exception {
        GooglePage googlePage = new GooglePage();
        googlePage.navigate();
        googlePage.performSearch("Milk!");
        googlePage.waitUntilResultsLoaded("Milk");
        googlePage.getValidator().assertThatTitleContains("Milk");
    }
}
