package com.proyecto.selenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TareaRapida {
    private WebDriver driver;
	
    public TareaRapida(WebDriver _driver) {
		this.driver = _driver;
	}

	private WebElement aniadirTareaBtn;    
    private WebElement tituloAniadirTarea;
    private WebElement cerrarAniadirTareaBtn;	
    private WebElement nombreTareaTxt;
    private WebElement prioridadTareaOption;
    private WebElement crearTareaBtn;
    private WebElement tareaAniadidaTxt;
    private WebElement borrarTareaBtn;
    private WebElement eliminarTareaBtn;
    
    By aniadirTarea = By.xpath("//*[@id='modal_add_tarea_rap_btn']");
    By tituloAniadirTareaLocator = By.xpath("//h4[contains(text(), 'Añadir nueva tarea')]");
    By cerrarAniadirTareaBtnLocator = By.xpath("(//button[contains(text(), 'Cerrar')])[2]");
    By nombreTareaLocator = By.xpath("//*[@id='label_tarea_rap']");
    By prioridadTareaOptionLocator = By.xpath("//*[@id='select_tarea_rap']/option[4]");
    By crearTareaBtnLocator = By.xpath("//*[@id='add_tarea_rap']");
    By tareaAniadidaLocator = By.xpath("//span[contains(text(), 'Clases de piano')]");
    By borrarTareaBtnLocator = By.xpath("//button[contains(text(), 'Borrar')]");
    By eliminarTareaBtnLocator = By.xpath("//button[@id='del_tarea_rap']");
    
	
    public String getTituloAniadirTarea() {
    	String obtainedTitle = tituloAniadirTarea.getText();
        return obtainedTitle;
    }
    
    public void cerrarAniadirTarea() throws InterruptedException {
    	cerrarAniadirTareaBtn.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    
    public void setElementsTareasRapidasTituloVentana() throws InterruptedException {
//    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	Thread.sleep(3000);
    	aniadirTareaBtn = driver.findElement(aniadirTarea);
    	aniadirTareaBtn.click();
        Thread.sleep(3000);
        tituloAniadirTarea = driver.findElement(tituloAniadirTareaLocator);
        System.out.println("tituloAniadirTarea0: " + tituloAniadirTarea.getText());
        cerrarAniadirTareaBtn = driver.findElement(cerrarAniadirTareaBtnLocator);
    }
    
    public void setElementsAniadirTareasRapidas() throws InterruptedException {
//    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	Thread.sleep(3000);
    	aniadirTareaBtn = driver.findElement(aniadirTarea);
    	aniadirTareaBtn.click();
        Thread.sleep(3000);
        nombreTareaTxt = driver.findElement(nombreTareaLocator);
        nombreTareaTxt.sendKeys("Clases de piano");
//        prioridadTareaOption = new Select(driver.findElement(prioridadTareaOptionLocator));
//        prioridadTareaOption.deselectByVisibleText("Hoy");
        prioridadTareaOption = driver.findElement(prioridadTareaOptionLocator);
        prioridadTareaOption.click();
        crearTareaBtn = driver.findElement(crearTareaBtnLocator);
        crearTareaBtn.sendKeys(Keys.ENTER);
        cerrarAniadirTareaBtn = driver.findElement(cerrarAniadirTareaBtnLocator);
        tareaAniadidaTxt = driver.findElement(tareaAniadidaLocator);        
        
    }

	public String getTareaAniadida() {
    	String obtainedTitle = tareaAniadidaTxt.getText();
        return obtainedTitle;
	}

	public void setElementsEliminarTareaRapida() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	borrarTareaBtn = driver.findElement(borrarTareaBtnLocator);
    	borrarTareaBtn.click();
        Thread.sleep(1000);
    	eliminarTareaBtn = driver.findElement(eliminarTareaBtnLocator);
    	eliminarTareaBtn.click();
        Thread.sleep(1000);
        try {
            tareaAniadidaTxt = driver.findElement(tareaAniadidaLocator);        	
        }catch (Exception e) {
        	tareaAniadidaTxt = null;
		}
	}
}
