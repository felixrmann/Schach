package Schach.view;

import Schach.model.Buttons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/**
 * The type Game frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class GameFrame extends JFrame {
    private JButton
            buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH,
            button1, button2, button3, button4, button5, button6, button7, button8,
            buttonReset, buttonBewegen, buttonUndo, buttonSave, buttonSaveLeave;
    /**
     * The constant fromWhereY.
     */
    public static int fromWhereY;
    /**
     * The constant fromWhereX.
     */
    public static int fromWhereX;
    /**
     * The constant toWhereY.
     */
    public static int toWhereY;
    /**
     * The constant toWhereX.
     */
    public static int toWhereX;
    /**
     * The constant modusAuswahl.
     */
    public static String modusAuswahl = "v";
    /**
     * The constant modusXY.
     */
    public static String modusXY = "x", /**
     * The Last move.
     */
    lastMove;

    /**
     * The Feld.
     */
//TODO feld in externe Klasse auslagern
    //TODO feld mit bildern anzeigen und wie ein echtes Spiel aussehen lassen
    public static String[][] feld = {
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "}
    };

    private String[] hoch = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private static JTable table;
    private static JTextArea welcherZug;
    /**
     * The constant welcherSpieler.
     */
    public static JTextArea welcherSpieler;
    /**
     * The constant welcherZugText.
     */
    public static StringBuilder welcherZugText;
    private static StringBuilder welcherSpielerText;
    private static JSplitPane splitPane;
    /**
     * The constant playingColor.
     */
    public static char playingColor;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JTable headerTable;
    private JPanel twoPanelContainer, bottomLeftPanel, bottomRightPanel;
    /**
     * The Geschlagene figuren.
     */
    public static Vector<String> geschlageneFiguren;

    private Buttons buttons;

    /**
     * Instantiates a new Game frame.
     */
    public GameFrame(){
        buttonA = new JButton("A");
        buttonB = new JButton("B");
        buttonC = new JButton("C");
        buttonD = new JButton("D");
        buttonE = new JButton("E");
        buttonF = new JButton("F");
        buttonG = new JButton("G");
        buttonH = new JButton("H");

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");

        buttonReset = new JButton("Reset");
        buttonBewegen = new JButton("Bewegen");
        buttonUndo = new JButton("Undo");
        buttonSave = new JButton("Save");
        buttonSaveLeave = new JButton("Leave");

        playingColor = 'w';

        table = new JTable(feld, hoch) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        splitPane = new JSplitPane() {
            final int location = 424;
            { setDividerLocation(location); }
            @Override
            public int getDividerLocation() { return location; }
            @Override
            public int getLastDividerLocation() { return location; }
        };
        welcherZug = new JTextArea();
        welcherSpieler = new JTextArea();
        welcherZugText = new StringBuilder("__ - __");
        welcherSpielerText = new StringBuilder();
        scrollPane = new JScrollPane(table);

        model = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;
            @Override
            public int getColumnCount() { return 1; }
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
            @Override
            public int getRowCount() { return table.getRowCount(); }
            @Override
            public Class<?> getColumnClass(int colNum) {
                if (colNum == 0) return String.class;
                return super.getColumnClass(colNum);
            }
        };
        headerTable = new JTable(model); // Die Titel an der Seite des Spielfeldes werden erzeugt
        twoPanelContainer = new JPanel(new GridLayout(1, 2)); // Container für Panels erstellt
        bottomLeftPanel = new JPanel(); // Planel links erstellt
        bottomRightPanel = new JPanel(); // Planel rechts erstellt
        geschlageneFiguren = new Vector<>();
        lastMove = new String();

        init();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Schachfeld");

        for (int i = 0; i < 8; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setWidth(50);
            table.setRowHeight(i, 50);
        }
    }

    private void init(){
        getContentPane().add(splitPane);

        // hochzählen für die Zahlen am Rand
        for (int i = 0; i < table.getRowCount(); i++) {
            headerTable.setValueAt(i + 1, i, 0);
        }

        // Die höhe muss nochmals eingestellt werden, da es sonst aus irgend einem Grund nicht funktioniert
        headerTable.setRowHeight(50);
        // die grösse für die Zahlen am rand werden eingestellt
        headerTable.setPreferredScrollableViewportSize(new Dimension(20, 50));
        // Logik für Zahlen am rand
        headerTable.getColumnModel().getColumn(0).setCellRenderer((x, value, isSelected, hasFocus, row, column) -> {
            boolean selected = table.getSelectionModel().isSelectedIndex(row);
            Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
            ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
            if (selected) {
                component.setFont(component.getFont().deriveFont(Font.BOLD));
                component.setForeground(Color.red);
            } else {
                component.setFont(component.getFont().deriveFont(Font.PLAIN));
            }
            return component;
        });


        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(scrollPane);
        splitPane.setBottomComponent(twoPanelContainer);

        twoPanelContainer.add(bottomLeftPanel);
        twoPanelContainer.add(bottomRightPanel);

        bottomLeftPanel.setLayout(new GridLayout(4, 4));
        bottomLeftPanel.setBackground(Color.lightGray);
        bottomRightPanel.setBackground(Color.lightGray);

        bottomLeftPanel.add(buttonA);
        bottomLeftPanel.add(buttonB);
        bottomLeftPanel.add(buttonC);
        bottomLeftPanel.add(buttonD);
        bottomLeftPanel.add(buttonE);
        bottomLeftPanel.add(buttonF);
        bottomLeftPanel.add(buttonG);
        bottomLeftPanel.add(buttonH);

        bottomLeftPanel.add(button1);
        bottomLeftPanel.add(button2);
        bottomLeftPanel.add(button3);
        bottomLeftPanel.add(button4);
        bottomLeftPanel.add(button5);
        bottomLeftPanel.add(button6);
        bottomLeftPanel.add(button7);
        bottomLeftPanel.add(button8);

        bottomRightPanel.add(buttonReset);
        bottomRightPanel.add(buttonBewegen);
        bottomRightPanel.add(buttonUndo);
        bottomRightPanel.add(welcherZug);
        bottomRightPanel.add(welcherSpieler);
        bottomRightPanel.add(buttonSave);
        bottomRightPanel.add(buttonSaveLeave);

        printWelcherSpieler();

        welcherZug.setBounds(50, 50, 150, 30);
        welcherZug.setText(String.valueOf(welcherZugText));
        welcherZug.setLineWrap(false);
        welcherZug.setEditable(false);
        welcherZug.setBackground(Color.WHITE);
        Font font1 = welcherZug.getFont();
        float size1 = font1.getSize() + 10.0f;
        welcherZug.setFont(font1.deriveFont(size1));

        welcherSpieler.setBounds(50, 100, 150, 30);
        welcherSpieler.setLineWrap(false);
        welcherSpieler.setEditable(false);
        welcherSpieler.setBackground(Color.WHITE);
        Font font2 = welcherSpieler.getFont();
        float size2 = font2.getSize() + 5.0f;
        welcherSpieler.setFont(font2.deriveFont(size2));

        table.setBackground(Color.WHITE);

        scrollPane.setRowHeaderView(headerTable);

        //Logik in der Button-Klasse erklärt
        buttonA.addActionListener(e -> {
            buttons.obenButton('A', 1);
            modusXY = "y";
        });
        buttonB.addActionListener(e -> {
            buttons.obenButton('B', 2);
            modusXY = "y";
        });
        buttonC.addActionListener(e -> {
            buttons.obenButton('C', 3);
            modusXY = "y";
        });
        buttonD.addActionListener(e -> {
            buttons.obenButton('D', 4);
            modusXY = "y";
        });
        buttonE.addActionListener(e -> {
            buttons.obenButton('E', 5);
            modusXY = "y";
        });
        buttonF.addActionListener(e -> {
            buttons.obenButton('F', 6);
            modusXY = "y";
        });
        buttonG.addActionListener(e -> {
            buttons.obenButton('G', 7);
            modusXY = "y";
        });
        buttonH.addActionListener(e -> {
            buttons.obenButton('H', 8);
            modusXY = "y";
        });

        button1.addActionListener(e -> buttons.untenButton('1', 1));
        button2.addActionListener(e -> buttons.untenButton('2', 2));
        button3.addActionListener(e -> buttons.untenButton('3', 3));
        button4.addActionListener(e -> buttons.untenButton('4', 4));
        button5.addActionListener(e -> buttons.untenButton('5', 5));
        button6.addActionListener(e -> buttons.untenButton('6', 6));
        button7.addActionListener(e -> buttons.untenButton('7', 7));
        button8.addActionListener(e -> buttons.untenButton('8', 8));

        buttonReset.addActionListener(e -> buttons.resetButton());
        buttonBewegen.addActionListener(e -> {
            if (!welcherZug.getText().equals("__ - __")){
                String werSpeicher = feld[fromWhereY - 1][fromWhereX - 1];
                String wohinSpeicher = feld[toWhereY - 1][toWhereX - 1];

                buttons.bewegenButton(werSpeicher, wohinSpeicher);
                table.repaint();
            } else {
                welcherZug.setBorder(BorderFactory.createLineBorder(Color.RED));
                java.util.Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        welcherZug.setBorder(BorderFactory.createLineBorder(null));
                    }
                }, 3000);
            }
        });

        buttonUndo.addActionListener(e -> buttons.undoButton());
        buttonSave.addActionListener(e -> buttons.saveButton(this));
        buttonSaveLeave.addActionListener(e -> buttons.leaveButton(this));
    }

    /**
     * Print welcher zug.
     */
    public static void printWelcherZug() {
        welcherZug.setText(String.valueOf(welcherZugText));
    }

    /**
     * Print welcher spieler.
     */
    public static void printWelcherSpieler() {
        if (playingColor == 'w') {
            welcherSpieler.setText("Spieler Weiss ist am Zug");
        } else if (playingColor == 's') {
            welcherSpieler.setText("Spieler Schwarz ist am Zug");
        } else {
            welcherSpieler.setText("ERROR");
        }
    }

    /**
     * Change playing color.
     */
    public static void changePlayingColor() {
        if (playingColor == 's') {
            playingColor = 'w';
        } else if (playingColor == 'w') {
            playingColor = 's';
        }
    }

    /**
     * Print geschlagene figuren.
     */
    public static void printGeschlageneFiguren() {
        for (String s : geschlageneFiguren) {
            System.out.println(s);
        }
    }

    /**
     * Sets playing color.
     *
     * @param playingColor the playing color
     */
    public void setPlayingColor(char playingColor) {
        GameFrame.playingColor = playingColor;
    }

    private static void repaintTable() {
        table.revalidate();
    }

    /**
     * Get feld string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
    public String[][] getFeld(){
        return feld;
    }

    /**
     * Set feld.
     *
     * @param feld the feld
     */
    public void setFeld(String[][] feld){
        GameFrame.feld = feld;
    }

    /**
     * Set buttons.
     *
     * @param buttons the buttons
     */
    public void setButtons(Buttons buttons){
        this.buttons = buttons;
    }

    /**
     * Save move.
     *
     * @param fromWhereY    the from where y
     * @param fromWhereX    the from where x
     * @param toWhereY      the to where y
     * @param toWhereX      the to where x
     * @param werSpeicher   the wer speicher
     * @param wohinSpeicher the wohin speicher
     */
    public static void saveMove(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX, String werSpeicher, String wohinSpeicher){

        if (werSpeicher.length() != 3) werSpeicher = werSpeicher + "_";
        if (wohinSpeicher.equals(" ")){
            wohinSpeicher =  "___";
        } else if (wohinSpeicher.length() == 2){
            wohinSpeicher = wohinSpeicher + "_";
        }

        //               1               2         3       4               5       6       7,8,9       10    11,12,13
        lastMove = fromWhereY + "" + fromWhereX + "-" + toWhereY + "" + toWhereX + "-" + werSpeicher + "-" + wohinSpeicher;
    }
}