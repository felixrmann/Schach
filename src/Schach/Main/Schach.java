package Schach.Main;

import Schach.controller.PrintPosAufFeld;
import Schach.controller.SaveLoad;
import Schach.model.*;
import Schach.view.GameFrame;
import Schach.view.LoadFrame;

/**
 * The type Schach.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
public class Schach {

    //TODO den Save irgendwie laden

    /**
     * The Alle figuren.
     */
    public static figur[] alleFiguren;
    /**
     * The constant justPlay.
     */
    public static boolean justPlay = false;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        Buttons buttons = new Buttons(gameFrame);
        gameFrame.setButtons(buttons);

        if (justPlay){
            SchwarzKoenig schwarzKoenig = new SchwarzKoenig(8, 5);
            SchwarzDame schwarzDame = new SchwarzDame(8, 4);
            SchwarzTurm schwarzTurm1 = new SchwarzTurm(8, 1);
            SchwarzTurm schwarzTurm2 = new SchwarzTurm(8, 8);
            SchwarzLaeufer schwarzLaeufer1 = new SchwarzLaeufer(8, 3);
            SchwarzLaeufer schwarzLaeufer2 = new SchwarzLaeufer(8, 6);
            SchwarzPferd schwarzPferd1 = new SchwarzPferd(8, 2);
            SchwarzPferd schwarzPferd2 = new SchwarzPferd(8, 7);
            SchwarzBauer schwarzBauer1 = new SchwarzBauer(7, 1);
            SchwarzBauer schwarzBauer2 = new SchwarzBauer(7, 2);
            SchwarzBauer schwarzBauer3 = new SchwarzBauer(7, 3);
            SchwarzBauer schwarzBauer4 = new SchwarzBauer(7, 4);
            SchwarzBauer schwarzBauer5 = new SchwarzBauer(7, 5);
            SchwarzBauer schwarzBauer6 = new SchwarzBauer(7, 6);
            SchwarzBauer schwarzBauer7 = new SchwarzBauer(7, 7);
            SchwarzBauer schwarzBauer8 = new SchwarzBauer(7, 8);

            WeissKoenig weissKoenig = new WeissKoenig(1, 5);
            WeissDame weissDame = new WeissDame(1, 4);
            WeissTurm weissTurm1 = new WeissTurm(1, 1);
            WeissTurm weissTurm2 = new WeissTurm(1, 8);
            WeissLaeufer weissLaeufer1 = new WeissLaeufer(1, 3);
            WeissLaeufer weissLaeufer2 = new WeissLaeufer(1, 6);
            WeissPferd weissPferd1 = new WeissPferd(1, 2);
            WeissPferd weissPferd2 = new WeissPferd(1, 7);
            WeissBauer weissBauer1 = new WeissBauer(2, 1);
            WeissBauer weissBauer2 = new WeissBauer(2, 2);
            WeissBauer weissBauer3 = new WeissBauer(2, 3);
            WeissBauer weissBauer4 = new WeissBauer(2, 4);
            WeissBauer weissBauer5 = new WeissBauer(2, 5);
            WeissBauer weissBauer6 = new WeissBauer(2, 6);
            WeissBauer weissBauer7 = new WeissBauer(2, 7);
            WeissBauer weissBauer8 = new WeissBauer(2, 8);
            
            PrintPosAufFeld.setSchwarzKoenig(schwarzKoenig);
            PrintPosAufFeld.setSchwarzDame(schwarzDame);
            PrintPosAufFeld.setSchwarzTurm(schwarzTurm1, 1);
            PrintPosAufFeld.setSchwarzTurm(schwarzTurm2, 2);
            PrintPosAufFeld.setSchwarzLaeufer(schwarzLaeufer1, 1);
            PrintPosAufFeld.setSchwarzLaeufer(schwarzLaeufer2, 2);
            PrintPosAufFeld.setSchwarzPferd(schwarzPferd1, 1);
            PrintPosAufFeld.setSchwarzPferd(schwarzPferd2, 2);

            PrintPosAufFeld.setSchwarzBauer(schwarzBauer1, 1);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer2, 2);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer3, 3);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer4, 4);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer5, 5);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer6, 6);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer7, 7);
            PrintPosAufFeld.setSchwarzBauer(schwarzBauer8, 8);

            PrintPosAufFeld.setWeissKoenig(weissKoenig);
            PrintPosAufFeld.setWeissDame(weissDame);
            PrintPosAufFeld.setWeissTurm(weissTurm1, 1);
            PrintPosAufFeld.setWeissTurm(weissTurm2, 2);
            PrintPosAufFeld.setWeissLaeufer(weissLaeufer1, 1);
            PrintPosAufFeld.setWeissLaeufer(weissLaeufer2, 2);
            PrintPosAufFeld.setWeissPferd(weissPferd1, 1);
            PrintPosAufFeld.setWeissPferd(weissPferd2, 2);

            PrintPosAufFeld.setWeissBauer(weissBauer1,1);
            PrintPosAufFeld.setWeissBauer(weissBauer2,2);
            PrintPosAufFeld.setWeissBauer(weissBauer3,3);
            PrintPosAufFeld.setWeissBauer(weissBauer4,4);
            PrintPosAufFeld.setWeissBauer(weissBauer5,5);
            PrintPosAufFeld.setWeissBauer(weissBauer6,6);
            PrintPosAufFeld.setWeissBauer(weissBauer7,7);
            PrintPosAufFeld.setWeissBauer(weissBauer8,8);

            Tempfigure tempfigure = new Tempfigure();

            CheckMove checkMove = new CheckMove(schwarzKoenig,schwarzTurm1,schwarzTurm2,weissKoenig,weissTurm1,weissTurm2);
            returnPlayer returnPlayer = new returnPlayer(
                    weissBauer1,weissBauer2,weissBauer3,weissBauer4,weissBauer5,weissBauer6,weissBauer7,weissBauer8,
                    weissKoenig,weissDame,weissLaeufer1,weissLaeufer2,weissTurm1,weissTurm2,weissPferd1,weissPferd2,
                    schwarzBauer1,schwarzBauer2,schwarzBauer3,schwarzBauer4,schwarzBauer5,schwarzBauer6,schwarzBauer7,schwarzBauer8,
                    schwarzKoenig,schwarzDame,schwarzLaeufer1,schwarzLaeufer2,schwarzTurm1,schwarzTurm2,schwarzPferd1,schwarzPferd2);

            alleFiguren = new figur[]{
                    weissKoenig,weissDame,weissTurm1,weissTurm2,weissPferd1,weissPferd2,weissLaeufer1,weissLaeufer2,
                    weissBauer1,weissBauer2,weissBauer3,weissBauer4,weissBauer5,weissBauer6,weissBauer7,weissBauer8,
                    schwarzKoenig,schwarzDame,schwarzLaeufer1,schwarzLaeufer2,schwarzTurm1,schwarzTurm2,schwarzPferd1,schwarzPferd2,
                    schwarzBauer1,schwarzBauer2,schwarzBauer3,schwarzBauer4,schwarzBauer5,schwarzBauer6,schwarzBauer7,schwarzBauer8,tempfigure
            };
        } else {
            SaveModel saveModel = new SaveModel();
            String[][] feld = SaveLoad.LoadGame(saveModel.getGameSaves(LoadFrame.getNumber()));

            for (int yPos = 0; yPos < 8; yPos++) {
                for (int xPos = 0; xPos < 8; xPos++) {

                    assert feld != null;
                    String content = feld[yPos][xPos];
                    if (content == null || content.equals(" ")){
                        break;
                    } else {
                        if (content.charAt(0) == 'w'){
                            switch (content.charAt(1)){
                                case 'K': 
                                    WeissKoenig weissKoenig = new WeissKoenig(yPos + 1,xPos + 1);
                                    PrintPosAufFeld.setWeissKoenig(weissKoenig);
                                    break;
                                case 'D': 
                                    WeissDame weissDame = new WeissDame(yPos + 1,xPos + 1);
                                    PrintPosAufFeld.setWeissDame(weissDame);
                                    break;
                                case 'T':
                                    if (content.charAt(2) == '1'){
                                        WeissTurm weissTurm1 = new WeissTurm(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissTurm(weissTurm1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        WeissTurm weissTurm2 = new WeissTurm(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissTurm(weissTurm2, 2);
                                        break;
                                    }
                                case 'P':
                                    if (content.charAt(2) == '1'){
                                        WeissPferd weissPferd1 = new WeissPferd(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissPferd(weissPferd1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        WeissPferd weissPferd2 = new WeissPferd(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissPferd(weissPferd2, 2);
                                        break;
                                    } 
                                case 'L':
                                    if (content.charAt(2) == '1'){
                                        WeissLaeufer weissLaeufer1 = new WeissLaeufer(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissLaeufer(weissLaeufer1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        WeissLaeufer weissLaeufer2 = new WeissLaeufer(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setWeissLaeufer(weissLaeufer2, 2);
                                        break;
                                    }
                                case 'B':
                                    switch (content.charAt(2)){
                                        case '1':
                                            WeissBauer weissBauer1 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer1, 1);
                                            break;
                                        case '2':
                                            WeissBauer weissBauer2 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer2, 2);
                                            break;
                                        case '3':
                                            WeissBauer weissBauer3 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer3, 3);
                                            break;
                                        case '4':
                                            WeissBauer weissBauer4 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer4, 4);
                                            break;
                                        case '5':
                                            WeissBauer weissBauer5 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer5, 5);
                                            break;
                                        case '6':
                                            WeissBauer weissBauer6 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer6, 6);
                                            break;
                                        case '7':
                                            WeissBauer weissBauer7 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer7, 7);
                                            break;
                                        case '8':
                                            WeissBauer weissBauer8 = new WeissBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setWeissBauer(weissBauer8, 8);
                                            break;
                                    }
                            }
                        } else 
                            if (content.charAt(0) == 's'){
                            switch (content.charAt(1)){
                                case 'K':
                                    SchwarzKoenig schwarzKoenig = new SchwarzKoenig(yPos + 1,xPos + 1);
                                    PrintPosAufFeld.setSchwarzKoenig(schwarzKoenig);
                                    break;
                                case 'D':
                                    SchwarzDame schwarzDame = new SchwarzDame(yPos + 1,xPos + 1);
                                    PrintPosAufFeld.setSchwarzDame(schwarzDame);
                                    break;
                                case 'T':
                                    if (content.charAt(2) == '1'){
                                        SchwarzTurm schwarzTurm1 = new SchwarzTurm(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzTurm(schwarzTurm1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        SchwarzTurm schwarzTurm2 = new SchwarzTurm(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzTurm(schwarzTurm2, 2);
                                        break;
                                    }
                                case 'P':
                                    if (content.charAt(2) == '1'){
                                        SchwarzPferd schwarzPferd1 = new SchwarzPferd(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzPferd(schwarzPferd1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        SchwarzPferd schwarzPferd2 = new SchwarzPferd(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzPferd(schwarzPferd2, 2);
                                        break;
                                    }
                                case 'L':
                                    if (content.charAt(2) == '1'){
                                        SchwarzLaeufer schwarzLaeufer1 = new SchwarzLaeufer(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzLaeufer(schwarzLaeufer1, 1);
                                        break;
                                    } else if (content.charAt(2) == '2'){
                                        SchwarzLaeufer schwarzLaeufer2 = new SchwarzLaeufer(yPos + 1, xPos + 1);
                                        PrintPosAufFeld.setSchwarzLaeufer(schwarzLaeufer2, 2);
                                        break;
                                    }
                                case 'B':
                                    switch (content.charAt(2)){
                                        case '1':
                                            SchwarzBauer schwarzBauer1 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer1, 1);
                                            break;
                                        case '2':
                                            SchwarzBauer schwarzBauer2 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer2, 2);
                                            break;
                                        case '3':
                                            SchwarzBauer schwarzBauer3 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer3, 3);
                                            break;
                                        case '4':
                                            SchwarzBauer schwarzBauer4 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer4, 4);
                                            break;
                                        case '5':
                                            SchwarzBauer schwarzBauer5 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer5, 5);
                                            break;
                                        case '6':
                                            SchwarzBauer schwarzBauer6 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer6, 6);
                                            break;
                                        case '7':
                                            SchwarzBauer schwarzBauer7 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer7, 7);
                                            break;
                                        case '8':
                                            SchwarzBauer schwarzBauer8 = new SchwarzBauer(yPos + 1, xPos + 1);
                                            PrintPosAufFeld.setSchwarzBauer(schwarzBauer8, 8);
                                            break;
                                    }
                            }
                        }
                    }
                }
            }
            
        }
    }
}