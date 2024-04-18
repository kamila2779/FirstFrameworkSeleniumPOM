package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page factory - OR:
    @FindBy(name = "login_id")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[text() ='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//header//*[contains(@class, 'logo')]")
    WebElement logo;

    //initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateLogo(){
       return logo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        return new HomePage();
    }
}
