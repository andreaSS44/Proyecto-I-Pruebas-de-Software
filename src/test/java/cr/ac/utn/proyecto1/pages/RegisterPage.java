package cr.ac.utn.proyecto1.pages;

import cr.ac.utn.proyecto1.base.Visual;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Pagina de registro (/register). Page Factory. */
public class RegisterPage {

    public static final String URL = "https://demowebshop.tricentis.com/register";

    private final WebDriver driver;

    @FindBy(id = "gender-male")
    private WebElement generoMasculino;

    @FindBy(id = "gender-female")
    private WebElement generoFemenino;

    @FindBy(id = "FirstName")
    private WebElement campoNombre;

    @FindBy(id = "LastName")
    private WebElement campoApellido;

    @FindBy(id = "Email")
    private WebElement campoCorreo;

    @FindBy(id = "Password")
    private WebElement campoClave;

    @FindBy(id = "ConfirmPassword")
    private WebElement campoConfirmacion;

    @FindBy(id = "register-button")
    private WebElement botonRegistrar;

    // Mensaje junto a cada campo: el sitio lo deja vacio cuando el campo es valido.
    @FindBy(css = "[data-valmsg-for='FirstName']")
    private WebElement errorNombre;

    @FindBy(css = "[data-valmsg-for='LastName']")
    private WebElement errorApellido;

    @FindBy(css = "[data-valmsg-for='Email']")
    private WebElement errorCorreo;

    @FindBy(css = "[data-valmsg-for='Password']")
    private WebElement errorClave;

    @FindBy(css = "[data-valmsg-for='ConfirmPassword']")
    private WebElement errorConfirmacion;

    @FindBy(css = ".field-validation-error")
    private List<WebElement> erroresDeCampos;

    // Errores que valida el servidor (por ejemplo, correo ya registrado). Solo existe si hay error.
    @FindBy(css = ".validation-summary-errors")
    private List<WebElement> resumenErrores;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage abrir() {
        driver.get(URL);
        Visual.pausa();
        return this;
    }

    /**
     * Registro que se espera exitoso: lleva a la pagina de resultado.
     * genero: "M" (masculino), "F" (femenino) o null para no elegir.
     */
    public RegisterResultPage registrar(String genero, String nombre, String apellido,
                                        String correo, String clave, String confirmacion) {
        llenarYEnviar(genero, nombre, apellido, correo, clave, confirmacion);
        return new RegisterResultPage(driver);
    }

    /** Registro que se espera que falle: se permanece en la pagina de registro. */
    public RegisterPage registrarFallido(String genero, String nombre, String apellido,
                                         String correo, String clave, String confirmacion) {
        llenarYEnviar(genero, nombre, apellido, correo, clave, confirmacion);
        return this;
    }

    /** Textos de todos los errores que se muestran junto a los campos. */
    public List<String> erroresDeCampos() {
        List<String> textos = new ArrayList<>();
        for (WebElement error : erroresDeCampos) {
            textos.add(error.getText().trim());
        }
        return textos;
    }

    public String errorNombre() {
        return errorNombre.getText().trim();
    }

    public String errorApellido() {
        return errorApellido.getText().trim();
    }

    public String errorCorreo() {
        return errorCorreo.getText().trim();
    }

    public String errorClave() {
        return errorClave.getText().trim();
    }

    public String errorConfirmacion() {
        return errorConfirmacion.getText().trim();
    }

    /** Error general del formulario (por ejemplo, correo ya registrado). Vacio si no hay. */
    public String errorGeneral() {
        if (resumenErrores.isEmpty()) {
            return "";
        }
        return resumenErrores.get(0).getText().trim();
    }

    private void llenarYEnviar(String genero, String nombre, String apellido,
                               String correo, String clave, String confirmacion) {
        if ("M".equals(genero)) {
            generoMasculino.click();
        } else if ("F".equals(genero)) {
            generoFemenino.click();
        }
        campoNombre.sendKeys(nombre);
        campoApellido.sendKeys(apellido);
        campoCorreo.sendKeys(correo);
        campoClave.sendKeys(clave);
        campoConfirmacion.sendKeys(confirmacion);
        Visual.pausa();
        botonRegistrar.click();
        Visual.pausa();
    }
}
