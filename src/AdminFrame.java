import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

class AdminFrame extends JFrame
{
    Buttons adminframe;
    AdminFrame()
    {
        String[] temp = new String[4];
        temp[0] = "To View List Of Users";
        temp[1] = "To View List of Client Companies";
        temp[2] = "To View List of Policies";
        temp[3] = "To Add New Policy";
                
        adminframe= new Buttons(4, temp);
        add(adminframe);
        setVisible(true);
        pack();
        adminframe.choices[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableFrame tf = new TableFrame("SELECT * FROM userdata");     
            }
        });
        adminframe.choices[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableFrame tf = new TableFrame("SELECT * FROM companies");     
            }
        });
        adminframe.choices[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableFrame tf = new TableFrame("SELECT * FROM policies");     
            }
        });
        adminframe.choices[3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    FormPolicy fp = new FormPolicy();
                    String name = fp.ppan.formcomp[0].jt.getText();
                    String ioc = fp.ppan.formcomp[1].jt.getText();
                    String amt = fp.ppan.formcomp[2].jt.getText();
                    String bonus = fp.ppan.formcomp[3].jt.getText();
                    String fv = fp.ppan.formcomp[4].jt.getText();
                    String md = fp.ppan.formcomp[5].jt.getText();
                    String nmns = fp.ppan.formcomp[6].jt.getText();
                    String pa = fp.ppan.formcomp[7].jt.getText();
                    String rc = fp.ppan.formcomp[8].jt.getText();
                    String sv = fp.ppan.formcomp[9].jt.getText();
                    String tl = fp.ppan.formcomp[10].jt.getText();
                    String tp = fp.ppan.formcomp[11].jt.getText();
                    Myconnection mc = new Myconnection();
                    mc.resultSet = mc.statement.executeQuery("INSERT INTO policies (Name, IdOfCompany, Amount, Bonus, ForfeitValue, MaturityDate, Nominations, PremiumAmount, RisksCovered, SurrenderValue, TimeLength, TimePeriod) VALUES( name, ioc, amt, bonus, fv, md, nmns, pa, rc, sv, tl, tp)");
                   
                    mc.resultSet = mc.statement.executeQuery("SELECT PolicyId FROM policies WHERE Name='"+name+"'");
                    String ts = mc.resultSet.getString("PolicyId");
                    
                    mc.resultSet = mc.statement.executeQuery("INSERT INTO companypolicy (CompanyId,PolicyId) VALUES(ioc,ts)");
                } catch (SQLException ex) {
                    Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}