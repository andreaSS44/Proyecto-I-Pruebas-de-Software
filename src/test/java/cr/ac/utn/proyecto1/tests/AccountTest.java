
package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.base.DatosPrueba;
import cr.ac.utn.proyecto1.pages.AccountPage;
import cr.ac.utn.proyecto1.pages.RegisterPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest extends BaseTest {

    @Test
    @DisplayName("CP-027 - Modificar nombre de usuario RF-10")
    void modificarNombreUsuario() {

        // Registrar una cuenta nueva
        String correo = DatosPrueba.correoUnico();

        new RegisterPage(driver).abrir()
                .registrar(
                        "F",
                        "daniela",
                        "Prueba",
                        correo,
                        "Test1234!",
                        "Test1234!"
                );

        // Abrir la informacion de la cuenta
        AccountPage cuenta = new AccountPage(driver).abrir();

        // Cambiar el nombre
        cuenta.cambiarNombre("daniela editada");

        // Volver a abrir para comprobar que se guardo
        cuenta.abrir();

        // Verificar el nombre actualizado
        assertEquals(
                "daniela editada",
                cuenta.obtenerNombre()
        );
    }
}
