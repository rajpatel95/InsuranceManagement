import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

class Login extends JFrame
{
    JButton li;
    JButton su;
    static String un;
    static String pw;
    static String uId;
    String una="admin";
    String pwa="admin";
    boolean flag = false;
    static LoginPanel loginPanel;
    public Login() throws SQLException
    {
        setTitle("Login");
        setLayout( new FlowLayout() );
        loginPanel = new LoginPanel();
        JScrollPane sp = new JScrollPane( loginPanel );
        Myconnection cn = new Myconnection();
        if( LoginPanel.choice == 1)
        {
            cn.resultSet = cn.statement.executeQuery("SELECT Id FROM userdata WHERE UserName='"+Login.un+"'");
            uId = cn.resultSet.getString("Id");
        }
        if( LoginPanel.choice == 2)
        {
            cn.resultSet = cn.statement.executeQuery("SELECT Id FROM companies WHERE UserName='"+Login.un+"'");
            uId = cn.resultSet.getString("Id");
        }
        li = new JButton("Login");
        su = new JButton("Signup");
        add(sp);
        add(li);
        add(su);
        li.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                un="";
                pw="";
  
                un=LoginPanel.usertext.jt.getText();
                pw=LoginPanel.password.jt.getText();
                        
                System.out.print(un);
                try
                {
                Myconnection myconnection = new Myconnection();                
                myconnection.resultSet = myconnection.statement.executeQuery("SELECT * FROM userdata");
              
                if( un.equals(una) && pw.equals(pwa) )
                {
                    flag = true;
                   
                }
                
                if( flag == false )
                {
                     while( myconnection.resultSet.next() )
                    {
                        if(myconnection.resultSet.getString("UserName").equals(un) && myconnection.resultSet.getString("PassWord").equals(pw))
                        {
                            flag = true;
                            break;
                        }
                    }
                }
               
                myconnection.resultSet = myconnection.statement.executeQuery("SELECT * FROM companies");
                if( flag == false )
                {
                    while( myconnection.resultSet.next() )
                    {
                        if( myconnection.resultSet.getString("UserName").equals(un) && myconnection.resultSet.getString("Password").equals(pw))
                        {
                            flag = true;
                            break;
                        }
                    }
                }
               
                }
                catch( Exception eb )
                {
                    eb.printStackTrace();
                }
                
                if(flag==true)
                {
                    switch( LoginPanel.choice )
                    {
                        case 1 : UserFrame userFrame = new UserFrame();
                                break;
                        case 2 : CompanyFrame companyFrame = new CompanyFrame();
                            break;
                        case 3 : AdminFrame adminFrame = new AdminFrame();      
                            break;
                    }
                }
                else if(flag==false)
                {
                    JOptionPane.showMessageDialog(rootPane, "Wrong Username of Password");
                }
            }
        } );
        
        su.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                FormUser formUser = new FormUser();
                String add, ban, bd, no, gen, nm, pwd, unme;
                add=formUser.signuppanel.formcomp[7].jt.getText();
                ban=formUser.signuppanel.formcomp[6].jt.getText();
                bd=formUser.signuppanel.formcomp[5].jt.getText();
                no=formUser.signuppanel.formcomp[4].jt.getText();
                gen=formUser.signuppanel.formcomp[3].jt.getText();
                nm=formUser.signuppanel.formcomp[2].jt.getText();
                pwd=formUser.signuppanel.formcomp[1].jt.getText();
                unme=formUser.signuppanel.formcomp[0].jt.getText();
                try
                {
                    Myconnection nc = new Myconnection();
                    
                    
                    nc.resultSet = nc.statement.executeQuery("INSERT INTO userdata ( Address, BankAccNo, BirthDate, ContactNo, Gender, Name, PassWord, UserName ) VALUES ( add, ban, bd, no, gen, nm, pwd, unme)");
                }
                catch( Exception ebc)
                {
                    ebc.printStackTrace();
                }
                
            }
        });
        setVisible( true );
        pack();
        
    }
    
    }