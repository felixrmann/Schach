package Schach.controller;

import Schach.view.MenuFrame;
import Schach.Main.Schach;

/**
 * The type Load controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class LoadController {

    /**
     * Cancel button pressed.
     */
    public static void CancelButtonPressed(){
        new MenuFrame();
    }

    /**
     * Load button pressed.
     */
    public static void LoadButtonPressed(){
        Schach.main(null);
    }
}
