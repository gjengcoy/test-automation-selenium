package com.series.page;

import com.series.base.BaseTestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tinylog.Logger;

import java.util.List;

public class ContactUs extends BaseTestConfig {

    @FindBy(xpath = "//*/div[@class='cmp-mrkto-modal']//span[contains(text(), 'Contact us')]")
    WebElement _btn_contactUs;

    @FindBy(xpath = "//*/a[@title='Solutions' and text()='Solutions']")
    WebElement _nav_solutions;
    @FindBy(xpath = "//*/a[@title='Products' and text()='Products']")
    WebElement _nav_products;
    @FindBy(xpath = "//*/a[@title='Industries' and text()='Industries']")
    WebElement _nav_industries;
    @FindBy(xpath = "//*/a[@title='Discover' and text()='Discover']")
    WebElement _nav_discover;
    @FindBy(xpath = "//*/a[@title='About Us' and text()='About Us']")
    WebElement _nav_about_us;
    @FindBy(xpath = "//*/a[@title='Careers' and text()='Careers']")
    WebElement _nav_careers;
    @FindBy(xpath = "//*/a[@class='cmp-tabs__anchor-link ' and contains(text(),'Our locations')]")
    WebElement _nav_our_locations;
    @FindBy(xpath = "//*/a[@class='cmp-tabs__anchor-link ' and contains(text(),'Get in touch')]")
    WebElement _nav_get_in_touch;

    public ContactUs() {
        PageFactory.initElements(testDriver, this);
    }

    public boolean validateButtonLabels() {
        return _btn_contactUs.isDisplayed();
    }

    public boolean validateHeaderNavigationLabels() {
        List<WebElement> elements = testDriver.findElements(By.tagName("nav"));
        for (WebElement element : elements) {
            if (element.getText().contains(_nav_solutions.getText()) &&
                    element.getText().contains(_nav_products.getText()) &&
                    element.getText().contains(_nav_industries.getText()) &&
                    element.getText().contains(_nav_discover.getText()) &&
                    element.getText().contains(_nav_about_us.getText()) &&
                    element.getText().contains(_nav_careers.getText()))
                return true;
        }
        return false;
    }

    public boolean clickNavigation() {
        try {
            _nav_get_in_touch.click();
            _nav_our_locations.click();
        } catch (Exception e) {
            Logger.info(e.getMessage());
            return false;
        }
        return true;
    }
}
