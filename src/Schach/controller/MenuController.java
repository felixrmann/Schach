package Schach.controller;

import Schach.view.LoadFrame;
import Schach.Main.Schach;

/**
 * The type Menu controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-02
 */
public class MenuController {

    /**
     * Play button pressed.
     */
    public static void PlayButtonPressed(){
        Schach.justPlay = true;
        Schach.main(null);
    }

    /**
     * Load button pressed.
     */
    public static void LoadButtonPressed(){
        new LoadFrame();
    }

    /**
     * Exit button pressed.
     */
    public static void ExitButtonPressed(){
        System.exit(0);
    }
}