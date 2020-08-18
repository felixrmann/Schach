package Schach.view;

import Schach.Main.Schach;
import Schach.controller.LoadController;
import Schach.model.SaveModel;

import javax.swing.*;
import java.awt.*;

/**
 * The type Load frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class LoadFrame extends JFrame {

    private JPanel mainPanel, titlePanel, botPanel;
    private JLabel title;
    private JList<String> list;
    private DefaultListModel<String> dlm;
    private JButton cancelButton, loadButton;
    private JScrollPane scrollPane;
    private static int number;

    /**
     * Instantiates a new Load frame.
     */
    public LoadFrame(){

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        botPanel = new JPanel();
        title = new JLabel("Load");
        dlm = new DefaultListModel<String>();
        getSaves();
        list = new JList<>(dlm);
        cancelButton = new JButton("Cancel");
        loadButton = new JButton("Load");
        scrollPane = new JScrollPane();

        init();

        setSize(480,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Load");
    }

    private void init(){
        getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        scrollPane.setViewportView(list);

        titlePanel.setLayout(new GridBagLayout());
        titlePanel.add(title);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        botPanel.setLayout(new GridLayout(1,2));
        botPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        botPanel.add(cancelButton);
        botPanel.add(loadButton);

        list.setFont(new Font("monospaced bold", Font.PLAIN, 20));

        cancelButton.addActionListener(e -> {
            setVisible(false);
            LoadController.CancelButtonPressed();
        });
        loadButton.addActionListener(e -> {
            if (checkIfSelected()){
                setVisible(false);
                number = list.getSelectedIndex();
                Schach.justPlay = false;
                LoadController.LoadButtonPressed();
            }
        });
    }

    private void getSaves(){
        SaveModel sm = new SaveModel();
        sm.getAllSaves();
        for (int i = 0; i < sm.getAnzSaves(); i++) {
            dlm.add(i, sm.getGameSaves(i));
        }
    }

    private boolean checkIfSelected(){
        return !list.isSelectionEmpty();
    }

    /**
     * Get number int.
     *
     * @return the int
     */
    public static int getNumber(){
        return number;
    }
}
