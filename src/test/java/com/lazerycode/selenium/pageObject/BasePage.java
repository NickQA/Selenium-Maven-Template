package com.lazerycode.selenium.pageObject;


import java.util.function.Supplier;

/**
 * Created by Nick Chursin on 9/22/2016.
 */

public class BasePage<TMap extends BasePageMap, TVal extends BasePageValidator<TMap>> {
    private String url;
    protected final String baseUrl = "https://www.google.com.ua";

    private Supplier<TMap> map;
    private Supplier<TVal> val;

    protected BasePage(Supplier<TMap> map, Supplier<TVal> val) {
        this.map = map;
        this.val = val;
    }

    public void open() {
        getMap().driver.navigate().to(baseUrl);
    }

    protected TMap getMap() {
        return map.get();
    }

    public TVal getValidator() {
        return val.get();
    }

    public String getTitle() {
      return getMap().driver.getTitle();
    }
}
