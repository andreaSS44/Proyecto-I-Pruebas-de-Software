package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import java.math.BigDecimal;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver driver;

    @FindBy(name = "updatecart")
    private WebElement botonActualizar;

    @FindBy(css = ".cart .cart-item-row .product-unit-price")
    private WebElement precioUnitario;

    @FindBy(css = ".cart .cart-item-row .product-subtotal")
    private WebElement subtotal;

    @FindBy(css = ".shopping-cart-page")
    private WebElement pagina;

    @FindBy(css = ".cart .cart-item-row")
    private List<WebElement> productos;

    @FindBy(css = ".cart .cart-item-row .product-name")
    private WebElement nombrePrimerProducto;

    @FindBy(css = ".cart .cart-item-row .qty-input")
    private WebElement cantidadPrimerProducto;

    // Elementos para realizar la compra

    @FindBy(id = "termsofservice")
    private WebElement terminos;

    @FindBy(id = "checkout")
    private WebElement botonCheckout;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pagina));
    }

    public int numeroDeProductos() {
        return productos.size();
    }

    public String nombrePrimerProducto() {
        return nombrePrimerProducto.getText().trim();
    }

    public int cantidadPrimerProducto() {
        return Integer.parseInt(
                cantidadPrimerProducto.getDomProperty("value"));
    }

    public BigDecimal precioUnitarioPrimerProducto() {
        return new BigDecimal(
                precioUnitario.getText().trim().replace(",", ""));
    }

    public BigDecimal subtotalPrimerProducto() {
        return new BigDecimal(
                subtotal.getText().trim().replace(",", ""));
    }

    public CartPage actualizarCantidadPrimerProducto(int unidades) {
        cantidadPrimerProducto.clear();
        cantidadPrimerProducto.sendKeys(String.valueOf(unidades));

        WebElement campoAnterior = cantidadPrimerProducto;
        WebElement elementoAnterior =
                ((org.openqa.selenium.WrapsElement) campoAnterior)
                        .getWrappedElement();

        botonActualizar.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.stalenessOf(elementoAnterior));

        return new CartPage(driver);
    }

    // Aceptar los terminos y condiciones

    public CartPage aceptarTerminos() {
        if (!terminos.isSelected()) {
            terminos.click();
        }
        return this;
    }

    // Continuar con el proceso de compra

    public void continuarCompra() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(botonCheckout))
                .click();
    }
}

