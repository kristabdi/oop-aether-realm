public class Main {
    //create main
    public static int cycle = 0;
    public static void main(String[] args) {
        //create windows
        //create gamestate
        
        //setup windows based on current gamestate
      
        while(gameState.checkIsEnd()){
            // draw
            draw(gameState, gameWindow);
            // plan
            plan(gameState, gameWindow);
            // attack
            attack(gameState, gameWindow);
            // end
            cycle += 1;
        }
    }
    public static void draw(GameState gameState, GameWindow gameWindow){
        if(turn % 2 == 0){
            gameState.player1.draw(gameWindow);
        }
        else{
            gameWindow.player2.draw(gameWindow);
        }

    }
    public static void plan(GameState gameState, GameWindow gameWindow){

    }
    public static void attack(GameState gameState, GameWindow gameWindow){

    }
}
