
package atmInterface;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
    setLayout(null);
    setSize(400,600);
    setLocation(500,40);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    setTitle("MINI STATEMENT");
    
    
    JLabel mini = new JLabel();
    add(mini);
    mini.setBounds(20,140,400,200);
    
    
    JLabel bank = new JLabel("INDIAN BANK ");
    bank.setBounds(150,20,100,20);
    add(bank);
    
    JLabel card = new JLabel();
    card.setBounds(90,50,300,20);
    add(card);
    
    
    JLabel balance = new JLabel();
    balance.setBounds(20,400,300,20);
    add(balance);
    
    
    
   
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
        while(rs.next()){
            
            card.setText("Card Number:" + rs.getString("card_number").substring(0,4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            
        }
        
    }catch(Exception e){
        System.out.println(e);
        }
    
    try{
        Conn conn = new Conn();
        int bal = 0 ;
        ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
        while(rs.next()){
            mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
        
             if(rs.getString("type").equals("Deposite")){
            
            bal +=Integer.parseInt(rs.getString("amount"));
            }else{
            bal -=Integer.parseInt(rs.getString("amount"));
             
            
            }
        
        }
        
        balance.setText("YOUR CURRENT ACCOUNT BALANCE IS: RS " + bal);
        
    }catch(Exception e){
        System.out.println(e);
    
    
   }
   
    }
    
    public static void main(String[] args) {
        
        new MiniStatement("");
    }
    
}
