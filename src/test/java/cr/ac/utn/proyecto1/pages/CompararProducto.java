
package cr.ac.utn.proyecto1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CompararProducto {

    private WebDriver driver;

    @FindBy(className = "add-to-compare-list-button")
    private WebElement botonComparar;

    public CompararProducto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void abrirProducto() {
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
    }

    public void agregarAComparacion() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(botonComparar));
        botonComparar.click();
    }

    public boolean productoAgregado() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement producto = espera.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".compare-products-table .product-name a")
            )
        );

        String nombre = producto.getText();

        if (nombre.equals("Build your own cheap computer")) {
            return true;
        } else {
            return false;
        }
    }
}
