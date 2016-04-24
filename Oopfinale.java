/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopfinale;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Charvak and Raj
 */
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

class LoginPanel extends JPanel 
{
    static Jp usertext ;
    static Jp password ;
    JRadioButton user;
    JRadioButton comp;
    JRadioButton admin;
    ButtonGroup radiogrp;
    ButtonGroup radioGroup;
    static int choice;
    public LoginPanel()
    {
        BoxLayout x = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout( x );
        
        user = new JRadioButton("User", true);
        comp = new JRadioButton("Company", false);
        admin = new JRadioButton("Admin", false);
        usertext = new Jp("Username : ");
        password = new Jp("Password : ");
        
        
        radioGroup = new ButtonGroup();
        radioGroup.add(user);
        radioGroup.add(comp);
        radioGroup.add(admin);
        
        
        add(usertext);
        add(password);
        add(user);
        add(comp);
        add(admin);
       
        user.addItemListener(new HandlerClass(1));
        comp.addItemListener(new HandlerClass(2));
        admin.addItemListener(new HandlerClass(3));
                
        
        
    }

    private static class HandlerClass implements ItemListener
    {
        int c;
        public HandlerClass(int i)
        {
            c = i;
        }

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            choice = c;
            
        }
    }

    
}
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
                    JTextField idop = new JTextField();
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

class GenTable extends AbstractTableModel
{
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData metaData;
    int numberOfRows;
    
    boolean connectedToDatabase = false;
    public GenTable(String query) throws Exception
    {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproj","root","");
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        connectedToDatabase = true;
        
        setQuery( query );
        
    }
    public Class getColumnClass( int column)throws IllegalArgumentException
    {
        if ( !connectedToDatabase )
            throw new IllegalStateException( "Not Connected to Database" );
        try
        {
            String className = metaData.getColumnClassName( column + 1 );
            return Class.forName( className );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        return Object.class;
    }
    @Override
    public int getRowCount()throws IllegalArgumentException
    {
        if ( !connectedToDatabase )
            throw new IllegalStateException( "Not Connected to Database" );
        return numberOfRows;
    }

    @Override
    public int getColumnCount()throws IllegalArgumentException
    {
        if ( !connectedToDatabase )
            throw new IllegalStateException( "Not Connected to Database" );
        try
        {
            return metaData.getColumnCount();
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public String getColumnName(int column)throws IllegalArgumentException
    {
        if ( !connectedToDatabase )
            throw new IllegalStateException( "Not Connected to Database" );
        try
        {
            return metaData.getColumnName( column+1 );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return "";
            
    }

    @Override
    public Object getValueAt(int row, int column)throws IllegalArgumentException
    {
        if ( !connectedToDatabase )
            throw new IllegalStateException( "Not Connected to Database" );
        try
        {
            resultSet.absolute(row + 1);
            return resultSet.getObject( column+1 );
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public void setQuery( String query )throws SQLException, IllegalStateException
    {
            if ( !connectedToDatabase )
                 throw new IllegalStateException( "Not Connected to Database" );
            resultSet = statement.executeQuery( query );
            metaData = resultSet.getMetaData();
            resultSet.last();
            numberOfRows = resultSet.getRow();
            fireTableStructureChanged();
    }
    
    public void disconnectedFromDatabase()
    {
        if(connectedToDatabase)
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
            finally
            {
                connectedToDatabase = false;
            }
        }
    }
    
}

class TableFrame extends JFrame
{
    GenTable tableModel;

    TableFrame( String q ) 
    {
        try {
            tableModel = new GenTable( q );
            JTable table = new JTable(tableModel);
            add(new JScrollPane(table));
            setVisible(true);
            pack();
        } catch (Exception ex) {
            Logger.getLogger(TableFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class Myconnection
{
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
                
    public Myconnection()throws SQLException
    {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproj","root","");
        statement =  connection.createStatement();
                
    }
}
public class Oopfinale
{


    public static void main(String[] args) throws Exception 
    {
       Login login = new Login();
        
    }
    
}
