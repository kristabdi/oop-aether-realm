package com.aetherwars.model;

public class GameState {
    //punya catatan global yg gabakal keganti
    // list semua kartu yg mungkin

    // attribut
    private String word;

    // UMUM
    public GameState() {
        this.word = "abcdef";
    }
    public String getWord(){
        return this.word;
    }
    public void changeWord(){
        if(this.word.equals("abcdef")){
            this.word = "ini yg baru";
        }
        else{
            this.word = "abcdef";
        }
    }
}