package com.proyecto.selenium.framework;

import org.openqa.selenium.WebDriver;

import com.proyecto.selenium.pages.CalendarioPage;
import com.proyecto.selenium.pages.HomePage;
import com.proyecto.selenium.pages.PanelPage;

public class AppPage {
    private static WebDriver driver;
	private static HomePage loginPage;
    private static PanelPage panelPage;
    private static CalendarioPage calendarioPage;

    public static HomePage getLoginPage(WebDriver _driver)
    {
    	driver = _driver;
        if (loginPage == null)
        {
            loginPage = new HomePage(_driver);
        }
        return loginPage;
    }
    
    public static PanelPage getPanelPage()
    {
        if (panelPage == null)
        {
            panelPage = new PanelPage(driver);
        }
        return panelPage;
    }

    public static CalendarioPage getCalendarioPage()
    {
        if (calendarioPage == null)
        {
        	calendarioPage = new CalendarioPage(driver);
        }
        return calendarioPage;
    }    
    
}
