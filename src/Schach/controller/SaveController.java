package Schach.controller;

import Schach.view.GameFrame;
import Schach.view.MenuFrame;

import javax.swing.*;
import java.util.Arrays;

/**
 * The type Save controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class SaveController {

    /**
     * Cancel button.
     *
     * @param frame the frame
     */
    public static void CancelButton(JDialog frame){
        frame.setVisible(false);
    }

    /**
     * Save button.
     *
     * @param name      the name
     * @param gameFrame the game frame
     * @param exit      the exit
     */
    public static void SaveButton(String name, GameFrame gameFrame, boolean exit){
        SaveLoad.SaveGame(name, Arrays.deepToString(gameFrame.getFeld()));

        if (exit){
            gameFrame.setVisible(false);
            new MenuFrame();
        }
    }
}
