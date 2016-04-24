import javax.swing.BoxLayout;
import javax.swing.JPanel;

class PolicyPanel extends JPanel
{
    Jp[] formcomp = new Jp[12];
    PolicyPanel()
    {
        BoxLayout z = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(z);
        
        formcomp[0] = new Jp("Name : ");
        add(formcomp[0]);
        
        formcomp[1] = new Jp("Id Of Company : ");
        add(formcomp[1]);
        
        formcomp[2] = new Jp("Amount : ");
        add(formcomp[2]);
        
        formcomp[3] = new Jp("Bonus : ");
        add(formcomp[3]);
        
        formcomp[4] = new Jp("Forfeit Value : ");
        add(formcomp[4]);
        
        formcomp[5] = new Jp("Maturity Date(Enter in DD/MM/YY) : ");
        add(formcomp[5]);
        
        formcomp[6] = new Jp("Nominations : ");
        add(formcomp[6]);
        
        formcomp[7] = new Jp("Premium Amount : ");
        add(formcomp[7]); 
        
        formcomp[8] = new Jp("Risks Covered : ");
        add(formcomp[8]); 
        
        formcomp[9] = new Jp("Surrender Value : ");
        add(formcomp[9]); 
        
        formcomp[10] = new Jp("Time Length : ");
        add(formcomp[10]); 
        
        formcomp[11] = new Jp("Time Period : ");
        add(formcomp[11]); 
 
        
        String[] data = new String[8];
        for( int i = 0; i<=7; i++)
        {
            data[i] = formcomp[i].jt.getText();
        }
        
        
    }
}