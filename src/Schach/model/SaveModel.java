package Schach.model;

import javax.swing.*;
import java.io.File;

/**
 * The type Save model.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-12
 */
public class SaveModel extends DefaultListModel<String> {

    private static int cnt;
    private static String[] gameSaves;

    /**
     * Instantiates a new Save model.
     */
    public SaveModel(){
        gameSaves = new String[20];
        cnt = 0;
        getAllSaves();
    }

    /**
     * Sets game saves.
     *
     * @param newSave the new save
     */
    public void setGameSaves(String newSave) {
        SaveModel.gameSaves[cnt] = newSave;
        cnt++;
    }

    /**
     * Gets game saves.
     *
     * @param index the index
     * @return the game saves
     */
    public String getGameSaves(int index) {
        return gameSaves[index];
    }

    /**
     * Get anz saves int.
     *
     * @return the int
     */
    public int getAnzSaves(){
        File folder = new File("SAVES");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        return listOfFiles.length;
    }

    /**
     * Get all saves.
     */
    public void getAllSaves(){
        File folder = new File("SAVES");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String temp = listOfFile.getName();
                temp = temp.substring(0, temp.length() -4);
                gameSaves[cnt] = temp;
                cnt++;
            }
        }
    }
}