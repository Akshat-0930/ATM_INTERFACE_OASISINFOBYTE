package atmInterface;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.SQLException;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField PanTextField,AadhaarTextField;
    JButton next;
    JRadioButton SeniorYes , SeniorNo , ExistingYes, ExistingNo;
    JComboBox religion ,category ,income , educationqualification ,occupation;
    String Formno;
    SignupTwo(String Formno){  
        this.Formno= Formno;
        setLayout(null);
       
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,700);
        setLocation(350,10);
        setVisible(true);
       
        setTitle("NEW ACCOUNT APPLICATION FORM 2 - PAGE 2");
      
        JLabel AdditionalDetails = new JLabel("Page 2:- additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        AdditionalDetails.setBounds(250,80,300,60);
        add(AdditionalDetails);
        
        JLabel Religion = new JLabel("RELIGION :-");
        Religion.setFont(new Font("Raleway", Font.BOLD,22));
        Religion.setBounds(80,140,150,30);
        add(Religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(310,140,250,30);
        add(religion);
         
        
        JLabel Category = new JLabel("CATEGORY :-");
        Category .setFont(new Font("Raleway", Font.BOLD,22)); 
        Category .setBounds(80,180,200,30);
        add(Category );
        
        String valCategory[] = {"General","OBC","SC","ST","Others"}; 
        category = new JComboBox(valCategory);
        category.setBounds(310,180,250,30);
        add(category);
        
        JLabel Income = new JLabel("INCOME:-");
        Income .setFont(new Font("Raleway", Font.BOLD,22));
        Income .setBounds(80,220,200,30);
        add(Income );
        
        String valIncome[] = {"Null","< 1,00,000","< 2,50,000","< 5,00,000","Upto 10,00,000"}; 
        income = new JComboBox(valIncome);
        income.setBounds(310,220,250,30);
        add(income);
     
        
        
        
        JLabel Educational = new JLabel("EDUCATIONAL");
        Educational .setFont(new Font("Raleway", Font.BOLD,22));
        Educational .setBounds(80,260,200,30);
        add(Educational );
        
         
        JLabel Qualification = new JLabel("QUALIFICATION :-");
        Qualification .setFont(new Font("Raleway", Font.BOLD,22));
        Qualification .setBounds(80,300,200,30);
        add(Qualification );
        
        String valEducationQualification[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"}; 
        educationqualification = new JComboBox(valEducationQualification);
        educationqualification.setBounds(310,300,250,30);
        add(educationqualification);
        
     
        
        JLabel Occupation = new JLabel("OCCUPATION :-");
        Occupation .setFont(new Font("Raleway", Font.BOLD,22));
        Occupation .setBounds(80,340,220,30);
        add(Occupation );
        
        
        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Retired"}; 
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(310,340,90,30);
        add(occupation);
        
       
        JLabel PanNo = new JLabel("PAN NO. :-");
        PanNo .setFont(new Font("Raleway", Font.BOLD,22));
        PanNo .setBounds(80,380,200,30);
        add(PanNo );
        
        PanTextField=new JTextField();
        PanTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        PanTextField.setBounds(310,380,250,30);
        add(PanTextField);
        
        JLabel Aadhaar = new JLabel("AADHAAR NO. :-");
        Aadhaar .setFont(new Font("Raleway", Font.BOLD,22));
        Aadhaar .setBounds(80,420,200,30);
        add(Aadhaar );
        
        AadhaarTextField=new JTextField();
        AadhaarTextField.setFont(new Font("Raleway",Font.BOLD , 14));
        AadhaarTextField.setBounds(310,420,250,30);
        add(AadhaarTextField);
        
        JLabel SeniorCitizen = new JLabel("SENIOR CITIZEN :-");
        SeniorCitizen .setFont(new Font("Raleway", Font.BOLD,22));
        SeniorCitizen .setBounds(80,460,250,30);
        add(SeniorCitizen );
        
        SeniorYes = new JRadioButton("Yes");
        SeniorYes.setBounds(310,460,50,30);
        add(SeniorYes);
        
        SeniorNo = new JRadioButton("No");
        SeniorNo.setBounds(370,460,50,30);
        add(SeniorNo);
        
        ButtonGroup seniorcitizen = new ButtonGroup();
        seniorcitizen.add(SeniorYes);
        seniorcitizen.add(SeniorNo);

       
        
        JLabel ExistingAccount = new JLabel("EXISTING ACCOUNT:-");
        ExistingAccount .setFont(new Font("Raleway", Font.BOLD,20));
        ExistingAccount .setBounds(80,500,300,30);
        add(ExistingAccount );
        
        ExistingYes = new JRadioButton("Yes");
        ExistingYes.setBounds(310,500,50,30);
        add(ExistingYes);
        
        ExistingNo = new JRadioButton("No");
        ExistingNo.setBounds(370,500,50,30);
        add(ExistingNo);
        
        ButtonGroup existingaccount = new ButtonGroup();
        existingaccount.add(ExistingYes);
        existingaccount.add(ExistingYes);
        
        
        
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
        
        
        String sreligion = (String) religion.getSelectedItem(); //set text
        String scategory = (String) category.getSelectedItem(); //set text
        String sincome  = (String) income.getSelectedItem();
        String seducation  = (String) educationqualification.getSelectedItem();
        String soccupation  = (String) occupation.getSelectedItem();
        
        
        String SeniorCitizen = null;
        if(SeniorYes.isSelected()){
            SeniorCitizen = "Yes";
        } else if (SeniorNo.isSelected()){
        SeniorCitizen = "No"; 
        
    }
        
        String ExistingAccount = null;
        if(ExistingYes.isSelected()){
            ExistingAccount = "Yes";
           }
        else  if (ExistingNo.isSelected()){
            ExistingAccount = "No";
            
       }
       
        String Pan = PanTextField.getText();
        String Aadhaar = AadhaarTextField.getText();
       
                
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into SignupTwo values('"+Formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+seducation+"' , '"+soccupation+"' , '"+Pan+"' , '"+Aadhaar+"' , '"+SeniorCitizen+"' , '"+ExistingAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(Formno).setVisible(true);
                
            
            } 
        }catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
          
          
          
        
        
    }
    
    
    
    public static void main(String[] args) {
       new SignupTwo("");
    }
    
}
               