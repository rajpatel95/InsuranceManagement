import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class LoginPanel extends JPanel 
{
    static Jp usertext ;
    static Jp password ;
    JRadioButton user;
    JRadioButton comp;
    JRadioButton admin;
    ButtonGroup radiogrp;
    ButtonGroup radioGroup;
    static int choice;
    public LoginPanel()
    {
        BoxLayout x = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout( x );
        
        user = new JRadioButton("User", true);
        comp = new JRadioButton("Company", false);
        admin = new JRadioButton("Admin", false);
        usertext = new Jp("Username : ");
        password = new Jp("Password : ");
        
        
        radioGroup = new ButtonGroup();
        radioGroup.add(user);
        radioGroup.add(comp);
        radioGroup.add(admin);
        
        
        add(usertext);
        add(password);
        add(user);
        add(comp);
        add(admin);
       
        user.addItemListener(new HandlerClass(1));
        comp.addItemListener(new HandlerClass(2));
        admin.addItemListener(new HandlerClass(3));
                
        
        
    }

    private static class HandlerClass implements ItemListener
    {
        int c;
        public HandlerClass(int i)
        {
            c = i;
        }

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            choice = c;
            
        }
    }

    
}