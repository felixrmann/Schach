package Schach.controller;

import Schach.model.returnPlayer;
import Schach.Main.Schach;

/**
 * The type Schlagen.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Januar-15
 */
public class Schlagen {
    /**
     * Kill figure.
     *
     * @param name the name
     */
    public static void killFigure(String name){
        Schach.alleFiguren[returnPlayer.getPos(name)] = null;
    }
}
