import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

class FormPolicy extends JFrame 
{
    JButton sm = new JButton("Submit");
    PolicyPanel ppan = new PolicyPanel();
    public FormPolicy()
    {
        setTitle("Sign Up");
        setLayout( new FlowLayout(FlowLayout.RIGHT) );
        JScrollPane sp = new JScrollPane(ppan);
        add(sp);
        add(sm);
        setVisible(true);
        pack();

    }

    
}