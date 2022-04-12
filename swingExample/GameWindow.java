import javax.swing.*;  

public class GameWindow{
    // SEMUA BINDING FUNGSI KE GAMEFRAME CUMAN BOLEH TERJADI DISINI
    public JFrame gameFrame = new JFrame();

    //buat nempelin semua komponen yg dibutuhkan ke gameFrame
    public void initiate(GameState gameState){

        //CREATE KOMPONEN. LANGSUNG DI BIND KE FUNGSI DAN KE GAMEFRAME
        //create 
        JButton addButtonButton = new JButton("add another button");//creating instance of JButton  
        addButtonButton.setBounds(130,100,100, 40);//x axis, y axis, width, height  

        JLabel label = new JLabel(String.valueOf(gameState.getTemp()));
        label.setBounds(100,100,100,40);
        //bind
        addButtonButton.addActionListener(e -> {
            HandleEvent.addButtonButtonOnClick(this, gameState, label);
        }); 

        //add
        this.gameFrame.add(addButtonButton); 
        this.gameFrame.add(label);

        // SETUP GAMEFRAME
        this.gameFrame.setSize(400,500);//400 width and 500 height  
        this.gameFrame.setLayout(null);//using no layout managers 

    }

    //buat nampilin ke layar
    public void show(){
        this.gameFrame.setVisible(true);
    }
}