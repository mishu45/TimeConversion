/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeconversion;

/**
 *
 * @author Ramsha Rasheed
 */

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



public class WorldClock {

    /**
     * @param args the command line arguments
     */
    private JFrame f;
    private JLabel label1 ,label2, label3, label4, label5, label6,labela, labelb;
    private JButton btnconvert;
    private JComboBox box;
    private JTextField localid,localzone, localtime,changeid,changezone, changetime;
    private TimeZone timezone ,timezone1;
    private String[] timeIDs;
    private Calendar calendar, calendar1;
    private SimpleDateFormat dateformat;
    private String DATE_FORMAT = " hh:mm:ss a       dd-M-yyyy";
    private ImageIcon icon;
    
    
    
    public WorldClock(){
        
        
    
            f =new JFrame("Time Converter");
            f.setSize(600,550);
            f.setVisible(true);
             
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            
            
            label1 = new JLabel("Current Country:");
            label1.setFont (label1.getFont ().deriveFont (12.0f));
            localid = new JTextField(20);
            labela = new JLabel("Current zone:");
            labela.setFont(label1.getFont().deriveFont(12.0f));
            localzone = new JTextField(20);
            label2 = new JLabel("Current date and time:");
            label2.setFont (label2.getFont ().deriveFont (12.0f));
            localtime = new JTextField(20);
            
            label3 = new JLabel("Selected Country:");
            label3.setFont (label3.getFont ().deriveFont (12.0f));
            changeid = new JTextField(20);
            labelb = new JLabel("Selected Zone:");
            labelb.setFont (labelb.getFont ().deriveFont (12.0f));
            changezone = new JTextField(20);
            label4 = new JLabel("Converted date and time:");
            label4.setFont (label4.getFont ().deriveFont (12.0f));
            changetime= new JTextField(20);
            label5 = new JLabel("List of timezones:");
            label5.setFont (label5.getFont ().deriveFont (12.0f));
            calendar = new GregorianCalendar();
            calendar1 = new GregorianCalendar();
            dateformat = new SimpleDateFormat(DATE_FORMAT);
            timezone = TimeZone.getDefault();
            calendar.getInstance();
            timeIDs = timezone.getAvailableIDs();
            box = new JComboBox(timeIDs);
                
            
            label6 = new JLabel();// JLabel constructor no arguments 35   
            label6.setText("Welcome to World Clock"); 
           
            icon = new ImageIcon("photo_0171411622jxwdkp.jpg");
             label6.setIcon(icon);
            
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setVerticalAlignment(SwingConstants.BOTTOM);
            label6.setFont (label6.getFont ().deriveFont (20.0f));
            
            localid.setText(timezone.getID());
            localzone.setText(timezone.getDisplayName());
            localtime.setText(dateformat.format(calendar.getTime()));
            
         
            
            f.validate();
            
            btnconvert =  new JButton("Convert");
            
            
            Container c = f.getContentPane();
            c.setLayout(new GridLayout(0,1));
            c.setBackground(Color.cyan);
            f.add(label6);
            f.add(label1);
            f.add(localid);
            f.add(labela);
            f.add(localzone);
            f.add(label2);
            f.add(localtime);
            f.add(label5);
            f.add(box);
            box.setBounds(100, 150,120,50);
            
            f.add(label3);
            f.add(changeid);
            f.add(labelb);
            f.add(changezone);
            f.add(label4);
            f.add(changetime);
            f.add(btnconvert);
            
           
            
            btnconvert.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    timezone1 = TimeZone.getTimeZone(box.getItemAt(box.getSelectedIndex()).toString());
                    changeid.setText(timezone1.getID());
                    changezone.setText(timezone1.getDisplayName());
                    dateformat.setTimeZone(timezone1);
                    calendar1.setTimeZone(timezone1);
                    changetime.setText(dateformat.format(calendar1.getTime()));
                }
            });
                
        
    }
            
            
            
     public static void main(String[] args) {
        // TODO code application logic here
        WorldClock worldClock = new WorldClock();
        
        
    }

    

}
