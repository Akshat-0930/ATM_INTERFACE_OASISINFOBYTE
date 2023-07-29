package atmInterface;

import javax.swing.*;
import java.awt.*; 
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long Random;
    JTextField NameTextField,FNameTextField, EmailTextField, AddressTextField,CityTextField,StateTextField,PincodeTextField;
    JButton next;
    JRadioButton male , female , married, unmarried, other ;
    JDateChooser dob;
    
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        Random = Math.abs(ran.nextLong() % 9000L + 1000L);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,700);
        setLocation(350,10);
        setVisible(true);
       
       
        JLabel FormNo = new JLabel("APPLICATION FORM NO. :-" + Random);
        FormNo.setFont(new Font("Raleway", Font.BOLD,35));
        FormNo.setBounds(120,20,600,40);
        add(FormNo);
        
          JLabel PersonalDetails = new JLabel("Page 1:- Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        PersonalDetails.setBounds(250,80,300,60);
        add(PersonalDetails);
        
        JLabel Name = new JLabel("NAME :-");
        Name.setFont(new Font("Raleway", Font.BOLD,22));
        Name.setBounds(80,140,100,30);
        add(Name);
        
        NameTextField=new JTextField();
        NameTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        NameTextField.setBounds(310,140,250,30);
        add(NameTextField);
        
        JLabel FName = new JLabel("FATHERS NAME :-");
        FName .setFont(new Font("Raleway", Font.BOLD,22));
        FName .setBounds(80,180,200,30);
        add(FName );
        
          FNameTextField=new JTextField();
        FNameTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        FNameTextField.setBounds(310,180,250,30);
        add(FNameTextField);
        
          JLabel Dob = new JLabel("DATE OF BIRTH :-");
        Dob .setFont(new Font("Raleway", Font.BOLD,22));
        Dob .setBounds(80,220,200,30);
        add(Dob );
        
        dob = new JDateChooser();
        dob.setFont(new Font("Raleway",Font.BOLD , 14));
        dob.setBounds(310,220,250,30);
        add(dob);
        
        
        
          JLabel Gender = new JLabel("GENDER :-");
        Gender .setFont(new Font("Raleway", Font.BOLD,22));
        Gender .setBounds(80,260,200,30);
        add(Gender );
        
         male = new JRadioButton("MALE");
        male.setBounds(310,260,60,30);
        add(male);
        male.setBackground (Color.white);
        
           
         female = new JRadioButton("FEMALE");
        female.setBounds(380,260,80,30);
        add(female);
          female.setBackground (Color.white);
        
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);
        
        
        
                  JLabel Email = new JLabel("EMAIL :-");
        Email .setFont(new Font("Raleway", Font.BOLD,22));
        Email .setBounds(80,300,200,30);
        add(Email );
        
           EmailTextField=new JTextField();
        EmailTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        EmailTextField.setBounds(310,300,250,30);
        add(EmailTextField);
        
         JLabel MartialStatus = new JLabel("MARTIAL STATUS :-");
        MartialStatus .setFont(new Font("Raleway", Font.BOLD,22));
        MartialStatus .setBounds(80,340,220,30);
        add(MartialStatus );
        
         married = new JRadioButton("MARRIED");
        married.setBounds(310,340,90,30);
        add(married);
        married.setBackground (Color.white);

        
         unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(400,340,100,30);
        add(unmarried);
        unmarried.setBackground (Color.white);
        
        
         other = new JRadioButton("OTHER");
        other.setBounds(500,340,90,30);
        add(other);
        other.setBackground (Color.white);
        
        
        ButtonGroup martialstatus = new ButtonGroup();
        martialstatus.add(married);
        martialstatus.add(unmarried);
        martialstatus.add(other);

        JLabel Address = new JLabel("ADDRESS :-");
        Address .setFont(new Font("Raleway", Font.BOLD,22));
        Address .setBounds(80,380,200,30);
        add(Address );
        
        AddressTextField=new JTextField();
        AddressTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        AddressTextField.setBounds(310,380,250,30);
        add(AddressTextField);
        
        JLabel City = new JLabel("CITY :-");
        City .setFont(new Font("Raleway", Font.BOLD,22));
        City .setBounds(80,420,200,30);
        add(City );
        
        CityTextField=new JTextField();
        CityTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        CityTextField.setBounds(310,420,250,30);
        add(CityTextField);
        
         JLabel State = new JLabel("STATE :-");
        State .setFont(new Font("Raleway", Font.BOLD,22));
        State .setBounds(80,460,200,30);
        add(State );
        
        StateTextField=new JTextField();
        StateTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        StateTextField.setBounds(310,460,250,30);
        add(StateTextField);
        
          JLabel Pincode = new JLabel("PINCODE :-");
        Pincode .setFont(new Font("Raleway", Font.BOLD,22));
        Pincode .setBounds(80,500,200,30);
        add(Pincode );
        
         PincodeTextField=new JTextField();
        PincodeTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        PincodeTextField.setBounds(310,500,250,30);
        add(PincodeTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(250,550,100,40);
        next.addActionListener(this);
        add(next);
        

        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        String Formno="" + Random; //lomg
        String Name = NameTextField.getText(); //set text
        String Fname = FNameTextField.getText();
        String  Dob  = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if(male.isSelected()){
            Gender = "Male";
        } else if (female.isSelected()){
        Gender = "Female"; 
        
    }
        String  Email  = EmailTextField.getText();
        String MartialStatus = null;
        if(married.isSelected()){
            MartialStatus = "Married";
           }
        else if (unmarried.isSelected()){
            MartialStatus = "Unmarried";
            
       }
        else if (other.isSelected()){
            MartialStatus = "Other";
        }
        String Address = AddressTextField.getText();
        String City = CityTextField.getText();
        String State = StateTextField.getText();
        String Pincode = PincodeTextField.getText();
                
        try{
            if(Name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+Formno+"' , '"+Name+"' , '"+Fname+"' , '"+Dob+"' , '"+Gender+"' ,  '"+Email+"' , '"+MartialStatus+"' , '"+Address+"' , '"+City+"' , '"+State+"' , '"+Pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(Formno).setVisible(true);                
            } 
        }catch (Exception e){
            System.out.println(e);
        }
          try{
            if(Fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father 's Name is Required");
            }
        }catch (Exception e){
            System.out.println(e);
        }
            try{
            if(Dob.equals("")){
                JOptionPane.showMessageDialog(null, " DOB is Required");
            }
        }catch (Exception e){
            System.out.println(e);
            
        }
            
            try{
            if(Email.equals("")){
                JOptionPane.showMessageDialog(null, " Email is Required");
            }
        }catch (Exception e){
            System.out.println(e);
            
        }
            try{
            if(Address.equals("")){
                JOptionPane.showMessageDialog(null, " Address is Required");
            }
        }catch (Exception e){
            System.out.println(e);
            
        }
            try{
            if(City.equals("")){
                JOptionPane.showMessageDialog(null, " City is Required");
            }
        }catch (Exception e){
            System.out.println(e);
            
        }
          try{
            if(State.equals("")){
                JOptionPane.showMessageDialog(null, " State is Required");
            }
        }catch (Exception e){
            System.out.println(e);
            
        }
          try{
            if(Pincode.equals("")){
                JOptionPane.showMessageDialog(null, " Pin Code is Required");
            }
            
         
        }catch (Exception e){
            System.out.println(e);
            
        }
          
          
        
        
    }
    
    
    
    public static void main(String[] args) {
       new SignupOne();
    }
    
}
               