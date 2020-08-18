package Schach.view;

import Schach.controller.MenuController;

import javax.swing.*;
import java.awt.*;

/**
 * The type Menu frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class MenuFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel mainContentPanel;
    private JPanel topPanel;
    private JPanel botPanel;
    private JPanel botMidPanel;

    private JButton playButton, loadButton, exitButton;

    /**
     * Instantiates a new Menu frame.
     */
    public MenuFrame() {
        mainPanel = new JPanel();
        mainContentPanel = new JPanel();
        topPanel = new JPanel();
        botPanel = new JPanel();
        botMidPanel = new JPanel();
        playButton = new JButton("Play");
        loadButton = new JButton("Load");
        exitButton = new JButton("Exit");

        init();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menu");
    }

    private void init() {
        getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(mainContentPanel, BorderLayout.CENTER);

        mainContentPanel.setLayout(new GridLayout(2, 1));
        mainContentPanel.add(topPanel);
        mainContentPanel.add(botPanel);

        topPanel.setLayout(new BorderLayout());

        botPanel.setLayout(new GridLayout(1, 3));
        botPanel.add(new JPanel());
        botPanel.add(botMidPanel);
        botPanel.add(new JPanel());

        GridLayout grid = new GridLayout(3,1);
        grid.setVgap(50);
        botMidPanel.setLayout(grid);
        botMidPanel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
        botMidPanel.add(playButton);
        botMidPanel.add(loadButton);
        botMidPanel.add(exitButton);

        playButton.addActionListener(e -> {
            setVisible(false);
            MenuController.PlayButtonPressed();
        });
        loadButton.addActionListener(e -> {
            setVisible(false);
            MenuController.LoadButtonPressed();
        });
        exitButton.addActionListener(e -> MenuController.ExitButtonPressed());
    }
}
