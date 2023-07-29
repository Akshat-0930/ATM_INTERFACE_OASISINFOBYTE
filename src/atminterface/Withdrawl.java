package atmInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;



public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    
    Withdrawl(String Pinnumber){
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
        
        
        JLabel text = new JLabel("PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        text.setBounds(120,80,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,17));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,170,350,35);
        amount.setBackground(Color.darkGray);
        amount.setForeground(Color.WHITE);
        amount.setHorizontalAlignment(JTextField.CENTER);

        image.add(amount);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(420,220,100,35);
        withdraw.setBackground(Color.darkGray);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);

        image.add(withdraw);
        
        back = new JButton("BACK");
        back.setBounds(420,260,100,35);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);

        image.add(back);

        
        
        
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()== withdraw){
           String number = amount.getText();
           Date date = new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null, "AMOUNT FIELD CANNOT BE EMPTY");
               
           }
           else {
               try{
                   Conn conn = new Conn();
           String query = "insert into bank values('"+pinnumber+"' , '"+date+"' , 'Withdraw' , '"+number+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "RS" +number+ " WITHDRAW SUCCESSFULLY");
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
           
            
           }catch(Exception e){
                   System.out.println(e);
               }
               
           }
           
           
           }
       else if(ae.getSource()==back){
           
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
           
           
           
       
       }
        
        
    }
    
    
    public static void main(String[] args) {
        
        new Withdrawl("");
        
        
    }

    
}
