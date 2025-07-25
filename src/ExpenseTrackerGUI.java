import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class ExpenseTrackerGUI extends JFrame {
    private JComboBox<String> categoryBox;
    private JTextField amount ,description,date;
    private JLabel statusLabel;

    public  ExpenseTrackerGUI(){
        setTitle("SmartSpend - Add Expense");
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //Panel:

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBorder(new EmptyBorder(20,30,20,30));
        panel.setBackground(Color.black);

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5,10,5,10);
        g.fill = GridBagConstraints.HORIZONTAL;

    //Category:
g.gridx=0;
g.gridy=0;
panel.add(new JLabel("Category:"), g);
g.gridx=1;
categoryBox =new JComboBox<>(new String[]{"Food","Travel","Study","Others"});
panel.add(categoryBox,g);


//Amount
        g.gridx=0;
        g.gridy=1;
        panel.add(new JLabel("Amount (Rs):"), g);
        g.gridx = 1;
        amount = new JTextField();
        panel.add(amount, g);

        //Description:
        g.gridx=0;
        g.gridy=2;
        panel.add(new JLabel("Description"));
        g.gridx=1;
        description = new JTextField();
        panel.add(description,g);

        //Date
        g.gridx=0;
        g.gridy=3;
        panel.add(new JLabel("Date (yyy-MM-dd):"),g);
        g.gridx=1;
        date = new JTextField(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
        panel.add(date,g);


        // Button
        g.gridx = 0; g.gridy = 4; g.gridwidth = 2;
        JButton submitButton = new JButton("➕ Add Expense");
        submitButton.setBackground(new Color(65, 105, 225));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
        panel.add(submitButton, g);
        // Status
        g.gridy = 5;
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(new Color(0, 200, 0));
        panel.add(statusLabel, g);


        // Add action
        submitButton.addActionListener(e -> {
            try {
                String category = categoryBox.getSelectedItem().toString();
                double amount = Double.parseDouble(amount.getText());
                String description = description.getText();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(date.getText());

                Expense expense = new Expense(category, amount, description, date);
                ExpenseDAO dao = new ExpenseDAO();

                boolean success = dao.addExpense(expense);
                statusLabel.setText(success ? "✅ Expense saved!" : "❌ Failed to save.");
            } catch (Exception ex) {
                statusLabel.setText("⚠️ Error: " + ex.getMessage());
            }
        });

        // Finalize window
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExpenseTrackerGUI::new);
    }
}







