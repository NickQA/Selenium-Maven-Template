package com.lazerycode.selenium.pageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasePageValidator<TMap extends BasePageMap> {
    private TMap map;

    public BasePageValidator(TMap map){
        this.map = map;
    }

    protected TMap getMap(){
        return map;
    }

    public void assertThatTitleContains(String value) {
        assertThat(getMap().driver.getTitle(), containsString(value));
    }
}
