
package atmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2, r3, r4;
    JCheckBox c1 , c2 , c3 ,c4,c5,c6,c7;
    JButton submit,cancel;     
    String Formno;
    SignupThree(String Formno){
        this.Formno= Formno;

        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        
        JLabel l1 = new JLabel("PAGE 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel Type = new JLabel("Account Type :");
        Type.setFont(new Font("Raleway",Font.BOLD,22));
        Type.setBounds(100, 140, 200, 30);
        add(Type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setBounds(100, 180, 200, 20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setBounds(350, 180, 250, 20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 150, 20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setBounds(350, 220, 250, 20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        
         JLabel CardNo = new JLabel("Card Number :");
        CardNo.setFont(new Font("Raleway",Font.BOLD,22));
        CardNo.setBounds(100, 300, 200, 30);
        add(CardNo);
        
        JLabel CardDetail = new JLabel("Your 16 digit card detail");
        CardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        CardDetail.setBounds(100, 320, 300, 30);
        add(CardDetail);
        
         JLabel Number = new JLabel("XXXX-XXXX-XXXX-4184");
        Number.setFont(new Font("Raleway",Font.BOLD,22));
        Number.setBounds(330, 300, 400, 30);
        add(Number);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,22));
        Pin.setBounds(100, 370, 200, 30);
        add(Pin);
        
        JLabel PinDetail = new JLabel("Your 4 digit card detail");
        PinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        PinDetail.setBounds(100, 390, 200, 30);
        add(PinDetail);
        
        JLabel PinNumber = new JLabel("XXXX");
        PinNumber.setFont(new Font("Raleway",Font.BOLD,22));
        PinNumber.setBounds(330, 370, 300, 30);
        add(PinNumber);
        
        JLabel Service = new JLabel("Service Required:");
        Service.setFont(new Font("Raleway",Font.BOLD,22));
        Service.setBounds(100, 450, 200, 30);
        add(Service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.white);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("NET BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.white);
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING ");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.white);
        c3.setBounds(100,550,200,30);
        add(c3);
        
         
        c4 = new JCheckBox("EMAIL AND SMS ALERT");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.white);
        c4.setBounds(350,550,300,30);
        add(c4);
        
        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.white);
        c5.setBounds(100,600,200,30);
        add(c5);
        
         
        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.white);
        c6.setBounds(350,600,200,30);
        add(c6);
       
         
        c7 = new JCheckBox("I HEARBY DECLARE THAT ABOVE DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.white);
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton ("Submit");
        submit.setBackground (Color. BLACK);
        submit.setForeground(Color. WHITE) ;
        submit.setFont(new Font ("Raleway", Font. BOLD, 14));
        submit.setBounds (200, 740, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton ("Cancel");
        cancel.setBackground (Color. BLACK);
        cancel.setForeground (Color. WHITE) ;
        cancel.setFont (new Font ("Raleway", Font. BOLD, 14));
        cancel.setBounds (350, 740, 100, 30);
        cancel.addActionListener(this);
        add(cancel); 
        



        
     
    
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String accounttype= null;
            if(r1.isSelected()){
                accounttype = "Saving Account";
            }
            else if(r2.isSelected()){
                accounttype = "Fixed Deposite Account";
            }
                        else if(r3.isSelected()){
                accounttype = "Current Account";
            }
            else if(r4.isSelected()){
                accounttype = "Recurring Deposite Account"; 
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)) + 50409360L;
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM CARD ";
            }
            else  if(c2.isSelected()){
                facility = facility + " NET BANKING ";
            }else  if(c3.isSelected()){
                facility = facility + " MOBILE BANKING ";
            }else  if(c4.isSelected()){
                facility = facility + " EMAIL AND SMS ALERTS ";
            }else  if(c5.isSelected()){
                facility = facility + " CHEQUE BOOK ";
            }else  if(c6.isSelected()){
                facility = facility + " E-STATEMENT ";
            }  
            
            try{
                if(accounttype.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
                    } 
                else{ Conn conn = new Conn();
                
                String query1 = "insert into SignupThree values('"+Formno+"' , '"+accounttype+"' , '"+cardnumber+"' , '"+pinnumber+"' , '"+facility+"')";
                conn.s.executeUpdate(query1);    
                String query2 = "insert into login values('"+Formno+"' , '"+cardnumber+"' , '"+pinnumber+"')";
                conn.s.executeUpdate(query2);  
                
                JOptionPane.showMessageDialog(null, "Card Number " + cardnumber + "\n pin:" + pinnumber);
                
                
                setVisible(false);
                new Deposite(pinnumber).setVisible(true);
                     }
            
            }catch(Exception e){
                System.out.println(e);
            }
         
        } else if (ae.getSource()==cancel){
            
            setVisible(false);
            
            new Login().setVisible(true);
        
    }
    
    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    
}
