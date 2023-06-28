//Gabriel Ruiz, Jonathan Reyes, Keneth Benavidez.

public class Utilidades {
    // Método para limpiar la consola
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método para esperar una cantidad especificada de segundos
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 850);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para animar la salida de texto
    public static void animarTexto(String texto) {
        for (int ix = 0; ix < texto.length(); ix++) {
            System.out.print(texto.charAt(ix));
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("  ");
    }
}