package Schach.model;

/**
 * The type Schwarz laeufer.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-26
 */
public class SchwarzLaeufer extends figur {
    private String bezeichnung = "sL";
    private static int[] xPos = new int[2];
    private static int[] yPos = new int[2];
    private static int cnt;

    /**
     * Instantiates a new Schwarz laeufer.
     *
     * @param yPos the y pos
     * @param xPos the x pos
     */
    public SchwarzLaeufer(int yPos, int xPos) {
        if (cnt <= 2){
            bezeichnung += cnt + 1;
            SchwarzLaeufer.xPos[cnt] = xPos;
            SchwarzLaeufer.yPos[cnt] = yPos;
            cnt++;
        } else {
            System.err.println("Es sind zu viele Läufer.");
        }
    }

    /**
     * Gets x pos.
     *
     * @param index the index
     * @return the x pos
     */
    public int getXPos(int index) {
        return xPos[index - 1];
    }

    /**
     * Gets y pos.
     *
     * @param index the index
     * @return the y pos
     */
    public int getYPos(int index) {
        return yPos[index - 1];
    }

    /**
     * Set x pos.
     *
     * @param newValue the new value
     * @param index    the index
     */
    public void setXPos(int newValue, int index){
        xPos[index - 1] = newValue;
    }

    /**
     * Set y pos.
     *
     * @param newValue the new value
     * @param index    the index
     */
    public void setYPos(int newValue, int index){
        yPos[index - 1] = newValue;
    }

    /**
     * Get bezeichnung string.
     *
     * @return the string
     */
    public String getBezeichnung(){
        return bezeichnung;
    }

    /**
     * Print infos.
     */
    public void printInfos(){
        for (int i = 0; i < yPos.length; i++) {
            System.out.println("Bezeichnung : " + bezeichnung);
            System.out.println("Y Pos       : " + yPos[i]);
            System.out.println("X Pos       : " + xPos[i]);
        }
    }
}