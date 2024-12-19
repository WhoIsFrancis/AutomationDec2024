package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomeBsAsPage;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultPage;

public class wikiTest2 {
	WebDriver driver;

	@BeforeMethod
	public void Precondicion(ITestContext context)  {
		String browserName = context.getCurrentXmlTest().getParameter("NombreNavegador");
		String URL = context.getCurrentXmlTest().getParameter("Url");
		driver = DriverFactory.LevantarBrowser(driver, URL, browserName);
	}

	@AfterMethod
	public void Postcondicion() {
		DriverFactory.FinalizarBrowser(driver);
	}
	
	@DataProvider(name = "datos")
	public Object[][] createData() {
	    return new Object[][] {
	        {"Messi"},
	        {"Selenium"}
	    };
	}
	/**Joel
	 Fecha: 13/12/24
	 Hora: 11:03
	 **/
	@DataProvider(name = "datos2")
    public Object[][] createData2() {
        return new Object[][] {
            {"Python"},
            {"Messi"},
				{"Club Atlético Talleres"}
        };
    }
	
	@DataProvider(name = "datos3")
	public Object[][] createData3() {
	    return new Object[][] {
	        {"No pude agregar apodo el 'La ciudad del tango' por permisos", "AgustinaA"}
	    };
	}

	
	
	@Test(dataProvider = "datos3", description = "Validar que las b�squedas en Wikipedia funcionan")
	public void ValidarWikipediaAA (String textoNuevo, String firma ) throws Exception {
	    Reporter.log("Inicializamos la p�gina de Buenos Aires", true);
	 
        
	    // Inicializamos la p�gina de Buenos Aires
	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);
        driver.get("https://es.wikipedia.org/wiki/Buenos_Aires");
        
	    // Verificamos que el men� superior izquierdo este disponibles
	    Reporter.log("Haciendo clic en el men� superior izquierdo", true);
	    wikiPage.clickMenuIzquierdo();
	    
	    Reporter.log("Haciendo clic en Notificar un error", true);
	    wikiPage.clickNotificarError();

	    Reporter.log("Haciendo clic en 'Voy Informar El error'", true);
	    wikiPage.clickVoyAInformarElerror();
	    
	    Reporter.log("Escribiendo texto");
	    wikiPage.escribirMensaje(textoNuevo);
	    
	    Reporter.log("Escribiendo mensaje", true);
	    wikiPage.escribirfirma("firma");
	    
	    Reporter.log("Haciendo clic en 'Aceptar'", true);
	    wikiPage.clickAceptar();
	    
