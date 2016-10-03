package com.lazerycode.selenium.stepDef;

import com.lazerycode.selenium.pageObject.google.GooglePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDefs{
    private GooglePage googlePage;

    @Given("^an open browser with google.com$")
    public void anOpenBrowserWithGoogleCom() throws Throwable {
        googlePage = new GooglePage();
        googlePage.navigate();
    }

    @When(value = "^a keyword (.*) is entered in input field and submit button is clicked$")
    public void aKeywordWordIsEnteredInInputField(String s){
        googlePage.performSearch(s);
        googlePage.waitUntilResultsLoaded(s);
    }

    @Then("^title should contains (.*)$")
    public void titleShouldContainsWord(String s) throws Throwable {
        googlePage.getValidator().assertThatTitleContains(s);
    }
}
