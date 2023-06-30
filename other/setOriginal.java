import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class setOriginal {
    private static final int SIZE = 9;
    private static final String[][] matrix = new String[SIZE][SIZE];
    private static boolean horizontal = true;

    public static void set(String[] args) {

        JFrame frame = new JFrame("Tabla 9x9");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false); // Evita que la ventana cambie de tamaño

        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        JLabel[][] labels = new JLabel[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JLabel label = new JLabel(Integer.toString(i * SIZE + j + 1));
                labels[i][j] = label;

                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(40, 40));
                int finalI = i;
                int finalJ = j;
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        actualizarMatriz(finalI, finalJ);
                        actualizarEtiquetas(labels);
                    }
                });
                panel.add(label);
            }
        }
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void actualizarMatriz(int row, int col) {
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

    public static void actualizarEtiquetas(JLabel[][] labels) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] != null) {
                    labels[i][j].setText(matrix[i][j]);
                } else {
                    labels[i][j].setText(Integer.toString(i * SIZE + j + 1));
                }
            }
        }
    }

    public static void MirarHorizonte() {

    }
}