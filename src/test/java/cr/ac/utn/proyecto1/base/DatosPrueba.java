package cr.ac.utn.proyecto1.base;

/**
 * Datos de prueba generados en cada ejecucion.
 * El registro de Demo Web Shop rechaza correos repetidos, por eso cada correo usa la hora en milisegundos.
 */
public final class DatosPrueba {
    private DatosPrueba() {}

    /** Correo distinto en cada llamada, por ejemplo p1_1730150000000@test.com */
    public static String correoUnico() {
        return "p1_" + System.currentTimeMillis() + "@test.com";
    }
}
