package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait espera;

    @FindBy(css = ".product-essential .product-name h1")
    private WebElement nombre;

    @FindBy(css = ".product-essential .add-to-cart .qty-input")
    private WebElement cantidad;

    @FindBy(css = ".product-essential .add-to-cart-button")
    private WebElement botonAgregar;

    @FindBy(css = "#bar-notification.success .content")
    private WebElement confirmacion;

    @FindBy(css = "#bar-notification.success .content a[href='/cart']")
    private WebElement enlaceCarrito;

    @FindBy(css = "#bar-notification.error .content")
    private WebElement errorCarrito;

    @FindBy(css = "#topcartlink a")
    private WebElement carritoEncabezado;

    @FindBy(css = "#bar-notification .close")
    private WebElement cerrarAviso;

    @FindBy(id = "bar-notification")
    private WebElement aviso;

    @FindBy(css = ".product-essential .attributes input[type='radio'][name='product_attribute_16_3_6']")
    private List<WebElement> opcionesDisco;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public ProductPage abrir(String url) {
        driver.get(url);
        espera.until(ExpectedConditions.visibilityOf(nombre));
        return this;
    }

    public String nombreProducto() {
        return nombre.getText().trim();
    }

    public ProductPage agregarAlCarrito(int unidades) {
        cantidad.clear();
        cantidad.sendKeys(String.valueOf(unidades));
        espera.until(ExpectedConditions.elementToBeClickable(botonAgregar)).click();
        espera.until(ExpectedConditions.visibilityOf(confirmacion));
        return this;
    }

    public CartPage abrirCarrito() {
        espera.until(ExpectedConditions.elementToBeClickable(enlaceCarrito)).click();
        return new CartPage(driver);
    }

    public boolean hayDiscoSeleccionado() {
        return opcionesDisco.stream().anyMatch(WebElement::isSelected);
    }

    public ProductPage intentarAgregarAlCarrito(int unidades) {
        cantidad.clear();
        cantidad.sendKeys(String.valueOf(unidades));
        espera.until(ExpectedConditions.elementToBeClickable(botonAgregar)).click();
        espera.until(ExpectedConditions.visibilityOf(errorCarrito));
        return this;
    }

    public String mensajeErrorCarrito() {
        return errorCarrito.getText().trim();
    }

    public CartPage abrirCarritoDesdeEncabezado() {
        if (aviso.isDisplayed()) {
            cerrarAviso.click();
            espera.until(ExpectedConditions.invisibilityOf(aviso));
        }
        espera.until(ExpectedConditions.elementToBeClickable(carritoEncabezado)).click();
        return new CartPage(driver);
    }
}
