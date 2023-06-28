import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class battleship implements ActionListener {

    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[81];
    boolean player1_turn = true;
    String jugador1 = "Gaby";
    String jugador2 = "Hillary";

    battleship() {

        // Estamos Utilizando fuente personalizada Contener error en otro equipo
        try {

            textfield.setFont(new Font("Amatic SC", Font.BOLD, 55));

        } catch (Exception e) {
            System.err.println("Error al establecer la fuente: " + e.getMessage());

            textfield.setFont(new Font("Arial", Font.BOLD, 75));
            System.out.println("Usando: Fuente Arial");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0, 250, 0));
        textfield.setForeground(new Color(0, 0, 255));

        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("B A T T L E S H I P");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 50);

        button_panel.setLayout(new GridLayout(9, 9));
        // button_panel.setBackground(new Color(250, 0, 0));

        for (int i = 0; i < 81; i++) {
            buttons[i] = new JButton();
            // buttons[i].setBackground(Color.GREEN);
            buttons[i].setContentAreaFilled(false);
            button_panel.add(buttons[i]);
            // buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));

            // Estamos Utilizando fuente personalizada Contener error en otro equipo
            try {

                buttons[i].setFont(new Font("Dungeon", Font.BOLD, 55));

            } catch (Exception e) {
                System.err.println("Error al establecer la fuente: " + e.getMessage());

                buttons[i].setFont(new Font("Arial", Font.BOLD, 75));
                System.out.println("Usando: Fuente Arial");
            }
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.SOUTH);
        frame.add(button_panel);

        // Mostrar el turno
        Utilidades.esperar(2);
        textfield.setText("Es turno de:" + jugador1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 81; i++) {
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