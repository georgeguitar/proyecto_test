package com.proyecto.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PanelPage {
    private WebDriver driver;

    By titleLocator = By.cssSelector("h1");
    By userNameBtnLocator = By.xpath("//span[contains(@class,'username')]");
    By salirBtnLocator = By.xpath("//a[contains(@href,'salir')]");

    private WebElement userNameBtn;
    private WebElement salirBtn;
    private WebElement title;
    private TareaRapida tareaRapida;
    private NotaRapida notaRapida;
    
	public PanelPage(WebDriver _driver) {
		this.driver = _driver;
		tareaRapida = new TareaRapida(_driver);
		notaRapida = new NotaRapida(_driver);
	}

    public void logOut() throws InterruptedException {
	    userNameBtn.click();
	    userNameBtn.click();
	    salirBtn.click();
	    Thread.sleep(2000);
    }

    public String getTitle() {
    	String obtainedTitle = title.getText();
        return obtainedTitle;
    }

    public void setElements() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userNameBtn = driver.findElement(userNameBtnLocator);
        salirBtn = driver.findElement(salirBtnLocator);
        title = driver.findElement(titleLocator);
    }

	public TareaRapida getTareaRapida() {
		return tareaRapida;
	}

	public NotaRapida getNotaRapida() {
		return notaRapida;
	}
	
}
