package com.lazerycode.selenium.pageObject;

/**
 * Created by Nick Chursin on 9/22/2016.
 */
public class BasePageValidator<TMap extends BasePageMap> {
    private TMap map;

    protected TMap getMap(){
        return map;
    }
}
