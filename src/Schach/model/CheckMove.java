package Schach.model;

import Schach.view.GameFrame;

/**
 * The type Check move.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
//TODO Schachmatt
//TODO rosschade fuktioniert noch nicht richtig

public class CheckMove {

    private static SchwarzKoenig schwarzKoenig;
    private static SchwarzTurm schwarzTurm1, schwarzTurm2;

    private static WeissKoenig weissKoenig;
    private static WeissTurm weissTurm1, weissTurm2;

    /**
     * Instantiates a new Check move.
     *
     * @param schwarzKoenig the schwarz koenig
     * @param schwarzTurm1  the schwarz turm 1
     * @param schwarzTurm2  the schwarz turm 2
     * @param weissKoenig   the weiss koenig
     * @param weissTurm1    the weiss turm 1
     * @param weissTurm2    the weiss turm 2
     */
    public CheckMove(SchwarzKoenig schwarzKoenig, SchwarzTurm schwarzTurm1, SchwarzTurm schwarzTurm2, WeissKoenig weissKoenig, WeissTurm weissTurm1, WeissTurm weissTurm2){
        CheckMove.schwarzKoenig = schwarzKoenig;
        CheckMove.schwarzTurm1 = schwarzTurm1;
        CheckMove.schwarzTurm2 = schwarzTurm2;
        CheckMove.weissKoenig = weissKoenig;
        CheckMove.weissTurm1 = weissTurm1;
        CheckMove.weissTurm2 = weissTurm2;
    }

    /**
     * Check player move boolean.
     *
     * @param wasImFeldSteht the was im feld steht
     * @param fromWhereY     the from where y
     * @param fromWhereX     the from where x
     * @param toWhereY       the to where y
     * @param toWhereX       the to where x
     * @return the boolean
     */
    static boolean checkPlayerMove(String wasImFeldSteht, int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        char zweitePos = wasImFeldSteht.charAt(1);

        // Es wird überprüft, welche Figur gespielt wird
        switch (zweitePos) {
            case 'K':
                if (checkKoenig(fromWhereY, fromWhereX, toWhereY, toWhereX)){
                    return checkKoenig(fromWhereY, fromWhereX, toWhereY, toWhereX);
                } else return checkRosschade(fromWhereY,fromWhereX,toWhereY,toWhereX,wasImFeldSteht);
            case 'D':
                return checkDame(fromWhereY, fromWhereX, toWhereY, toWhereX);
            case 'T':
                return checkTurm(fromWhereY, fromWhereX, toWhereY, toWhereX);
            case 'L':
                return checkLaeufer(fromWhereY, fromWhereX, toWhereY, toWhereX);
            case 'P':
                return checkPferd(fromWhereY, fromWhereX, toWhereY, toWhereX);
            case 'B':
                return checkBauer(wasImFeldSteht, fromWhereY, fromWhereX, toWhereY, toWhereX);
        }
        return false;
    }


    /*
    =====================
    Logik für KöingLaufen
    =====================
     */
    private static boolean checkKoenig(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        if (fromWhereX + 1 == toWhereX && fromWhereY == toWhereY) { // Wenn er nach rechts läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX - 1 == toWhereX && fromWhereY == toWhereY) { // Wenn er nach links läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY + 1 == toWhereY && fromWhereX == toWhereX) { // Wenn er nach unten läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY - 1 == toWhereY && fromWhereX == toWhereX) { // Wenn er nahc oben läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX + 1 == toWhereX && fromWhereY - 1 == toWhereY) { // Wenn er nach rechts oben läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX - 1 == toWhereX && fromWhereY - 1 == toWhereY) { // Wenn er nach links oben läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX + 1 == toWhereX && fromWhereY + 1 == toWhereY) { // Wenn er nch rechts unten läuft
            saveZug(toWhereY, toWhereX);
            return true;
        } else
            saveZug(toWhereY, toWhereX);
        return fromWhereX - 1 == toWhereX && fromWhereY + 1 == toWhereY; // Wenn er nach links unten läuft
    }

    /*
    ====================
    Logik für DameLaufen
    ====================
     */
    private static boolean checkDame(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        if (fromWhereX == toWhereX && checkIfPlayerInWayYStraight(fromWhereY, toWhereY, fromWhereX, toWhereX)) { // Wenn die Figur sich nach oben oder nach unten bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY == toWhereY && checkIfPlayerInWayXStraight(fromWhereX, toWhereX, fromWhereY, toWhereY)) { // Wenn sich die Figur nch links oder nach rechts bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (toWhereX > fromWhereX && toWhereY > fromWhereY) { // wenn der Läufer nach unten rechts läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayRightDown(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX < fromWhereX && toWhereY > fromWhereY) { // wenn der läufer nach unten links läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayLeftDown(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX > fromWhereX && toWhereY < fromWhereY) { // wenn der Läufer nach oben rechts läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayRightUp(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX < fromWhereX && toWhereY < fromWhereY) { // wenn der Läufer nach oben links läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayLeftUp(fromWhereY, fromWhereX, toWhereY, toWhereX);
        }
        return false;
    }

    /*
    ====================
    Logik für TurmLaufen
    ====================
     */
    private static boolean checkTurm(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        if (fromWhereX == toWhereX && checkIfPlayerInWayYStraight(fromWhereY, toWhereY, fromWhereX, toWhereX)) { // Wenn die Figur sich nach oben oder nach unten bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else
            saveZug(toWhereY, toWhereX);
        return fromWhereY == toWhereY && checkIfPlayerInWayXStraight(fromWhereX, toWhereX, fromWhereY, toWhereY); // Wenn sich die Figur nch links oder nsch rechts bewegt
    }

    /*
    ======================
    Logik für LäuferLaufen
    ======================
     */
    private static boolean checkLaeufer(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        if (toWhereX > fromWhereX && toWhereY > fromWhereY) { // wenn der Läufer nach unten rechts läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayRightDown(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX < fromWhereX && toWhereY > fromWhereY) { // wenn der läufer nach unten links läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayLeftDown(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX > fromWhereX && toWhereY < fromWhereY) { // wenn der Läufer nach oben rechts läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayRightUp(fromWhereY, fromWhereX, toWhereY, toWhereX);
        } else if (toWhereX < fromWhereX && toWhereY < fromWhereY) { // wenn der Läufer nach oben links läuft
            saveZug(toWhereY, toWhereX);
            return checkIfPlayerInWayLeftUp(fromWhereY, fromWhereX, toWhereY, toWhereX);
        }
        return false;
    }


    /*
    =====================
    Logik für PferdLaufen
    =====================
     */
    private static boolean checkPferd(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        if (fromWhereX + 2 == toWhereX && fromWhereY + 1 == toWhereY) { // Wenn das Pferd sich nach rechts unten bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX + 2 == toWhereX && fromWhereY - 1 == toWhereY) { // Wenn das Pferd sich nach rechts oben bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX - 2 == toWhereX && fromWhereY + 1 == toWhereY) { // Wenn das Pferd sich nach links unten bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX - 2 == toWhereX && fromWhereY - 1 == toWhereY) { // Wenn das Pferd sich nach links oben bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY - 2 == toWhereY && fromWhereX - 1 == toWhereX) { // Wenn das Pferd sich nach oben links bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY - 2 == toWhereY && fromWhereX + 1 == toWhereX) { // Wenn das Pferd sich nach oben rechts bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY + 2 == toWhereY && fromWhereX - 1 == toWhereX) { // Wenn das Pferd sich nach unten links bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY + 2 == toWhereY && fromWhereX + 1 == toWhereX) { // Wenn das Pferd sich nach unten rechts bewegt
            saveZug(toWhereY, toWhereX);
            return true;
        }
        return false;
    }

    /*
    =====================
    Logik für BauerLaufen
    =====================
     */
    private static boolean checkBauer(String wasImFeldSteht, int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        char erstePos = wasImFeldSteht.charAt(0);

        if (erstePos == 'w') {
            if (fromWhereY + 1 == toWhereY && fromWhereX - 1 == toWhereX) {
                saveZug(toWhereY, toWhereX);
                return true;
            } else if (fromWhereY + 1 == toWhereY && fromWhereX + 1 == toWhereX) {
                saveZug(toWhereY, toWhereX);
                return true;
            } else if (fromWhereY == 2 && toWhereY == 4 && fromWhereX == toWhereX) {   // Wenn er auf der Startreie ist kann er 2 Felder Laufen
                return true;
            } else
                return fromWhereY + 1 == toWhereY && fromWhereX == toWhereX;            // Wenn er normal läuft
        } else if (erstePos == 's') {
            if (fromWhereY - 1 == toWhereY && fromWhereX - 1 == toWhereX) {
                saveZug(toWhereY, toWhereX);
                return true;
            } else if (fromWhereY - 1 == toWhereY && fromWhereX + 1 == toWhereX) {
                saveZug(toWhereY, toWhereX);
                return true;
            } else if (fromWhereY == 7 && toWhereY == 5 && fromWhereX == toWhereX) {   // Wenn er auf der Startreie ist kann er 2 Felder Laufen
                return true;
            } else
                return fromWhereY - 1 == toWhereY && fromWhereX == toWhereX;            // Wenn er normal läuft
        }
        return false;
    }


    private static boolean checkIfPlayerInWayYStraight(int fromWhereY, int toWhereY, int fromWhereX, int toWhereX) {
        if (fromWhereY > toWhereY) {
            for (int i = 1; i <= fromWhereY - toWhereY; i++) {
                try {
                    if (!GameFrame.feld[(fromWhereY - i) - 1][fromWhereX - 1].equals(" ")) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereY < toWhereY) {
            for (int i = 1; i <= toWhereY - fromWhereY; i++) {
                try {
                    if (!GameFrame.feld[(fromWhereY + i) - 1][fromWhereX - 1].equals(" ")) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            saveZug(toWhereY, toWhereX);
            return true;
        }
        return false;
    }

    private static boolean checkIfPlayerInWayXStraight(int fromWhereX, int toWhereX, int fromWhereY, int toWhereY) {
        if (fromWhereX > toWhereX) {
            for (int i = 1; i <= fromWhereX - toWhereX; i++) {
                try {
                    if (!GameFrame.feld[fromWhereY - 1][(fromWhereX - i) - 1].equals(" ")) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            saveZug(toWhereY, toWhereX);
            return true;
        } else if (fromWhereX < toWhereX) {
            for (int i = 1; i <= (toWhereX - fromWhereX) - 1; i++) {
                try {
                    if (!GameFrame.feld[fromWhereY - 1][(fromWhereX + i) - 1].equals(" ")) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            saveZug(toWhereY, toWhereX);
            return true;
        }
        return false;
    }

    private static boolean checkIfPlayerInWayLeftUp(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        int length = fromWhereY - toWhereY;
        for (int i = 1; i <= length; i++) {
            try {
                if (!GameFrame.feld[(fromWhereY - i) - 1][(fromWhereX - i) - 1].equals(" ")) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        saveZug(toWhereY, toWhereX);
        return fromWhereY - length == toWhereY && fromWhereX - length == toWhereX;
    }

    private static boolean checkIfPlayerInWayRightUp(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        int length = fromWhereY - toWhereY;
        for (int i = 1; i <= length; i++) {
            try {
                if (!GameFrame.feld[(fromWhereY + i) - 1][(fromWhereX - i) - 1].equals(" ")) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        saveZug(toWhereY, toWhereX);
        return fromWhereY - length == toWhereY && fromWhereX + length == toWhereX;
    }

    private static boolean checkIfPlayerInWayLeftDown(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        int length = fromWhereY - toWhereY;
        for (int i = 1; i <= length; i++) {
            try {
                if (!GameFrame.feld[(fromWhereY - i) - 1][(fromWhereX + i) - 1].equals(" ")) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        saveZug(toWhereY, toWhereX);
        return fromWhereY - length == toWhereY && fromWhereX + length == toWhereX;
    }

    private static boolean checkIfPlayerInWayRightDown(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX) {
        int length = toWhereY - fromWhereY;
        for (int i = 1; i <= length - 1; i++) {
            try {
                if (!GameFrame.feld[(fromWhereY + i) - 1][(fromWhereX + i) - 1].equals(" ")) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        saveZug(toWhereY, toWhereX);
        return fromWhereY + length == toWhereY && fromWhereX + length == toWhereX;
    }

    //TODO rosschschade

    private static boolean checkRosschade(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX, String wer){
        if (wer.charAt(0) == 'w') return weissRosschade(fromWhereY,fromWhereX,toWhereY,toWhereX, wer);
        else if (wer.charAt(0) == 's')return schwarzRosschade(fromWhereY,fromWhereX,toWhereY,toWhereX, wer);
        return false;
    }

    private static boolean weissRosschade(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX, String wer){
        if (fromWhereY == 1 && fromWhereX == 5){
            if (toWhereY == 1 && toWhereX == 7 && weissKoenig.getMoved() && weissTurm2.getMoved()) {
                moveTurm(toWhereX, wer);
                return true;
            }
            if (toWhereY == 1 && toWhereX == 3 && weissKoenig.getMoved() && weissTurm1.getMoved()) {
                moveTurm(toWhereX, wer);
                return true;
            }
        }
        return false;
    }

    private static boolean schwarzRosschade(int fromWhereY, int fromWhereX, int toWhereY, int toWhereX, String wer){
        if (fromWhereY == 8 && fromWhereX == 5){
            if (toWhereY == 8 && toWhereX == 7 && schwarzKoenig.getMoved() && schwarzTurm2.getMoved()) {
                moveTurm(toWhereX, wer);
                return true;
            }
            if (toWhereY == 8 && toWhereX == 3 && schwarzKoenig.getMoved() && schwarzTurm1.getMoved()) {
                moveTurm(toWhereX, wer);
                return true;
            }
        }
        return false;
    }

    private static void moveTurm(int toWhereX, String wer){
        if          (toWhereX == 3) {
            if (wer.charAt(0) == 'w'){
                GameFrame.feld[returnPlayer.getWeissTurm(1).getYPos(1) - 1][returnPlayer.getWeissTurm(1).getXPos(1)] = " ";
                returnPlayer.getWeissTurm(1).setXPos(3, 1);
                GameFrame.feld[returnPlayer.getWeissTurm(1).getYPos(1) - 1][returnPlayer.getWeissTurm(1).getXPos(1)] = returnPlayer.getWeissTurm(1).getBezeichnung();
            }
            if (wer.charAt(0) == 's'){
                GameFrame.feld[returnPlayer.getSchwarzTurm(1).getYPos(1) - 1][returnPlayer.getSchwarzTurm(1).getXPos(1)] = " ";
                returnPlayer.getSchwarzTurm(1).setXPos(3,1);
                GameFrame.feld[returnPlayer.getSchwarzTurm(1).getYPos(1) - 1][returnPlayer.getSchwarzTurm(1).getXPos(1)] = returnPlayer.getSchwarzTurm(1).getBezeichnung();           }
        } else if   (toWhereX == 7){
            if (wer.charAt(0) == 'w'){
                GameFrame.feld[returnPlayer.getWeissTurm(2).getYPos(2) - 1][returnPlayer.getWeissTurm(2).getXPos(2)] = " ";
                returnPlayer.getWeissTurm(2).setXPos(5,2);
                GameFrame.feld[returnPlayer.getWeissTurm(2).getYPos(2) - 1][returnPlayer.getWeissTurm(2).getXPos(2)] = returnPlayer.getWeissTurm(2).getBezeichnung();
            }
            if (wer.charAt(0) == 's'){
                GameFrame.feld[returnPlayer.getSchwarzTurm(2).getYPos(2) - 1][returnPlayer.getSchwarzTurm(2).getXPos(2)] = " ";
                returnPlayer.getSchwarzTurm(2).setXPos(5,2);
                GameFrame.feld[returnPlayer.getSchwarzTurm(2).getYPos(2) - 1][returnPlayer.getSchwarzTurm(2).getXPos(2)] = returnPlayer.getSchwarzTurm(2).getBezeichnung();
            }
        }
    }

    private static void moveKoenig(int toWhereX, String wer){

    }

    private static void saveZug(int toWhereY, int toWhereX) {
        GameFrame.geschlageneFiguren.add(GameFrame.feld[toWhereY - 1][toWhereX - 1]);
        GameFrame.printGeschlageneFiguren();
    }
}
