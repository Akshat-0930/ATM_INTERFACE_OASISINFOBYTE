
package atmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transaction(String pinnumber){
        
        
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
      
        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setBounds(150,80,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,20));
        image.add(text);
        
         deposite = new JButton("DEPOSITE");
        deposite.setBounds(160,170,150,30);
        image.add(deposite);
        deposite.addActionListener(this);
        
         withdrawl = new JButton("WITHDRAWL");
        withdrawl.setBounds(400,170,150,30);
        image.add(withdrawl);
                withdrawl.addActionListener(this);

        
         fastcash = new JButton("FASTCASH");
        fastcash.setBounds(160,220,150,30);
        image.add(fastcash);
                fastcash.addActionListener(this);

        
         ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(400,220,150,30);
        image.add(ministatement);
                ministatement.addActionListener(this);

        
         pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(160,270,150,30);
        image.add(pinchange);
                pinchange.addActionListener(this);

        
         balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(400,270,150,30);
        image.add(balanceenquiry);
                balanceenquiry.addActionListener(this);

        
         exit = new JButton("EXIT");
        exit.setBounds(280,310,150,30);
        image.add(exit);
                exit.addActionListener(this);

        
        
        
        
         
        
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource()== deposite){
           
             setVisible(false);
             new Deposite(pinnumber).setVisible(true);
             
           }
         
         else if(ae.getSource()== withdrawl){
           
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
             
           }
         else if(ae.getSource()== fastcash){
           
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
             
           }
         else if(ae.getSource()== pinchange){
           
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
             
           }
          else if(ae.getSource()== balanceenquiry){
           
             setVisible(false);
             new BalanceEnquiry(pinnumber).setVisible(true);
             
           }
         else if(ae.getSource()== ministatement){
           
             new MiniStatement(pinnumber).setVisible(true);
             
           }
        
    }
    

   
    public static void main(String args[]) {
        new Transaction("");
        
    }

    
}
