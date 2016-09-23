package com.lazerycode.selenium.pageObject;

public class BasePageValidator<TMap extends BasePageMap> {
    private TMap map;

    public BasePageValidator(TMap map){
        this.map = map;
    }

    protected TMap getMap(){
        return map;
    }
}
