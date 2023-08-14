package main.gameStracture;

import javax.swing.*;

public class GameFrame {
    private JFrame jframe;

    public GameFrame(GamePanel gp){
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.add(gp);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
