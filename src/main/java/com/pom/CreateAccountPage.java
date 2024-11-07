package com.pom;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * @author Kyrillos Nageh
 */
public class CreateAccountPage  {
    SHAFT.GUI.WebDriver driver;  // SHAFT WebDriver instance declaration

    public CreateAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By password_InText = By.id("password");
    private By firstName_InText = By.id("fist-name");
    private By lastName_InText = By.id("last-name");
    private By company_InText = By.id("company");
    private By phone_InText = By.id("phone");
    private By country_InText = By.xpath("//*[@id='country'] //input[contains(@placeholder, 'Type to filter')]");
    private By selectCountry  = By.xpath("//*[contains(@class, 'k-list-item-text') and contains(text(), 'Egypt') ]");
    private By createAccount_Btn = By.xpath("//*[contains(text(), 'Create Account')]");

  @Step("Create Account with `{password}`, `{firstName}`, `{lastName}`, `{company}`, `{phone}`, `{country}`")
  public HomePage createAccount(String password, String firstName, String lastName, String company, String phone, String country){
      driver.element()
              .type(password_InText, password)
              .type(firstName_InText, firstName)
              .type(lastName_InText, lastName)
              .type(company_InText, company)
              .type(phone_InText, phone)
              .type(country_InText, country)
              .click(selectCountry)
              .click(createAccount_Btn);
      return new HomePage(driver);
  }

}
