package Schach.controller;

import Schach.view.GameFrame;
import Schach.view.MenuFrame;
import Schach.view.SaveFrame;

import javax.swing.*;

/**
 * The type Exit controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class ExitController {
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
     * @param parent    the parent
     * @param frame     the frame
     * @param gameFrame the game frame
     * @param exit      the exit
     */
    public static void SaveButton(JFrame parent, JDialog frame, GameFrame gameFrame, boolean exit){
        frame.setVisible(false);
        new SaveFrame(parent, gameFrame, exit);
    }

    /**
     * Exit button.
     *
     * @param parent the parent
     * @param frame  the frame
     */
    public static void ExitButton(JFrame parent, JDialog frame){
        frame.setVisible(false);
        parent.setVisible(false);
        new MenuFrame();
    }
}
