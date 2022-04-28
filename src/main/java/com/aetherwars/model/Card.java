package com.aetherwars.model;

public class Card {
    private String name;
    private String description;
    private String type; //character atau spell
    private String imagePath;
    Card(String name, String type, String description, String imagePath) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.imagePath = imagePath;
    };
    public String getImagePath(){
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMana(){
        return 0;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
    // private cardOnHover(GameWindow gameWindow){
    //     //menampilkan deskripsi card ke gameWindow
    // }
}