package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.CartPage;
import cr.ac.utn.proyecto1.pages.ProductPage;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductosCarritoTest extends BaseTest {
    @Test
    @DisplayName("CP-014 Cambiar cantidad y recalcular subtotal - RF-05")
    void cambiarCantidadYRecalcularSubtotal() {
        int cantidadNueva = 3;
        CartPage carritoInicial = new ProductPage(driver)
                .abrir("https://demowebshop.tricentis.com/141-inch-laptop")
                .agregarAlCarrito(1).abrirCarrito();
        BigDecimal precioUnitario = carritoInicial.precioUnitarioPrimerProducto();
        assertEquals(1, carritoInicial.cantidadPrimerProducto());
        assertEquals(0, precioUnitario.compareTo(carritoInicial.subtotalPrimerProducto()),
                "Con una unidad, el subtotal debe coincidir con el precio unitario");

        CartPage carritoActualizado = carritoInicial.actualizarCantidadPrimerProducto(cantidadNueva);
        BigDecimal subtotalEsperado = precioUnitario.multiply(BigDecimal.valueOf(cantidadNueva));

        assertAll(
                () -> assertEquals(1, carritoActualizado.numeroDeProductos()),
                () -> assertEquals("14.1-inch Laptop", carritoActualizado.nombrePrimerProducto()),
                () -> assertEquals(cantidadNueva, carritoActualizado.cantidadPrimerProducto()),
                () -> assertEquals(0, precioUnitario.compareTo(carritoActualizado.precioUnitarioPrimerProducto()),
                        "El precio unitario debe mantenerse"),
                () -> assertEquals(0, subtotalEsperado.compareTo(carritoActualizado.subtotalPrimerProducto()),
                        "El subtotal debe ser precio unitario multiplicado por cantidad"));
    }

    @Test
    @DisplayName("CP-013 Agregar un producto al carrito - RF-05")
    void agregarProductoAlCarrito() {
        String nombreEsperado = "14.1-inch Laptop";
        int cantidadEsperada = 1;
        ProductPage producto = new ProductPage(driver)
                .abrir("https://demowebshop.tricentis.com/141-inch-laptop");
        assertEquals(nombreEsperado, producto.nombreProducto());

        CartPage carrito = producto.agregarAlCarrito(cantidadEsperada).abrirCarrito();

        assertAll(
                () -> assertEquals(1, carrito.numeroDeProductos(), "Debe haber un solo producto"),
                () -> assertEquals(nombreEsperado, carrito.nombrePrimerProducto()),
                () -> assertEquals(cantidadEsperada, carrito.cantidadPrimerProducto()));
    }
}
