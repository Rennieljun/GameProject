package main.worldMap;

import main.gameStracture.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WorldGenerator {
    private int maxWorldCol;
    private int maxWorldRow;
    private double worldX;
    private double worldY;
    private int tileSize;
    private int[][] tileNum;
    private GamePanel gp;


    public WorldGenerator(int maxWorldRow, int maxWorldCol, int tileSize, GamePanel gp){
        this.gp = gp;
        this.maxWorldCol = maxWorldCol;
        this.maxWorldRow = maxWorldRow;
        this.tileSize = tileSize;
        tileNum = new int[maxWorldRow][maxWorldCol];
        generateTiles("/Map/WorldTileMap.txt");

    }

    public void generateTiles(String map){
        try {
            InputStream is = getClass().getResourceAsStream("/Map/WorldTileMap.txt");
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (col < maxWorldCol && row < maxWorldRow){
                String line = br.readLine();

                while (col < maxWorldCol){
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    tileNum[row][col] = num;
                    col++;
                }
                if(col == maxWorldCol){
                    row++;
                    col = 0;
                }
            }

            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void placeTiles(Graphics g){
        int col = 0;
        int row = 0;


        while (col < maxWorldCol && row < maxWorldRow){
            int num = tileNum[row][col];

            int worldX = tileSize * col;
            int worldY = tileSize * row;
            int screenX = (int) (worldX - gp.player.getWorldX() + gp.player.getScreenX());
            int screenY = (int) (worldY - gp.player.getWorldY() + gp.player.getScreenY());
            if(num == 1) {
                g.setColor(Color.GREEN);
                g.fillRect(screenX, screenY, tileSize, tileSize);
                g.setColor(Color.BLACK);
                g.drawRect(screenX, screenY, tileSize, tileSize);
            }
            if(num == 2) {
                g.setColor(Color.CYAN);
                g.fillRect(screenX, screenY, tileSize, tileSize);
                g.setColor(Color.BLACK);
                g.drawRect(screenX, screenY, tileSize, tileSize);
            }

            col++;
            if(col == maxWorldCol){
                row++;
                col = 0;
            }
        }
    }
}
