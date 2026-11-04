package cr.ac.utn.proyecto1.pages;

import cr.ac.utn.proyecto1.base.Visual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static final String URL = "https://demowebshop.tricentis.com/login";

    private final WebDriver driver;

    @FindBy(id = "Email")
    private WebElement campoCorreo;

    @FindBy(id = "Password")
    private WebElement campoClave;

    // El boton no tiene id: se usa su clase.
    @FindBy(css = "input.login-button")
    private WebElement botonLogin;

    @FindBy(css = ".validation-summary-errors")
    private WebElement mensajeError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage abrir() {
        driver.get(URL);
        Visual.pausa();
        return this;
    }

    public HomePage iniciarSesion(String correo, String clave) {
        escribirYEnviar(correo, clave);
        return new HomePage(driver);
    }

    public LoginPage iniciarSesionFallido(String correo, String clave) {
        escribirYEnviar(correo, clave);
        return this;
    }

    public String mensajeError() {
        return mensajeError.getText().trim();
    }

    private void escribirYEnviar(String correo, String clave) {
        campoCorreo.sendKeys(correo);
        campoClave.sendKeys(clave);
        Visual.pausa();
        botonLogin.click();
        Visual.pausa();
    }
}
