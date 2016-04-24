import javax.swing.BoxLayout;
import javax.swing.JPanel;

class Signuppanel extends JPanel
{
    Jp[] formcomp = new Jp[8];
    Signuppanel()
    {
        BoxLayout z = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(z);
        
        formcomp[0] = new Jp("Username : ");
        add(formcomp[0]);
        
        formcomp[1] = new Jp("Password: ");
        add(formcomp[1]);
        
        formcomp[2] = new Jp("Name : ");
        add(formcomp[2]);
        
        formcomp[3] = new Jp("Gender(Enter Male/Female) :");
        add(formcomp[3]);
        
        formcomp[4] = new Jp("Contact No : ");
        add(formcomp[4]);
        
        formcomp[5] = new Jp("BirthDate(Enter in DD/MM/YY) : ");
        add(formcomp[5]);
        
        formcomp[6] = new Jp("Bank Account No : ");
        add(formcomp[6]);
        
        formcomp[7] = new Jp("Address : ");
        add(formcomp[7]); 
        
        String[] data = new String[8];
        for( int i = 0; i<=7; i++)
        {
            data[i] = formcomp[i].jt.getText();
        }
        
        
    }
}