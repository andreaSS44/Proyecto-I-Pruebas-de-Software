package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
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
}
