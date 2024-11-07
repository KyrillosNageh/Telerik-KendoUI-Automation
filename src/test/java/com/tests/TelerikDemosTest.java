package com.tests;

import com.pom.DownloadPage;
import com.pom.EmailPage;
import com.pom.HomePage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

/**
 * @author Kyrillos Nageh
 */
@Epic("Telerik UI Automation")
public class TelerikDemosTest {
    SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance declaration
    SHAFT.TestData.JSON data; // SHAFT Test Data JSON parser declaration

    @Story("Telerik UI Automation")
    @Description("Given I am on the Telerik support demos page,\n" +
            "When I select the Kendo UI plan and choose the 'Try Now' option for 'UI for React',\n" +
            "And I fill in the required details with a valid email,\n" +
            "Then I am able to proceed to the account creation step and select 'Egypt' as the country of residence.")
    @Test(description = "Verify the end-to-end flow for selecting a Kendo UI plan, filling in details, and creating an account with Egypt as the country.")
    public void testKendoUIAccountCreation() {
        new HomePage(driver).clickOnGetFreeTrial();
               new DownloadPage(driver) .select(DownloadPage.MenuOption.REACT);
               new EmailPage(driver) .enterEmail(data.getTestData("email"))
                .createAccount(data.getTestData("password"),
                        data.getTestData("firstName"),
                        data.getTestData("lastName"),
                        data.getTestData("company"),
                        data.getTestData("phone"),
                        data.getTestData("country"));
/*
        driver.browser().assertThat()
                .url()
                .contains("kendo-ui.com")
                .perform();
 */
    }

    @BeforeClass(description = "Setup Browser instance.")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        data = new SHAFT.TestData.JSON("accountCreation.json");
        new HomePage(driver).navigate();
    }

    @AfterClass(description = "Teardown Browser instance.")
    public void tearDown() {
        driver.quit();
    }
}
