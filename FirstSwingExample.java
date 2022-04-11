import javax.swing.*;  

public class FirstSwingExample {  
    public static void main(String[] args) {  

        GameState gameState = new GameState();
        GameWindow gameWindow = new GameWindow();
        gameWindow.initiate(gameState);
        gameWindow.show();
    }
}  