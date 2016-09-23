package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePageValidator;

public class GoogleValidator extends BasePageValidator<GoogleMap> {
    public GoogleValidator() {
        super(new GoogleMap());
    }

    public void assertThatTitleContains(String value) {
        if (!getMap().driver.getTitle().contains(value)) {
            System.out.println("Title doesn't contains " + value);
        }
    }
}
