import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class main {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[] headers = {
                "Team A",
                "Team B",
                "Ergebnis Team A",
                "Ergebnis Team B",
                "Punktedifferenz"
        };

        Object[][] matches = {
                {"Flensburg Sealords", "Bremen Firebirds", 14, 32, -18},
                {"Flensburg Sealords", "Kiel Baltic Hurricanes II", 6, 41, -35},
                {"Flensburg Young Sealords", "SG Ostholstein/Schwarzenbek", 28, 0, 28},
                {"Flensburg Sealords", "Rendsburg Knights", 9, 30, -21},
                {"Flensburg Young Sealords", "SG Rendsburg/Neumünster", 24,14, 10},
                {"Flensburg Sealords", "Hamburg Black Swans", 6, 14, -8},
                {"Flensburg Sealords", "Bremen Firebirds", 27, 24, 3},
                {"Flensburg Young Sealords", "Hamburg Young Heat", 12, 44, -32},
                {"Flensburg Sealords","Rotenburg Northern United", 23, 27, -4},
                {"Flensburg Sealords","Kiel Baltic Hurricanes II", 6, 43, -37},
                {"Flensburg Sealords","Rotenburg Northern United", 15, 32, -17},
                {"Flensburg Young Sealords", "SG Ostholstein/Schwarzenbek", 20, 0, 20},
                {"Flensburg Sealords","Rendsburg Knights", 0, 20, -20},
                {"Flensburg Young Sealords", "SG Rendsburg/Neumünster", 8, 29, -21},
                {"Flensburg Sealords","Hamburg Black Swans", 0, 0, 0},
                {"Flensburg Young Sealords", "Hamburg Young Heat", 3, 20, -17},
                
        };

        DefaultTableModel tModel = new DefaultTableModel(matches, headers) {
        	@Override
        	public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    default:
                        return Integer.class;
                }
           }
        };
        JTable table = new JTable(tModel);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        table.getRowSorter().toggleSortOrder( 4);
        table.getRowSorter().toggleSortOrder( 4);
        
       

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);

        table.getModel().addTableModelListener(e -> {
            if (4 == e.getColumn()) return;
            int row = table.getSelectedRow();
            int data1 = Integer.parseInt(table.getValueAt(row, 2).toString());
            int data2 = Integer.parseInt(table.getValueAt(row, 3).toString());
            table.setValueAt(data1 - data2, row, 4);
            table.getRowSorter().toggleSortOrder( 4);  
            table.getRowSorter().toggleSortOrder( 4);
        });
    }
}

