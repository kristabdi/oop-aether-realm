package com.aetherwars.model;

public class HandleEvent{
    public static GameState gameState;
    public static void setGameState(GameState gs){
        gameState = gs;
    }

    public static String onButtonClick(){
        gameState.nextPhase();
        return(gameState.getPhase().name());
    }
}