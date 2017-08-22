package com.lazerycode.selenium.pageObject;

public class BasePage<TMap extends BasePageMap, TVal extends BasePageValidator<TMap>> {
    private String url;
    protected final String baseUrl = "https://www.google.com";

    public BasePage(TMap map, TVal val) {
        this.map = map;
        this.val = val;
    }

    protected TMap getMap() {
        return map;
    }

    public TVal getValidator() {
        return val;
    }

    private TMap map;
    private TVal val;


    public void navigate() {
        getMap().driver.navigate().to(baseUrl);
    }

    public String getTitle() {
        return getMap().driver.getTitle();
    }
}
