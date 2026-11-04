package cr.ac.utn.proyecto1.base;

/** Pausa solo para observar el navegador, no es una espera. Se controla con -Dritmo=ms (0 = sin pausas). */
public final class Visual {
    private Visual() {}

    public static void pausa() {
        int ms = Integer.getInteger("ritmo", 700);
        if (ms <= 0) {
            return;
        }
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
