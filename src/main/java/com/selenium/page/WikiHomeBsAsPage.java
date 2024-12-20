package com.selenium.page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



import Utils.Utiles;


public class WikiHomeBsAsPage {
	WebDriver driver;

    
    public WikiHomeBsAsPage(WebDriver ldriver) {
		driver = ldriver;
    }
    

 // ***** IDENTIFICAMOS LOS ELEMENTOS POR SU LOCATOR EJEMPLO ID O XPATH

    
    @FindBy(xpath = "//input[@id='vector-main-menu-dropdown-checkbox']")
    private WebElement menuIzquierdo;

    @FindBy(xpath = "//li[@id='n-bug_in_article']")
    private WebElement notificarError;

    @FindBy(xpath = "//span[contains(text(),'Informar del error')]")
    private WebElement informarElError;
  
    @FindBy(xpath = "//textarea[@id='ooui-4']")
    private WebElement textodelMensaje;
  
    @FindBy(xpath = "//input[@id='ooui-5']")
    private WebElement firma;
    
    @FindBy(xpath = "//span[@class='oo-ui-widget oo-ui-widget-enabled oo-ui-buttonElement oo-ui-labelElement oo-ui-flaggedElement-progressive oo-ui-buttonWidget oo-ui-actionWidget oo-ui-buttonElement-framed']//a[@role='button']")
    private WebElement botonAceptar;
  
    @FindBy(xpath = "//div[@id='mw-notification-area']")
    private WebElement SinTextoError;
  
  
    @FindBy(xpath = "//a[span[@class='oo-ui-labelElement-label' and text()='Voy a arreglarlo']]")
    private WebElement voyAArreglarlo;
    
    @FindBy(xpath = "a//span[@class='oo-ui-labelElement-label' and text()='Empezar a editar']")
    private WebElement empezarAEditar1; 
    
    @FindBy(xpath = "//textarea[@id='wpTextbox1']")
    private WebElement textoScript;
    
    @FindBy(xpath = "//input[@id='wpSummary']")
    private WebElement inputResumen;
 
    @FindBy(xpath = "//input[@id='wpSave']")
    private WebElement botonGuardar;
    
    @FindBy(xpath = "//*[@id=\"content\"]/header")
    private WebElement tituloInformeDeError;
    
    
//ELEMENTOS DE LA PAGINA
    
    @FindBy(xpath = "//a[@href='/w/index.php?title=Buenos_Aires&action=history']")
    private WebElement enlaceHistorialPagina;
    
    @FindBy(xpath = "//a[@href='/w/index.php?title=Buenos_Aires&action=edit']")
    private WebElement enlaceEditarPagina;
  
    
    @FindBy(xpath = "//input[@class='cdx-text-input__input']")
    private WebElement campoBusqueda;

    @FindBy(xpath = "//li[@id='ca-talk']")
    private WebElement discusion;

    @FindBy(xpath = "//li[@id='ca-nstab-main']")
    private WebElement archivo;


    @FindBy(id = "pt-sitesupport-2")
    private WebElement donaciones;


    @FindBy(id = "pt-createaccount-2")
    private WebElement crearCuenta;

    @FindBy(xpath = "//li[@id='pt-login-2']//a[contains(@href, 'Especial:Entrar')]")
    private WebElement enlaceLogin;


    @FindBy(xpath = "//a[@href='/wiki/Distrito_federal']")
    private WebElement enlaceCapitalFederal;

  
    @FindBy(xpath = "//a[@href='/wiki/Categor%C3%ADa:Personas_de_la_ciudad_de_Buenos_Aires']")
    private WebElement enlacePersonasDeBuenosAires;

    @FindBy(xpath = "//input[@id='skin-client-pref-vector-feature-custom-font-size-value-0']")
    private WebElement radioPequeno;;
    
    
    @FindBy(id = "skin-client-pref-vector-feature-custom-font-size-value-1")
    private WebElement radioEstandar;
    
    

    
    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public String obtenerPlaceholder() {
        return textodelMensaje.getAttribute("placeholder");
    }
    
    public void verificarYHacerClickEnDonaciones() {
        Reporter.log("Validando que el sitio de soporte est� visible", true);
        try {
            waitForElementToBeVisible(donaciones, 10);
            Assert.assertTrue(donaciones.isDisplayed(), "El sitio de soporte no est� visible");
            Reporter.log("El sitio de soporte est� visible", true);
        } catch (Exception e) {
            Reporter.log("Error al validar el sitio de soporte: " + e.getMessage(), true);
            throw e;
        }
    }
    
