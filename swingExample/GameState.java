import javax.swing.*;  
public class GameState{
    private int temp = 1;
    
    //getter setter
    public int getTemp(){
        return temp;
    }
    public void setTemp(int temp){
        this.temp = temp;
        //print
        System.out.println("temp: " + temp);
    }
}