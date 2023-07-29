
package atmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balanceebquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        
        
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
      
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(150,80,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,20));
        image.add(text);
        
         deposite = new JButton("RS 100");
        deposite.setBounds(160,170,150,30);
        image.add(deposite);
        deposite.addActionListener(this);
        
         withdrawl = new JButton("RS 500");
        withdrawl.setBounds(400,170,150,30);
        image.add(withdrawl);
                withdrawl.addActionListener(this);

        
         fastcash = new JButton("RS 1000");
        fastcash.setBounds(160,220,150,30);
        image.add(fastcash);
                fastcash.addActionListener(this);

        
         ministatement = new JButton("RS 2000");
        ministatement.setBounds(400,220,150,30);
        image.add(ministatement);
                ministatement.addActionListener(this);

        
         pinchange = new JButton("RS 5000");
        pinchange.setBounds(160,270,150,30);
        image.add(pinchange);
                pinchange.addActionListener(this);

        
         balanceebquiry = new JButton("RS 10000");
        balanceebquiry.setBounds(400,270,150,30);
        image.add(balanceebquiry);
                balanceebquiry.addActionListener(this);

        
         exit = new JButton("BACK");
        exit.setBounds(280,310,150,30);
        image.add(exit);
                exit.addActionListener(this);

        
        
        
        
         
        
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            
        }else {
        
        String amount = ((JButton)ae.getSource()).getText().substring(3); //RS500
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0 ;
            while(rs.next()){
            if(rs.getString("type").equals("Deposite")){
            
            balance +=Integer.parseInt(rs.getString("amount"));
            }else{
            balance -=Integer.parseInt(rs.getString("amount"));
            
            }
            
            }
            
            if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
                return;
            }
            Date date = new Date();
            String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "RS" + amount + " DEBITED SUCCESSFULLY");
            
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);}
        
        }
         
        
    }
    

   
    public static void main(String args[]) {
        new FastCash("");
        
    }

    
}
