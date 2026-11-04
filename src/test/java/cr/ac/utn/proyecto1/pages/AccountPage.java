
package cr.ac.utn.proyecto1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;

    @FindBy(id = "FirstName")
    private WebElement campoNombre;

    @FindBy(id = "LastName")
    private WebElement campoApellido;

    @FindBy(id = "Email")
    private WebElement campoCorreo;

    @FindBy(name = "save-info-button")
    private WebElement botonGuardar;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage abrir() {
        driver.get("https://demowebshop.tricentis.com/customer/info");
        return this;
    }

    public void cambiarNombre(String nuevoNombre) {
        campoNombre.clear();
        campoNombre.sendKeys(nuevoNombre);
        botonGuardar.click();
    }

    public String obtenerNombre() {
        return campoNombre.getDomProperty("value");
    }
}
