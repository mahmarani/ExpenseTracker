import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ExpenseView extends JFrame {
private JTable expenseTable;
private JComboBox<String> filterBox;
private JLabel totalLabel;

ExpenseDAO dao = new ExpenseDAO();

public ExpenseView(){
setTitle("VIEW EXPENSES");
setSize(600,400);


    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));
//TOP
    JPanel topPanel = new JPanel();
    filterBox = new JComboBox<>(new String[]{"All","Travel","Study", "Others"});

    JButton refreshButton = new JButton("REFRESH");
    topPanel.add(new JLabel("Filter By Category:-"));
            topPanel.add(filterBox);
            topPanel.add(refreshButton);
            add(topPanel,BorderLayout.NORTH);
            //Table
            expenseTable=new JTable();
            JScrollPane scroll = new JScrollPane(expenseTable);
            add(scroll,BorderLayout.CENTER);
//Botton panel:
    JPanel bottonPanel = new JPanel();
    totalLabel = new JLabel("Total Spend: Rs 0");
    totalLabel.setFont(new Font("Segeo UI", Font.BOLD,16));
    totalLabel.setForeground(new Color(76,8,76));
bottonPanel.add(totalLabel);
add(bottonPanel,BorderLayout.SOUTH);


refreshButton.addActionListener(e ->loadExpenses());
    loadExpenses();
    setVisible(true);

}
    private void loadExpenses() {
        String selected = filterBox.getSelectedItem().toString();
        List<Expense> list;

        if (selected.equals("All")) {
            list = dao.getAllExpenses();
        } else {
            list = dao.getExpensesByCategory(selected);
        }

// Table model
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Category", "Amount", "Description", "Date"}, 0);

        double total = 0;
        for (Expense exp : list) {
            model.addRow(new Object[]{
                    exp.getCategory(),
                    exp.getAmount(),
                    exp.getDescription(),
                    new java.text.SimpleDateFormat("yyyy-MM-dd").format(exp.getDate())
            });
            total += exp.getAmount();
        }

        expenseTable.setModel(model);
        totalLabel.setText("Total Spent: Rs. " + total);
    }
}