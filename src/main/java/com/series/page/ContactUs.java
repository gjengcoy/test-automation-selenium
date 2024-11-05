package com.series.page;

import com.series.base.BaseTestConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends BaseTestConfig {


    @FindBy(xpath = "//*/span[text()='Contact us']")
    WebElement _btn_contactUs;

    public ContactUs() {
        PageFactory.initElements(testDriver, this);
    }

    public boolean validateButtonLabels(){
        return _btn_contactUs.isDisplayed();
    }
}
