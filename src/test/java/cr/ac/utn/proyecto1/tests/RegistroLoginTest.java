package cr.ac.utn.proyecto1.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.base.DatosPrueba;
import cr.ac.utn.proyecto1.pages.HomePage;
import cr.ac.utn.proyecto1.pages.LoginPage;
import cr.ac.utn.proyecto1.pages.RegisterPage;
import cr.ac.utn.proyecto1.pages.RegisterResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistroLoginTest extends BaseTest {

    private static final String NOMBRE = "Prueba";
    private static final String APELLIDO = "Uno";
    private static final String CLAVE = "Test123";

    @Test
    @DisplayName("CP-001 Registro exitoso con datos validos")
    void cp001_registroExitoso() {
        String correo = DatosPrueba.correoUnico();
        RegisterPage registro = new HomePage(driver).abrir().irARegistro();

        RegisterResultPage resultado = registro.registrar("F", NOMBRE, APELLIDO, correo, CLAVE, CLAVE);

        assertEquals("Your registration completed", resultado.mensaje());
        HomePage inicio = resultado.continuar();
        assertTrue(inicio.haySesionIniciada(), "Deberia haber sesion iniciada despues del registro");
        assertEquals(correo, inicio.cuentaEnEncabezado());
    }

    @Test
    @DisplayName("CP-002 Registro con campos obligatorios vacios")
    void cp002_registroConCamposVacios() {
        RegisterPage registro = new RegisterPage(driver).abrir();

        registro.registrarFallido(null, "", "", "", "", "");

        assertAll(
                () -> assertEquals("First name is required.", registro.errorNombre()),
                () -> assertEquals("Last name is required.", registro.errorApellido()),
                () -> assertEquals("Email is required.", registro.errorCorreo()),
                () -> assertEquals("Password is required.", registro.errorClave()),
                () -> assertEquals("Password is required.", registro.errorConfirmacion()));
        assertFalse(new HomePage(driver).haySesionIniciada(), "No deberia crearse la cuenta");
    }

    @Test
    @DisplayName("CP-007 Inicio de sesion valido y cierre de sesion")
    void cp007_loginValidoYCierreDeSesion() {
        String correo = registrarUsuarioNuevoYCerrarSesion();
        LoginPage login = new HomePage(driver).irALogin();

        HomePage inicio = login.iniciarSesion(correo, CLAVE);

        assertTrue(inicio.haySesionIniciada(), "Deberia mostrarse Log out");
        assertEquals(correo, inicio.cuentaEnEncabezado());

        HomePage visitante = inicio.cerrarSesion();

        assertFalse(visitante.haySesionIniciada(), "No deberia haber sesion despues de Log out");
        assertTrue(visitante.muestraOpcionesDeVisitante(), "Deberian mostrarse Register y Log in");
    }

    @Test
    @DisplayName("CP-008 Inicio de sesion con clave incorrecta")
    void cp008_loginConClaveIncorrecta() {
        String correo = registrarUsuarioNuevoYCerrarSesion();
        LoginPage login = new LoginPage(driver).abrir();

        login.iniciarSesionFallido(correo, "Incorrecta1");

        assertTrue(login.mensajeError().contains("Login was unsuccessful"),
                "Mensaje real: " + login.mensajeError());
        assertFalse(new HomePage(driver).haySesionIniciada(), "No deberia iniciarse sesion");
    }

    // Cada prueba registra su propio usuario para no depender de otra prueba ni de una cuenta fija.
    private String registrarUsuarioNuevoYCerrarSesion() {
        String correo = DatosPrueba.correoUnico();
        new RegisterPage(driver).abrir()
                .registrar("F", NOMBRE, APELLIDO, correo, CLAVE, CLAVE)
                .continuar()
                .cerrarSesion();
        return correo;
    }
}
