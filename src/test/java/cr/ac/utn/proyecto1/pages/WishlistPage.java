package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {
    private final WebDriver driver;
    private final WebDriverWait espera;

    @FindBy(css = ".wishlist-page")
    private WebElement pagina;

    @FindBy(css = ".wishlist-content .cart-item-row")
    private List<WebElement> productos;

    @FindBy(css = ".wishlist-content .cart-item-row .product a")
    private WebElement nombrePrimerProducto;

    @FindBy(css = ".wishlist-content .cart-item-row .qty-input")
    private WebElement cantidadPrimerProducto;

    @FindBy(css = ".wishlist-content .cart-item-row input[name='addtocart']")
    private WebElement seleccionarPrimerProducto;

    @FindBy(name = "addtocartbutton")
    private WebElement botonAgregarAlCarrito;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        espera.until(ExpectedConditions.visibilityOf(pagina));
    }

    public int numeroDeProductos() {
        return productos.size();
    }

    public String nombrePrimerProducto() {
        return nombrePrimerProducto.getText().trim();
    }

    public int cantidadPrimerProducto() {
        return Integer.parseInt(cantidadPrimerProducto.getDomProperty("value"));
    }

    public CartPage moverPrimerProductoAlCarrito() {
        if (!seleccionarPrimerProducto.isSelected()) {
            seleccionarPrimerProducto.click();
        }
        espera.until(ExpectedConditions.elementToBeClickable(botonAgregarAlCarrito)).click();
        return new CartPage(driver);
    }
}
