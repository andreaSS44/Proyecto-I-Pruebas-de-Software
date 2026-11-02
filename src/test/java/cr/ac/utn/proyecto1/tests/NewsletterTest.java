package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.base.DatosPrueba;
import cr.ac.utn.proyecto1.pages.NewsletterPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsletterTest extends BaseTest {

    @Test
    @DisplayName("CP-028 - Suscripcion al boletin RF-11")
    void suscripcionExitosa() {

        // Crear un correo diferente para cada prueba
        String correo = DatosPrueba.correoUnico();

        // Abrir la tienda
        NewsletterPage newsletter = new NewsletterPage(driver).abrir();

        // Suscribirse al boletin
        newsletter.suscribirse(correo);

        // Obtener el mensaje de confirmacion
        String mensaje = newsletter.obtenerMensaje();

        // Comprobar que la suscripcion fue aceptada
        assertTrue(mensaje.contains("Thank you for signing up!"));
    }
}
