import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

class FormUser extends JFrame
{
   JButton sm = new JButton("Submit");
   Signuppanel signuppanel = new Signuppanel();
    public FormUser()
    {
        setTitle("Sign Up");
        setLayout( new FlowLayout(FlowLayout.RIGHT) );
        JScrollPane sp = new JScrollPane( signuppanel );
        add(sp);
        add(sm);
        setVisible(true);
        pack();
        sm.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        } );
        
    }

}