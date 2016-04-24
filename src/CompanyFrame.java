import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class CompanyFrame extends JFrame
{
    Buttons companyframe;
    CompanyFrame()
    {
        String[] temp = new String[2];
        temp[0] = "To View Your Clients";
        temp[1] = "To View Policies You Have Offered";
                
        companyframe= new Buttons(2, temp);
        add(companyframe);
        setVisible(true);
        pack();
        companyframe.choices[0].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableFrame tf = new TableFrame("SELECT * FROM userdata WHERE Id=(SELECT UserID FROM companyuser WHERE CompanyId='"+Login.uId +"')");
            }
        });
        companyframe.choices[1].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableFrame tf = new TableFrame("SELECT * FROM policies WHERE Id=(SELECT CompanyId FROM companypolicy WHERE CompanyId='"+Login.uId+"')");
            }
        });
    }
}