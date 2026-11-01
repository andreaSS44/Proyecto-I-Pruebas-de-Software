
package cr.ac.utn.proyecto1.tests;

import cr.ac.utn.proyecto1.base.BaseTest;
import cr.ac.utn.proyecto1.pages.CompararProducto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompararProductoTest extends BaseTest {

    @Test
    @DisplayName("CP-012 Agregar producto a comparacion")
    void agregarProductoAComparacion() {
        CompararProducto comparar = new CompararProducto(driver);

        comparar.abrirProducto();
        comparar.agregarAComparacion();

        assertTrue(comparar.productoAgregado(),
                "El producto no aparece en la lista de comparacion");
    }
}
