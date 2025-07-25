import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class ExpenseTrackerGUI extends JFrame {
    JComboBox<String> categoryBox;
    JTextField amount ,description,date;
    JLabel statusLabel;

    public  ExpenseTrackerGUI(){
        setTitle("SmartSpend - Add Expense");
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font font = new Font("Segoe UI", Font.PLAIN, 16);
        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("ComboBox.font", font);

        //Panel:

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20,30,20,30));
        panel.setBackground(Color.WHITE);

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
        panel.add(new JLabel("Description"),g);
        g.gridx=1;
        description = new JTextField();
        panel.add(description,g);

        //Date
        g.gridx=0;
        g.gridy=3;
        panel.add(new JLabel("Date (yyyy-MM-dd):"),g);
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
                double amt = Double.parseDouble(amount.getText());
                String descriptionText = description.getText();
                Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(date.getText());

                Expense expense = new Expense(category, amt, descriptionText, dt);
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







