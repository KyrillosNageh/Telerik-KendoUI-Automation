package com.pom;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * @author Kyrillos Nageh
 */
public class HomePage {
    private SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance declaration
    private String url = "https://www.telerik.com/support/demos";

    private By getFreeTrail_Btn = By.xpath("//a[contains(text(),'Get A Free Trial')]");

    public HomePage(SHAFT.GUI.WebDriver driver){
        // SHAFT WebDriver instance assignation
        this.driver = driver;
    }

    @Step("Given I navigate to the Home page.")
    public HomePage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Click on Get a Free Trial.")
    public DownloadPage clickOnGetFreeTrial(){
        driver.element().click(getFreeTrail_Btn);
        return new DownloadPage(driver);
    }
}
