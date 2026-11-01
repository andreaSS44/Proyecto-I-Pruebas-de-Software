package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.CartPage;
import cr.ac.utn.proyecto1.pages.ProductPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductosCarritoTest extends BaseTest {
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
