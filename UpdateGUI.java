import javax.swing.*;  

public class UpdateGUI{
    public void update(GameWindow gameWindow, GameState gameState){
        // kalo di panggil, maka akan muncul button baru di gameWindow dan gameState di update
        // print temp dari game state
        gameState.setTemp(gameState.getTemp() + 1);
        System.out.println("gameState.getTemp()");
        System.out.println(gameState.getTemp());
        
        JButton button = new JButton("Click dari updateGUI me!");

        button.setBounds(100,100,100,100);
        // button.addActionListener(e -> {
        //   UpdateGUI.update(this, gameState);

        // }); 
        gameWindow.f.add(button);
        gameWindow.f.repaint();
    }
    public static void staticUpdate(GameWindow gameWindow, GameState gameState){
        // kalo di panggil, maka akan muncul button baru di gameWindow dan gameState di update
        // print temp dari game state
        gameState.setTemp(gameState.getTemp() + 1);
        // gameState.setTemp(10);
        System.out.println("dari fungsi static gameState.getTemp()");
        System.out.println(gameState.getTemp());
        
        JButton button = new JButton("Click dari updateGUI static me!");

        button.setBounds(200,100,100,100);
        // button.addActionListener(e -> {
        //   UpdateGUI.update(this, gameState);

        // }); 
        gameWindow.f.add(button);
        gameWindow.f.repaint();
    }

    public static void helloWorld(){
        System.out.println("hello world");
    }
}