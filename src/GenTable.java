import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

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