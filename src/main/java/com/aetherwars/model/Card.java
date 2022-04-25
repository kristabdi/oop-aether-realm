import java.util.ArrayList;
import java.util.List;

public class Card {
    private String nama;
    private String description;
    private String type; //character atau spell

    Card(String name, String type, String description) {
        this.nama = name;
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

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
    // private cardOnHover(GameWindow gameWindow){
    //     //menampilkan deskripsi card ke gameWindow
    // }
}