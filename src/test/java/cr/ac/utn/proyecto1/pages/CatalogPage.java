
package cr.ac.utn.proyecto1.pages;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPage {

    private WebDriver driver;

    @FindBy(id = "products-orderby")
    private WebElement ordenarPor;

    @FindBy(css = ".product-grid .actual-price")
    private List<WebElement> precios;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void abrirBooks() {
        driver.get("https://demowebshop.tricentis.com/books");
    }

    public void ordenarPrecioMayorAMenor() {
        Select opciones = new Select(ordenarPor);
        opciones.selectByVisibleText("Price: High to Low");
    }

    public List<Double> obtenerPrecios() {
        List<Double> listaPrecios = new ArrayList<>();

        for (WebElement precio : precios) {
            listaPrecios.add(Double.parseDouble(precio.getText().trim()));
        }

        return listaPrecios;
    }
}

