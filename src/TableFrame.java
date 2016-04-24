import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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