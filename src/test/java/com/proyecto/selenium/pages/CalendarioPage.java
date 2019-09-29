package com.proyecto.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CalendarioPage {
    private WebDriver driver;
	
    public CalendarioPage(WebDriver _driver) {
		this.driver = _driver;
	}
    
	private WebElement abrirCalendarioBtn;    
	private WebElement aniadirCategoriaBtn;
	private WebElement nombreCategoriaTxt;
	private WebElement crearCategoriaBtn;
	private WebElement categoriaAniadidaTxt;
	private WebElement borrarCategoriaBtn;
	private WebElement eliminarCategoriaBtn;	
    
//    By abrirCalendarioBtnLocator = By.xpath("//span[contains(text(), 'CalendarioPage')]");
    By abrirCalendarioBtnLocator = By.xpath("//a[contains(@href,'calendario')]/span[contains(text(), 'Calendario')]");
    By aniadirCategoriaBtnLocator = By.xpath("//*[@id='add_cat_calendar_modal']");
    By nombreCategoriaLocator = By.xpath("//*[@id='label_cat_calendar']");
    By crearCategoriaBtnLocator = By.xpath("//*[@id='add_cat_calendar']");
    By categoriaAniadidaLocator = By.xpath("//div[contains(@class,'event-category label-green ui-draggable')]|/*[contains(text(), 'Medicinas')]");
    By borrarCategoriaBtnLocator = By.xpath("//i[contains(@class,'fa fa-trash-o del_cat')]");
    By eliminarCategoriaBtnLocator = By.xpath("//*[@id='del_categoria']");
    
	public void setElementsAniadirCalendario() throws InterruptedException {
		Thread.sleep(1000);
		abrirCalendarioBtn = driver.findElement(abrirCalendarioBtnLocator);
		abrirCalendarioBtn.click();
		Thread.sleep(3000);
		aniadirCategoriaBtn = driver.findElement(aniadirCategoriaBtnLocator);
		aniadirCategoriaBtn.click();
		Thread.sleep(1000);
		nombreCategoriaTxt = driver.findElement(nombreCategoriaLocator);
		nombreCategoriaTxt.sendKeys("Medicinas");
		crearCategoriaBtn = driver.findElement(crearCategoriaBtnLocator);
		crearCategoriaBtn.click();
		Thread.sleep(1000);
		categoriaAniadidaTxt = driver.findElement(categoriaAniadidaLocator);
	}
	
	public String getCategoriaAniadida() {
    	String obtainedTitle = categoriaAniadidaTxt.getText();
        return obtainedTitle;
	}

	public void setElementsEliminarCategorias() throws InterruptedException {
		Thread.sleep(1000);
		borrarCategoriaBtn = driver.findElement(borrarCategoriaBtnLocator);
		Actions actions = new Actions(driver);
		actions.moveToElement(borrarCategoriaBtn).click().build().perform();
		Thread.sleep(2000);		
		eliminarCategoriaBtn = driver.findElement(eliminarCategoriaBtnLocator);
		eliminarCategoriaBtn.click();
		Thread.sleep(2000);	
        try {
        	categoriaAniadidaTxt = driver.findElement(categoriaAniadidaLocator);        	
        }catch (Exception e) {
        	categoriaAniadidaTxt = null;
		}
	}
}
