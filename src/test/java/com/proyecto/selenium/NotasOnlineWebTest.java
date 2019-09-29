/**
 * Proyecto Pruebas Unitarias de Interfaz
 * --------------------------------------
 * Autor: Navarro Arias, Juan Dirceu.  
 * Modulo: Pruebas Unitarias de Interfaz.  
 * Universidad Andina Simón Bolivar.  
 * Sede Sucre, Bolivia.
 */

package com.proyecto.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.proyecto.selenium.framework.AppPage;
import com.proyecto.selenium.pages.CalendarioPage;
import com.proyecto.selenium.pages.HomePage;
import com.proyecto.selenium.pages.NotaRapida;
import com.proyecto.selenium.pages.PanelPage;
import com.proyecto.selenium.pages.TareaRapida;

public class NotasOnlineWebTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "src/test/resources/chromedriver/geckodriver");
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.navigate().to("https://www.notasonline.es/");
	}	
	
	@Test
	public void obtenerTituloVentana() throws InterruptedException {	
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();
        PanelPage panelPage = homePage.login();
        panelPage.setElements();
        String titleObtained = panelPage.getTitle();
        assertEquals("Panel de inicio rápido", titleObtained);
        panelPage.logOut();
    }
	
	@Test
	public void abrirVentanaAniadirTareaRapida() throws InterruptedException {	
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();       
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        TareaRapida tareaRapida = panelPage.getTareaRapida();
        tareaRapida.setElementsTareasRapidasTituloVentana();
        String titleObtained = tareaRapida.getTituloAniadirTarea();
        System.out.println("titleObtained: " + titleObtained);
        assertEquals("Añadir nueva tarea", titleObtained);
        tareaRapida.cerrarAniadirTarea();
        panelPage.logOut();
    }
	
	@Test
	public void aniadirTareaRapida() throws InterruptedException {
		// Insertar tarea
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();       
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        TareaRapida tareaRapida = panelPage.getTareaRapida();        
        tareaRapida.setElementsAniadirTareasRapidas();
        String tareaAniadida = tareaRapida.getTareaAniadida();
        System.out.println("tareaAniadida: " + tareaAniadida);
        assertEquals("Clases de piano", tareaAniadida);
		// Eliminar tarea        
        tareaRapida.setElementsEliminarTareaRapida();
        panelPage.logOut();
    }
	
	@Test
	public void eliminarTareaRapida() throws InterruptedException {
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();       
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        TareaRapida tareaRapida = panelPage.getTareaRapida();        
        tareaRapida.setElementsAniadirTareasRapidas();
        tareaRapida.setElementsEliminarTareaRapida();
        String tareaAniadida;
        try {
            tareaAniadida = tareaRapida.getTareaAniadida();        	
        } catch (Exception e) {
        	tareaAniadida = null;
		}
        System.out.println("tareaAniadida: " + tareaAniadida);
        assertNull(tareaAniadida, null);
        panelPage.logOut();
    }
	
	@Test
	public void aniadirCategoriaCalendario() throws InterruptedException {
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        CalendarioPage calendario = AppPage.getCalendarioPage();
        calendario.setElementsAniadirCalendario();
        // Se llama otra vez ya que con el click de CalendarioPage,
        // El DOM anterior desapareció y se debe volver a cargar.
        panelPage.setElements(); 
        String categoriaAniadida = calendario.getCategoriaAniadida();
        System.out.println("categoriaAniadida: " + categoriaAniadida);
        assertEquals("Medicinas", categoriaAniadida);
        calendario.setElementsEliminarCategorias();
        panelPage.logOut();
    }
	
	@Test
	public void eliminarCategoriaCalendario() throws InterruptedException {
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        CalendarioPage calendario = AppPage.getCalendarioPage();
        calendario.setElementsAniadirCalendario();
        calendario.setElementsEliminarCategorias();
        String categoriaAniadida;
        try {
        	categoriaAniadida = calendario.getCategoriaAniadida();
        } catch (Exception e) {
        	categoriaAniadida = null;
		}
        assertNull(categoriaAniadida, null);
        panelPage.setElements();
        panelPage.logOut();
    }
	
	@Test
	public void aniadirNotaRapida() throws InterruptedException {
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();       
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        NotaRapida notaRapida = panelPage.getNotaRapida();
        notaRapida.setElementsAniadirNotaRapida();
        String notaAniadida = notaRapida.getNotaAniadida();
        System.out.println("notaAniadida: " + notaAniadida);
        assertEquals("Nueva nota", notaAniadida);
		// Eliminar Nota        
        notaRapida.setElementsEliminarNotaRapida();
        panelPage.logOut();
    }
	
	@Test
	public void eliminarNotaRapida() throws InterruptedException {
    	HomePage homePage = AppPage.getLoginPage(driver);
        homePage.setElements();       
        PanelPage panelPage = homePage.login();
        panelPage.setElements();      
        NotaRapida notaRapida = panelPage.getNotaRapida();        
        notaRapida.setElementsAniadirNotaRapida();
        notaRapida.setElementsEliminarNotaRapida();
        String notaAniadida;
        try {
        	notaAniadida = notaRapida.getNotaAniadida();        	
        } catch (Exception e) {
        	notaAniadida = null;
		}
        System.out.println("notaAniadida: " + notaAniadida);
        assertNull(notaAniadida, null);
        panelPage.logOut();
    }
	
	@Test
	public void editarNotaRapida() throws InterruptedException {
		HomePage homePage = AppPage.getLoginPage(driver);
		homePage.setElements();       
		PanelPage panelPage = homePage.login();
		panelPage.setElements();      
		NotaRapida notaRapida = panelPage.getNotaRapida();
		notaRapida.setElementsAniadirNotaRapida();
		notaRapida.setElementsEditarNotaRapida();
		String notaRapidaEditadaAniadida = notaRapida.getNotaAniadida();
		assertEquals("Nueva notaSalir en bici", notaRapidaEditadaAniadida);
		notaRapida.setElementsEliminarNotaRapida();
		panelPage.logOut();
    }
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
