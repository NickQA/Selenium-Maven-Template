package com.lazerycode.selenium.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Arrays;

/**
 * Created by unickq on 8/21/2017.
 */
public class Steps {
    int a;
    int b;
    int c;
    int sum;

    @Given("^first digit (\\d+)$")
    public void firstDigit(int digit) throws Throwable {
        a = digit;
    }

    @And("^second digit (\\d+)$")
    public void secondDigit(int digit) throws Throwable {
        b = digit;
    }

    @Дано("^третье число (\\d+)$")
    public void thirdDigit(int digit) throws Throwable {
        c = digit;
    }

    @When("^I multiply it$")
    public void multiply() throws Throwable {
        sum = a + b + c;
    }

    @Then("^sum is (\\d+)$")
    public void sum(int result) throws Throwable {
        Assert.assertEquals(result, sum);
    }


    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }
}
