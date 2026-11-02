
package cr.ac.utn.proyecto1.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsletterPage {

    private final WebDriver driver;

    @FindBy(id = "newsletter-email")
    private WebElement campoCorreo;

    @FindBy(id = "newsletter-subscribe-button")
    private WebElement botonSuscribir;

    @FindBy(id = "newsletter-result-block")
    private WebElement mensajeResultado;

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewsletterPage abrir() {
        driver.get("https://demowebshop.tricentis.com/");
        return this;
    }

    public void suscribirse(String correo) {
        campoCorreo.sendKeys(correo);
        botonSuscribir.click();
    }

    public String obtenerMensaje() {
        WebDriverWait espera = new WebDriverWait(
                driver, Duration.ofSeconds(10));

        espera.until(ExpectedConditions.textToBePresentInElement(
                mensajeResultado, "Thank you for signing up!"));

        return mensajeResultado.getText().trim();
    }
}
