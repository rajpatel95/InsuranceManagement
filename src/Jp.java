import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Jp extends JPanel
{
    public JLabel jl;
    public JTextField jt;

    public Jp(String jln)
    {
        GridLayout gridLayout = new GridLayout( 1, 2, 15, 0 );
        setLayout( gridLayout );
        jl = new JLabel(jln);
        jt = new JTextField(15);
        add(jl);
        add(jt);
    }
    
}