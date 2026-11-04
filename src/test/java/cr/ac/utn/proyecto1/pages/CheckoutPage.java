package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private final WebDriverWait espera;

    // Compra como invitado
    @FindBy(css = ".checkout-as-guest-button")
    private WebElement botonInvitado;

    // Datos personales
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement nombre;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement apellido;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement correo;

    // Direccion de facturacion
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement pais;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    private WebElement provincia;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement ciudad;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement direccion;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement codigoPostal;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement telefono;

    @FindBy(css = "#billing-buttons-container .new-address-next-step-button")
    private WebElement continuarFacturacion;

    // Direccion de envio
    @FindBy(css = "#shipping-buttons-container .new-address-next-step-button")
    private WebElement continuarEnvio;

    // Metodo de envio
    @FindBy(id = "shippingoption_0")
    private WebElement envioTerrestre;

    @FindBy(css = "#shipping-method-buttons-container .shipping-method-next-step-button")
    private WebElement continuarMetodoEnvio;

    // Metodo de pago
    @FindBy(id = "paymentmethod_0")
    private WebElement pagoContraEntrega;

    @FindBy(css = "#payment-method-buttons-container .payment-method-next-step-button")
    private WebElement continuarMetodoPago;

    // Informacion de pago
    @FindBy(css = "#payment-info-buttons-container .payment-info-next-step-button")
    private WebElement continuarInformacionPago;

    // Confirmar pedido
    @FindBy(css = "#confirm-order-buttons-container .confirm-order-next-step-button")
    private WebElement botonConfirmar;

    // Mensaje final
    @FindBy(css = ".order-completed .title strong")
    private WebElement mensajeConfirmacion;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        espera = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Paso 1: Comprar como invitado
    public void continuarComoInvitado() {
        espera.until(ExpectedConditions.elementToBeClickable(botonInvitado))
                .click();
    }

    // Paso 2: Datos personales
    public void escribirDatosPersonales(
            String primerNombre, String apellidos, String email) {

        espera.until(ExpectedConditions.visibilityOf(nombre))
                .sendKeys(primerNombre);

        apellido.sendKeys(apellidos);
        correo.sendKeys(email);
    }

    // Paso 3: Direccion de facturacion
    public void completarDireccion(
            String nombrePais, String nombreProvincia,
            String nombreCiudad, String domicilio,
            String postal, String numeroTelefono) {

        new Select(pais).selectByVisibleText(nombrePais);

        espera.until(ExpectedConditions.elementToBeClickable(provincia));

        new Select(provincia).selectByVisibleText(nombreProvincia);

        ciudad.sendKeys(nombreCiudad);
        direccion.sendKeys(domicilio);
        codigoPostal.sendKeys(postal);
        telefono.sendKeys(numeroTelefono);
    }

    public void continuarFacturacion() {
        espera.until(ExpectedConditions.elementToBeClickable(continuarFacturacion))
                .click();
    }

    // Paso 4: Direccion de envio
    public void continuarDireccionEnvio() {
        espera.until(ExpectedConditions.elementToBeClickable(continuarEnvio))
                .click();
    }

    // Paso 5: Metodo de envio
    public void seleccionarEnvioTerrestre() {
        espera.until(ExpectedConditions.elementToBeClickable(envioTerrestre))
                .click();

        continuarMetodoEnvio.click();
    }

    // Paso 6: Metodo de pago
    public void seleccionarPagoContraEntrega() {
        espera.until(ExpectedConditions.elementToBeClickable(pagoContraEntrega))
                .click();

        continuarMetodoPago.click();
    }

    // Paso 7: Informacion de pago
    public void continuarPago() {
        espera.until(ExpectedConditions.elementToBeClickable(continuarInformacionPago))
                .click();
    }

    // Paso 8: Confirmar compra
    public void confirmarCompra() {
        espera.until(ExpectedConditions.elementToBeClickable(botonConfirmar))
                .click();
    }

    // Obtener el mensaje final
    public String obtenerMensajeConfirmacion() {
        return espera.until(
                ExpectedConditions.visibilityOf(mensajeConfirmacion))
                .getText().trim();
    }
}


