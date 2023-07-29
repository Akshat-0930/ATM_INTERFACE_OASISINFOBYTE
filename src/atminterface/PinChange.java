
package atmInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
PinChange(String pinnumber){

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
        
        
        JLabel text = new JLabel("PLEASE ENTER NEW PIN BELOW");
        text.setBounds(220,80,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD,17));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN-");
        pintext.setBounds(150,170,200,25);
        pintext.setForeground(Color.black);
        pintext.setFont(new Font("Raleway" , Font.BOLD,17));
        image.add(pintext);
        
        
        JLabel repintext = new JLabel("RE-ENTER NEW PIN-");
        repintext.setBounds(150,210,200,25);
        repintext.setForeground(Color.black);
        repintext.setFont(new Font("Raleway" , Font.BOLD,17));
        image.add(repintext);
        
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(320,170,200,25);
        pin.setBackground(Color.darkGray);
        pin.setForeground(Color.WHITE);
        pin.setHorizontalAlignment(JTextField.CENTER);
        image.add(pin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,22));
        repin.setBounds(320,210,200,25);
        repin.setBackground(Color.darkGray);
        repin.setForeground(Color.WHITE);
        repin.setHorizontalAlignment(JTextField.CENTER);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(300,260,100,35);
        change.setBackground(Color.darkGray);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(420,260,100,35);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
        
        



}

    @Override
   public void actionPerformed(ActionEvent ae){
       
       if(ae.getSource()==change){  
           
           try{
               
           String npin=pin.getText();
           String rpin=repin.getText();
           
            if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null,"ENTER PIN DOES NOT MATCH");
            return;
           }
            if(npin.equals("")){
       JOptionPane.showMessageDialog(null,"PLEASE ENTER PIN");
       return;
       }
         if(rpin.equals("")){
       JOptionPane.showMessageDialog(null,"PLEASE RE - ENTER PIN");
       return;
       
       } 
         Conn conn = new Conn();
         String query1= "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
         String query2= "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
         String query3= "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
     
           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           conn.s.executeUpdate(query3);
             
             JOptionPane.showMessageDialog(null, "PIN CHANGE SUCCESSFULLY");
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
             
           
       }catch (HeadlessException | SQLException e){
           System.out.println(e);
       }
       
       } else{
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
           
       }
       
     
       
  
   
  } 
   
   
        
         

    
    public static void main(String[] args) {
        
        new PinChange("").setVisible(true);
        
    }

}
