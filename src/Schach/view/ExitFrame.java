package Schach.view;

import Schach.controller.ExitController;

import javax.swing.*;
import java.awt.*;

/**
 * The type Exit frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class ExitFrame extends JDialog {

    private JPanel mainPanel, botPanel;
    private JTextArea text;
    private JButton cancelButton, saveButton, exitButton;

    /**
     * Instantiates a new Exit frame.
     *
     * @param parent    the parent
     * @param gameFrame the game frame
     */
    public ExitFrame(JFrame parent, GameFrame gameFrame){
        super(parent, "Exit", true);

        mainPanel = new JPanel();
        botPanel = new JPanel();
        text = new JTextArea();
        cancelButton = new JButton("Cancel");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");

        init(parent, gameFrame);

        setMinimumSize(new Dimension(300,200));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void init(JFrame parent, GameFrame gameFrame){
        getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(text, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        text.setText("Wollen Sie das Spiel verlassen\n ohne zu speichern?");
        text.setEditable(false);
        text.setCursor(null);
        text.setOpaque(false);
        text.setFocusable(false);


        botPanel.setLayout(new GridLayout(1,3));
        botPanel.add(cancelButton);
        botPanel.add(saveButton);
        botPanel.add(exitButton);

        cancelButton.addActionListener(e -> ExitController.CancelButton(this));
        saveButton.addActionListener(e -> ExitController.SaveButton(parent, this, gameFrame, true));
        exitButton.addActionListener(e -> ExitController.ExitButton(parent, this));
    }
}
