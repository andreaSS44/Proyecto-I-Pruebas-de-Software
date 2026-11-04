package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.CartPage;
import cr.ac.utn.proyecto1.pages.ProductPage;
import cr.ac.utn.proyecto1.pages.WishlistPage;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ProductosCarritoTest extends BaseTest {
    @Test
    @DisplayName("CP-016 Agregar producto a deseos y moverlo al carrito - RF-07")
    void agregarADeseosYMoverAlCarrito() {
        String nombreEsperado = "Black & White Diamond Heart";
        WishlistPage deseos = new ProductPage(driver)
                .abrir("https://demowebshop.tricentis.com/black-white-diamond-heart")
                .agregarAListaDeDeseos(1).abrirListaDeDeseos();

        assertAll(
                () -> assertEquals(1, deseos.numeroDeProductos()),
                () -> assertEquals(nombreEsperado, deseos.nombrePrimerProducto()),
                () -> assertEquals(1, deseos.cantidadPrimerProducto()));

        CartPage carrito = deseos.moverPrimerProductoAlCarrito();

        assertAll(
                () -> assertEquals(1, carrito.numeroDeProductos()),
                () -> assertEquals(nombreEsperado, carrito.nombrePrimerProducto()),
                () -> assertEquals(1, carrito.cantidadPrimerProducto()));
    }

    @Test
    @DisplayName("CP-015 Producto sin opcion obligatoria no se agrega al carrito - RF-06")
    void productoSinDiscoObligatorio() {
        ProductPage producto = new ProductPage(driver)
                .abrir("https://demowebshop.tricentis.com/build-your-own-computer");
        assertEquals("Build your own computer", producto.nombreProducto());
        assertFalse(producto.hayDiscoSeleccionado(), "La opcion obligatoria HDD debe estar sin seleccionar");

        producto.intentarAgregarAlCarrito(1);

        assertEquals("Please select HDD", producto.mensajeErrorCarrito());
        CartPage carrito = producto.abrirCarritoDesdeEncabezado();
        assertEquals(0, carrito.numeroDeProductos(), "El producto incompleto no debe agregarse al carrito");
    }

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
