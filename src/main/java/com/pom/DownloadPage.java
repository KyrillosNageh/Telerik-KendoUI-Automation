package com.pom;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * @author Kyrillos Nageh
 */
public class DownloadPage {
    SHAFT.GUI.WebDriver driver;  // SHAFT WebDriver instance declaration

    public DownloadPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By kendoUIPlan_Btn = By.xpath("//h4[contains(text(), 'Kendo UI')]//following::div //a[contains(@class,'Dropdown')]");

    private By getMenuElement(MenuOption menuOption) {
        return By.xpath("(//*[contains(@class, 'DashMenu')]  //*[contains(text(),'" + menuOption.getDisplayName() + "')])[1]");
    }

    @Step("Select \"`{menuOption}`\" from the {Try Now} drop-down list..")
    public EmailPage select(MenuOption menuOption){
    driver.element().click(kendoUIPlan_Btn)
            .click(getMenuElement(menuOption));
    return new EmailPage(driver);
    }

    public enum MenuOption {
        ANGULAR("UI for Angular"),
        REACT("UI for React"),
        VUE("UI for Vue"),
        JQUERY("UI for jQuery");

        private final String displayName;

        MenuOption(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
}
