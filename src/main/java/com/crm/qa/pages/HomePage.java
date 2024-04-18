package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//div[contains(@class, \'fr-ec-bottom\')]//div//div//div[3]")
    WebElement accountLoginButton;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnLogin(){
        accountLoginButton.click();
        return new LoginPage();
    }
}
