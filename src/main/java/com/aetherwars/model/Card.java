package com.aetherwars.model;

public class Card {
    private String name;
    private String description;
    private String type; //character atau spell

    Card(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    };

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

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
    // private cardOnHover(GameWindow gameWindow){
    //     //menampilkan deskripsi card ke gameWindow
    // }
}