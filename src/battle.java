import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class battle implements ActionListener {

    // Declarar e inicializar variables y componentes
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[82];
    boolean player1_turn = true;
    String jugador1 = "Gaby";
    String jugador2 = "Hillary";
    boolean boatlistos = false;
    int clickcount = 0;

    private static final int SIZE = 9;
    private static final String[][] matrix = new String[SIZE + 1][SIZE + 1];
    private static boolean horizontal = true;

    // Constructor para configurar el tablero de juego y la Interfaz
    battle() {

        LoadTablero();
        setFuente(0, 1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // jlabel tendra el fondo
        ImageIcon icon = new ImageIcon(
                "C:\\Users\\gabri\\Downloads\\Programacion\\Semestral\\battleship\\src\\Image\\Mar3.jpg");

        // Mejorar calidad de la imagen escalando
        Image img = icon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel background = new JLabel(icon);
        frame.setContentPane(background);
        frame.setLayout(new BorderLayout());

        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("B A T T L E S H I P");
        textfield.setOpaque(false);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 50);

        button_panel.setLayout(new GridLayout(9, 9));

        // botones transaparente == false
        button_panel.setOpaque(false);

        title_panel.add(textfield);

        // Añadimos el titulo encima de fondo
        background.add(title_panel, BorderLayout.SOUTH);
        background.add(button_panel);

        // Mostrar el turno
        Utilidades.esperar(2);
        textfield.setText("Es turno de:" + jugador1);
    }

    // Método para manejar los clics de botones y la lógica del juego
    @Override
    public void actionPerformed(ActionEvent e) {

        // Configurar botes luego proceder con el juego segun turno --Prueba aun
        if (!boatlistos) {
            for (int i = 1; i <= 81; i++) {
                if (e.getSource() == buttons[i]) {
                    setbarcos(i);

                    clickcount++;
                    System.out.println(clickcount);

                }

                if (clickcount == 3) {
                    boatlistos = true;
                }

            }

        } else {
            for (int i = 1; i <= 81; i++) {
                if (e.getSource() == buttons[i]) {

                    if (player1_turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));

                            buttons[i].setText("1");
                            textfield.setText("Es turno de:" + jugador1);
                            System.out.println("Jugador: 1");
                            player1_turn = false;
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));

                            buttons[i].setText("2");
                            textfield.setText("Es turno de:" + jugador2);
                            System.out.println("Jugador 2");
                            player1_turn = true;

                        }
                    }
                }
            }
        }

    }

    // Método para establecer la fuente para los botones y el campo de texto
    public void setFuente(int i, int accion) {
        try {
            if (accion == 0) {
                buttons[i].setFont(new Font("Dungeon", Font.BOLD, 55));
                System.out.println("FBotones cargado: " + i);
            } else {
                textfield.setFont(new Font("Amatic SC", Font.BOLD, 55));
                System.out.println("Ftextfield cargado");
            }
        } catch (Exception e) {
            System.err.println("Error al establecer la fuente: " + e.getMessage());
            buttons[i].setFont(new Font("Arial", Font.BOLD, 75));
            System.out.println("Usando: Fuente Arial");
        }
    }

    // Método para crear y agregar los botones al tablero de juego
    public void LoadTablero() {
        for (int i = 1; i <= SIZE * SIZE; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(true);
            button_panel.add(buttons[i]);
            setFuente(i, 0);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setOpaque(false);
        }
    }

    // Método para actualizar la matriz del juego con la ubicación de los barcos
    public void actualizarMatriz(int row, int col) {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                matrix[i][j] = null;
            }
        }

        if (horizontal) {
            if (col + 3 <= SIZE) {
                for (int i = col; i <= col + 2; i++) {
                    matrix[row][i] = "x";
                }
            } else {
                for (int i = col; i >= col - 2; i--) {
                    matrix[row][i] = "x";
                }
            }
            horizontal = false;
        } else {
            if (row + 3 <= SIZE) {
                for (int i = row; i <= row + 2; i++) {
                    matrix[i][col] = "x";
                }
            } else {
                for (int i = row; i >= row - 2; i--) {
                    matrix[i][col] = "x";
                }
            }
            horizontal = true;
        }
    }

    // Método para actualizar los botones en el tablero de juego para mostrar dónde
    // están colocados los barcos
    public void actualizarBotones() {
        for (int row = 1; row <= SIZE; row++) {
            for (int col = 1; col <= SIZE; col++) {
                int index = (row - 1) * SIZE + col;
                // Ubicacion de botones
                About_barcos_Location(0, row, col, index, 1);
                // revisar matriz
                About_barcos_Location(0, row, col, 0, 3);
                if (matrix[row][col] != null) {
                    buttons[index].setText(matrix[row][col]);
                } else {
                    buttons[index].setText("");
                }
            }
            System.out.println();
        }
    }

    // Método para colocar los barcos en el tablero
    public void setbarcos(int i) {

        int row = (i - 1) / SIZE + 1;
        int col = (i - 1) % SIZE + 1;
        actualizarMatriz(row, col);
        actualizarBotones();
        About_barcos_Location(i, row, col, 0, 2);

    }

    // Método para imprimir información sobre la ubicación de los barcos con fines
    // de depuración
    public void About_barcos_Location(int i, int row, int col, int index, int test) {

        if (test == 1) {
            System.out.println("Obtener datos de ubicaci\u00F3n de los botones");
            System.out.println(" ");
            System.out.println("index: " + index);
            System.out.println("Sizes: " + SIZE);
            System.out.println("col " + col);
            System.out.println("row " + row);
            System.out.println(" ");
        } else if (test == 2) {

            System.out.println("Datos del Boton presionado");
            System.out.println(i + " i");
            System.out.println(i - 1 + " i -1");

            System.out.println("Sizes: " + SIZE);
            System.out.println(row + " row");
            System.out.println(col + " Col");
            System.out.println(" ");
        } else if (test == 3) {
            System.out.print(matrix[row][col] + " ");
            System.out.println(" ");
        } else {
            System.out.println("Solo hay 3 test");
        }
    }
}