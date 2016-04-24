import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

class Buttons extends JPanel
{
    JButton[] choices;
    Buttons( int nob, String[] names )
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        choices = new JButton[nob];
        for( int i = 0; i<nob; i++)
        {
            choices[i] = new JButton(names[i]);
            add(choices[i]);
        }   
    }
}