package Schach.view;

import Schach.controller.SaveController;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Save frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class SaveFrame extends JDialog {

    private JPanel panel, botPanel, textPanel;
    private JLabel text;
    private JTextField textField;
    private JButton cancelButton, saveButton;
    private boolean exit;

    /**
     * Instantiates a new Save frame.
     *
     * @param parent    the parent
     * @param gameFrame the game frame
     * @param exit      the exit
     */
    public SaveFrame(JFrame parent, GameFrame gameFrame, boolean exit){
        super(parent, "Save", true);
        this.exit = exit;

        panel = new JPanel();
        botPanel = new JPanel();
        textPanel = new JPanel();
        text = new JLabel("Save as");
        textField = new JTextField("", 27);
        cancelButton = new JButton("cancel");
        saveButton = new JButton("save");



        init(gameFrame);

        setMinimumSize(new Dimension(300,150));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void init(GameFrame gameFrame){
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(3,1));
        panel.add(text);
        panel.add(textPanel);
        panel.add(botPanel);

        textPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        textPanel.add(textField);

        botPanel.setLayout(new GridLayout(1,2));
        botPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        botPanel.add(cancelButton);
        botPanel.add(saveButton);

        cancelButton.addActionListener(e -> SaveController.CancelButton(this));
        saveButton.addActionListener(e -> {
            if (!textField.getText().isEmpty()){
                this.setVisible(false);
                SaveController.SaveButton(textField.getText(), gameFrame, exit);
            } else {
                textField.setBorder(BorderFactory.createLineBorder(Color.RED));
                java.util.Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        textField.setBorder(BorderFactory.createLineBorder(null));
                    }
                }, 3000);
            }
        });
    }
}
