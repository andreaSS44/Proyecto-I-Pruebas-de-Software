package cr.ac.utn.proyecto1.pages;

import cr.ac.utn.proyecto1.base.Visual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Resultado del registro (/registerresult/1), a la que se llega despues de registrarse. Page Factory. */
public class RegisterResultPage {

    private final WebDriver driver;

    @FindBy(css = ".page-body .result")
    private WebElement mensaje;

    @FindBy(css = "input.register-continue-button")
    private WebElement botonContinuar;

    public RegisterResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String mensaje() {
        return mensaje.getText().trim();
    }

    public HomePage continuar() {
        botonContinuar.click();
        Visual.pausa();
        return new HomePage(driver);
    }
}
