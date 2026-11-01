package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    @FindBy(css = ".shopping-cart-page")
    private WebElement pagina;

    @FindBy(css = ".cart .cart-item-row")
    private List<WebElement> productos;

    @FindBy(css = ".cart .cart-item-row .product-name")
    private WebElement nombrePrimerProducto;

    @FindBy(css = ".cart .cart-item-row .qty-input")
    private WebElement cantidadPrimerProducto;

    public CartPage(WebDriver driver) {
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
        return Integer.parseInt(cantidadPrimerProducto.getAttribute("value"));
    }
}
