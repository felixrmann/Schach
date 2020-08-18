package Schach.model;

/**
 * The type Schwarz dame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
public class SchwarzDame extends figur {
    private String bezeichnung = "sD";
    private static int xPos;
    private static int yPos;

    /**
     * Instantiates a new Schwarz dame.
     *
     * @param yPos the y pos
     * @param xPos the x pos
     */
    public SchwarzDame(int yPos, int xPos) {
        SchwarzDame.xPos = xPos;
        SchwarzDame.yPos = yPos;
    }

    /**
     * Gets x pos.
     *
     * @return the x pos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Gets y pos.
     *
     * @return the y pos
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * Sets x pos.
     *
     * @param newValue the new value
     */
    public void setXPos(int newValue) {
        xPos = newValue;
    }

    /**
     * Sets y pos.
     *
     * @param newValue the new value
     */
    public void setYPos(int newValue) {
        yPos = newValue;
    }

    /**
     * Gets bezeichnung.
     *
     * @return the bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Print infos.
     */
    public void printInfos(){
        System.out.println("Bezeichnung : " + bezeichnung);
        System.out.println("Y Pos       : " + yPos);
        System.out.println("X Pos       : " + xPos);
    }
}