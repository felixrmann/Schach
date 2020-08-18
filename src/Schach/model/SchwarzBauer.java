package Schach.model;

/**
 * The type Schwarz bauer.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
public class SchwarzBauer extends figur {
    private String bezeichnung = "sB";
    private static int[] xPos = new int[8];
    private static int[] yPos = new int[8];
    private static int cnt;

    /**
     * Instantiates a new Schwarz bauer.
     *
     * @param yPos the y pos
     * @param xPos the x pos
     */
    public SchwarzBauer(int yPos, int xPos) {
        if (cnt <= 8){
            SchwarzBauer.xPos[cnt] = xPos;
            SchwarzBauer.yPos[cnt] = yPos;
            bezeichnung += cnt + 1;
            cnt++;
        } else {
            System.err.println("Es sind zu viele Bauern.");
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