	    Reporter.log("Verificando que el t�tulo 'Informes de error' est� presente", true);
	    Assert.assertTrue(wikiPage.isTituloInformeDeErrorPresente(), 
	            "El t�tulo 'Informes de error' no est� presente.");
	     
	}
	
	@Test(dataProvider = "datos3", description = "Validar que las b�squedas en Wikipedia funcionan")
	public void ValidarWikipediaAA1 (String textoNuevo, String firma ) throws Exception {
	    Reporter.log("Inicializamos la p�gina de Buenos Aires", true);
	 
        
	    // Inicializamos la p�gina de Buenos Aires
	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);
        driver.get("https://es.wikipedia.org/wiki/Buenos_Aires");
        
	    // Verificamos que el men� superior izquierdo este disponibles
	    Reporter.log("Haciendo clic en el men� superior izquierdo", true);
	    wikiPage.clickMenuIzquierdo();
	    
	    Reporter.log("Haciendo clic en Notificar un error", true);
	    wikiPage.clickNotificarError();

	    Reporter.log("Haciendo clic en 'Voy A Arreglarlo'", true);
	    wikiPage.clickVoyAArreglarlo();
	    
	    Reporter.log("Haciendo clic en Editar");
	    wikiPage.clickEmpezarAEditar();
	    
	    Reporter.log("Escribiendo mensaje", true);
	   
	    
	     
	}
	/*
	    Reporter.log("Haciendo clic en 'Empezar a Editar'", true);
	    wikiPage.clickEmpezarAEditar();
	    
	    Reporter.log("Escribiendo en el �rea de texto del script", true);
	    wikiPage.escribirEnScript(textoNuevo);

	    Reporter.log("Escribiendo el resumen", true);
	    wikiPage.escribirResumen("Agregar apodo");

	    Reporter.log("Guardando los cambios", true);
	    wikiPage.guardar();

	    // Aqu�, puedes validar que la p�gina haya cambiado o si el texto fue guardado correctamente
	    Assert.assertTrue(driver.getCurrentUrl().contains("wpSave"), "No se guard� la p�gina correctamente");

	    // Para validar los resultados de b�squeda, si es necesario
	    WikiResultPage resultadoPage = PageFactory.initElements(driver, WikiResultPage.class);
	    Assert.assertTrue(resultadoPage.getTitulo(textoNuevo).contains(textoNuevo), "No se encontr� " + textoNuevo);*/

	
	
	/*
		@Test
	public void ValidarWikipediaAA() {
	    try {
	    	 driver.get("https://es.wikipedia.org/wiki/Buenos_Aires");
	 	    
	 	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);
	        System.out.println("Inicio del test ValidarWikipediaAA...");

	        System.out.println("Localizando la caja de b�squeda...");
	       

	        System.out.println("Navegando por el men�...");
	       wikiPage.clickMenuIzquierdo();
	        wikiPage.clickNotificarError();
	        wikiPage.clickVoyAArreglarlo();
	        wikiPage.clickEmpezarAEditar();

	        System.out.println("Escribiendo el texto principal...");
	        wikiPage.escribirEnScript();

	        System.out.println("Escribiendo el resumen...");
	        wikiPage.escribirResumen();

	        System.out.println("Guardando los cambios...");
	        wikiPage.guardar();

	    } catch (Exception e) {
	        System.out.println("Error durante el test: " + e.getMessage());
	        e.printStackTrace();
	    }
	    System.out.println("Fin del test ValidarWikipediaAA.");
	}

	*/
	
	@Test(dataProvider = "datos2", description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarWikipedia2(String dato) throws Exception {
		Reporter.log("Caso de prueba", true);
		Reporter.log("Localizar la caja de busqueda del home de wiki", true);
		WikiHomePage homepage = PageFactory.initElements(driver, WikiHomePage.class);

		Reporter.log("Verificar que la caja de busqueda se este mostrando", true);
		Assert.assertTrue((homepage.SeVisualizaCaja()), "No se visualizo la caja");

		Reporter.log("Ingresar el texto " + dato, true);
		homepage.IngresarDatoCajaBusqueda(dato);

		WikiResultPage resultadoPage = PageFactory.initElements(driver, WikiResultPage.class);

		Assert.assertTrue((resultadoPage.getTitulo(dato).contains(dato)), "no se encontro " + dato);
	}
	/**Ramiro 
	 Fecha: 13/12/24
	 Hora: 8:48
	 **/
	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception {

		Reporter.log("P�gina de Wikipedia cargada", true);
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		Assert.assertTrue(searchInput.isDisplayed());
		Reporter.log("Campo de b�squeda encontrado", true);
		searchInput.sendKeys("Selenium");
		Reporter.log("Texto 'Selenium' ingresado en el campo de b�squeda", true);

		searchInput.submit();
		Reporter.log("Formulario de b�squeda enviado", true);
		
		Thread.sleep(5000);
		WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
		Reporter.log("Texto encontrado en la p�gina: " + tituloResultado.getText(), true);

		System.out.println("Texto encontrado " + tituloResultado.getText());
		Assert.assertTrue(tituloResultado.isDisplayed());
		Reporter.log("T�tulo del resultado de b�squeda es visible", true);
		Reporter.log("Prueba en Chrome finalizada", true);
		driver.close();
	}

	@Test(dataProvider = "datos", description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarWikipediaRamiro(String dato) throws Exception {
		Reporter.log("Caso de prueba Fanny Montoya", true);
		Reporter.log("Localizar la caja de busqueda del home de wiki", true);
		WikiHomePage homepage = PageFactory.initElements(driver, WikiHomePage.class);

		Reporter.log("Verificar que la caja de busqueda se este mostrando", true);
		Assert.assertTrue((homepage.SeVisualizaCaja()), "No se visualizo la caja");

		Reporter.log("Ingresar el texto " + dato, true);
		homepage.IngresarDatoCajaBusqueda(dato);

		WikiResultPage resultadoPage = PageFactory.initElements(driver, WikiResultPage.class);

		Assert.assertTrue((resultadoPage.getTitulo(dato).contains(dato)), "no se encontro " + dato);
	}
	
	
	 @Test(dataProvider = "datos2", description = "Validar que las b�squedas en Wikipedia funcionan correctamente")
	    public void validarBusquedaWikipediaAgustina(String dato) throws Exception {
	        Reporter.log("Iniciando prueba de b�squeda en Wikipedia Agustina", true);
	        Reporter.log("Localizando la caja de b�squeda en la p�gina principal de Wikipedia", true);

	        
	        
	        WikiHomePage homepage = PageFactory.initElements(driver, WikiHomePage.class);
	        Reporter.log("Verificando que la caja de b�squeda est� visible", true);
	        Assert.assertTrue(homepage.SeVisualizaCaja(), "No se visualiz� la caja de b�squeda");
	        Reporter.log("Ingresando el texto: " + dato, true);
	        homepage.IngresarDatoCajaBusqueda(dato);

	        WikiResultPage resultadoPage = PageFactory.initElements(driver, WikiResultPage.class);
	        Assert.assertTrue(resultadoPage.getTitulo(dato).contains(dato), "No se encontr� el t�rmino: " + dato);
	    }
	

	
}