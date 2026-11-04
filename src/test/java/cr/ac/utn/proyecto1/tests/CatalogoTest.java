
package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.CatalogPage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogoTest extends BaseTest {

    @Test
    @DisplayName("CP-013 Ordenar productos por precio de mayor a menor")
    void ordenarProductosPorPrecio() {
        CatalogPage catalogo = new CatalogPage(driver);
        catalogo.abrirBooks();
        catalogo.ordenarPrecioMayorAMenor();

        List<Double> precios = catalogo.obtenerPrecios();

        assertTrue(precios.size() > 1, "No hay suficientes productos");

        for (int i = 0; i < precios.size() - 1; i++) {
            assertTrue(precios.get(i) >= precios.get(i + 1),
                    "Los precios no estan ordenados correctamente");
        }
    }
}
