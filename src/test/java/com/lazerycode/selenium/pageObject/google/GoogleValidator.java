package com.lazerycode.selenium.pageObject.google;

import com.lazerycode.selenium.pageObject.BasePageValidator;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleValidator extends BasePageValidator<GoogleMap> {
    public GoogleValidator() {
        super(new GoogleMap());
    }




}
