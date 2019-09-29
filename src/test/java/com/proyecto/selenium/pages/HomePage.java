package com.proyecto.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.proyecto.selenium.framework.AppPage;

public class HomePage {
    private WebDriver driver;
    By loginUserLocator = By.id("login_usu");
    By loginPassLocator = By.id("login_pass");
    By loginUserBtnLocator = By.id("login_user_btn");
    
    public WebElement userTxt;
    public WebElement passwordTxt;
    public WebElement loginBtn;
    
    public HomePage(WebDriver _driver) {
    	this.driver = _driver;
    }
    
    public PanelPage login()
    {
		userTxt.sendKeys("georgeguitar777");
		passwordTxt.sendKeys("sldfjsd9808");    	
        passwordTxt.sendKeys(Keys.ENTER);
        PanelPage panelPage = AppPage.getPanelPage();
        return panelPage;
    }
    
    public void OpenPage()
    {
        driver.navigate().to("https://www.notasonline.es/");
    }

    public void setElements() {
        userTxt = driver.findElement(loginUserLocator);
        passwordTxt = driver.findElement(loginPassLocator);
        loginBtn = driver.findElement(loginUserBtnLocator);
    }
}
