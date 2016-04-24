import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class UserFrame extends JFrame
{
    Buttons userframe;
    UserFrame()
    {
        pack();
        setVisible(true);
        
        String[] temp = new String[2];
        temp[0] = "To Compare And Issue A Policy";
        temp[1] = "To View Policies You Have Issued";
        
                
        userframe= new Buttons(3, temp);
        add(userframe);
                
        userframe.choices[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    JFrame fortable = new JFrame("Compare And Issue Policy");
                    fortable.setLayout(new FlowLayout());
                    GenTable tableModel = new GenTable( "SELECT * FROM policies" );
                    JTable table = new JTable(tableModel);
                    fortable.add(new JScrollPane(table));
                    JButton ins = new JButton();
                    fortable.add(ins);
                    final JTextField idop = new JTextField();
                    fortable.add(idop);
                    ins.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            try {
                                String t = idop.getText();
                                Myconnection cn = new Myconnection();
                                cn.resultSet = cn.statement.executeQuery("SELECT Id FROM userdata WHERE UserName='"+Login.un+"'");
                                String temp = cn.resultSet.getString("Id");
                                cn.resultSet = cn.statement.executeQuery("INSERT INTO userpolicy VALUES( '"+t+"','"+temp+"' ");
                            } catch (SQLException ex) {
                                Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    fortable.setVisible(true);
                    fortable.pack();
                } catch (Exception ex)
                {
                    Logger.getLogger(TableFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        userframe.choices[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
 
                TableFrame tf = new TableFrame("SELECT * FROM policies WHERE Id=(SELECT PolicyId FROM userpolicy WHERE userid='"+Login.uId+"')");
            }
        });
    }
}