package Schach.controller;

import Schach.model.*;
import Schach.view.GameFrame;

/**
 * The type Print pos auf feld.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
public class PrintPosAufFeld {

    // Code um die Spieler richtig zu setzen

    /**
     * Sets schwarz bauer.
     *
     * @param schwarzBauer the schwarz bauer
     * @param welcher      the welcher
     */
    public static void setSchwarzBauer(SchwarzBauer schwarzBauer, int welcher) {
        GameFrame.feld[(schwarzBauer.getYPos(welcher)) - 1][(schwarzBauer.getXPos(welcher)) - 1] = schwarzBauer.getBezeichnung();
    }

    /**
     * Sets schwarz pferd.
     *
     * @param schwarzPferd the schwarz pferd
     * @param welcher      the welcher
     */
    public static void setSchwarzPferd(SchwarzPferd schwarzPferd, int welcher) {
        GameFrame.feld[(schwarzPferd.getYPos(welcher)) - 1][(schwarzPferd.getXPos(welcher)) - 1] = schwarzPferd.getBezeichnung();
    }

    /**
     * Sets schwarz laeufer.
     *
     * @param schwarzLaeufer the schwarz laeufer
     * @param welcher        the welcher
     */
    public static void setSchwarzLaeufer(SchwarzLaeufer schwarzLaeufer, int welcher) {
        GameFrame.feld[(schwarzLaeufer.getYPos(welcher)) - 1][(schwarzLaeufer.getXPos(welcher)) - 1] = schwarzLaeufer.getBezeichnung();
    }

    /**
     * Sets schwarz turm.
     *
     * @param schwarzTurm the schwarz turm
     * @param welcher     the welcher
     */
    public static void setSchwarzTurm(SchwarzTurm schwarzTurm, int welcher) {
        GameFrame.feld[(schwarzTurm.getYPos(welcher)) - 1][(schwarzTurm.getXPos(welcher)) - 1] = schwarzTurm.getBezeichnung();
    }

    /**
     * Sets schwarz dame.
     *
     * @param schwarzDame the schwarz dame
     */
    public static void setSchwarzDame(SchwarzDame schwarzDame) {
        GameFrame.feld[(schwarzDame.getYPos()) - 1][(schwarzDame.getXPos()) - 1] = schwarzDame.getBezeichnung();
    }

    /**
     * Sets schwarz koenig.
     *
     * @param schwarzKoenig the schwarz koenig
     */
    public static void setSchwarzKoenig(SchwarzKoenig schwarzKoenig) {
        GameFrame.feld[(schwarzKoenig.getYPos()) - 1][(schwarzKoenig.getXPos()) - 1] = schwarzKoenig.getBezeichnung();
    }

    /**
     * Sets weiss bauer.
     *
     * @param weissBauer the weiss bauer
     * @param welcher    the welcher
     */
    public static void setWeissBauer(WeissBauer weissBauer, int welcher) {
        GameFrame.feld[(weissBauer.getYPos(welcher)) - 1][(weissBauer.getXPos(welcher)) - 1] = weissBauer.getBezeichnung();
    }

    /**
     * Sets weiss pferd.
     *
     * @param weissPferd the weiss pferd
     * @param welcher    the welcher
     */
    public static void setWeissPferd(WeissPferd weissPferd, int welcher) {
        GameFrame.feld[(weissPferd.getYPos(welcher)) - 1][(weissPferd.getXPos(welcher)) - 1] = weissPferd.getBezeichnung();
    }

    /**
     * Sets weiss laeufer.
     *
     * @param weissLaeufer the weiss laeufer
     * @param welcher      the welcher
     */
    public static void setWeissLaeufer(WeissLaeufer weissLaeufer, int welcher) {
        GameFrame.feld[(weissLaeufer.getYPos(welcher)) - 1][(weissLaeufer.getXPos(welcher)) - 1] = weissLaeufer.getBezeichnung();
    }

    /**
     * Sets weiss turm.
     *
     * @param weissTurm the weiss turm
     * @param welcher   the welcher
     */
    public static void setWeissTurm(WeissTurm weissTurm, int welcher) {
        GameFrame.feld[(weissTurm.getYPos(welcher)) - 1][(weissTurm.getXPos(welcher)) - 1] = weissTurm.getBezeichnung();
    }

    /**
     * Sets weiss dame.
     *
     * @param weissDame the weiss dame
     */
    public static void setWeissDame(WeissDame weissDame) {
        GameFrame.feld[(weissDame.getYPos()) - 1][(weissDame.getXPos()) - 1] = weissDame.getBezeichnung();
    }

    /**
     * Sets weiss koenig.
     *
     * @param weissKoenig the weiss koenig
     */
    public static void setWeissKoenig(WeissKoenig weissKoenig) {
        GameFrame.feld[(weissKoenig.getYPos()) - 1][(weissKoenig.getXPos()) - 1] = weissKoenig.getBezeichnung();
    }
}