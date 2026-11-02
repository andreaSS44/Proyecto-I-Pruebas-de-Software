package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.base.DatosPrueba;
import cr.ac.utn.proyecto1.pages.ProductPage;
import cr.ac.utn.proyecto1.pages.CartPage;
import cr.ac.utn.proyecto1.pages.CheckoutPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    @DisplayName("CP-025 - Compra completa como invitado")
    void compraCompletaComoInvitado() {

        // Abrir el producto
        ProductPage producto = new ProductPage(driver);

        producto.abrir(
                "https://demowebshop.tricentis.com/computing-and-internet");

        // Agregar una unidad al carrito
        producto.agregarAlCarrito(1);

        // Abrir carrito y aceptar terminos
        CartPage carrito = producto.abrirCarrito();

        carrito.aceptarTerminos();
        carrito.continuarCompra();

        // Iniciar compra como invitado
        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.continuarComoInvitado();

        // Completar datos personales
        checkout.escribirDatosPersonales(
                "Daniela",
                "Prueba",
                DatosPrueba.correoUnico()
        );

        // Completar direccion
        checkout.completarDireccion(
                "United States",
                "California",
                "Los Angeles",
                "123 Test Street",
                "90001",
                "5551234567"
        );

        checkout.continuarFacturacion();

        // Direccion de envio
        checkout.continuarDireccionEnvio();

        // Metodo de envio
        checkout.seleccionarEnvioTerrestre();

        // Metodo de pago
        checkout.seleccionarPagoContraEntrega();

        // Informacion de pago
        checkout.continuarPago();

        // Confirmar pedido
        checkout.confirmarCompra();

        // Verificar resultado
        assertEquals(
                "Your order has been successfully processed!",
                checkout.obtenerMensajeConfirmacion()
        );
    }
}
