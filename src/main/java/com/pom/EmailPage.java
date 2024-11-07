package com.pom;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * @author Kyrillos Nageh
 */
public class EmailPage  {
    SHAFT.GUI.WebDriver driver;  // SHAFT WebDriver instance declaration

    public EmailPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By email_InText = By.id("email");
    private By next_Btn = By.xpath("//*[contains(text(), 'Next')]");

    @Step("Enter `{email}` in the email field.")
    public CreateAccountPage enterEmail(String email){
        driver.element()
                .type(email_InText, email)
                .click(next_Btn);
        return new CreateAccountPage(driver);
    }
}
