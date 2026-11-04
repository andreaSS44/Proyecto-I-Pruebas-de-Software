package cr.ac.utn.proyecto1.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    @FindBy(id = "small-searchterms")
    private WebElement campoBusqueda;

    @FindBy(css = ".search-box-button")
    private WebElement botonBuscar;

    @FindBy(css = ".search-results .result")
    private WebElement mensajeResultado;

    @FindBy(css = ".search-results .product-title a")
    private List<WebElement> nombresProductos;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void buscarProducto(String producto) {
        campoBusqueda.clear();
        campoBusqueda.sendKeys(producto);
        botonBuscar.click();
    }

    public String obtenerMensajeResultado() {
        return mensajeResultado.getText();
    }

    public boolean hayProductos() {
        return !nombresProductos.isEmpty();
    }
}
