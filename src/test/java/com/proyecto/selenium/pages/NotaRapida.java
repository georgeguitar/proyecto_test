package com.proyecto.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotaRapida {
    private WebDriver driver;
	
    public NotaRapida(WebDriver _driver) {
		this.driver = _driver;
	}
    
	private WebElement aniadirNotaBtn;
	private WebElement notaAniadidaTxt;
	private WebElement borrarNotaBtn;
	private WebElement eliminarNotaBtn;
	private WebElement notaAniadidaEditarTxt;
	private WebElement aceptarNotaAniadidaEditarBtn;
	
    By aniadirNotaBtnLocator = By.xpath("//*[@id='add_nota_rap']");
    By notaAniadidaTxtLocator = By.xpath("//a[contains(@class,'nota_rapida editable editable-pre-wrapped editable-click')]");
    By borrarNotaBtnLocator = By.xpath("//i[contains(@class,'fa fa-times')]");
    By eliminarNotaBtnLocator = By.xpath("//*[@id=\"del_nota_rap\"]");
    By notaAniadidaEditarTxtLocator = By.xpath("//textarea[contains(@class,'form-control input-large')]");
    By aceptarNotaAniadidaEditarBtnLocator = By.xpath("//button[contains(@class,'btn btn-primary btn-sm editable-submit')]");

	public void setElementsAniadirNotaRapida() throws InterruptedException {
    	Thread.sleep(3000);
    	aniadirNotaBtn = driver.findElement(aniadirNotaBtnLocator);
    	aniadirNotaBtn.click();
        Thread.sleep(3000);
        notaAniadidaTxt = driver.findElement(notaAniadidaTxtLocator);
	}

	public String getNotaAniadida() {
    	String obtainedTitle = notaAniadidaTxt.getText();
        return obtainedTitle;
	}

	public void setElementsEliminarNotaRapida() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	borrarNotaBtn = driver.findElement(borrarNotaBtnLocator);
    	borrarNotaBtn.click();
        Thread.sleep(1000);
    	eliminarNotaBtn = driver.findElement(eliminarNotaBtnLocator);
    	eliminarNotaBtn.click();
        Thread.sleep(1000);
        try {
        	notaAniadidaTxt = driver.findElement(notaAniadidaTxtLocator);        	
        }catch (Exception e) {
        	notaAniadidaTxt = null;
		}
	}

	public void setElementsEditarNotaRapida() throws InterruptedException {
    	Thread.sleep(1000);
        notaAniadidaTxt = driver.findElement(notaAniadidaTxtLocator);
        notaAniadidaTxt.click();
        Thread.sleep(1000);
        notaAniadidaEditarTxt = driver.findElement(notaAniadidaEditarTxtLocator);
        notaAniadidaEditarTxt.sendKeys("Salir en bici");
        Thread.sleep(1000);
        aceptarNotaAniadidaEditarBtn = driver.findElement(aceptarNotaAniadidaEditarBtnLocator);
        aceptarNotaAniadidaEditarBtn.click();
        Thread.sleep(1000);
        notaAniadidaTxt = driver.findElement(notaAniadidaTxtLocator);
	}
    
}
