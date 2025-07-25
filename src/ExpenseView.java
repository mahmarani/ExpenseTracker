import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ExpenseView extends JFrame {
private JTable expenseTable;
private JComboBox<String> filterBox;
private JLabel total;

ExpenseDAO dao = new ExpenseDAO();

public ExpenseView(){
setTitle("VIEW EXPENSES");
setSize(600,400);


    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));

    JPanel topPanel = new JPanel();
    filterBox = new JComboBox<>(new String[]{"All","Travel","Study", "Others"});

    JButton refreshButton = new JButton("REFRESH");
    topPanel.add(new JLabel("Filter By Category:-"));
            topPanel.add(filterBox);
            topPanel.add(refreshButton);
            add(topPanel,BorderLayout.NORTH);

            expenseTable=new JTable();
            JScrollPane scroll = new JScrollPane(expenseTable);
            add(scroll,BorderLayout.CENTER);


}


}
