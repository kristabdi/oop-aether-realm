import javax.swing.*;  


//UDAH MAIN GINI DOANG. GK NAMBAH
public class FirstSwingExample {  
    public static void main(String[] args) {  
        //CREATE GAMESTATE AND GAMEWINDOW
        GameState gameState = new GameState();
        GameWindow gameWindow = new GameWindow();
        //INITIATE GAMEWINDOW AND SHOW
        gameWindow.initiate(gameState);
        gameWindow.show();
    }
}  