package Schach.model;

/**
 * The type Weiss koenig.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -Dezember-23
 */
public class WeissKoenig extends figur {
    private String bezeichnung = "wK";
    private static int xPos;
    private static int yPos;
    private boolean moved = true;

    /**
     * Instantiates a new Weiss koenig.
     *
     * @param yPos the y pos
     * @param xPos the x pos
     */
    public WeissKoenig(int yPos, int xPos) {
        WeissKoenig.xPos = xPos;
        WeissKoenig.yPos = yPos;
    }

    /**
     * Gets moved.
     *
     * @return the moved
     */
    public boolean getMoved() {
        return moved;
    }

    /**
     * Sets moved.
     *
     * @param moved the moved
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
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