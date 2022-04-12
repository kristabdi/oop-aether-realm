import javax.swing.*;  

public class HandleEvent{
    //semua yang ada disini STATIC. isinya fungsi2 yang dipanggil kalo ada event. urutannya UPDATE GAMESTATE, UPDATE GAMEWINDOW, RERENDER
    public static void addButtonButtonOnClick(GameWindow gameWindow, GameState gameState, JLabel label){
        // kalo di panggil, maka akan muncul button baru di gameWindow dan gameState di update, trus update label
        //UPDATE GAMESTATE
        gameState.setTemp(gameState.getTemp() + 1);
        //UPDATE GAMEWINDOW
        //add button
        JButton removeButton = new JButton("new button added!");
        removeButton.setBounds(200,300,200,100);
        removeButton.addActionListener(e -> {
            removeButtonOnClick(gameWindow, gameState, removeButton);

        }); 
        //update label
        label.setText(String.valueOf(gameState.getTemp()));
        gameWindow.gameFrame.add(removeButton);
        // RERENDER
        gameWindow.gameFrame.revalidate();
        gameWindow.gameFrame.repaint();
    }
    

    public static void removeButtonOnClick(GameWindow gameWindow, GameState gameState, JButton removeButton){
        // kalo di panggil, maka akan muncul button baru di gameWindow
        // UPDATE GAMESTATE
        // UPDATE GAMEWINDOW
        removeButton.getParent().remove(removeButton);
        // RERENDER
        gameWindow.gameFrame.revalidate();
        gameWindow.gameFrame.repaint();
    }

}