
package atmInterface;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    
     BalanceEnquiry( String pinnumber){
                
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(700,830);
        setLocation(400,0);
        setVisible(true); 
     
        getContentPane().setBackground(Color.black);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource ("icon/atm2.jpg"));
        Image i2=i1.getImage().getScaledInstance (700, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,800);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(420,260,100,35);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);

        image.add(back);
         
        Conn c = new Conn();
        int balance = 0 ;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
            if(rs.getString("type").equals("Deposite")){
            
            balance +=Integer.parseInt(rs.getString("amount"));
            }else{
            balance -=Integer.parseInt(rs.getString("amount"));
            
            }
            }
            }catch(Exception e ){
                System.out.println(e);
                
            }
        
        JLabel text = new JLabel("YOUR CURRENT BALANCE IS RS " + balance);
        text.setBounds(200,180,700,35);
        text.setForeground(Color.black);
        text.setFont(new Font("System" , Font.BOLD,17));
        image.add(text);
   
        
        
        
         
        
        
     }
        @Override
      public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        
        
    }
     
     
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

   
    
}
