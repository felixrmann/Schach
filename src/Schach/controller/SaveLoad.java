package Schach.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * The type Save load.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-10
 */
public class SaveLoad {
    /**
     * Save game.
     *
     * @param saveName the save name
     * @param gameData the game data
     */
    public static void SaveGame(String saveName, String gameData){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("SAVES/" + saveName + ".txt", StandardCharsets.UTF_8));
            
            writer.write(gameData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load game string [ ] [ ].
     *
     * @param saveName the save name
     * @return the string [ ] [ ]
     */
    public static String[][] LoadGame(String saveName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("SAVES/" + saveName + ".txt", StandardCharsets.UTF_8));
            String out = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            out = out.replaceAll("\\s\\s", "-");
            out = out.replaceAll("\\s,", "-,");
            out = out.replaceAll("\\s", "");
            out = out.replaceAll("-", " ");
            out = out.replaceAll("\\[", "").replaceAll("\\]", "");

            String[][] feld = new String[8][8];
            String[] temp = out.split(",");
            int cnt = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    feld[i][j] = temp[cnt];
                    cnt++;
                }
            }

            System.out.println("geladen");
            return feld;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
