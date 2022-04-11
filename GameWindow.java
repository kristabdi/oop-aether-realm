import javax.swing.*;  

public class GameWindow{
    public static JFrame f = new JFrame();

    public static void addButton(JFrame gameFrame){
        JButton button = new JButton("Click me!");
        button.setBounds(100,100,100,100);
        gameFrame.add(button);
        gameFrame.repaint();
    }

    public void initiate(GameState gameState){
        // gameState.setTemp(2);
        // System.out.println("dari initate");
        // System.out.println(gameState.getTemp());
        
        // ngebikin jButton sebiji
        UpdateGUI.helloWorld();
        JButton b = new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
        b.addActionListener(e -> {
            new UpdateGUI().update(this, gameState);
            UpdateGUI.staticUpdate(this, gameState);

        }); 
        this.f.add(b);//adding button in JFrame  

        // addButton(f);


        // JButton c = new JButton("ganti temp");//creating instance of JButton  
        // c.setBounds(130,50,100, 40);//x axis, y axis, width, height  
        // b.addActionListener(e -> {
        //     addButton(f);
        // });  

        // setup jframe
        this.f.setSize(400,500);//400 width and 500 height  
        this.f.setLayout(null);//using no layout managers 

    }
    public void show(){
        this.f.setVisible(true);
    }
}