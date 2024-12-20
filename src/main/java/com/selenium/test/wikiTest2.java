package com.selenium.test;

import java.util.ArrayList;
import java.util.List;

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
import org.testng.asserts.SoftAssert;

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
	

	/////////////////////////////////////////////////AGUS
	@DataProvider(name = "datos3")
	public Object[][] createData3() {
	    return new Object[][] {
	        {"Esto es un test, para el sistema. No pude agregar 'La ciudad que nunca duerme' por permisos", "Luis", "https://es.wikipedia.org/wiki/Wikipedia:Informes_de_error#Buenos_Aires"}
	    };
	}

	 //No pude agregar apodo el 'La ciudad del tango' por permisos
	
	
	@Test(dataProvider = "datos3", description = "Validar que las b�squedas en Wikipedia funcionan")
	public void ValidarWikipediaAA (String textoNuevo, String firma, String urlEsperada ) throws Exception {
	    Reporter.log("Inicializamos la p�gina de Buenos Aires", true);
	
	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);

        
	    Reporter.log("Haciendo clic en el men� superior izquierdo", true);
	    wikiPage.clickMenuIzquierdo();
	    
	    Reporter.log("Haciendo clic en Notificar un error", true);
	    wikiPage.clickNotificarError();

	    Reporter.log("Haciendo clic en 'Voy Informar El error'", true);
	    wikiPage.clickVoyAInformarElerror();
	    
	    Reporter.log("Escribiendo texto");
	    wikiPage.escribirMensaje(textoNuevo);
	    
	    Reporter.log("Escribiendo mensaje", true);
	    wikiPage.escribirfirma(firma);
	    
	    Reporter.log("Haciendo clic en 'Aceptar'", true);
	    wikiPage.clickAceptar();
	    
	    
	    Reporter.log("Verificando que  la URL sea correcta", true);
	    String urlActual = wikiPage.getCurrentUrl();
	    Assert.assertEquals(urlActual, urlEsperada, "La URL actual no coincide con la esperada.");
	    Reporter.log("La redirecci�n fue exitosa y la URL es correcta: " + urlActual, true);
	    
	    Reporter.log("Verificando que el t�tulo 'Informes de error' est� presente", true);
	    Assert.assertTrue(wikiPage.isTituloInformeDeErrorPresente(), 
	            "El t�tulo 'Informes de error' no est� presente.");
	     
	}
	
	@Test(dataProvider = "datos3", description = "Validar pagina de wiki/BsAs.")
	public void ValidarWikipediaAA1 (String textoNuevo, String firma, String urlEsperada ) throws Exception {
	    Reporter.log("Inicializamos la p�gina de Buenos Aires", true);
	
	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);

        
	    Reporter.log("Haciendo clic en el men� superior izquierdo", true);
	    wikiPage.clickMenuIzquierdo();
	    
	    Reporter.log("Haciendo clic en Notificar un error", true);
	    wikiPage.clickNotificarError();

	    Reporter.log("Haciendo clic en 'Voy Informar El error'", true);
	    wikiPage.clickVoyAInformarElerror();
	    
	    Reporter.log("Escribiendo mensaje", true);
	    wikiPage.escribirfirma(firma);
	    
	    Reporter.log("Haciendo clic en 'Aceptar'", true);
	    wikiPage.clickAceptar();
	    
	    boolean errorVisible = wikiPage.isSinTextoErrorVisible();

        try {
            Assert.assertTrue(errorVisible, "El mensaje de error 'SinTextoError' no est� visible.");
        } catch (AssertionError e) {
            Reporter.log("Error encontrado: " + e.getMessage(), true);
            throw e; 
        }

        Reporter.log("El mensaje de error 'SinTextoError' se mostr� correctamente.", true);
	    
	   
	     
	}

	@Test(dataProvider = "datos3", description = "Validar pagina de wiki/BsAs.")
	public void ValidarWikipediaAA2 (String textoNuevo, String firma, String urlEsperada ) throws Exception {
	    Reporter.log("Inicializamos la p�gina de Buenos Aires", true);
	
	    WikiHomeBsAsPage wikiPage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);
        driver.get("https://es.wikipedia.org/wiki/Buenos_Aires");
        
	    Reporter.log("Haciendo clic en el men� superior izquierdo", true);
	    wikiPage.clickMenuIzquierdo();
	    
	    Reporter.log("Haciendo clic en Notificar un error", true);
	    wikiPage.clickNotificarError();

	    Reporter.log("Haciendo clic en 'Voy Informar El error'", true);
	    wikiPage.clickVoyAInformarElerror();
	  
	    Reporter.log("Escribiendo texto");
	    wikiPage.escribirMensaje(textoNuevo);
	    
	    Reporter.log("Haciendo clic en 'Aceptar'", true);
	    wikiPage.clickAceptar();
	    
	    Reporter.log("Verificando que el t�tulo 'Informes de error' est� presente", true);
	    Assert.assertTrue(wikiPage.isTituloInformeDeErrorPresente(), 
	            "El t�tulo 'Informes de error' no est� presente.");
	    
	    Reporter.log("Verificando que  la URL sea correcta", true);
	    String urlActual = wikiPage.getCurrentUrl();
	    Assert.assertEquals(urlActual, urlEsperada, "La URL actual no coincide con la esperada.");
	    Reporter.log("La redirecci�n fue exitosa y la URL es correcta: " + urlActual, true);
	     
	}
	
	@DataProvider(name = "datos4")
	public Object[][] createData4() {
	    return new Object[][] {
	        {"Wikipedia"}
	    };
	}
	
	
	@Test(dataProvider = "datos4", description = "Validar que las b�squedas en Wikipedia funcionan")
	public void ValidarElementosYPagina(String texto ) throws Exception {
	    // Crear el objeto SoftAssert para realizar m�ltiples verificaciones
	    SoftAssert softAssert = new SoftAssert();

	    Reporter.log("Cargando la p�gina principal", true);
	    WikiHomeBsAsPage homepage = PageFactory.initElements(driver, WikiHomeBsAsPage.class);
	    try {
	    	homepage.verificarYHacerClickEnEnlaceCapitalFederal();
	    } catch (Exception e) {
	        softAssert.fail("Error al hacer clic en el enlace 'Capital federal': " + e.getMessage());
	    }
	  
	    Reporter.log("Validando la opci�n de discusi�n", true);
	    try {
	        homepage.clickDiscusion();
	        Reporter.log("Se valid� el tab de 'Discusi�n' y se hizo clic", true);
	    } catch (Exception e) {
	        softAssert.fail("Error al validar el tab 'Discusi�n': " + e.getMessage());
	    }
	   
	   
	    Reporter.log("Validando otro elemento espec�fico", true);
	    try {
	        homepage.clickArchivo();
	        Reporter.log("Se valid� el tab de 'Archivo' y se hizo clic", true);
	    } catch (Exception e) {
	        softAssert.fail("Error al validar el tab 'Archivo': " + e.getMessage());
	    }

	    Reporter.log("Validando Campo de B�squeda", true);
	   
	    try {
	        homepage.verificarYEscribirEnCampoBusqueda(texto);
	        Reporter.log("Texto ingresado en el campo de b�squeda: " + texto, true);
	    } catch (Exception e) {
	        softAssert.fail("Error al validar el campo de b�squeda: " + e.getMessage());
	    }

	    Reporter.log("Validando clic en enlace 'Editar p�gina'", true);
	    try {
	        homepage.verificarYHacerClickEnEnlaceEditar();
	        Reporter.log("Se hizo clic en el enlace 'Editar p�gina'", true);
	    } catch (Exception e) {
	        softAssert.fail("Error al validar el enlace 'Editar p�gina': " + e.getMessage());
	    }

	    
	    Reporter.log("Validando la opci�n de Soporte del sitio", true);
	    try {
	        homepage.verificarYHacerClickEnDonaciones();
	    } catch (Exception e) {
	        softAssert.fail("Error al validar 'Sitio de soporte': " + e.getMessage());
	    }

	    Reporter.log("Validando la opci�n de Crear Cuenta", true);
	    try {
	        homepage.verificarYHacerClickEnCrearCuenta();
	    } catch (Exception e) {
	        softAssert.fail("Error al validar 'Crear cuenta': " + e.getMessage());
	    }

	    
	    Reporter.log("Se validaron los elementos de la p�gina, reportando fallas si las hay", true);
	    softAssert.assertAll(); // Esto reportara todos los errores que ocurrieron durante el test
	}

	

	/////////////////////////////////////////////////////////////////////////
	
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