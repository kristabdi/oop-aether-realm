
public class Main {
    //create main
    
    public static void main(String[] args) {
        //CREATE GAMESTATE HANDLEEVENT GAMEWINDOW
        // get all cards
        List<Card> allCards = new ArrayList<Card>();
        // ini list ini dengan card yg legal
        
        // create gamestate
        GameState gameState = new GameState(allCards);

        // create gamewindow
        GameWindow gameWindow = new GameWindow();

        gameWindow.initiate(gameState);
        gameWindow.show();

    }

}
