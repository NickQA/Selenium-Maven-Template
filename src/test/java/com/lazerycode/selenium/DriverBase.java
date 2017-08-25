package com.lazerycode.selenium;

import com.lazerycode.selenium.config.DriverFactory;
import com.lazerycode.selenium.listeners.ScreenshotListener;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(ScreenshotListener.class)
public class DriverBase extends AbstractTestNGCucumberTests{

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;



    @BeforeSuite(alwaysRun = true, description = "Initializing WebDriver pool")
    public static void instantiateDriverObject() {
        System.out.println("instantiateDriverObject");
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        if(driverFactory == null) instantiateDriverObject();
        return driverFactory.get().getDriver();
    }

    public static WebDriverWait getWait() throws Exception {
        if(driverFactory == null) instantiateDriverObject();
        return driverFactory.get().getWait();
    }

    @AfterMethod(alwaysRun = true, description = "Clearing cookies")
    public static void clearCookies() throws Exception {
        System.out.println("deleteAllCookies");
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true, description = "Killing WebDriver instances")
    public static void closeDriverObjects() {
        System.out.println("closeDriverObjects");
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
        saveEnvVars();
    }

    private static void saveEnvVars(){
        if(webDriverThreadPool.size() > 0){
            DriverFactory driverFactory = webDriverThreadPool.get(0);
            StringBuilder sb = new StringBuilder();
            sb.append("Browser=").append(driverFactory.browser).append("\n");
            sb.append("OS=").append(driverFactory.operatingSystem).append("\n");
            sb.append("System=").append(driverFactory.systemArchitecture).append("\n");
            sb.append("IsRemote=").append(driverFactory.useRemoteWebDriver).append("\n");
            sb.append("GridParams=").append(driverFactory.desiredGridParams).append("\n");
            PrintWriter out = null;
            try {
                out = new PrintWriter("target\\allure-results\\environment.properties");
                out.write(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}