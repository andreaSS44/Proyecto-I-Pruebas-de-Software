package cr.ac.utn.proyecto1.base;

public final class DatosPrueba {
    private DatosPrueba() {}

    // El registro rechaza correos repetidos: se usa la hora en milisegundos para que cada uno sea distinto.
    public static String correoUnico() {
        return "p1_" + System.currentTimeMillis() + "@test.com";
    }
}
