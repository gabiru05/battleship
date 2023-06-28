import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class battle implements ActionListener {

    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[82];
    boolean player1_turn = true;
    String jugador1 = "Gaby";
    String jugador2 = "Hillary";
    boolean boatlistos = false;
    int clickcount = 1;

    private static final int SIZE = 9;
    private static final String[][] matrix = new String[SIZE][SIZE];
    private static boolean horizontal = true;

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

        // textfield.setBackground(new Color(0, 250, 0));
        // textfield.setForeground(new Color(0, 0, 255));

        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("B A T T L E S H I P");
        textfield.setOpaque(false);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 50);

        button_panel.setLayout(new GridLayout(9, 9));

        // Set the opaque property of the button_panel to false
        button_panel.setOpaque(false);

        // button_panel.setBackground(new Color(250, 0, 0));

        title_panel.add(textfield);

        // Add the title_panel and button_panel to the background label
        background.add(title_panel, BorderLayout.SOUTH);
        background.add(button_panel);

        // Mostrar el turno
        Utilidades.esperar(2);
        textfield.setText("Es turno de:" + jugador1);
    }

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

    public void setFuente(int i, int accion) {
        // Estamos Utilizando fuente personalizada Contener error en otro equipo
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

    public void LoadTablero() {

        // Crear y agregar los botones
        for (int i = 1; i <= 81; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(true);
            button_panel.add(buttons[i]);

            setFuente(i, 0);

            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            // Set the opaque property to false
            buttons[i].setOpaque(false);

        }

    }

    public void actualizarMatriz(int row, int col) {
        // Eliminar las "x" anteriores
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = null;
            }
        }

        // si Horizonte verdadero
        if (horizontal) {
            // // Agregamos las --x-- hacia la derecha o izquierda
            if (col + 2 < SIZE) {
                for (int i = col; i <= col + 2; i++) {
                    matrix[row][i] = "x";
                }
            } else {
                for (int i = col; i >= col - 2; i--) {
                    matrix[row][i] = "x";
                }
            }
            horizontal = false;

            // Sino Miramos eje de las ordenadas
        } else {
            // Agregamos las --x-- hacia abajo o arriba
            if (row + 2 < SIZE) {
                for (int i = row; i <= row + 2; i++) {
                    matrix[i][col] = "x";
                }
            } else {
                for (int i = row; i >= row - 2; i--) {
                    matrix[i][col] = "x";
                }
            }
            // en caso ya este en vertical y el usuario lo quiera en Horizontal
            horizontal = true;
        }
    }

    public void actualizarBotones() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                int index = i * SIZE + j + 1;

                if (matrix[i][j] != null) {
                    buttons[index].setText(matrix[i][j]);
                } else {
                    buttons[index].setText("");
                }
            }
        }
    }

    public void setbarcos(int i) {

        int row = (i - 1) / SIZE;
        int col = (i - 1) % SIZE;
        actualizarMatriz(row, col);
        actualizarBotones();

    }
}