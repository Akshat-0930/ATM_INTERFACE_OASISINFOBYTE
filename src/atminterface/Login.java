package atmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton signin , signup, clear ;
    JTextField cardnumbertextfield;
    JPasswordField pintextfield;
   
    Login(){
        setLayout(null);
        setTitle("ATM INTERFACE BY AKSHAT JAISWAL");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(20,40,100,100);
        add(label);
        setSize(800,480);
        setLocation(350,200);
        setVisible(true); 
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("WELCOME TO");
        JLabel text1 = new JLabel("BANKING MANAGEMENT SYSTEM");
        add(text);
        add(text1);
        text.setFont(new Font("Osward",Font.BOLD,35));
        text.setBounds(250,40,800,40);
        text1.setFont(new Font("Osward",Font.BOLD,35));
        text1.setBounds(150,80,800,40);
        
        JLabel cardNumber = new JLabel("CARD NO:-");
            cardNumber.setFont(new Font("Raleway",Font.BOLD,25));
             cardNumber.setBounds(120,200,150,40);
           
             JLabel Pin = new JLabel("PIN:-");
             Pin.setFont(new Font("Raleway",Font.BOLD,25));
             Pin.setBounds(120,240,150,40);
         add(cardNumber);
        add(Pin);
        
              cardnumbertextfield = new JTextField();
              cardnumbertextfield.setBounds(300,200 , 250, 30);
              add(cardnumbertextfield);
              
              pintextfield = new JPasswordField();
              pintextfield.setBounds(300,240 , 250, 30);
              add(pintextfield);
              
              signin = new JButton("SIGN IN");
              signin.setBounds(300,300,100,30);
              signin.setBackground(Color.BLACK);
              signin.setForeground(Color.white);
              signin.addActionListener(this);
              
              signup = new JButton("SIGN UP");
              signup.setBounds(450,300,100,30);
              signup.setBackground(Color.BLACK);
              signup.setForeground(Color.white);
              signup.addActionListener(this);
              
              clear = new JButton("CLEAR");
              clear.setBounds(375,350,100,30);
              clear.setBackground(Color.BLACK);
              clear.setForeground(Color.white);
              clear.addActionListener(this);
              
              add(signin);
              add(signup);
              add(clear);
              
              
        
    }
    @Override
     public void actionPerformed(ActionEvent click){
         
         if(click.getSource() == clear){
             cardnumbertextfield.setText("");
             pintextfield.setText("");
             
             
             }
           
         if(click.getSource() == signin){
           Conn conn = new Conn();
           String cardnumber=cardnumbertextfield.getText();
           String pinnumber=pintextfield.getText();
           String query = " select * from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
           
           try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);              
               }
               else{
               JOptionPane.showMessageDialog(null,"Incorret card number or pin");
                       }
               
               }catch(Exception e){
               System.out.println(e);
               }
             
             }
         if(click.getSource() == signup){
             setVisible(false);
             new SignupOne().setVisible(true);
             
            
                          
             
             
             }
         
         
         
         
     }
    
    
    
    
    
    public static void main(String[] args) {
        new Login();
        
    }
    
}
