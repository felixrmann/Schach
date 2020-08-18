package Schach.model;

import javax.swing.*;
import java.awt.*;

/**
 * The type Game field.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -April-22
 */
public class GameField extends JPanel {

    //height 400
    //width 400

    public void paint(Graphics g){

        g.fillRect(0,0,400,400);

        for (int i = 0; i <= 300; i+= 100) {
            for (int j = 0; j <= 300; j+= 100) {
                g.clearRect(i, j, 50, 50);
            }
        }

        for (int i = 50; i <= 350; i+= 100){
            for (int j = 50; j <= 350; j+= 100){
                g.clearRect(i, j, 50, 50);
            }
        }
    }
}