    public void clickArchivo() {
        Reporter.log("Validar que el tab 'Archivo' est� visible y hacer clic", true);
        waitForElementToBeVisible(archivo, 10);
        Assert.assertTrue(archivo.isDisplayed(), "El tab 'Archivo' no est� visible");
        Reporter.log("Haciendo clic en el tab 'Archivo'", true);
        waitForElementToBeClickable(archivo, 10);
        archivo.click();
        Reporter.log("Se hizo clic en el tab 'Archivo'", true);
    }

    public void verificarYHacerClickEnCrearCuenta() {
        Reporter.log("Validando que la opci�n de crear cuenta est� visible", true);
        try {waitForElementToBeVisible(crearCuenta, 10);
            Assert.assertTrue(crearCuenta.isDisplayed(), "La opci�n de crear cuenta no est� visible");
            Reporter.log("La opci�n de crear cuenta est� visible", true);
        } catch (Exception e) {
            Reporter.log("Error al validar la opci�n de crear cuenta: " + e.getMessage(), true);
            throw e;
        }
    }
    
    public void verificarYHacerClickEnEnlacePersonasDeBuenosAires() {
        Reporter.log("Validando que el enlace 'Personas de la ciudad de Buenos Aires' est� visible y clickeable", true);

        try {
           
            waitForElementToBeVisible(enlacePersonasDeBuenosAires, 10);  
            Assert.assertTrue(enlacePersonasDeBuenosAires.isDisplayed(), "El enlace 'Personas de la ciudad de Buenos Aires' no est� visible");
            Assert.assertTrue(enlacePersonasDeBuenosAires.isEnabled(), "El enlace 'Personas de la ciudad de Buenos Aires' no est� habilitado para hacer clic");
            enlacePersonasDeBuenosAires.click();
            Reporter.log("Se hizo clic en el enlace 'Personas de la ciudad de Buenos Aires'", true);
        } catch (Exception e) {
            Reporter.log("Error al manejar el enlace 'Personas de la ciudad de Buenos Aires': " + e.getMessage(), true);
            throw e; 
        }
    }
    
    public void seleccionarTama�oPeque�o() {
        Reporter.log("Validando que el radio de tama�o peque�o est� visible y seleccionable", true);
        try {
            waitForElementToBeVisible(radioPequeno, 10);
            Assert.assertTrue(radioPequeno.isDisplayed(), "El radio de tama�o peque�o no est� visible");
            Assert.assertTrue(radioPequeno.isEnabled(), "El radio de tama�o peque�o no est� habilitado para hacer clic");

            radioPequeno.click();  
            Reporter.log("Se seleccion� el radio de tama�o peque�o", true);
        } catch (Exception e) {
            Reporter.log("Error al seleccionar el radio de tama�o peque�o: " + e.getMessage(), true);
            throw e;
        }
    }
    
    public void seleccionarTama�oEstandar() {
        Reporter.log("Validando que el radio de tama�o est�ndar est� visible y seleccionable", true);
        try {
            waitForElementToBeVisible(radioEstandar, 10);
            Assert.assertTrue(radioEstandar.isDisplayed(), "El radio de tama�o est�ndar no est� visible");
            Assert.assertTrue(radioEstandar.isEnabled(), "El radio de tama�o est�ndar no est� habilitado para hacer clic");
            radioEstandar.click();  
            Reporter.log("Se seleccion� el radio de tama�o est�ndar", true);
        } catch (Exception e) {
            Reporter.log("Error al seleccionar el radio de tama�o est�ndar: " + e.getMessage(), true);
            throw e;
        }
    }
    
    public void verificarYHacerClickEnEnlaceCapitalFederal() {
        Reporter.log("Validando que el enlace 'Capital federal' est� visible y clickeable", true);
        
        try {
           
            waitForElementToBeVisible(enlaceCapitalFederal, 10);  
            Assert.assertTrue(enlaceCapitalFederal.isDisplayed(), "El enlace de 'Capital federal' no est� visible");
            Assert.assertTrue(enlaceCapitalFederal.isEnabled(), "El enlace de 'Capital federal' no est� habilitado para hacer clic");

        } catch (Exception e) {
            Reporter.log("Error al manejar el enlace de 'Capital federal': " + e.getMessage(), true);
            throw e;  
        }
    }
    
