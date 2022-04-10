import javax.swing.*;  
public class FirstSwingExample {  
    private static int temp = 1;
    public static void main(String[] args) {  
        JFrame f = new JFrame();//creating instance of JFrame  
        JButton b = new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
        b.addActionListener(e -> {
            if(temp == 1){
                selectionButtonPressed(temp);
            }
            else{
                selectionButtonPressed(temp);
            } 
        });  
        f.add(b);//adding button in JFrame  

        addButton(f);


        JButton c = new JButton("ganti temp");//creating instance of JButton  
        c.setBounds(130,50,100, 40);//x axis, y axis, width, height  
        b.addActionListener(e -> { 
            System.out.println("Hello aldkfjasd;flaskjf!");
                if(temp == 1){
                    temp = 2;
                }
                else{
                    temp = 1;
                }
        });  

        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);
        //add delay 1 second
        try {
            //print to console
            System.out.println("Hello World!");
            Thread.sleep(1000);
            System.out.println("Hello Wor22ld!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        addAnotherButton(f);

        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
        // addButton(f, 2);

    }
    public static void selectionButtonPressed(int temp){
        if(temp == 1){
            System.out.println("Button 1 pressed");
        }
        else{
            System.out.println("Button 2 pressed");
        }
    
    }
    public static void addButton(JFrame f){
        JButton b=new JButton("clock");//creating instance of JButton  
        b.setBounds(130,200,100, 40);//x axis, y axis, width, height  
                
        f.add(b);//adding button in JFrame  
    }
    public static void addAnotherButton(JFrame f){
        JButton b=new JButton("cleck");//creating instance of JButton  
        b.setBounds(230,100,100, 40);//x axis, y axis, width, height  
                
        f.add(b);//adding button in JFrame  
    }
}  