
public class game {
    public static void main(String[] args) throws Exception {

        // set boat
        // setOriginal.set(args);
        // Start the game
        // new battleship();
        new battle();

        /*
         * Cuando se crea una instancia de la clase de --battle--, se llama al
         * constructor.
         * Esto configura el tablero de juego y crea la Interfaz.
         * 
         * El método --LoadTablero-- se llama desde el constructor para crear y agregar
         * los
         * botones al tablero de juego.
         * 
         * El método --setFuente-- se llama desde el constructor y el método
         * --LoadTablero-- para
         * establecer la fuente de los botones y el campo de texto.
         * 
         * Cuando se hace clic en un botón, se llama al método --actionPerformed--. Este
         * método maneja la lógica del juego y actualiza la pantalla en consecuencia.
         * 
         * Si los barcos aún no se han colocado, se llama al método de configuración de
         * --setbarcos-- desde el método de acción --actionPerformed-- para colocar un
         * barco en el
         * tablero.
         * 
         * El método --setbarcos-- llama al método --actualizarMatriz-- para actualizar
         * la matriz
         * del juego con la ubicación del barco.
         * 
         * El método --setbarcos-- también llama al método --actualizarBotones-- para actualizar
         * los
         * botones en el tablero de juego para mostrar dónde se colocan los barcos.
         * 
         * El método --About_boats_Location-- se llama desde varios lugares del código
         * con
         * fines de depuración. Imprime información sobre la ubicación de los barcos.
         */ }
}