    public void verificarYHacerClickEnLogin() {
        Reporter.log("Validando que el enlace de 'Iniciar sesi�n' est� visible y clickeable", true);
        try { waitForElementToBeVisible(enlaceLogin, 10);
            Assert.assertTrue(enlaceLogin.isDisplayed(), "El enlace de 'Iniciar sesi�n' no est� visible");
            Assert.assertTrue(enlaceLogin.isEnabled(), "El enlace de 'Iniciar sesi�n' no est� habilitado para hacer clic");
            Reporter.log("El enlace de 'Iniciar sesi�n' est� visible y habilitado", true);
           enlaceLogin.click();
            Reporter.log("Se hizo clic en el enlace de 'Iniciar sesi�n'", true);
        } catch (Exception e) {
            Reporter.log("Error al validar el enlace de 'Iniciar sesi�n': " + e.getMessage(), true);
            throw e;
        }
    }
    
    public void verificarYEscribirEnCampoBusqueda(String textoBusqueda) {
        Reporter.log("Validando que el campo de b�squeda est� visible", true);

        try {
            waitForElementToBeVisible(campoBusqueda, 10); 
             Assert.assertTrue(campoBusqueda.isDisplayed(), "El campo de b�squeda no est� visible");
            campoBusqueda.clear();  
            campoBusqueda.sendKeys(textoBusqueda);
            Reporter.log("Texto ingresado en el campo de b�squeda: " + textoBusqueda, true);
         } catch (Exception e) {
            Reporter.log("Ocurri� un error al manejar el campo de b�squeda: " + e.getMessage(), true);
            throw e; 
        }
    }

    public void clickDiscusion() {
        Reporter.log("Validar que el tab 'Discusi�n' est� visible y hacer clic", true);
        waitForElementToBeVisible(discusion, 10);
        Assert.assertTrue(discusion.isDisplayed(), "El tab 'Discusi�n' no est� visible");
        Reporter.log("Haciendo clic en el tab 'Discusi�n'", true);
        waitForElementToBeClickable(discusion, 10);
        discusion.click();
        Reporter.log("Se hizo clic en el tab 'Discusi�n'", true);
    }

    public void verificarYHacerClickEnEnlaceHistorial() {
        Reporter.log("Validando que el enlace de 'Historial' est� visible y clickeable", true);

        try {
            waitForElementToBeVisible(enlaceHistorialPagina, 10);  
            Assert.assertTrue(enlaceHistorialPagina.isDisplayed(), "El enlace de 'Historial' no est� visible");
            Assert.assertTrue(enlaceHistorialPagina.isEnabled(), "El enlace de 'Historial' no est� habilitado para hacer clic");
            enlaceHistorialPagina.click();
            Reporter.log("Se hizo clic en el enlace de 'Historial'", true);
        } catch (Exception e) {
            Reporter.log("Ocurri� un error al manejar el enlace de 'Historial': " + e.getMessage(), true);
            throw e;  
        }
    }
    
    public void verificarYHacerClickEnEnlaceEditar() {
        Reporter.log("Validando que el enlace de 'Editar p�gina' est� visible y clickeable", true);
        try {waitForElementToBeVisible(enlaceEditarPagina, 10);  
            Assert.assertTrue(enlaceEditarPagina.isDisplayed(), "El enlace de 'Editar p�gina' no est� visible");
            Assert.assertTrue(enlaceEditarPagina.isEnabled(), "El enlace de 'Editar p�gina' no est� habilitado para hacer clic");
            enlaceEditarPagina.click();
            Reporter.log("Se hizo clic en el enlace de 'Editar p�gina'", true);
         } catch (Exception e) {
            Reporter.log("Ocurri� un error al manejar el enlace de 'Editar p�gina': " + e.getMessage(), true);
            throw e; 
        }
    }


   
    public boolean isTituloInformeDeErrorPresente() {
        return tituloInformeDeError.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    
    public boolean isSinTextoErrorVisible() {
    	try {
            return SinTextoError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    public void esperarVentanaModal() {
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
 // M�todos para interactuar con los elementos
    public void clickMenuIzquierdo() {
        menuIzquierdo.click();
    }

    public void clickNotificarError() {
        notificarError.click();
    }
    
    
    
 
    public void clickVoyAInformarElerror() {
        try {
           
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        informarElError.click();
    }
    
    public void escribirMensaje(String texto) {
    	
    	try {
            
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	Reporter.log("Escribiendo mensaje1");
    	textodelMensaje.sendKeys(texto);
    	Reporter.log("Mensaje escrito");
    	
    }
    
 public void escribirfirma(String texto) {
    	
    	try {
            
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	Reporter.log("Escribiendo firma");
    	firma.sendKeys(texto);
    	Reporter.log("Firma escrita");
    	
    }
 
 public void clickAceptar() {
 Reporter.log("Clickeando aceptar");
 botonAceptar.click();
 try {
     
     Thread.sleep(5000); 
 } catch (InterruptedException e) {
     e.printStackTrace();
 } 
 
 }







  

    
   

}
