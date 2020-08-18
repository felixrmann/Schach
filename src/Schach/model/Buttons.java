package Schach.model;

import Schach.controller.Schlagen;
import Schach.view.ExitFrame;
import Schach.view.GameFrame;
import Schach.view.SaveFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Schach.view.GameFrame.*;

/**
 * The type Buttons.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -November-18
 */
public class Buttons {

    private GameFrame gameFrame;

    /**
     * Instantiates a new Buttons.
     *
     * @param gameFrame the game frame
     */
    public Buttons(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    /*
        Hier werden alle Knöpfe mit werten versehen und es wird eingestellt, dass der Code erst
        beim Drücken des Knopfes ausgeführt wird

        Die gesammte Logik funktioniert folgendermassen:

        Es gibt 2 Modi
            1. modusauswahl "V"
            2. modusauswahl "n"

        v ist von Modus, also erste Zahl, die eingegeben wird
        n ist nach Modus, also die Zweite Zahl, die eingefügt wird

        Dann gibt es den "y" und den "x" mods. Was diese Modi machen ist
        sicherzustellen, dass zuerst die y und erst danach die x Position eingegeben wird
    */

    /**
     * Oben button.
     *
     * @param buttonname the buttonname
     * @param zahl       the zahl
     */
    public void obenButton(char buttonname, int zahl){
        if          (GameFrame.modusAuswahl.equals("v") && GameFrame.modusXY.equals("x")){
            fromWhereX = zahl;
            GameFrame.welcherZugText.setCharAt(0,buttonname);
            GameFrame.printWelcherZug();
        } else if   (GameFrame.modusAuswahl.equals("n") && GameFrame.modusXY.equals("x")) {
            GameFrame.toWhereX = zahl;
            GameFrame.welcherZugText.setCharAt(5,buttonname);
            GameFrame.printWelcherZug();
        }
    }

    /**
     * Unten button.
     *
     * @param buttonname the buttonname
     * @param zahl       the zahl
     */
    public void untenButton(char buttonname, int zahl){
        if          (GameFrame.modusAuswahl.equals("v") && GameFrame.modusXY.equals("y")){
            fromWhereY = zahl;
            GameFrame.modusAuswahl = "n";
            GameFrame.modusXY = "x";
            GameFrame.welcherZugText.setCharAt(1, buttonname);
            GameFrame.printWelcherZug();
        } else if   (GameFrame.modusAuswahl.equals("n") && GameFrame.modusXY.equals("y")){
            toWhereY = zahl;
            GameFrame.modusAuswahl = "v";
            GameFrame.welcherZugText.setCharAt(6, buttonname);
            GameFrame.printWelcherZug();
        }
    }

    /**
     * Reset button.
     */
    public void resetButton(){
        fromWhereY = 0;
        fromWhereX = 0;
        toWhereY = 0;
        GameFrame.toWhereX = 0;
        GameFrame.modusAuswahl = "v";
        GameFrame.modusXY = "x";
        GameFrame.welcherZugText = new StringBuilder("__ - __");
        GameFrame.printWelcherZug();
    }

    /**
     * Bewegen button.
     *
     * @param werSpeicher   the wer speicher
     * @param wohinSpeicher the wohin speicher
     */
    public void bewegenButton(String werSpeicher, String wohinSpeicher){
        if (!werSpeicher.equals(" ")){

            if (werSpeicher.charAt(0) == GameFrame.playingColor){

                if (wohinSpeicher.charAt(0) != GameFrame.playingColor && !wohinSpeicher.equals(" ")){

                    // Schlagen Mehtode

                    if (CheckMove.checkPlayerMove(
                            werSpeicher,
                            fromWhereY,
                            fromWhereX,
                            toWhereY,
                            GameFrame.toWhereX)
                    ) {
                        GameFrame.feld[fromWhereY - 1][fromWhereX - 1] = " ";
                        GameFrame.feld[toWhereY - 1][GameFrame.toWhereX - 1] = werSpeicher;
                        GameFrame.changePlayingColor();
                        GameFrame.printWelcherSpieler();
                        setPos(werSpeicher);
                        GameFrame.saveMove(fromWhereY,fromWhereX,toWhereY,toWhereX,werSpeicher,wohinSpeicher);
                        Schlagen.killFigure(wohinSpeicher);
                    }
                    System.out.println("besetzt");

                } else if (wohinSpeicher.equals(" ")){
                    if (CheckMove.checkPlayerMove(
                            werSpeicher,
                            fromWhereY,
                            fromWhereX,
                            toWhereY,
                            GameFrame.toWhereX)
                    ) {
                        GameFrame.feld[fromWhereY - 1][fromWhereX - 1] = " ";
                        GameFrame.feld[toWhereY - 1][GameFrame.toWhereX - 1] = werSpeicher;
                        GameFrame.changePlayingColor();
                        GameFrame.printWelcherSpieler();
                        setPos(werSpeicher);
                        GameFrame.saveMove(fromWhereY,fromWhereX,toWhereY,toWhereX,werSpeicher,wohinSpeicher);
                    }
                    System.out.println("Leer");

                }

            } else {
                GameFrame.welcherSpieler.setBackground(Color.RED);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        GameFrame.welcherSpieler.setBackground(Color.WHITE);
                    }
                }, 3000);
            }

        } else System.err.println("Sie haben nichts ausgewählt.");

        GameFrame.modusXY = "x";
        GameFrame.welcherZugText = new StringBuilder("__ - __");
        GameFrame.printWelcherZug();
    }

    /**
     * Set pos.
     *
     * @param werSpeicher the wer speicher
     */
    public void setPos(String werSpeicher){
        switch (werSpeicher.charAt(0)){
            case 'w':
                switch (werSpeicher.charAt(1)){
                    case 'K':
                        returnPlayer.getWeissKoenig().setYPos(toWhereY - 1);
                        returnPlayer.getWeissKoenig().setXPos(GameFrame.toWhereX - 1);
                        break;
                    case 'D':
                        returnPlayer.getWeissDame().setYPos(toWhereY - 1);
                        returnPlayer.getWeissDame().setXPos(GameFrame.toWhereX - 1);
                        break;
                    case 'T':
                        returnPlayer.getWeissTurm(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getWeissTurm(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'P':
                        returnPlayer.getWeissPferd(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getWeissPferd(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'L':
                        returnPlayer.getWeissLeaufer(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getWeissLeaufer(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'B':
                        returnPlayer.getWeissBauer(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getWeissBauer(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                }
                break;
            case 's':
                switch (werSpeicher.charAt(1)){
                    case 'K':
                        returnPlayer.getSchwarzKoenig().setYPos(toWhereY - 1);
                        returnPlayer.getSchwarzKoenig().setXPos(GameFrame.toWhereX - 1);
                        break;
                    case 'D':
                        returnPlayer.getSchwarzDame().setYPos(toWhereY - 1);
                        returnPlayer.getSchwarzDame().setXPos(GameFrame.toWhereX - 1);
                        break;
                    case 'T':
                        returnPlayer.getSchwarzTurm(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getSchwarzTurm(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'P':
                        returnPlayer.getSchwarzPferd(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getSchwarzPferd(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'L':
                        returnPlayer.getSchwarzLeaufer(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getSchwarzLeaufer(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                    case 'B':
                        returnPlayer.getSchwarzBauer(werSpeicher.charAt(2)).setYPos(toWhereY - 1, werSpeicher.charAt(2));
                        returnPlayer.getSchwarzBauer(werSpeicher.charAt(2)).setXPos(GameFrame.toWhereX - 1, werSpeicher.charAt(2));
                        break;
                }
        }
    }

    /**
     * Undo button.
     */
    public void undoButton(){
        int lastFromWhereY = Character.getNumericValue(lastMove.charAt(0));
        int lastFromWhereX = Character.getNumericValue(lastMove.charAt(1));
        int lastToWhereY = Character.getNumericValue(lastMove.charAt(3));
        int lastToWhereX = Character.getNumericValue(lastMove.charAt(4));

        String lastWerSpeicher = lastMove.substring(6,9);
        String lastWohinSpeicher = lastMove.substring(10,13);

        if (lastWohinSpeicher.equals("___")) lastWohinSpeicher = " ";
        if (lastWerSpeicher.contains("_")) {
            lastWerSpeicher = lastWerSpeicher.replace("_", "");
        }

        feld[lastFromWhereY - 1][lastFromWhereX - 1] = lastWerSpeicher;
        feld[lastToWhereY - 1][lastToWhereX - 1] = lastWohinSpeicher;

        changePlayingColor();
    }


    /**
     * Save button.
     *
     * @param parent the parent
     */
    public void saveButton(JFrame parent){
        new SaveFrame(parent, gameFrame, false);
    }

    /**
     * Leave button.
     *
     * @param parent the parent
     */
    public void leaveButton(JFrame parent){
        new ExitFrame(parent, gameFrame);
    }
}
