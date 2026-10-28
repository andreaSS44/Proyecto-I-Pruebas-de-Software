package cr.ac.utn.proyecto1.pages;

import cr.ac.utn.proyecto1.base.Visual;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Pagina de inicio y encabezado del sitio (enlaces Register, Log in, cuenta y Log out). Page Factory. */
public class HomePage {

    public static final String URL = "https://demowebshop.tricentis.com/";

    private final WebDriver driver;

    @FindBy(className = "ico-register")
    private WebElement enlaceRegistro;

    @FindBy(className = "ico-login")
    private WebElement enlaceLogin;

    // Los enlaces de visitante y de usuario no siempre estan en la pagina: por eso son listas.
    @FindBy(className = "ico-register")
    private List<WebElement> enlacesRegistro;

    @FindBy(className = "ico-login")
    private List<WebElement> enlacesLogin;

    @FindBy(className = "ico-logout")
    private List<WebElement> enlacesSalir;

    @FindBy(css = ".header-links a.account")
    private WebElement enlaceCuenta;

    @FindBy(className = "ico-logout")
    private WebElement enlaceSalir;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage abrir() {
        driver.get(URL);
        Visual.pausa();
        return this;
    }

    public RegisterPage irARegistro() {
        enlaceRegistro.click();
        Visual.pausa();
        return new RegisterPage(driver);
    }

    public LoginPage irALogin() {
        enlaceLogin.click();
        Visual.pausa();
        return new LoginPage(driver);
    }

    public HomePage cerrarSesion() {
        enlaceSalir.click();
        Visual.pausa();
        return new HomePage(driver);
    }

    /** Correo que muestra el encabezado cuando hay sesion iniciada. */
    public String cuentaEnEncabezado() {
        return enlaceCuenta.getText().trim();
    }

    public boolean haySesionIniciada() {
        return !enlacesSalir.isEmpty();
    }

    /** true si el encabezado muestra Register y Log in (estado de visitante). */
    public boolean muestraOpcionesDeVisitante() {
        return !enlacesRegistro.isEmpty() && !enlacesLogin.isEmpty();
    }
}
