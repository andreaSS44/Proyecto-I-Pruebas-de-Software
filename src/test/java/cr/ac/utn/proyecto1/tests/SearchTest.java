
package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.SearchResultsPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchTest extends BaseTest {

    @Test
    @DisplayName("CP-009 Busqueda de producto existente")
    void buscarProductoExistente() {
        driver.get("https://demowebshop.tricentis.com/");

        SearchResultsPage busqueda = new SearchResultsPage(driver);
        busqueda.buscarProducto("computer");

        assertTrue(busqueda.hayProductos(),
                "No se encontraron productos");
    }

    @Test
    @DisplayName("CP-010 Busqueda de producto inexistente")
    void buscarProductoInexistente() {
        driver.get("https://demowebshop.tricentis.com/");

        SearchResultsPage busqueda = new SearchResultsPage(driver);
        busqueda.buscarProducto("zzzz");

        assertEquals(
                "No products were found that matched your criteria.",
                busqueda.obtenerMensajeResultado()
        );
    }
}
